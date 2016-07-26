/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Producto_Buscar;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Buscar {

    Modelo_Producto_Buscar sensql;

    public Controlador_Producto_Buscar() {
        sensql = new Modelo_Producto_Buscar();
    }

    public Object[][] consulta_Productos() {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and detallesucursal.stock <= 3 ) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.CONTACTO", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosCodigo(String codigo) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.IDPRODUCTO like '%" + codigo + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.CONTACTO", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaActivo(String activo) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.ACTIVO like '%" + activo + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.CONTACTO", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaNombre(String nombre) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.NOMBRE like '%" + nombre + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.CONTACTO", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaDescripcion(String Descripcion) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.CONTACTO,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.DESCRIPCION like '%" + Descripcion + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.CONTACTO", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[] cargaSucursal(String tablas) {
        String seleccion = "SELECT sucursal.nombre from ";
        String sentencia = seleccion + tablas;
        String columnas = "sucursal.nombre";
        return sensql.llenarCombo(tablas, columnas,sentencia);
    }
    
    public Object[] cargaProveedor(String tablas) {
        String seleccion = "SELECT proveedor.CONTACTO from ";
        String sentencia = seleccion + tablas;
        String columnas = "proveedor.CONTACTO";
        return sensql.llenarCombo(tablas, columnas,sentencia);
    }
}
