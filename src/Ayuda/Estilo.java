/**
 * Contiene clases necesarias para facilitar configuraciones globales
 */
package Ayuda;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
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
    public void lblTitulo(JLabel label){
        label.setFont(new java.awt.Font("Science Fair",Font.PLAIN,16));
    }
    /**
     * Estilo de JLabel común.
     * @param label recibe el JLabel al que se le cambiará fuente, tipo y tamaño
     */
    public void lblBody(JLabel label){
        label.setFont(new java.awt.Font("Century Gothic",Font.BOLD,12));
    }
    
    /**
     * Muestra los mensajes de correcto, advertencia y error en un JLabel dado.
     * @param label recibe dicho JLabel
     * @param mensaje recibe el mensaje que desplegará en el JLabel
     * @param opc recibe la opción de mensaje 1. Alerta, 2. Error, 3. Exito, cualquier otra no mostrará nada
     */
    public void lblMensajes(JLabel label,String mensaje,int opc){
        label.setOpaque(true);
        label.setText(mensaje);
        label.setFont(new java.awt.Font("Impact",Font.PLAIN,22));
        String path="";
        URL url=null;
        ImageIcon icon=null;
        
        switch (opc){
            case 1:
                //Alerta
                label.setForeground(Color.BLACK);
                label.setBackground(Color.YELLOW);
                path = "/Vista/Imagenes/Alerta.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                label.setIcon(icon);
            break;
            
            case 2:
                //Error
                label.setForeground(Color.yellow);
                label.setBackground(Color.red);            
                path = "/Vista/Imagenes/Error.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                label.setIcon(icon);
            break;
            
            case 3:
                //Correcto
                label.setForeground(Color.white);
                label.setBackground(Color.green);
                path = "/Vista/Imagenes/Correcto.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                label.setIcon(icon);
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
    public void PnlTitulo(JPanel panel,String titulo){
        //panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Science Fair", Font.PLAIN, 14), new java.awt.Color(0,0,0)));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Science Fair", Font.PLAIN, 14)));
    }
    
    /**
     * Recibe un jButton y un mensaje que mostrará en el mismo. 
     * Fuente = Britannic Bold, Plain, tamaño = 12
     * @param boton recibe el botón 
     * @param opc recibe la opción 1. Agregar, 2. Actualizar, 3. Cancelar
     */
    public void BtnOpcion(JButton boton, int opc){
        String path = "";
        URL url = null;
        ImageIcon icon = null;
        boton.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 13));
        switch (opc) {
            case 1: //Agregar
                path = "/Vista/Imagenes/Agregar.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setIcon(icon);
                boton.setText("Agregar");
                break;

            case 2://Actualizar
                path = "/Vista/Imagenes/Update.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setIcon(icon);
                boton.setText("Guardar");
                break;
                
            case 3: //Cancelar
                path = "/Vista/Imagenes/Cancelar.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setIcon(icon);
                boton.setText("Cancelar");
                break;
        }
    }
    
    /** 
     * Cambia la descripción del elemento TextField de edisoncorx 
     * @param textfield recibe el elemento
     * @param Descripcion recibe el mensaje/descripción que se mostrara en el elemento
     */
    public void txtfDescripcion(org.edisoncor.gui.textField.TextFieldRectBackground textfield, String Descripcion){
        textfield.setDescripcion(Descripcion);
    }
    
    /**
     * Evita que el jframe que recibe se pueda dimensionar y lo coloca al centro de la pantalla
     * @param ventana recibe  jframe
     */
    public void frmInicial(JFrame ventana,String titulo){
        ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/Icono.png"));
        ventana.setLocationRelativeTo(null); //centra en la pantalla
        ventana.setResizable(false);//evita redimensionar
        ventana.setTitle(titulo);
       ventana.setIconImage(icon);
       ventana.setBackground(Color.WHITE);
    }
    
    /**
     * Recibe un JLabel y dibuja la imagen de encabezado en él.
     * @param label recibe el panel de encabezado en el que se dibujara
     */
    public void lblEncabezado(JLabel label){
        String path = "/Vista/Imagenes/Encabezado.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
    }
}
