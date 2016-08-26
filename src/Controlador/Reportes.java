package Controlador;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase ticket para impresion
 * dependiendo de la clase venta o transaccion
 * @author root
 */
public class Reportes {
    Modelo.Conexion con;
    
    public Reportes(){
        con = new Modelo.Conexion();
    }
    
    @SuppressWarnings("unchecked")
    public void TicketVenta(String idVenta) {
        try {
            String ruta = "src/Jaspers/TicketVenta.jasper";
            Map parametros = new HashMap();
            parametros.put("idVenta", idVenta);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.conectado());
            JasperViewer jv = new JasperViewer(jp, false); //Eliminar cuando este listo
            jv.setVisible(true);
            //JasperPrintManager.printReport(jp, true);   
            con.desconectar();
        } catch (Exception ex) {
            System.err.println("Error al generar ticket Venta: "+ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public void TicketTransaccion(int ID) {
        try {
            String ruta = "src/Jaspers/TicketTransaccion.jasper";
            Map parametros = new HashMap();
            parametros.put("ID", ID);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.conectado());
            JasperViewer jv = new JasperViewer(jp, true); //Eliminar cuando este listo
            jv.setVisible(true);
            //JasperPrintManager.printReport(jp, true);   
            con.desconectar();
        } catch (Exception ex) {
            System.err.println("Error al generar ticket Trasaccion: "+ex.getMessage());
        }
    
}
        @SuppressWarnings("unchecked")
    public void VentasRoot(String Fecha) {
        try{
            String ruta="src/Jaspers/VentasDiario.jasper";
            Map parametros = new HashMap();
            parametros.put("Fecha", Fecha);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.conectado());
            JasperViewer jv = new JasperViewer(jp, true);
            jv.setVisible(true);
            jv.setTitle("Reporte de ventas");
            con.desconectar();
        }catch(Exception e){
            System.err.println("Error al leer el reporte de ventas");
        }
    }
    
    @SuppressWarnings("unchecked")
    public void ReporteCliente(String idCliente) {
        try{
            String ruta="src/Jaspers/VentasDiario.jasper";
            Map parametros = new HashMap();
            parametros.put("idCliente", idCliente);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.conectado());
            JasperViewer jv = new JasperViewer(jp, true);
            jv.setVisible(true);
            jv.setTitle("Reporte de cliente");
            con.desconectar();
        }catch(Exception e){
            System.err.println("Error al leer el reporte de cliente");
        }
    }
}
