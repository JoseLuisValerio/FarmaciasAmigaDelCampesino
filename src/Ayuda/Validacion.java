/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayuda;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Jose Luis
 */
public class Validacion {

    public static void txtVacio(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        if (txt.getText().isEmpty()) {
            txt.setDescripcion("Campo Vacio");
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
                } else {
                    valor = true;
                }
            }
        }
        if (valor = false) {
            //JOptionPane.showMessageDialog(this,"Las Contraseñas no Coinciden","EROR DE CONTRASEÑA",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN", "ERROR DE CONTRASEÑA", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void txtNumero(org.edisoncor.gui.textField.TextFieldRectBackground txt) {
        String numero = txt.getText();


            if (isNumeric(numero) == true) {

            } else {
                txt.setText(null);
            }
        
    }

    private static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?-") && str.equals("") == false);
    }
    
    
}
