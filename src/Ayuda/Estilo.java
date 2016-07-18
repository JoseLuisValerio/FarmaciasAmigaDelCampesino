/**
 * Contiene clases necesarias para facilitar configuraciones globales
 */
package Ayuda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Da formato visual a los elementos de las vistas
 */
public class Estilo {
    
    /**
     * JLabel tipo titulo, diferente fuente y mayor tamaño.
     * Fuente = Science Fair (Necesaria en Windows/fonts)
     * @param label 
     */
    public static void lblTitulo(JLabel label){
        label.setFont(new java.awt.Font("Science Fair",Font.PLAIN,16));
    }
    /**
     * Estilo de JLabel común.
     * @param label recibe el JLabel al que se le cambiará fuente, tipo y tamaño
     */
    public static void lblBody(JLabel label){
        label.setFont(new java.awt.Font("Century Gothic",Font.BOLD,12));
    }
    
    /**
     * Muestra los mensajes de correcto, advertencia y error en un JLabel dado.
     * @param label recibe dicho JLabel
     * @param mensaje recibe el mensaje que desplegará en el JLabel
     * @param opc recibe la opción de mensaje 1. Alerta, 2. Error, 3. Exito, cualquier otra no mostrará nada
     */
    public static void lblMensajes(JLabel label,String mensaje,int opc){
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
    /**
     * Recibe un JPanel colocandole borde en linea así como un titulo/encabezado
     * Fuente = Science Fair (Necesaria copiarla a Windows/fonts)
     * Tipo = PLAIN
     * Tamaño = 14
     * @param panel recibe un JPanel 
     * @param titulo recibe el titulo/encabezado que mostrará en el panel
     */
    public static void PnlTitulo(JPanel panel,String titulo){
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Science Fair", Font.PLAIN, 14), new java.awt.Color(0,0,0)));
    }
    
    /**
     * Recibe un jButton y un mensaje que mostrará en el mismo. 
     * Fuente = Britannic Bold, Plain, tamaño = 12
     * @param boton recibe el boton
     * @param mensaje recibe el texto que mostrará dicho botón
     */
    public static void BtnMsg(JButton boton, String mensaje){
        boton.setText(mensaje);
        boton.setFont(new java.awt.Font("Britannic Bold",Font.PLAIN,12));
    }
    
    /** 
     * Cambia la descripción del elemento TextField de edisoncorx 
     * @param textfield recibe el elemento
     * @param Descripcion recibe el mensaje/descripción que se mostrara en el elemento
     */
    public static void txtfDescripcion(org.edisoncor.gui.textField.TextFieldRectBackground textfield, String Descripcion){
        textfield.setDescripcion(Descripcion);
    }
    
    /**
     * Evita que el jframe que recibe se pueda dimensionar y lo coloca al centro de la pantalla
     * @param ventana recibe  jframe
     */
    public static void frmAnti(JFrame ventana){
        ventana.setLocationRelativeTo(null); //centra en la pantalla
        ventana.setResizable(false);//evita redimensionar
    }
}
