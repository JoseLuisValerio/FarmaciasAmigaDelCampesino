package Ayuda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;


/**
 *
 * @author Jose Luis
 * Clase que Recibe datos para la creación de sesiones
 */
public class Sesion {
   static ArrayList<String>datosSesion= new ArrayList<String>();
   static ArrayList<Integer>permisosSesion= new ArrayList<Integer>();

   
    public static void iniciarSesion(String user,String name,String tuser) throws IOException{
//rebie el usuario , el nombre de usuario  y el tipo para asignar permisos
        datosSesion.add(user);
        datosSesion.add(name);
        datosSesion.add(tuser);
        
		/** FORMA 2 DE ESCRITURA. Con el fichero codificado en UTF-8 **/
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("datosSesion.frm"), "UTF-8"));
			
			// Escribimos linea a linea en el fichero
			for (String linea :datosSesion) {
				try {
					out.write(linea+"\n");
				} catch (IOException ex) {
					System.err.println("Mensaje excepcion escritura: " + ex.getMessage());
				}
			}

		} catch (UnsupportedEncodingException | FileNotFoundException ex2) {
			System.err.println("Mensaje error 2: " + ex2.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException ex3) {
				System.err.println("Mensaje error cierre fichero: " + ex3.getMessage());
			}
		}
        
        
    }
    
    public static void cerrarSesion(){
        //Identifica el archivo creado para eliminar los daots creados en la sesion
    File fichero = new File("datosSesion.frm");
    if (fichero.delete())
   System.err.println("El fichero ha sido borrado satisfactoriamente");
    else
   System.err.println("El fichero no puede ser borrado");
            
    }
    public static ArrayList<String> obtenerSesion() throws IOException{
       //Retorna los datos de la sesion en en un ArrayList de tipo String con los datos leidos del archivo de la sesión
        String cadena;
        ArrayList <String> datos= new ArrayList <String>();
      FileReader f = new FileReader("datosSesion.txt");
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          datos.add(cadena);
      }
      b.close();
      
       return datos;
    }
}