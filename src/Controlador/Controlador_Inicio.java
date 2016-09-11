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
    
    public Controlador_Inicio(){
        Model = new Modelo.Modelo_Inicio();
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
        datos = Model.GetTabla(columnas,"SELECT Nombre, Direccion FROM Sucursal WHERE IdSucursal = '"+ObtenerSucursal()+"';");
        return datos;
    }

public boolean HayMovimientos(String Fecha, String idUsuario){
    boolean Existe=false;
    Existe = Model.ExisteMovimientos(Fecha, idUsuario);
    return Existe;
}


    
}
