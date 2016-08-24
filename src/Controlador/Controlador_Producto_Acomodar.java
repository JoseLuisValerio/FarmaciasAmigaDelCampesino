package Controlador;

import Modelo.Modelo_Producto_Acomodar;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto_Acomodar {

    Modelo_Producto_Acomodar sensql;
    String suc = ObtenerSucursal();

    public Controlador_Producto_Acomodar() {
        sensql = new Modelo_Producto_Acomodar();
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
        Object[][] datos = null;
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = " + suc + ")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO)"
                + "INNER JOIN area on area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }
public Object[][] buscarProducto(String busqueda) {
        Object[][] datos = null;
        String seleccion = "SELECT producto.IDPRODUCTO, producto.NOMBRE,producto.ACTIVO,producto.PPUBLICO,detallesucursal.Stock,area.Nombre from ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal on detallesucursal.idsucursal = sucursal.idsucursal and sucursal.idsucursal = "+suc+")"
                + "on producto.IDPRODUCTO =detallesucursal.IDPRODUCTO and (producto.NOMBRE like '%"+busqueda+"%' or producto.ACTIVO LIKE '%"+busqueda+"%' or producto.DESCRIPCION LIKE '%"+busqueda+"%')) "
                + "INNER JOIN area on area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.PPUBLICO", "detallesucursal.Stock", "area.Nombre"};
        datos = sensql.GetTabla(columnas, sentencia, tablas);
        return datos;
    }
public Object[] cargaAreas() {
        String seleccion = "SELECT area.Nombre FROM area";
        String sentencia = seleccion;
        String columnas = "area.Nombre";
        return sensql.llenarCombo("area", columnas, sentencia);
    }
    public boolean ingresarNuevaArea(String Nombre) {

        String datos[] = {Nombre};
        return sensql.insertar(datos, "INSERT INTO area (area.Nombre) VALUES(?)");
    }
        public boolean actualizarArea(String idproducto,String area) {
        String campos[] = {area, idproducto};
        String sentencia = "UPDATE detallesucursal SET detallesucursal.idArea =? WHERE detallesucursal.IDPRODUCTO= ? AND detallesucursal.idsucursal = "+suc;
        return sensql.insertar(campos, sentencia);
        }
        public String idArea(String area) {
        String idsucursal = null;
        String campos = "area.idArea";
        String sentencia="SELECT area.idArea from area WHERE area.nombre = '" + area + "'";
        return idsucursal = sensql.idSucursal(campos, sentencia);
        }
}
