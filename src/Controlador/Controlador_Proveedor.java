/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Producto_Root;
import Modelo.Modelo_Proveedor;

/**
 *
 * @author Jose Luis
 */

public class Controlador_Proveedor {
      Modelo_Proveedor sensql;

    public Controlador_Proveedor() {
        sensql = new Modelo_Proveedor();
    }
    
    public Object[][] consulta_Proveedores() {

        String seleccion = "SELECT proveedor.IDproveedor,proveedor.RSOCIAL, proveedor.CONTACTO, proveedor.TEL, proveedor.EMAIL, proveedor.DIRECCION from ";
        String tablas = "proveedor";
        String sentencia = seleccion + tablas;
        
        Object[][] datos = null;
        String[] columnas = {"proveedor.IDproveedor","proveedor.RSOCIAL", "proveedor.CONTACTO", "proveedor.TEL", "proveedor.EMAIL", "proveedor.DIRECCION"};
        //dividir la consulta en dos una parta de los datos a busca y otra que tendra las tablas 
        datos = sensql.GetTabla(columnas, sentencia, tablas);

        return datos;
    }
    public boolean insertarProveedor(String rsocial, String contacto, String tel, String email, String direc ) {

        String datos[] = {rsocial, contacto, tel, email, direc};
        return sensql.insertar(datos, "INSERT INTO `proveedor` (`RSOCIAL`, `CONTACTO`, `TEL`, `EMAIL`, `DIRECCION`) VALUES (?,?,?,?,?)");
    }
    
    public boolean actualizaProveedor(String id, String rsocial, String contacto, String tel, String email, String dire){
        String campos[]={rsocial,contacto,tel,email,dire,id};
        String sentencia="UPDATE proveedor SET proveedor.RSOCIAL=?, proveedor.CONTACTO=?,proveedor.TEL=?,proveedor.EMAIL=?, proveedor.DIRECCION=? WHERE proveedor.IDproveedor = ?";
    return sensql.insertar(campos, sentencia);
    }
}
