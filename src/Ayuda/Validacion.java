package Ayuda;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * Clase de validación de texto
 * @author Jose Luis
 */
public class Validacion {

    /**
     * Verifica que lo ingresado en un textfield este vacio
     * @param txt recibe el textfield de edison.
     */
    public static void txtVacio(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        while(txt.getText().isEmpty()) {            
            txt.setDescripcion("Campo Vacio");
            break; 
        }
    }

    /**
     * Recibe dos objetos tipo JPasswordField y los compara para ver si lo introducido en ellos coincide
     * @param Pass1 Recibe un JPasswordField
     * @param Pass2  recibe el segundo JPasswordField
     * @return retorna el resultado de dicha comparación
     */
    public boolean PassCompara(JPasswordField Pass1, JPasswordField Pass2) {
        char[] Password1 = Pass1.getPassword();
        char[] Password2 = Pass2.getPassword();
        boolean esIgual = false;
        int puntero = 0;
        if (Password1.length != Password2.length) {
            esIgual = false;
        } else {
            while ((!esIgual) && (puntero < Password1.length)) {
                if (Password1[puntero] != Password2[puntero]) {
                    esIgual = false;
                    break;
                } else {
                    esIgual = true;
                }
            }
        }
        return esIgual;
    }

    public static void txtNumero(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        String numero = txt.getText();


            while (isNumeric(numero) == false) {

                txt.setText(null);
                break;
            }
        
    }

    private static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?-") && str.equals("") == false);
    }
    
    
}
