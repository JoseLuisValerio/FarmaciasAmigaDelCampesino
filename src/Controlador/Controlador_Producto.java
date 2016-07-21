package Controlador;

import Modelo.Modelo_Producto;

/**
 *
 * @author Jose Luis
 */
public class Controlador_Producto {

    Modelo_Producto sensql;

    public Controlador_Producto() {
        sensql = new Modelo_Producto();
    }

    public Object[][] consulta_articulos(String id) {
        Object[][] datos = null;
        String[] columnas = {"Nombre","Activo","Descripcion","PCompra","PPublico","idArea","stock"};
        if(id.length()==0){
        datos = sensql.GetTabla(columnas,"select producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PCOMPRA,producto.PPUBLICO,producto.idArea,detallesucursal.Stock from producto inner join detallesucursal on detallesucursal.IDPRODUCTO = producto.IDPRODUCTO and (detallesucursal.idsucursal=1 and producto.estatus=1)");
        }else {
        datos = sensql.GetTabla(columnas,"select producto.NOMBRE,producto.ACTIVO,producto.DESCRIPCION,producto.PCOMPRA,producto.PPUBLICO,producto.idArea,detallesucursal.Stock from producto inner join detallesucursal on detallesucursal.IDPRODUCTO = producto.IDPRODUCTO and (detallesucursal.idsucursal=1 and producto.estatus=1)");
        }
        
        return datos;
    }
}
