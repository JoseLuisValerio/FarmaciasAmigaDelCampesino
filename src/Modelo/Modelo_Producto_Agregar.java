/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis
 */
public class Modelo_Producto_Agregar {

    private Conexion con;
    PreparedStatement ps;
    ResultSet res;
    
    
    public Modelo_Producto_Agregar() {
        con = new Conexion();
    }

    public Object[][] GetTabla(String colName[], String sql) {
        int registros = 0;
        String sentencia="select count(*) as total from (producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and detallesucursal.Stock <= 3) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";

        try {
            ps = con.conectado().prepareStatement(sentencia);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
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
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
