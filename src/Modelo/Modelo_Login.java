package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Jose Luis
 */
public class Modelo_Login {
    private Conexion con;
    PreparedStatement ps;
    ResultSet res;

    public Modelo_Login() {
        con = new Conexion();
    }
    
  /**
   * C
   * @param colName
   * @param sql
   * @return 
   */
    public Object [][] Comprueba(String colName[], String sql){
      int registros = 0;
      
      try{
         ps = con.conectado().prepareStatement("select count(*) as total from usuario");
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
         con.desconectar();
      }catch(SQLException e){
         System.err.println("Error al contar la cantidad de usuarios: "+e.getMessage());
      }

    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.conectado().prepareStatement(sql);
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
         System.err.println(e.getMessage());
    }
    return data;
 }
}
