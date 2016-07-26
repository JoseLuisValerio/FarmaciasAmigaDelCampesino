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

    
    public static void txtCompara(JPasswordField txt, JPasswordField txt2) {
        char[] txt0;
        char[] txt1;
        boolean valor = false;
        int puntero = 0;

        txt0 = txt.getPassword();
        txt1 = txt2.getPassword();

        if (txt0.length != txt1.length) {
            valor = false;
        } else {
            while ((!valor) && (puntero < txt0.length)) {
                if (txt0[puntero] != txt1[puntero]) {
                    valor = false;
                    JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN", "ERROR DE CONTRASEÑA", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    valor = true;
                }
            }
        }
        if (valor = false) {
            //JOptionPane.showMessageDialog(this,"Las Contraseñas no Coinciden","EROR DE CONTRASEÑA",JOptionPane.ERROR_MESSAGE);

        }
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
