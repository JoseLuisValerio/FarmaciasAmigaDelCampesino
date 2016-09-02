package Ayuda;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
     * Coloca el cursor en el textfield de edisoncorp seleccionado
     * @param txt recibe un textfield de edisoncorp
     */
    public void txtFoco(org.edisoncor.gui.textField.TextFieldRectBackground txt){
        txt.requestFocus();
    }
    
    /**
     * Recibe un boton y lo habilita o deshabilita segun sea el caso
     * @param boton recibe un objeto de tipo JButton
     * @param estado recibe un boolean para definir si el boton estara habilitado o no
     */
    public void botonHabilitar(JButton boton, boolean estado){
        boton.setEnabled(estado);
    }
    
    /**
     * Recibe un objeto de tipo textfield y lo habilita o deshabilita segun sea el caso
     * @param txt recibe el objeto textfield
     * @param estado recibe el estado true=habilitado, false=deshabilitado
     */
    public void txtHabilitar(org.edisoncor.gui.textField.TextFieldRectBackground txt, boolean estado){
        txt.setEnabled(estado);
    }
    
    /**
     * Elimina los registros contenidos en una tabla dejando su modelo definido
     * @param tabla recibe la tabla
     * @param modelo1 recibe el modelo de dicha tabla
     */
    public void tblLimpiar(JTable tabla, DefaultTableModel modelo1){
        for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo1.removeRow(i);
           i-=1;
       }
    }
    
    /**
     * Limpia el JLabel recibido, es decir, muestra en él ""
     * @param label recibe el JLabel
     */
    public void lblLimpiar(JLabel label){
        label.setText("");
    }
    
    /**
     * Desekecciona un objeto de tipo jCheckBox
     * @param checkbox recibe el JCheckBox
     */
    public void ChkbxLimpiar(JCheckBox checkbox){
        checkbox.setSelected(false);
    }
}
