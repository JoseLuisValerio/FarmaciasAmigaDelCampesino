package Ayuda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ConectorCorreos {

    public static String usuario;
    public static String contrasena;
    public static String mensaje;
    public static String asunto = "Constancia";

    public void config() {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream("./src/ArchivosConfiguracion/ConfiguracionEmail.properties");
            // cargamos el archivo de propiedades
            propiedades.load(entrada);
            // obtenemos las propiedades y las imprimimos
            usuario = propiedades.getProperty("email");
            contrasena = propiedades.getProperty("psw");
            //destino1 = propiedades.getProperty("correomatutino");
            //destino2 = propiedades.getProperty("correovespertino");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void mail(String mensaje, String asunto,String archivo, String ruta,String destino) {

        ConectorCorreos.mensaje = mensaje;
        ConectorCorreos.asunto = asunto;
        config();
        C(archivo,ruta,destino);
    }

    public void C(String archivo, String ruta,String destino) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contrasena);
            }
        });

        try {
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(ruta)));
            adjunto.setFileName(archivo);
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.addRecipient(Message.RecipientType.BCC,
                    new InternetAddress(destino));
            message.setSubject(asunto);
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect(usuario, contrasena);

            t.sendMessage(message, message.getAllRecipients());
            //t.close();
            //     JOptionPane.showMessageDialog(null, "Mensaje enviado con Ã©xito");
            System.out.println("Formato de prestamo por E-mail: Enviado");
        } catch (Exception e) {
            System.out.println("Error al enviar email: " + e.getMessage());
        }
    }
}
