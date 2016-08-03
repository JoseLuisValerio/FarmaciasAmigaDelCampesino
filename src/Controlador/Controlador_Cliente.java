package Controlador;

/**
 * Controlador de la clase Cliente
 * @author root
 */
public class Controlador_Cliente {
    Modelo.Modelo_Cliente ModeloCliente;
    
    public Controlador_Cliente(){
        ModeloCliente = new Modelo.Modelo_Cliente();
    }
    
    /**
     * Hace la consulta a la clase modelo donde consulta todos los clientes en caso 
     * de que el parametro este vacio o busca el cliente ingresado.
     * @param Alias si es vacío, busca todos los clientes, de lo contrario, busca el cliente
     * ingresado
     * @return los datos generados por el modelo.
     */
    public Object[][] ConsultaCliente(String Alias) {
        Object[][] datos = null;
        String[] columnas = {"Alias","Nombre","APaterno","AMaterno","Tel","Direccion","Tipo_Cliente.Nombre","DineroElectronico"};
        if(Alias.equals("")){
        datos = ModeloCliente.GetTabla(columnas,"SELECT Alias, Cliente.Nombre, APaterno, AMaterno, Tel, Direccion, Tipo_Cliente.Nombre, DineroElectronico "
                + "FROM"
                + " Cliente INNER JOIN Tipo_Cliente ON Cliente.TipoCliente = Tipo_Cliente.idTipoCliente");
        }else {
        datos = ModeloCliente.GetTabla(columnas,"SELECT Alias, Cliente.Nombre, APaterno, AMaterno, Tel, Direccion, Tipo_Cliente.Nombre, DineroElectronico "
                + "FROM"
                + " Cliente INNER JOIN Tipo_Cliente ON Cliente.TipoCliente = Tipo_Cliente.idTipoCliente WHERE Alias = '"+Alias+"'");
        }
        return datos;
    }
    
    /**
     * Selecciona todos los tipos de usuario de la Tabla Tipo_Cliente y muestra sus nombres
     * @return un arreglo con los tipos de usuario
     */
    public Object[] CargaTipos(){
        String seleccion = "SELECT Nombre from ";
        String tablas ="Tipo_Cliente";
        String sentencia = seleccion + tablas;
        String columnas = "Nombre";
         return ModeloCliente.llenarCombo(columnas, sentencia);
    }
    
    /**
     * Recibe los datos desde la Vista Cliente, los almacena en un arreglo String y los
     * envia al modelo donde se hará la ejecución
     * @param Alias
     * @param Nombre
     * @param APaterno
     * @param AMaterno
     * @param Tel
     * @param Direccion
     * @param TipoCliente
     * @param DineroElectronico
     * @return Retorna el estado de la operación true = registro exitoso, false = falla
     */
    public boolean insertarCliente(String Alias,String Nombre, String APaterno, String AMaterno,String Tel,String Direccion,String TipoCliente,String DineroElectronico) {
        String datos[] = {Alias,Nombre,APaterno, AMaterno,Tel,Direccion,obtenerIdTipo(TipoCliente),DineroElectronico};           
            return ModeloCliente.insertar(datos, "INSERT INTO Cliente(Alias,Nombre,APaterno,AMaterno,Tel,Direccion,TipoCliente,DineroElectronico)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
    }
    
    /**
     * Recibe una descripción de tipo de cliente y retorna su correspondiente ID
     * para inserción en la tabla Cliente
     * @param Tipo recibe el nombre de la descripción del tipo de cliente
     * @return el id de dicho tipo
     */
     public String obtenerIdTipo(String Tipo){
        String sentencia = "SELECT idTipocliente from Tipo_Cliente WHERE Nombre = '"+Tipo+"';";
        String datos = null;
        String columnas = "idTipoCliente";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = ModeloCliente.obtenerIdTipoCliente(columnas, sentencia);
        return datos;
    }
}
