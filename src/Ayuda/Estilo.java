/**
 * Contiene clases necesarias para facilitar los estilos de 
 * las vistas.
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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
                label.setForeground(null);
                label.setBackground(null);
                path = "/Vista/Imagenes/Alerta.png";
                label.setIcon(null);
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
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Science Fair", Font.PLAIN, 14), new java.awt.Color(0,0,0)));
    }
    
    /**
     * Recibe un jButton y un mensaje que mostrará en el mismo. 
     * Fuente = Britannic Bold, Plain, tamaño = 12
     * @param boton recibe el boton 
     * @param opc 1.Agregar, 2.Actualizar,3.Cancelar,4.Login
     */
    public void BtnOpcion(JButton boton, int opc){
        String path = "";
        URL url = null;
        ImageIcon icon = null;
        boton.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        
        switch (opc) {
            case 1: //Agregar
                path = "/Vista/Imagenes/Agregar.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setText("Agregar");
                boton.setIcon(icon);
                break;

            case 2://Actualizar
                path = "/Vista/Imagenes/Update.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setText("Guardar");
                boton.setIcon(icon);
                break;
            case 3: //Cancelar
                path = "/Vista/Imagenes/Cancelar.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setText("Cancelar");
                boton.setIcon(icon);
                break;
            case 4: //Login
                path = "/Vista/Imagenes/Login.png";
                url = this.getClass().getResource(path);
                icon = new ImageIcon(url);
                boton.setText("Entrar");
                boton.setIcon(icon);
                break;
            default:
                boton.setText("No definido");
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
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Vista/Imagenes/Icono.png"));
        ventana.setLocationRelativeTo(null); //centra en la pantalla
        ventana.setResizable(false);//evita redimensionar
        ventana.setTitle(titulo);
        ventana.setIconImage(icon);
        ventana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }
    
    /**
     * Recibe un JLabel y dibuja la imagen de encabezado en él.
     * @param label recibe el panel de encabezado en el que se dibujara
     */
    public void lblLogo(JLabel label){
        String path = "/Vista/Imagenes/Encabezado.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
    }
    
    /**
     * Recibe un objeto de tipo JMenu agregandole un icono y cambiando la fuente
     * @param menu recibe un JMenu
     * @param opc recibe la opción que le corresponde al meú
     * 1. Archivo.
     * 2. Productos.
     * 3. Clientes
     * 4. Caja.
     * 5. Usuarios.
     * 6. Movimientos.
     * 7. Pedidos.
     */
    public void MnIcon(JMenu menu, int opc){
        String path = "";
        URL url = null; 
        ImageIcon tmpIcon = null;
        ImageIcon thumbnail = null;
        menu.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 13));
        
        switch(opc){
            case 1://Archivo
                path = "/Vista/Imagenes/Archivo.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 2: //Producto
                path = "/Vista/Imagenes/Producto.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 3: //Clientes
                path = "/Vista/Imagenes/Cliente.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 4: //Caja
                path = "/Vista/Imagenes/Caja.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 5: //Usuarios
                path = "/Vista/Imagenes/AgregarUsuario.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 6: //Movimientos
                path = "/Vista/Imagenes/Movimiento.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;

            case 7: //Pedidos
                path = "/Vista/Imagenes/Pedido.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;
                
            case 8: //Proveedores
                path = "/Vista/Imagenes/Proveedor.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;
             
            case 9: //Ventas
                path = "/Vista/Imagenes/Vender.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                menu.setIcon(thumbnail);
                break;
        }
    }
    
    /**
     * Recibe un JMenuItem se selecciona de que tipo es y se le coloca el icono correspondiente
     * @param item recibe el JMenuItem 
     * @param opc recibe la opción deseada.
     * 1. Cerrar sesión.
     */
    public void mnitemIcon(JMenuItem item, int opc){
        String path = "";
        URL url = null; 
        ImageIcon tmpIcon = null;
        ImageIcon thumbnail = null;
        item.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        
        switch(opc){
            case 1://Archivo
                path = "/Vista/Imagenes/Logout.png";
                url = this.getClass().getResource(path);
                tmpIcon = new ImageIcon(url);
                thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                item.setIcon(thumbnail);
                break;
        }
    }
}

