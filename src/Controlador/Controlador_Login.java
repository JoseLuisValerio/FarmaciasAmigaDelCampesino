package Controlador;

import Ayuda.Sesion;
import Modelo.Modelo_Login;
import java.io.IOException;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Login {

    Modelo_Login sensql;

    public Controlador_Login() {
        sensql = new Modelo_Login();
    }

    public boolean consultaUsuario(String usuario, String Pass) throws IOException {
        Object[][] datos = null;
        boolean se = false;
        String[] columnas = {"Alias", "Nombre", "APATERNO", "AMATERNO", "tipousuario.nombre","usuario.idUsuario"};
        datos = sensql.Comprueba(columnas, "SELECT usuario.Alias,usuario.Nombre,usuario.APATERNO, usuario.AMATERNO,tipousuario.nombre, usuario.idUsuario FROM usuario INNER JOIN tipousuario where usuario.ALIAS='" + usuario + "' and usuario.PASSWORD=SHA('" + Pass + "') and (usuario.idtipousuario = tipousuario.idtipousuario) and (usuario.Estatus = 1)");
        String Alias = (String) datos[0][0];
        String Nombre = (String) datos[0][1] +" "+ (String) datos[0][2]+" " + (String) datos[0][3];
        String tuser = (String) datos[0][4];
        String idUsuario = (String) datos[0][5];
        if(datos[0][0]==null){
            se=false;
        }else{
            se=true;
            Sesion.iniciarSesion(Alias,Nombre,tuser,idUsuario);
        }
        return se;

    }


}
