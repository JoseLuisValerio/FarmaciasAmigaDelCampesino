package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Consultar {

    private Modelo.Modelo_Producto_Consultar sensql;
    String suc = ObtenerSucursal();

    public Controlador_Producto_Consultar() {
        sensql = new Modelo.Modelo_Producto_Consultar();
        String suc = ObtenerSucursal();

    }

    public String ObtenerSucursal() {
        String sucursal = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;

        try {
            entrada = new FileInputStream("./src/ArchivosConfiguracion/Sucursal.properties");
            propiedades.load(entrada);
            //Se obtienen las valores almacenados en el archivo de configuracion
            sucursal = propiedades.getProperty("Sucursal");
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de configuración ");
        }
        return sucursal;
    }

    public Object[][] mostrarProductos() {
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = "+suc+")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO) "
                + "INNER JOIN area on area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] buscarCodigo(String codigo) {
        Object[][] datos = null;
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = "+suc+")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and producto.IDPRODUCTO like "+codigo+") "
                + "INNER JOIN area on area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        datos = sensql.GetTabla(columnas, sentencia, tablas);
        return datos;
    }

    public Object[][] buscarProducto(String busqueda) {
        Object[][] datos = null;
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = "+suc+")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and (producto.NOMBRE like '%"+busqueda+"%' or producto.ACTIVO LIKE '%"+busqueda+"%' or producto.DESCRIPCION LIKE '%"+busqueda+"%')) "
                + "INNER JOIN area on area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        datos = sensql.GetTabla(columnas, sentencia, tablas);
        return datos;
    }

    public Object[] cargaSucursal(String tablas) {
        String seleccion = "SELECT area.Nombre FROM ";
        String sentencia = seleccion + tablas;
        String columnas = "area.Nombre";
        return sensql.llenarCombo(tablas, columnas, sentencia);
    }
    public Object [][] buscarArea(String area){
        Object [][] datos =null;
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = "+suc+")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO) "
                + "INNER JOIN area on area.idArea = detallesucursal.idArea and area.Nombre like '%"+area+"%'";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        datos = sensql.GetTabla(columnas, sentencia, tablas);
        return datos;
    }
}
