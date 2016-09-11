package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis
 */
public class Modelo_Movimiento {

    private Conexion con;
    PreparedStatement ps;
    ResultSet res;

    public Modelo_Movimiento() {
        con = new Conexion();
    }

    public boolean insertar(String datos[], String insert) {
        boolean estado = false;
        try {
            ps = con.conectado().prepareStatement(insert);
            for (int i = 0; i <= datos.length - 1; i++) {
                ps.setString(i + 1, datos[i]);
            }
            ps.execute();
            ps.close();
            con.desconectar();
            estado = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return estado;
    }

    public String obtenerIdProvedor(String nombre_columna, String sentenciasql) {

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
            System.out.println(e);
        }
        return datos;
    }
}
