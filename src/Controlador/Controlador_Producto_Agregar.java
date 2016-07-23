/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Producto_Agregar;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Agregar {

    Modelo_Producto_Agregar sensql;

    public Controlador_Producto_Agregar() {
        sensql = new Modelo_Producto_Agregar();
    }

    public Object[][] consulta_Productos() {
        String sentencia = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from (producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and detallesucursal.Stock <= 4) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        Object[][] datos = null;
        String[] columnas = {"IDPRODUCTO","Nombre","Activo", "Descripcion", "PCompra", "PPublico","detallesucursal.Stock","proveedor.CONTACTO","sucursal.nombre"};
        datos = sensql.GetTabla(columnas, sentencia);

        return datos;
    }
    
}
