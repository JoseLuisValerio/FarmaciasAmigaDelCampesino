package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Controlador de la vista Venta
 * @author root
 */
public class Controlador_Venta {
    private Modelo.Modelo_Venta Modelo;
    
    public Controlador_Venta(){
        Modelo = new Modelo.Modelo_Venta();
    }
    
    /**
     * Registra la venta en la tabla Venta
     * @param DineroElectro
     * @param Total
     * @param Usuario
     * @param Cliente
     * @return 
     */
    public boolean RegistrarVenta(String Fecha, String Hora,String DineroElectro, String Total,String Usuario, String Cliente, String Sucursal){
        boolean estado=false;
        String Datos[]={Fecha,Hora,DineroElectro,Total,Usuario,Cliente,Sucursal};
        estado= Modelo.insertar(Datos, "INSERT INTO Venta (Fecha, Hora, DinElectro, Total, idUsuario, idCliente, idSucursal) "
                + "VALUES(?,?,?,?,?,?,?);");
        return estado;
    }
    
    public boolean RegistrarDetalleVenta(String Cantidad, String idProducto, String idVenta, String Total){
        boolean exitoso=false;
        String datos[]={Cantidad, idProducto, idVenta, Total};
        exitoso = Modelo.insertar(datos, "INSERT INTO DetallesVenta(Cantidad, idProducto, idVenta, Total )"
                + "VALUES (?,?,?,?);");
        return exitoso;
    }
    
    public String ObteneridVenta(String Fecha, String Hora, String Sucursal, String Usuario){
        String idVenta="";
        idVenta = Modelo.GetIdVenta(Fecha, Hora, Sucursal, Usuario);
        return idVenta;
    }
    
    
    /**
     * Obtiene la consulta del producto a traves de su codigo
     * @param codigo recibe el codigo del producto
     * @return los datos del producto recibidos de la consulta
     */
    public Object[][] ObtenerProducto(String codigo){
        Object[][] datos= null;
        String columnas[]={"IdProducto","Nombre","Descripcion", "PPublico"};
        String SQLContar="Producto WHERE idProducto='"+codigo+"';";
        String SQLExecute="SELECT IdProducto, Nombre, Descripcion, PPublico FROM "+SQLContar;
        datos = Modelo.GetTable(columnas, SQLContar, SQLExecute);
        return datos;
    }
    
    public String ObtenerSucursal(){
        String sucursal="";
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
}
