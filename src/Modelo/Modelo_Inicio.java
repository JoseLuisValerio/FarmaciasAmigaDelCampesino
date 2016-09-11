
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_Inicio {
Conexion con;
private PreparedStatement ps;
private ResultSet res;

public Modelo_Inicio(){
    con = new Conexion();
    
}
    
     public Object [][] GetTabla(String colName[], String sql){
      
    Object[][] data = new String[1][colName.length];
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
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
     
     public boolean ExisteMovimientos(String Fecha, String idUsuario){
         boolean Existe=false;
         int registros=0;
         String SQL="SELECT COUNT(idMovimiento) as total FROM Movimiento WHERE Fecha LiKE '"+Fecha+"' AND idUsuario='"+idUsuario+"';";
          try {
            ps = con.conectado().prepareStatement(SQL);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
          if(registros!=0){
              Existe=true;
          }
         return Existe;
         
     }

}
