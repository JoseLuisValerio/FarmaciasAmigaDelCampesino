package Ayuda;

import javax.swing.JComboBox;
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
    public boolean txtVacio(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        boolean estado=false;
        while(txt.getText().isEmpty()) {            
            txt.setDescripcion("Campo Vacio");
            estado=true;
            break; 
        }
        return estado;
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

    public void txtNumero(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        String numero = txt.getText();


            while (isNumeric(numero) == false) {

                txt.setText(null);
                break;
            }
        
    }

    private boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?-") && str.equals("") == false);
    }
    
    public boolean ComboVacio(JComboBox combo){
        boolean vacio=false;
        if(combo.getSelectedIndex() <=0){
            vacio=true;
        }
        return vacio;
    }
    
    
}
