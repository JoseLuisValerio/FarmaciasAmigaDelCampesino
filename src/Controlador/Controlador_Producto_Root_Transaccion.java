/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Producto_Root_Transaccion;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Root_Transaccion {
        Modelo_Producto_Root_Transaccion sensql;

    public Controlador_Producto_Root_Transaccion() {
        sensql = new Modelo_Producto_Root_Transaccion();
    }
        public Object[][] mostrarProductos() {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,detallesucursal.Stock,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor ON producto.IDPROVEEDOR = proveedor.IDproveedor)INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.nombre = 'Bodega') on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO","detallesucursal.Stock","sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }
}
