package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Modelo de la clase cliente
 * @author root
 */
public class Modelo_Cliente {
    private Conexion con;
    PreparedStatement ps;
    ResultSet res;

    public Modelo_Cliente() {
        con = new Conexion();
    }
    
    /**
     * 
     * @param colName
     * @param SQLExecute
     * @return 
     */
    public Object [][] GetTabla(String colName[], String SQLExecute, String SQLContar){
      int registros = 0;
      try{//Cuenta la cantidad de registros en la tabla Cliente
         ps = con.conectado().prepareStatement("SELECT count(*) AS total FROM "+SQLContar);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
         //con.desconectar(); -> Error Null Pointer
      }catch(SQLException e){
         System.err.println("Error al contar los registros en la tabla Cliente: "+e.getMessage());
      }

    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.conectado().prepareStatement(SQLExecute);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
         con.desconectar();
          }catch(SQLException e){
         System.err.println("Error al leer los registros en cliente: "+e.getMessage());
    }
    return data;
 }
    
    public Object[] llenarCombo(String nombrecol, String sql) {
        int registros = 0;
        try {
            ps = con.conectado().prepareStatement("SELECT count(*) as total FROM Tipo_Cliente");
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al contar los registros de tipo de cliente: "+e.getMessage());
        }

        Object[] datos = new Object[registros];
        try {
            ps = con.conectado().prepareStatement(sql);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                datos[i] = res.getObject(nombrecol);
                i++;
            }
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }
    
    /**
     * Recibe un nombre del tipo de cliente y retorna el id para la inserción
     * en Cliente.
     * @param nombre_columna recibe el nombre de la columna que buscará
     * @param SQL recibe la sentencia a ejecutar
     * @return 
     */
    public String obtenerIdTipoCliente(String nombre_columna, String SQL) {
        String datos = "";
        try {
            ps = con.conectado().prepareStatement(SQL);
            res = ps.executeQuery();
            while (res.next()) {
                datos = res.getString(nombre_columna);
            }
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al obtener el idTipoCliente " + e.getMessage());
        }
        return datos;
    }
    
    /**
     * Recibe un arreglo de datos String que corresponde a los datos que insertará
     * en la tabla Cliente
     * @param datos recibe los datos desde la clase controlador
     * @param SQL recibe la sentencia a ejecutar, Insertar.
     * @return retorna una bandera donde true = Registro exitoso y false = Falla
     */
    public boolean insertar(String datos[], String SQL) {
        boolean estado = false;
        try {
            ps = con.conectado().prepareStatement(SQL);
            for (int i = 0; i <= datos.length - 1; i++) {
                ps.setString(i + 1, datos[i]);
            }
            ps.execute();
            ps.close();
            con.desconectar();
            estado = true;
        } catch (SQLException e) {
            System.err.println("Error al insertar un nuevo registro en Cliente: "+e.getMessage());
        }
        return estado;
    }
}
