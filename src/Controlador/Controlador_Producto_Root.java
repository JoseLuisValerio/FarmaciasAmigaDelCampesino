/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Producto_Root;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Root {

    Modelo_Producto_Root sensql;

    public Controlador_Producto_Root() {
        sensql = new Modelo_Producto_Root();
    }

    public Object[][] mostrarProductos() {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] consulta_Productos() {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and detallesucursal.stock <= 100 and sucursal.idsucursal = 1) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosCodigo(String codigo) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.IDPRODUCTO ='" + codigo + "'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaActivo(String activo) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.ACTIVO like '%" + activo + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaNombre(String nombre) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.NOMBRE like '%" + nombre + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosaDescripcion(String Descripcion) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.DESCRIPCION like '%" + Descripcion + "%'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[] cargaSucursal(String tablas) {
        String seleccion = "SELECT sucursal.nombre from ";
        String sentencia = seleccion + tablas;
        String columnas = "sucursal.nombre";
        return sensql.llenarCombo(tablas, columnas, sentencia);
    }

    public Object[] cargaProveedor(String tablas) {
        String seleccion = "SELECT proveedor.RSOCIAL from ";
        String sentencia = seleccion + tablas;
        String columnas = "proveedor.RSOCIAL";
        return sensql.llenarCombo(tablas, columnas, sentencia);
    }

    public Object[][] buscaProductosSucursal(String Sucursal) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor) INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.nombre LIKE '%" + Sucursal + "%') on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscaProductosProveedor(String Proveedor) {

        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,producto.PCOMPRA,detallesucursal.Stock,proveedor.RSOCIAL,sucursal.nombre from";
        String tablas = "(producto INNER JOIN proveedor on producto.IDPROVEEDOR = proveedor.IDproveedor and proveedor.RSOCIAL LIKE '%" + Proveedor + "%') INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal) on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "producto.PCOMPRA", "detallesucursal.Stock", "proveedor.RSOCIAL", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public boolean ingresarProductoNuevo(String id, String nombre, String activo, String descripcion, String ppublico, String ppcompra, String idpreveedor, String status) {

        String datos[] = {id, nombre, activo, descripcion, ppublico, ppcompra, idpreveedor, status};
        return sensql.insertar(datos, "INSERT INTO `producto` (`IDPRODUCTO`, `NOMBRE`, `ACTIVO`, `DESCRIPCION`, `PPUBLICO`, `PCOMPRA`, `IDPROVEEDOR`, `estatus`) VALUES (?,?,?,?,?,?,?,?)");
    }

    public boolean ingresarDetalleNuevo(String idproducto, String sucursal, String stock, String vendidos, String area) {

        String datos[] = {idproducto, sucursal, stock, vendidos, area};
        return sensql.insertar(datos, "INSERT INTO `detallesucursal` (`IDPRODUCTO`, `idsucursal`, `Stock`, `Vendidos`, `idArea`) VALUES (?,?,?,?,?)");
    }

    public String obtenerIdProveedor(String contacto) {
        String sentencia = "SELECT proveedor.IDproveedor from proveedor WHERE proveedor.RSOCIAL = '" + contacto + "'";
        String datos = null;
        String columnas = "IDproveedor";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.obtenerIdProvedor(columnas, sentencia);
        return datos;
    }

    public boolean actualizarStock(String idproducto, String idsucursal, String stock) {
        String campos[] = {stock, idproducto, idsucursal};
        String sentencia = "UPDATE detallesucursal SET Stock = Stock+? WHERE detallesucursal.IDPRODUCTO =? and detallesucursal.idsucursal = ?";
        return sensql.insertar(campos, sentencia);
    }
    public boolean actualizaProducto(String codigo,String nombre,String activo, String descripcion,String ppublico, String pcompra){
        String campos[]={nombre,activo,descripcion,ppublico,pcompra,codigo};
        String sentencia="UPDATE producto SET producto.NOMBRE=?,producto.ACTIVO=?,producto.DESCRIPCION=?,producto.PPUBLICO=?,producto.PCOMPRA=? WHERE producto.IDPRODUCTO =?";
    return sensql.insertar(campos, sentencia);
    }

}
