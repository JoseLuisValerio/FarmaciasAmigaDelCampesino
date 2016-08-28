package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase funge como Modelo de la Vista/tabla Usuario
 *
 * @author root
 */
public class Modelo_Usuario {

    private Conexion con;
    PreparedStatement ps;
    ResultSet res;
    Statement stmn;

    public Modelo_Usuario() {
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
            System.err.println("Error al contar las filas: " + e.getMessage());
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
            System.err.println("Error al obtener los datos de a tabla" + e.getMessage());
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

    public boolean InsertarOActualizar(String insert) {
        boolean exitoso = false;
        try {
            stmn = con.conectado().createStatement();
            stmn.executeUpdate(insert);

            exitoso = true;
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
        return exitoso;
    }

    public String obtenerIdTipoUsuario(String nombre_columna, String sentenciasql) {
        String datos = "";
        try {
            ps = con.conectado().prepareStatement(sentenciasql);
            res = ps.executeQuery();
            while (res.next()) {
                datos = res.getString(nombre_columna);
            }
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al obtener el idTipoUsuario " + e.getMessage());
        }
        return datos;
    }
    
    public boolean ExisteUsuario(String SQL){
        boolean Existe=false;
        try {
            ps = con.conectado().prepareStatement(SQL);
            res = ps.executeQuery();
            while (res.next()) {
                Existe = true;
            }
            res.close();
            con.desconectar();
        } catch (SQLException e) {
            System.err.println("Error al verificar si existe el usuario " + e.getMessage());
        }
        return Existe;
    }
}
