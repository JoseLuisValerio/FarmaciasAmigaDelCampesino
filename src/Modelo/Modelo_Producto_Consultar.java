
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis
 */

public class Modelo_Producto_Consultar {
 private Conexion con;
    private PreparedStatement ps;
    private ResultSet res;
    
    public Modelo_Producto_Consultar(){
        con = new Conexion();
    }   
        public Object[][] GetTabla(String colName[], String sql, String tablas) {//recibir de las tablas el final de la consulta 
        int registros = 0;
        String sentencia = "select count(*) as total from " + tablas;

        try {
            ps = con.conectado().prepareStatement(sentencia);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][colName.length];
        String col[] = new String[colName.length];

        try {
            ps = con.conectado().prepareStatement(sql);
            res = ps.executeQuery();
            int i = 0;
            while (res.next()) {
                for (int j = 0; j <= colName.length - 1; j++) {
                    col[j] = res.getString(colName[j]);
                    data[i][j] = col[j];
                }
                i++;
            }
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
           public Object[] llenarCombo(String tabla, String nombrecol, String sql) {
        int registros = 0;
        try {
            ps = con.conectado().prepareStatement("SELECT count(*) as total FROM " + tabla);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
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
}
