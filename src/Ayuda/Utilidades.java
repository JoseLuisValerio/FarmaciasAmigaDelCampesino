package Ayuda;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Código diverso: Limpieza de tablas, de textfields y jPasswordFields
 * @author root
 */
public class Utilidades {
    
    /**
     * Recibe un textField y borra lo que contiene
     * @param textfield recibe un textField de edisoncorp
     */
    public void txtLimpiar(org.edisoncor.gui.textField.TextFieldRectBackground textfield){
        textfield.setText("");
    }
    
    /**
     * Recibe un JPasswordField y borra lo que contiene
     * @param passField recibe un JPasswordField de Swing
     */
    public void passLimpiar(JPasswordField passField){
        passField.setText("");
    }
    
    /**
     * Recibe una JTable, define un nuevo modelo así como elimina las filas de dicha tabla
     * dejandola vacía.
     * @param tabla recibe una JTable de la clase Swing
     */
    public void tblLimpiar(JTable tabla) {
        DefaultTableModel Modelo = new DefaultTableModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setModel(Modelo);
            Modelo.removeRow(i);
            i -= 1;
        }
    }
    
    /**
     * Coloca el cursor en el textfield de edisoncorp seleccionado
     * @param txt recibe un textfield de edisoncorp
     */
    public void txtFoco(org.edisoncor.gui.textField.TextFieldRectBackground txt){
        txt.requestFocus();
    }
}
