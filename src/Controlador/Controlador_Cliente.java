package Controlador;

/**
 * Controlador de la clase Cliente
 *
 * @author root
 */
public class Controlador_Cliente {

    Modelo.Modelo_Cliente ModeloCliente;

    public Controlador_Cliente() {
        ModeloCliente = new Modelo.Modelo_Cliente();
    }

    /**
     * Hace la consulta a la clase modelo donde consulta todos los clientes en
     * caso de que el parametro este vacio o busca el cliente ingresado.
     *
     * @param Alias si es vacío, busca todos los clientes, de lo contrario,
     * busca el cliente ingresado
     * @return los datos generados por el modelo.
     */
    public Object[][] ConsultaCliente(String Alias) {
        Object[][] datos = null;
        String[] columnas = {"Alias", "Nombre", "APaterno", "AMaterno", "Tel", "Direccion", "Tipo_Cliente.Nombre", "DineroElectronico"};
        if (Alias.equals("")) {
            String SQLContar="Cliente INNER JOIN Tipo_Cliente ON Cliente.TipoCliente = Tipo_Cliente.idTipoCliente";
            String SQLExecute="SELECT Alias, Cliente.Nombre, APaterno, AMaterno, Tel, Direccion, Tipo_Cliente.Nombre, DineroElectronico FROM "+SQLContar;
            datos = ModeloCliente.GetTabla(columnas, SQLExecute,SQLExecute);
        } else {
            String SQLContar="Cliente INNER JOIN Tipo_Cliente ON Cliente.TipoCliente = Tipo_Cliente.idTipoCliente WHERE Alias = '" + Alias + "';";
            String SQLExecute="SELECT Alias, Cliente.Nombre, APaterno, AMaterno, Tel, Direccion, Tipo_Cliente.Nombre, DineroElectronico FROM "+SQLContar;
            datos = ModeloCliente.GetTabla(columnas,SQLExecute, SQLContar);
        }
        return datos;
    }

    /**
     * Metodo auxiliar para mostrar clientes en vista Venta
     * Muestra Alias, Nombre, APaterno, AMaterno y Tel
     * @param Buscar Si  Buscar.equals("") -> Todos los clientes
     *                   Buscar.equals("Algo") -> coincidencias en todos los campos descritos menos Alias
     * @return los datos de la consulta
     */
    public Object[][] ConsultaUnCliente(String Buscar) {
        Object[][] datos = null;
        String[] columnaminima = {"Alias", "Nombre", "APaterno", "AMaterno", "Tel", "DineroElectronico", "idCliente"};
        if (Buscar.equals("")) {
            String SQLContar="Cliente;";
            String SQLExecte="SELECT Alias, Nombre, APaterno, AMaterno, Tel, DineroElectronico,idCliente FROM "+SQLContar;
            datos = ModeloCliente.GetTabla(columnaminima,SQLExecte,SQLContar);
        } else {
            String SQLContar="Cliente WHERE Nombre LIKE '%"+Buscar+"%' OR APaterno LIKE '%"+Buscar+"%' OR AMaterno LIKE '%"+Buscar+"%' OR Tel LIKE '%"+Buscar+"%';";
            String SQLExecute="SELECT Alias, Nombre, APaterno, AMaterno, Tel,DineroElectronico, idCliente FROM "+SQLContar;
            datos = ModeloCliente.GetTabla(columnaminima, SQLExecute,SQLContar);
        }
        return datos;
    }
    
    /**
     * Selecciona todos los tipos de usuario de la Tabla Tipo_Cliente y muestra
     * sus nombres
     *
     * @return un arreglo con los tipos de usuario
     */
    public Object[] CargaTipos() {
        String seleccion = "SELECT Nombre from ";
        String tablas = "Tipo_Cliente";
        String sentencia = seleccion + tablas;
        String columnas = "Nombre";
        return ModeloCliente.llenarCombo(columnas, sentencia);
    }

    /**
     * Recibe los datos desde la Vista Cliente, los almacena en un arreglo
     * String y los envia al modelo donde se hará la ejecución
     *
     * @param Alias
     * @param Nombre
     * @param APaterno
     * @param AMaterno
     * @param Tel
     * @param Direccion
     * @param TipoCliente
     * @param DineroElectronico
     * @return Retorna el estado de la operación true = registro exitoso, false
     * = falla
     */
    public boolean insertarCliente(String Alias, String Nombre, String APaterno, String AMaterno, String Tel, String Direccion, String TipoCliente, String DineroElectronico) {
        String datos[] = {Alias, Nombre, APaterno, AMaterno, Tel, Direccion, obtenerIdTipo(TipoCliente), DineroElectronico};
        return ModeloCliente.insertar(datos, "INSERT INTO Cliente(Alias,Nombre,APaterno,AMaterno,Tel,Direccion,TipoCliente,DineroElectronico)"
                + " VALUES (?,?,?,?,?,?,?,?)");
    }

    public boolean ActualizarCliente(String Alias, String Nombre, String APaterno, String AMaterno, String Tel, String Direccion, String TipoCliente) {
        System.out.println(Alias);
        String datos[] = {Nombre, APaterno, AMaterno, Tel, Direccion, obtenerIdTipo(TipoCliente)};
        return ModeloCliente.insertar(datos, "UPDATE Cliente SET Nombre=? ,APaterno=? ,AMaterno=?,Tel=?,Direccion=?,TipoCliente=? WHERE Alias='" + Alias + "';");
    }

    /**
     * Recibe una descripción de tipo de cliente y retorna su correspondiente ID
     * para inserción en la tabla Cliente
     *
     * @param Tipo recibe el nombre de la descripción del tipo de cliente
     * @return el id de dicho tipo
     */
    public String obtenerIdTipo(String Tipo) {
        String sentencia = "SELECT idTipocliente FROM Tipo_Cliente WHERE Nombre = '" + Tipo + "';";
        String datos = null;
        String columnas = "idTipoCliente";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = ModeloCliente.obtenerIdTipoCliente(columnas, sentencia);
        return datos;
    }
}
