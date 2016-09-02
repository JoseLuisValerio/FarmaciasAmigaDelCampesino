package Controlador;

import Modelo.Modelo_Producto_Root_Pedido;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Root_Pedido {

    Modelo_Producto_Root_Pedido sensql;

    public Controlador_Producto_Root_Pedido() {
        sensql = new Modelo_Producto_Root_Pedido();
    }

    public Object[][] buscarProducto(String codigo, String suc) {
        String seleccion = "SELECT producto.IDPRODUCTO,producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,detallesucursal.Stock FROM ";
        String tablas = "producto INNER JOIN detallesucursal ON producto.`IDPRODUCTO` = detallesucursal.`IDPRODUCTO`INNER JOIN  proveedor ON producto.`IDPROVEEDOR` = proveedor.`IDproveedor` WHERE detallesucursal.idsucursal = 1 and (producto.IDPRODUCTO LIKE '%" + codigo + "%' OR producto.NOMBRE LIKE '%" + codigo + "%' OR producto.ACTIVO LIKE '%" + codigo + "%') and proveedor.RSOCIAL = '" + suc + "'" + " and detallesucursal.Stock > 10";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columna = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "detallesucursal.Stock"};

        datos = sensql.GetTabla(columna, sentencia, tablas);
        return datos;
    }

    public Object[][] cargaPocaExistencia(String suc) {
        String seleccion = "SELECT producto.IDPRODUCTO,producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,detallesucursal.Stock FROM ";
        String tablas = "producto INNER JOIN detallesucursal ON producto.`IDPRODUCTO` = detallesucursal.`IDPRODUCTO`INNER JOIN  proveedor ON producto.`IDPROVEEDOR` = proveedor.`IDproveedor` WHERE detallesucursal.Stock <= 10 and proveedor.RSOCIAL = '" + suc + "'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columna = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "detallesucursal.Stock"};
        datos = sensql.GetTabla(columna, sentencia, tablas);
        return datos;

    }

    public Object[][] cargaProductos() {
        String seleccion = "SELECT producto.IDPRODUCTO,producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,detallesucursal.Stock FROM ";
        String tablas = "producto INNER JOIN `detallesucursal` detallesucursal ON producto.`IDPRODUCTO` = detallesucursal.`IDPRODUCTO` Where detallesucursal.idsucursal = 1 and detallesucursal.Stock > 10";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columna = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "detallesucursal.Stock"};
        datos = sensql.GetTabla(columna, sentencia, tablas);
        return datos;
    }

    public Object[] cargaProveedores(String tablas) {
        String seleccion = "SELECT proveedor.RSOCIAL from ";
        String sentencia = seleccion + tablas;
        String columnas = "proveedor.RSOCIAL";
        return sensql.llenarCombo(tablas, columnas, sentencia);
    }

    public String Correo(String proveedor) {
        String idsucursal = null;
        String campos = "proveedor.EMAIL";
        String sentencia = "SELECT proveedor.EMAIL from proveedor WHERE proveedor.RSOCIAL = '" + proveedor + "'";
        return idsucursal = sensql.Correo(campos, sentencia);
    }

    public boolean nuevoPedido(String fecha, String usuario, String proveedor) {

        String datos[] = {fecha, usuario, proveedor};
        return sensql.insertar(datos, "INSERT INTO pedido (`Fecha`, `idusuario`, `idproveedor`) VALUES (?,?,?)");
    }

    public boolean nuevoDetallePedido(String idproducto, String cantidad, String idpedido) {

        String datos[] = {idproducto, cantidad, idpedido};
        return sensql.insertar(datos, "INSERT INTO detallepedido (`IDPRODUCTO`, `Cantidad`,`idPedido`) VALUES (?,?,?)");
    }

    public String ultimoIdpedido(String pedido,String fecha) {
        String idsucursal = null;
        String campos = "pedido.idPedido";
        String sentencia = "SELECT pedido.idPedido from "+pedido+" WHERE pedido.Fecha= '"+fecha+"'";
        return idsucursal = sensql.Correo(campos, sentencia);
    }
     public String idProveedor(String Proveedor){
         String idproveedor = null;
         String campos = "proveedor.iDproveedor";
         String sentencia="select proveedor.IDproveedor from proveedor where proveedor.RSOCIAL = '"+Proveedor+"'";
         return idproveedor = sensql.Correo(campos, sentencia);   
     }
}
