/**
 * Contiene clases necesarias para facilitar configuraciones globales
 */
package Ayuda;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * Da formato visual a los elementos de las vistas
 */
public class Estilo {
    
    /**
     * Da formato a un jLabel asignandi
     * @param label 
     */
    public static void lblTitulo(JLabel label){
        label.setFont(new java.awt.Font("Science Fair",Font.PLAIN,16));
    }
    
    public static void lblBody(JLabel label){
        label.setFont(new java.awt.Font("Century Gothic",Font.BOLD,12));
    }
    
    public static void lblAlerta(JLabel label,String mensaje,int opc){
        label.setOpaque(true);
        label.setText(mensaje);
        label.setFont(new java.awt.Font("Impact",Font.PLAIN,22));
        
        
        switch (opc){
            case 1:
                //Alerta
                label.setForeground(Color.BLACK);
                label.setBackground(Color.YELLOW);
            break;
            
            case 2:
                //Error
                label.setForeground(Color.yellow);
                label.setBackground(Color.red);            
            break;
            case 3:
                //Exito
                label.setForeground(Color.white);
                label.setBackground(Color.green);
            break;
            default:
            
            break;
        }
        
    }
    
    public static void PnlTitulo(JPanel panel,String titulo){
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Science Fair", Font.PLAIN, 14), new java.awt.Color(0,0,0)));
    }
    
    public static void BtnMsg(JButton boton, String mensaje){
        boton.setText(mensaje);
        boton.setFont(new java.awt.Font("Britannic Bold",Font.PLAIN,12));
    }
    
    public static void txtfDescripcion(org.edisoncor.gui.textField.TextFieldRectBackground textfield, String Descripcion){
        textfield.setDescripcion(Descripcion);
    }
    
    public static void frmAnti(JFrame ventana){
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
    }
}
