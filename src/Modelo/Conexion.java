package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Esta clase desencripta la conexión usando los datos de un archivo de
 * configuracion definida en el paquete "ArchivosConfiguracion".
 *
 * @author Jose Luis
 */
public class Conexion {
    private static String base = "";//Base de Datos
    private static String usuario = "";//usuario
    private static String pass = "";//contraseña
    private static String url = "";//host
    private int cont=0;

    Connection con = null;

    public void LeerArchivoConf() throws Exception {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("./src/ArchivosConfiguracion/ConfiguracionBD.properties");
            // cargamos el archivo de propiedades
            propiedades.load(entrada);
            //Se obtienen las valores almacenados en el archivo de configuracion
            base = Descifrar.Desencriptar(propiedades.getProperty("BD"));
            usuario = Descifrar.Desencriptar(propiedades.getProperty("User"));
            pass = Descifrar.Desencriptar(propiedades.getProperty("Psw"));
            url = Descifrar.Desencriptar(propiedades.getProperty("Servidor")) + base;    
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de configuración ");
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el flujo InputStream");
                }
            }
        }
    }

    public Conexion() {
        Conectar();
                }
    
    private void Conectar(){
        if(cont==0){
            try{
            LeerArchivoConf();
            cont++;
            }catch(Exception e){
                System.err.println("Error al llamar al método de lectura");
            }
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, pass);
            if (con != null) {
                //System.out.println("Conexión a base de datos "+base+". listo");
            }else{
                JOptionPane.showMessageDialog(null, "La conexión no se ha podido realizar.\n"
                    + "Verifique conexión a la BD. Contacte a los ingenieros.\n","Error al realizar conexión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error con conexión al hacer la conexión.\n"
                    + "Posibles problemas de conexión a Internet. Contacte a los ingenieros.\n"+e.getMessage(),"Error al realizar conexión", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo de configuración. "+e.getMessage(),"Error al realizar conexión", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    /** 
     * Retorna la conexión generada
     * @return
     */
    public Connection conectado() {
        Conectar();
        return con;
    }

    /**
     * Cierra la conexión hecha
     */
    public void desconectar() {
        try{
        con.close();
        //System.err.println("conexion terminada");
        }catch(SQLException e){
            System.err.println("Ha Ocurrido un error al cerrar la conexion: "+e.getMessage());
        }
    }
}
