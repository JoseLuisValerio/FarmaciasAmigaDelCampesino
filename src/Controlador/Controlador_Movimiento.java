/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Movimiento;
import Modelo.Modelo_Producto_Acomodar;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Movimiento {

    Modelo_Movimiento sensql;
    String suc = ObtenerSucursal();

    //String caja = IdCaja();
    public Controlador_Movimiento() {
        sensql = new Modelo_Movimiento();
        String suc = ObtenerSucursal();
        //String caja = IdCaja();
    }

    public String ObtenerSucursal() {
        String sucursal = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;

        try {
            entrada = new FileInputStream("./src/ArchivosConfiguracion/Sucursal.properties");
            propiedades.load(entrada);
            //Se obtienen las valores almacenados en el archivo de configuracion
            sucursal = propiedades.getProperty("Sucursal");
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de configuración ");
        }
        return sucursal;
    }

    public boolean nuevoMovimiento(String Monto, String Descripcion, String Fecha, String Hora, String IdUsuario) {
        String caja = IdCaja();
        String datos[] = {Monto, Descripcion, Fecha, Hora, IdUsuario, caja};
        return sensql.insertar(datos, "INSERT INTO `movimiento` (`MONTO`, `DESCRIPCION`,`FECHA`, `HORA`, `idusuario`, `idcaja`) VALUES (?,?,?,?,?,?)");
    }

    public String obtenerSaldo() {
        String caja = IdCaja();
        String sentencia = "SELECT caja.saldototal from caja WHERE caja.idsucursal = '" + suc + "'";
        String datos = null;
        String columnas = "caja.saldototal";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.obtenerIdProvedor(columnas, sentencia);
        return datos;
    }

    public String IdCaja() {
        String sentencia = "SELECT caja.idcaja from caja WHERE caja.idsucursal = '" + suc + "'";
        String datos = null;
        String columnas = "caja.idcaja";
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.obtenerIdProvedor(columnas, sentencia);
        return datos;
    }

    public boolean actualizaSaldo(String monto, boolean opc) {
        String caja = IdCaja();
        String campos[] = {monto, caja};
        String sentencia;
        if (opc == false) {
            sentencia = "UPDATE caja SET saldototal=saldototal-? WHERE caja.idcaja =?";
            return sensql.insertar(campos, sentencia);
        } else {
            sentencia = "UPDATE caja SET saldototal=saldototal+? WHERE caja.idcaja =?";
        }
        return sensql.insertar(campos, sentencia);
    }
}
