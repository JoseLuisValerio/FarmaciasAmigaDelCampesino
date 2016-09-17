package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Modelo para el controlador Controlador_Venta
 * @author root
 */
public class Modelo_Venta {
    private Conexion con;
    private PreparedStatement ps;
    private ResultSet res;
    private Statement st;
    
    public Modelo_Venta(){
        con = new Conexion();
    }
    /**
     * Recibe los datos para consultar
     * @param NomColumnas recibe los nombres de las columnas que se consultarán
     * @param SQLContar recibe un SQL incompleto para contar la cantidad de registros donde se cumpla 
     * la sentencia, es útil para determinar el tamaño del arreglo que devolverá
     * @param SQLExecute recibe el SQL de consulta.
     * @return los datos obtenidos de la consulta
     */
    public Object[][] GetTable(String NomColumnas[],String SQLContar, String SQLExecute){
        int CantidadRegistros=0;
        /* Se cuentan los registros en la sentencia para darle tamaño al arreglo de resultados*/
        try{
            ps = con.conectado().prepareStatement("SELECT count(*) AS total FROM "+SQLContar);
         res = ps.executeQuery();
         res.next();
         CantidadRegistros = res.getInt("total");
         res.close();
         con.desconectar();
        }catch(SQLException e){
            System.err.println("Error al contar registros de: "+SQLContar);
        }
        
            Object[][] data = new String[CantidadRegistros][NomColumnas.length];
            String col[] = new String[NomColumnas.length];
        /* Se ejecuta la sentencia para obtener los resultados*/ 
         try{
         ps = con.conectado().prepareStatement(SQLExecute);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<NomColumnas.length;j++){
                col[j] = res.getString(NomColumnas[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
         con.desconectar();
         
          }catch(SQLException e){
         System.err.println("Error al leer los registros en producto: "+e.getMessage());
    }
        return data;
    }
    
    public boolean insertar(String columnas[], String SQL){
        boolean exitoso=false;
        try {
            ps = con.conectado().prepareStatement(SQL);
            for (int i = 0; i<columnas.length; i++) {
                ps.setString(i + 1, columnas[i]);
            }
            ps.execute();
            ps.close();
            con.desconectar();
            exitoso = true;
        } catch (SQLException e) {
            System.err.println("Error al insertar un nuevo registro en Venta: "+e.getMessage());
        }
        return exitoso;
    }
    
    public String GetIdVenta(String Fecha, String Hora, String Sucursal, String Usuario){
        String idVenta="";
        String SQL ="SELECT idVenta FROM Venta WHERE Fecha='"+Fecha+"' AND Hora='"+Hora+"' AND idSucursal='"+Sucursal+"' AND idUsuario='"+Usuario+"';";
        try{
            ps = con.conectado().prepareStatement(SQL);
         res = ps.executeQuery();
         res.next();
         idVenta = res.getString("idVenta");
         res.close();
         con.desconectar();
        }catch(SQLException e){
            System.err.println("Error al obtener el idVenta para DetalleVenta");
        }
        return idVenta;
    }
    /**
     * Obtiene el stock o el número de vendidos de un producto en una sucursal
     * @param Columna recibe la columna "Stock" o "Vendidos".
     * @param Producto recibe el idproducto para buscar.
     * @param Sucursal recibe la sucursal donde buscará el producto.
     * @return entero con Stock o número de vendidos
     */
    public int GetStock(String Columna, String Producto, String Sucursal){
        int Stock =0;
        String SQL = "SELECT "+Columna+" FROM DetalleSucursal WHERE idSucursal ="+Sucursal+" AND idProducto="+Producto+";";
        try{
            ps = con.conectado().prepareStatement(SQL);
            res = ps.executeQuery();
            res.next();
            Stock = res.getInt(Columna);
            res.close();
            con.desconectar();
        }catch(SQLException e){
            System.err.println("Error al obtener "+Columna+" de Detalle de Sucursal");
        }
        return Stock;
    }
    
    /**
     * Recibe el nuevo Stock y el número de vendidos dado un producto y una sucursal
     * @param Producto recibe el producto que se acualizará
     * @param Sucursal recibe la sucursal que corresponde al producto ingresado
     * @param Stock recibe el nuevo stock del producto
     * @param Vendidos recibe el nuevo número de productos vendidos.
     * @return si la operación fue exitosa o no.
     */
    public boolean ActualizaStockYVendidos(String Producto, String Sucursal, int Stock, int Vendidos){
        boolean exitoso = false;
        String SQL = "UPDATE DetalleSucursal SET Stock=?, Vendidos=? WHERE idProducto ='"+Producto+"' AND idSucursal='"+Sucursal+"'";
        try{
        ps= con.conectado().prepareStatement(SQL);
        ps.setInt(1, Stock);
        ps.setInt(2, Vendidos);
        ps.executeUpdate();
        ps.close();
        con.desconectar();
        exitoso = true;
        }catch(SQLException e){
            System.err.println("Error al actualizar Stock y vendidos: "+e.getMessage());
        }
        return exitoso;
    }
    
    /**
     * Actualiza el dinero electronico de un cliente dado
     * @param DinElectro recibe el nuevo saldo en 
     * @return 
     */
    public boolean ActualizaDinElectro(float DinElectro, String SQL){
        boolean exitoso=false;
        try{
            ps =con.conectado().prepareStatement(SQL);
            ps.setFloat(1, DinElectro);
            ps.executeUpdate();
            ps.close();
            con.desconectar();
            exitoso= true;
        }catch(SQLException e){
            System.err.println("Error al actualizar DineroElectronico: +"+e.getMessage());
        }
        return exitoso;
    }
    
    public boolean ActualizaCaja(String idSucursal, float Monto){
        boolean exitoso=false;
        
        //ACTUALIZACIÓN DEL SALDO
        String SQL ="UPDATE Caja SET SaldoTotal=SaldoTotal+? WHERE idSucursal='"+idSucursal+"';";
        try{
            ps =con.conectado().prepareStatement(SQL);
            ps.setFloat(1,Monto);
            ps.executeUpdate();
            ps.close();
            con.desconectar();
            exitoso= true;
        }catch(SQLException e){
            System.err.println("Error al actualizar Saldo Total: +"+e.getMessage());
        }
        return exitoso;
    }

}
