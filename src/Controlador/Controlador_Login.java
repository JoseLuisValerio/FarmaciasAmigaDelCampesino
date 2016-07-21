package Controlador;

import Ayuda.Sesion;
import Modelo.Modelo_Login;
import Modelo.Modelo_Producto;
import Vista.Inicio;
import Vista.Login;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.edisoncor.gui.textField.TextFieldRectBackground;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Login {

    Modelo_Login sensql;
    //Sesion se= new Sesion();
        //Inicio pr =new Inicio();

    public Controlador_Login() {
        sensql = new Modelo_Login();
    }

    public boolean consultaUsuario(String usuario, String Pass) throws IOException {
        Object[][] datos = null;
        boolean se = false;
        String[] columnas = {"Alias", "Nombre", "APATERNO", "AMATERNO", "tipousuario.nombre"};
        datos = sensql.Comprueba(columnas, "SELECT usuario.Alias,usuario.Nombre,usuario.APATERNO, usuario.AMATERNO,tipousuario.nombre FROM usuario INNER JOIN tipousuario where usuario.ALIAS='" + usuario + "' and usuario.PASSWORD='" + Pass + "' and (usuario.idtipousuario = tipousuario.idtipousuario)");
        String Alias = (String) datos[0][0];
        String Nombre = (String) datos[0][1] +" "+ (String) datos[0][2]+" " + (String) datos[0][3];
        String tuser = (String) datos[0][4];
        if(datos[0][0]==null){
            se=false;
            JOptionPane.showMessageDialog(null, "TUS DATOS NO SON CORRECTOS VERIFICA PORFAVOR", "ERROR DE SESION", JOptionPane.ERROR_MESSAGE);
        }else{
            se=true;
            Sesion.iniciarSesion(Alias,Nombre,tuser);
        }
        return se;

    }


}
