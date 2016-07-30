package Controlador;

import Modelo.Modelo_Usuario;

/**
 * Esta clase funge como el controlador de la vista/tabla Usuario
 * @author root
 */
public class Controlador_Usuario {
    Modelo.Modelo_Usuario ModelUser;

    public Controlador_Usuario() {
        ModelUser = new Modelo.Modelo_Usuario();
    }
    
    public Object[][] ConsultaUsuarios() {
        String seleccion = "SELECT Usuario.Alias,TipoUsuario.Nombre,Usuario.Nombre,Usuario.APaterno, Usuario.AMaterno FROM";
        String tablas = "(Usuario INNER JOIN TipoUsuario on Usuario.idTipoUsuario = TipoUsuario.idTipoUsuario); ";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"Usuario.Alias", "TipoUsuario.Nombre", "Usuario.Nombre","Usuario.APaterno", "Usuario.AMaterno"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = ModelUser.GetTabla(columnas, sentencia, tablas);

        return datos;
    }

    public Object[][] BuscaUsuario(String Usuario) {
        String seleccion = "SELECT Usuario.Alias,TipoUsuario.Nombre,Usuario.Nombre,Usuario.APaterno, Usuario.AMaterno FROM";
        String tablas = "(Usuario INNER JOIN TipoUsuario on Usuario.idTipoUsuario = TipoUsuario.idTipoUsuario) AND Usuario= '" + Usuario + "';";
        String sentencia = seleccion + tablas;
        Object[][] datos = null;
        String[] columnas = {"Usuario.Alias", "TipoUsuario.Nombre", "Usuario.Nombre","Usuario.APaterno", "Usuario.AMaterno"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = ModelUser.GetTabla(columnas, sentencia, tablas);
        return datos;
    }
    
    /**
     * Selecciona todos los tipos de usuario de la Tabla TipoUsuario y muestra sus nombres
     * @return un arreglo con los tipos de usuario
     */
    public Object[] CargaTipos(){
        String seleccion = "SELECT Nombre from ";
        String tablas ="TipoUsuario";
        String sentencia = seleccion + tablas;
        String columnas = "Nombre";
         return ModelUser.llenarCombo(tablas, columnas, sentencia);
    }
    
    public boolean InsertarUsuario(String Alias, String Password, String Tipo, String Nombre,String APaterno, String AMaterno){
        return ModelUser.InsertarOActualizar("INSERT INTO Usuario (Alias, Password, idTipoUsuario, Nombre, APaterno, AMaterno, Estatus)"
                + " VALUES ('"+Alias+"', SHA('"+Password+"'),'"+obtenerIdTipo(Tipo)+"','"+Nombre+"','"+APaterno+"', '"+AMaterno+"','1');");
    }
    
     public boolean ActualizarUsuario(String Alias, String Password, String Tipo, String Nombre,String APaterno, String AMaterno){
        return ModelUser.InsertarOActualizar("UPDATE Usuario SET Password = SHA('"+Password+"'), idTipoUsuario='"+obtenerIdTipo(Tipo)+"',Nombre='"+Nombre+"',APaterno='"+APaterno+"', AMaterno='"+AMaterno+"',Estatus='1' WHERE Alias = '"+Alias+"';");
    }
    
     public String obtenerIdTipo(String Tipo){
        String sentencia = "SELECT idTipoUsuario from TipoUsuario WHERE Nombre = '"+Tipo+"';";
        String datos = null;
        String columnas = "idTipoUsuario";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = ModelUser.obtenerIdTipoUsuario(columnas, sentencia);
        return datos;
    }

    
}
