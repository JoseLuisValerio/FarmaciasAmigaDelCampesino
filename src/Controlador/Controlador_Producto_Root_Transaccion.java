
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
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "detallesucursal.Stock", "sucursal.nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscarProducto(String codigo) {
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,detallesucursal.Stock,sucursal.nombre from  ";
        String tablas = "(producto INNER JOIN proveedor ON producto.IDPROVEEDOR = proveedor.IDproveedor)INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.nombre = 'Bodega') where producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and (producto.IDPRODUCTO LIKE '%" + codigo + "%' OR producto.NOMBRE LIKE '%" + codigo + "%' OR producto.ACTIVO LIKE '%" + codigo + "%')";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columna = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "detallesucursal.Stock", "sucursal.nombre"};

        datos = sensql.GetTabla(columna, sentencia, tablas);
        return datos;
    }
    
    public Object[][] comprobar(String codigo, String sucursal) {
        String seleccion = "SELECT detallesucursal.IDPRODUCTO from  ";
        String tablas = "detallesucursal WHERE detallesucursal.IDPRODUCTO='"+codigo+"' AND detallesucursal.idsucursal= '"+sucursal+"'";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columna = {"detallesucursal.IDPRODUCTO"};

        datos = sensql.GetTabla(columna, sentencia, tablas);
        return datos;   
    }

    public Object[] cargaSucursal(String tablas) {
        String seleccion = "SELECT sucursal.nombre from ";
        String sentencia = seleccion + tablas;
        String columnas = "sucursal.nombre";
        return sensql.llenarCombo(tablas, columnas, sentencia);
    }

    public boolean transaccion(String idproducto, String idsucursal, String stock) {
        String campos[] = {stock, idproducto, idsucursal};
        String sentencia = "UPDATE detallesucursal SET Stock = Stock + ? WHERE detallesucursal.IDPRODUCTO = ? and detallesucursal.idsucursal = ?";
        return sensql.insertar(campos, sentencia);
    }

    public boolean actualizarStock(String idproducto, String stock) {
        String campos[] = {stock, idproducto};
        String sentencia = "UPDATE detallesucursal SET Stock = Stock - ? WHERE detallesucursal.IDPRODUCTO = ? and detallesucursal.idsucursal = 1";
        return sensql.insertar(campos, sentencia);
    }

    public String idsucursal(String sucursal) {
        String idsucursal = null;
        String campos = "sucursal.idsucursal";
        String sentencia="SELECT sucursal.idsucursal from sucursal WHERE sucursal.nombre = '" + sucursal + "'";
        return idsucursal = sensql.idSucursal(campos, sentencia);
        }
    public boolean ingresarDetalleNuevo(String idproducto, String sucursal, String stock, String vendidos, String area) {

        String datos[] = {idproducto, sucursal, stock, vendidos, area};
        return sensql.insertar(datos, "INSERT INTO `detallesucursal` (`IDPRODUCTO`, `idsucursal`, `Stock`, `Vendidos`, `idArea`) VALUES (?,?,?,?,?)");
    }
    public boolean nuevaTransaccion(String fecha, String usuario, String idsucursal) {

        String datos[] = {fecha, usuario, idsucursal};
        return sensql.insertar(datos, "INSERT INTO transaccion (`Fecha`, `idusuario`, `idsucursal`) VALUES (?,?,?)");
    }
    public boolean nuevoDetalleTransaccion(String idTransanccion, String IDPRODUCTO, String Cantidad) {

        String datos[] = {idTransanccion, Cantidad, IDPRODUCTO};
        return sensql.insertar(datos, "INSERT INTO `detalletransaccion` (`idTransaccion`, `Cantidad`, `IDPRODUCTO`) VALUES (?,?,?)");
    }
        public String ultimoIdTransaccion(String Transaccion,String fecha) {
        String idsucursal = null;
        String campos = "transaccion.idTransaccion";
        String sentencia = "SELECT transaccion.idTransaccion FROM transaccion WHERE transaccion.Fecha ='"+fecha+"'";
        return idsucursal = sensql.Correo(campos, sentencia);
    }
   }
