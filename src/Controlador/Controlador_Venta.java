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
        estado= Modelo.insertar(Datos, "INSERT INTO venta (Fecha, Hora, DinElectro, Total, idUsuario, idCliente, idSucursal) "
                + "VALUES(?,?,?,?,?,?,?);");
        return estado;
    }
    
    public boolean RegistrarDetalleVenta(String Cantidad, String idProducto, String idVenta, String Total){
        boolean exitoso=false;
        String datos[]={Cantidad, idProducto, idVenta, Total};
        exitoso = Modelo.insertar(datos, "INSERT INTO detallesventa(Cantidad, idProducto, idVenta, Total )"
                + "VALUES (?,?,?,?);");
        return exitoso;
    }
    
    /**
     * Actualiza el stock y el número de vendidos de acuerdo a la cantidad vendida en Venta
     * @param idSucursal recibe la sucursal de la que se esta realizando la venta
     * @param Cantidad recibe la cantidad vendida del producto
     * @param idProducto recibe el producto que actualizará
     * @return el resultado de la operación realizada
     */
    public boolean ActualizarStockYVendidos(String idSucursal, String Cantidad, String idProducto){
        boolean exitoso = false;
        int auxCantidad = Integer.parseInt(Cantidad);
        exitoso = Modelo.ActualizaStockYVendidos(idProducto, idSucursal, auxCantidad);
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
    public Object[][] ObtenerProducto(String codigo, String idSucursal){
        Object[][] datos= null;
        String columnas[]={"producto.IdProducto","Nombre","Descripcion", "PPublico"};
        String SQLContar="producto INNER JOIN detallesucursal ON producto.idProducto = detallesucursal.idProducto "
                + "WHERE detallesucursal.idProducto='"+codigo+"' && detallesucursal.idSucursal ='"+idSucursal+"';";
        String SQLExecute="SELECT producto.IdProducto, Nombre, Descripcion, PPublico FROM "+SQLContar;
        datos = Modelo.GetTable(columnas, SQLContar, SQLExecute);
        return datos;
    }
    
    /**
     * Obtiene la sucursal desde la que se esta haciendo la venta
     * lee el archivo de configuración
     * @return el número de sucursal
     */
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
    
    /**
     * Hace la llamada para actualizar el dinero electronico del cliente si es que paga con dinero electronico
     * @param idCliente recibe el id del cliente
     * @param DinElectro recibe el dinero electronico original
     * @return el resultado de la operación.
     */
    public boolean RestaDinElectro(String idCliente, float DinElectro) {
        boolean exitoso = false;
        String SQL ="UPDATE cliente SET DineroElectronico=DineroElectronico -? WHERE idCliente='"+idCliente+"';";
        System.out.println("idCliente: "+idCliente+" Dinelectro: "+DinElectro);
        System.out.println("Se resta dinero electronico");
        exitoso = Modelo.ActualizaDinElectro(DinElectro, SQL);
        return exitoso;
    }
    
     /**
     * Hace la llamada para actualizar el dinero electronico del cliente si es que paga con dinero electronico
     * @param idCliente recibe el id del cliente
     * @param DinElectro recibe el dinero electronico original
     * @return el resultado de la operación.
     */
    public boolean SumaDinElectro(String idCliente, float DinElectro) {
        boolean exitoso = false;
        String SQL ="UPDATE cliente SET DineroElectronico=DineroElectronico+? WHERE idCliente='"+idCliente+"';";
        exitoso = Modelo.ActualizaDinElectro(DinElectro, SQL);
        return exitoso;
    }
    
    public boolean ActualizaCaja(String idSucursal, Float Monto){
        boolean exitoso = false;
        exitoso = Modelo.ActualizaCaja(idSucursal, Monto);
        return exitoso;
    }
}
