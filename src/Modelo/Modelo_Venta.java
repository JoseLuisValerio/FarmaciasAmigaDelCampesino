package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo para el controlador Controlador_Venta
 * @author root
 */
public class Modelo_Venta {
    private Conexion con;
    private PreparedStatement ps;
    private ResultSet res;
    
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
}
