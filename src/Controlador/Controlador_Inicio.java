package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author root
 */
public class Controlador_Inicio {
    Modelo.Modelo_Inicio Model;
    String suc = ObtenerSucursal();
    public Controlador_Inicio(){
        Model = new Modelo.Modelo_Inicio();
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

public Object[][] DatosSucursal() {
        Object[][] datos = null;
        String[] columnas = {"Nombre","Direccion"};
        datos = Model.GetTabla(columnas,"SELECT Nombre, Direccion FROM sucursal WHERE IdSucursal = '"+ObtenerSucursal()+"';");
        return datos;
    }

public boolean HayMovimientos(String Fecha, String idUsuario){
    boolean Existe=false;
    Existe = Model.ExisteMovimientos(Fecha, idUsuario);
    return Existe;
}

    public Object[][] mostrarProductos() {
        Object[][] datos = null;
        String seleccion = "SELECT producto.IDPRODUCTO,producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,detallesucursal.Stock FROM ";
        String tablas = "(producto INNER JOIN (detallesucursal INNER JOIN sucursal ON detallesucursal.idsucursal = sucursal.idsucursal AND sucursal.idsucursal = '1') ON producto.IDPRODUCTO = detallesucursal.IDPRODUCTO and detallesucursal.Stock <20)INNER JOIN area ON area.idArea = detallesucursal.idArea";
        String sentencia = seleccion + tablas;
        String[] columnas = {"producto.IDPRODUCTO", "producto.NOMBRE", "producto.ACTIVO", "producto.DESCRIPCION","detallesucursal.Stock"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = Model.ObtenetExistencias(columnas, sentencia, tablas);

        return datos;
    }
    
}
