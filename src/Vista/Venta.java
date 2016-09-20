package Vista;

import Ayuda.Sesion;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta vista cobrará los productos solicitados por un cliente
 *
 * @author root
 */
public class Venta extends javax.swing.JFrame {

    private Ayuda.Estilo Estilo = null;
    private Ayuda.Utilidades Util = null;
    private Controlador.Controlador_Venta Controlador = null;
    private Controlador.Reportes Ticket = null;
    private final String[] columnas = {"Código", "Nombre", "Descripcion", "Precio Unitario", "Cantidad", "Precio Total"};
    private DefaultTableModel ModelVenta;
    private String idCliente;
    private final String Sucursal;

    /**
     * Inicializa los elementos usando la clase Estilo
     */
    public Venta() {
        Estilo = new Ayuda.Estilo();
        Util = new Ayuda.Utilidades();
        Controlador = new Controlador.Controlador_Venta();
        Ticket = new Controlador.Reportes();
        idCliente = "";
        Sucursal = Controlador.ObtenerSucursal();
        initComponents();
        //Estilo JLabels
        Estilo.lblBody(jLabel5);
        Estilo.lblBody(jLabel6);
        Estilo.lblTitulo(jLabel1);
        Estilo.lblTitulo(jLabel8);
        Estilo.lblTitulo(lblTotal);
        //Estilo textfields
        Estilo.txtfDescripcion(txtCliente, "Clave del cliente");
        Estilo.txtfDescripcion(txtProducto, "Clave del producto");
        //Estilo Paneles
        Estilo.PnlTitulo(pnlCliente, "Datos del cliente");
        Estilo.PnlTitulo(pnlProductos, "Productos agregados");
        Estilo.PnlTitulo(pnlClienteBuscar, "Búsqueda de cliente");
        //Estilo botones
        Estilo.BtnOpcion(btnCobrar, 5);
        Estilo.BtnOpcion(btnCancelar, 3);
        //Estilo de ventana
        Estilo.lblMensajes(lblAlerta, "", 4);
        Estilo.frmInicial(this, "Venta");
        Estilo.lblLogo(lblEncabezado);
        //Estilo de textfields
        Estilo.txtfDescripcion(txtCliente, "Clave de cliente");
        Estilo.txtfDescripcion(txtProducto, "Código del producto");
        Estilo.txtfDescripcion(txtBusqueda, "Nombre del cliente");

        //Valores iniciales
        MostrarCliente("");
        ModelVenta = new DefaultTableModel(null, columnas);
        tblVenta.setModel(ModelVenta);
    }

    /**
     * Muestra los clientes
     *
     * @param Buscar
     */
    private void MostrarCliente(String Buscar) {
        Object[][] datostabla;
        String[] columnas = {"Alias", "Nombre", "APaterno", "AMaterno", "Tel", "DineroElectronico", "idCliente"};
        Controlador.Controlador_Cliente Controlador;
        Controlador = new Controlador.Controlador_Cliente();
        datostabla = Controlador.ConsultaUnCliente(Buscar);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblCliente.setModel(datos);
        Estilo.tblColumnaOculta(tblCliente, 0);
        Estilo.tblColumnaOculta(tblCliente, 5);
        Estilo.tblColumnaOculta(tblCliente, 6);
    }

    /**
     * Auxiliar para determinar si el producto ingresado ya se ha ingresado
     * antes a la tabla
     *
     * @param tabla recibe la jtable
     * @param codigo recibe el codigo del producto
     * @return Si datos[0]==0 ---> El producto no ha sido ingresado antes
     * datos[0]==1 ---> El producto ya ha sido ingresado datos[1]==100 --->
     * indice aleatorio de la tabla datos[1]!=100 ---> Indice de la tabla en el
     * que se ingreso
     */
    private int[] ExisteCodigoTbl(JTable tabla, String codigo) {
        int datos[] = new int[2];
        datos[0] = 0;//-->No existe codigo
        datos[1] = 100; //Posicion

        if (tabla.getRowCount() > 0) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (codigo.equals(String.valueOf(tabla.getValueAt(i, 0)))) {
                    datos[0] = 1;
                    datos[1] = i;
                    break;
                }
            }
        }
        return datos;
    }

    /**
     * Cuenta todos los precios totales ingresados a la tabla y los muestra en
     * el jlabel correspondiente
     *
     * @return el total de totales
     */
    private String PrecioTotal() {
        float total = 0f;
        for (int i = 0; i < ModelVenta.getRowCount(); i++) {
            float numero = 0f;
            numero = Float.valueOf(ModelVenta.getValueAt(i, 5).toString());
            total += numero;
        }
        return String.valueOf(total);
    }

    private void detalledeventa(String Fecha, String Hora, String Sucursal, String Usuario) {
        String idVenta = Controlador.ObteneridVenta(Fecha, Hora, Sucursal, Usuario);
        for (int i = 0; i < tblVenta.getRowCount(); i++) {
            String Cantidad = String.valueOf(tblVenta.getValueAt(i, 4));
            String idProducto = String.valueOf(tblVenta.getValueAt(i, 0));
            String Total = String.valueOf(tblVenta.getValueAt(i, 5));
            Controlador.RegistrarDetalleVenta(Cantidad, idProducto, idVenta, Total);
            Controlador.ActualizarStockYVendidos(Sucursal, Cantidad, idProducto);
        }
        Ticket.TicketVenta(idVenta);
        //Estilo.lblMensajes(lblAlerta, "Venta Cobrada exitosamente", 3);
        Limpiar();
    }

    private boolean VentaMaterialUso(String Fecha, String Hora, String idUsuario, String idSucursal) {
        boolean exitoso = false;
        exitoso = Controlador.RegistrarVenta(Fecha, Hora, "0", "0", idUsuario, "1", idSucursal);
        detalledeventa(Fecha, Hora, idSucursal, idUsuario);
        return exitoso;
    }

    private boolean ventaconCliente(String Fecha, String Hora, String idUsuario, String idCliente, String idSucursal) {
        //dinero electronico para cliente opcional 
        boolean exitoso = false;
        float PrecioTotalProducto = Float.parseFloat(PrecioTotal());
        float DinElectCliente = Float.parseFloat(lblDinElectro.getText());
        //Si ocupar dinero electronico esta habilitado y el dinero es mayor a 0
        if (CheckDinero.isSelected() && DinElectCliente > 0f) {
            if (DinElectCliente > PrecioTotalProducto) { //Si tiene más dinero electronico que lo que va a cobrar
                DinElectCliente = PrecioTotalProducto;
                float NuevoPrecioTotalProducto = PrecioTotalProducto - DinElectCliente;
                exitoso = Controlador.RegistrarVenta(Fecha, Hora, String.valueOf(DinElectCliente), String.valueOf(NuevoPrecioTotalProducto), idUsuario, idCliente, idSucursal);
                Controlador.ActualizaCaja(idSucursal, NuevoPrecioTotalProducto);
                Controlador.RestaDinElectro(idCliente, PrecioTotalProducto);
            } else {
                float NuevoPrecioTotalProducto = PrecioTotalProducto - DinElectCliente;
                exitoso = Controlador.RegistrarVenta(Fecha, Hora, String.valueOf(DinElectCliente), String.valueOf(NuevoPrecioTotalProducto), idUsuario, idCliente, idSucursal);
                Controlador.ActualizaCaja(idSucursal, NuevoPrecioTotalProducto);
                Controlador.RestaDinElectro(idCliente, DinElectCliente);
            }

            SumarDinElectro(String.valueOf(PrecioTotalProducto), idCliente);
            detalledeventa(Fecha, Hora, idSucursal, idUsuario);
            

        } else {//Si no esta seleccionado, el dinero electronico es $0
            exitoso = Controlador.RegistrarVenta(Fecha, Hora, "0", String.valueOf(PrecioTotalProducto), idUsuario, idCliente, idSucursal);
            Controlador.ActualizaCaja(idSucursal, PrecioTotalProducto);
            detalledeventa(Fecha, Hora, idSucursal, idUsuario);
        }
        return exitoso;
    }

    private boolean ventaSinCliente(String Fecha, String Hora, String idUsuario, String idSucursal) {
        boolean exitoso = false;
        String PrecioProducto = PrecioTotal();
        exitoso = Controlador.RegistrarVenta(Fecha, Hora, "0", PrecioProducto, idUsuario, "1", idSucursal);
        detalledeventa(Fecha, Hora, idSucursal, idUsuario);
        Controlador.ActualizaCaja(idSucursal,Float.parseFloat(PrecioProducto));
        return exitoso;
    }

    /**
     * Calcula el 5% del total de la venta
     */
    private void SumarDinElectro(String Venta, String idCliente) {
        float DineroElectronico = (float) ((int) ((Float.parseFloat(Venta) * 5) / 100));
        Controlador.SumaDinElectro(idCliente, DineroElectronico);
    }

    /**
     * Auxiliar para limpiar los controles involucrados despues de cobrar o por
     * el boton cancelar.
     */
    private void Limpiar() {
        Util.txtLimpiar(txtBusqueda);
        Util.txtLimpiar(txtCliente);
        Util.txtLimpiar(txtProducto);
        Util.lblLimpiar(lblDinElectro);
        MostrarCliente("");
        Util.tblLimpiar(tblVenta, ModelVenta);
        Util.txtHabilitar(txtCliente, true);
        Util.txtFoco(txtCliente);
        lblTotal.setText("0.0");
        Estilo.lblMensajes(lblAlerta, "", 4);
        idCliente = "";
        Util.ChkbxLimpiar(CheckDinero);
        Util.ChkbxLimpiar(CheckMaterial);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPopMnTablaProductos = new javax.swing.JPopupMenu();
        JMnItemEliminar = new javax.swing.JMenuItem();
        lblEncabezado = new javax.swing.JLabel();
        pnlCliente = new javax.swing.JPanel();
        txtCliente = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProducto = new org.edisoncor.gui.textField.TextFieldRectBackground();
        lblDinElectro = new javax.swing.JLabel();
        CheckDinero = new javax.swing.JCheckBox();
        pnlProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblAlerta = new javax.swing.JLabel();
        pnlClienteBuscar = new javax.swing.JPanel();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        CheckMaterial = new javax.swing.JCheckBox();

        JMnItemEliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        JMnItemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Error.png"))); // NOI18N
        JMnItemEliminar.setText("Cancelar producto");
        JMnItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMnItemEliminarActionPerformed(evt);
            }
        });
        JPopMnTablaProductos.add(JMnItemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Dinero Electronico: $");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Producto:");

        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });

        CheckDinero.setText("Usar!");

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblDinElectro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CheckDinero)))))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckDinero)
                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblDinElectro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42))
        );

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVenta.setComponentPopupMenu(JPopMnTablaProductos);
        jScrollPane1.setViewportView(tblVenta);

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.setText("Total:");

        btnCobrar.setText("jButton1");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        jLabel8.setText("$");

        lblTotal.setText("0.0");

        btnCancelar.setText("jButton2");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblAlerta.setText("Mensajes");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClienteMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblCliente);

        javax.swing.GroupLayout pnlClienteBuscarLayout = new javax.swing.GroupLayout(pnlClienteBuscar);
        pnlClienteBuscar.setLayout(pnlClienteBuscarLayout);
        pnlClienteBuscarLayout.setHorizontalGroup(
            pnlClienteBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlClienteBuscarLayout.setVerticalGroup(
            pnlClienteBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        CheckMaterial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CheckMaterial.setText("Material de uso!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlClienteBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CheckMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
            .addComponent(lblAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlClienteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        if (tblVenta.getRowCount() > 0) {
            Calendar c = new GregorianCalendar();
            String Fecha = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH) + 1) + "/" + Integer.toString(c.get(Calendar.YEAR));
            String Hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(c.get(Calendar.MINUTE)) + ":" + Integer.toString(c.get(Calendar.SECOND));
            String Usuario = Sesion.LeerSesion("idUsuario");

            if (!txtCliente.getText().isEmpty()) {
                if (ventaconCliente(Fecha, Hora, Usuario, idCliente, Sucursal)) {
                    Estilo.lblMensajes(lblAlerta, "Venta Cobrada exitosamente", 3);
                } else {
                    Estilo.lblMensajes(lblAlerta, "Ha ocurrido un error, por favor verifique", 2);
                }
            } else if (CheckMaterial.isSelected()) {
                if (VentaMaterialUso(Fecha, Hora, Usuario, Sucursal)) {
                    Estilo.lblMensajes(lblAlerta, "Venta Cobrada exitosamente", 3);
                } else {
                    Estilo.lblMensajes(lblAlerta, "Ha ocurrido un error, por favor verifique", 2);
                }
            } else if (ventaSinCliente(Fecha, Hora, Usuario, Sucursal)) {
                Estilo.lblMensajes(lblAlerta, "Venta Cobrada exitosamente", 3);
            } else {
                Estilo.lblMensajes(lblAlerta, "Ha ocurrido un error, por favor verifique", 2);
            }
        } else {
            Estilo.lblMensajes(lblAlerta, "Debe ingresar a menos un producto", 1);
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        MostrarCliente(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void tblClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMousePressed
        try {
            int fila = tblCliente.getSelectedRow();
            if (fila >= 0) {
                txtCliente.setText(String.valueOf(tblCliente.getValueAt(fila, 0)));
                lblDinElectro.setText(String.valueOf(tblCliente.getValueAt(fila, 5)));
                idCliente = String.valueOf(tblCliente.getValueAt(fila, 6));
                Util.txtFoco(txtProducto);
                Util.txtHabilitar(txtCliente, false);
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error al seleccionar fila en tabla Cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_tblClienteMousePressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        if (txtProducto.getText().length() != 0) {
            //Recorre el arreglo original para obtener solo la primera columna
            int ResultadosTabla[] = ExisteCodigoTbl(tblVenta, txtProducto.getText());

            if (ResultadosTabla[0] == 1) {//Es por que existe en la Tabla
                int Cantidad = Integer.parseInt(String.valueOf(tblVenta.getValueAt(ResultadosTabla[1], 4))) + 1;
                tblVenta.setValueAt(Cantidad, ResultadosTabla[1], 4);
                float auxPrecioTotal = Float.parseFloat(String.valueOf(tblVenta.getValueAt(ResultadosTabla[1], 3)));
                tblVenta.setValueAt(Cantidad * auxPrecioTotal, ResultadosTabla[1], 5);
                Estilo.lblMensajes(lblAlerta, "Producto agregado", 3);
            } else {//No existe en la tabla, busca en la BD
                Object[][] aux = null; //Auxiliar para obtener arreglo unidimensional de los resultados
                aux = Controlador.ObtenerProducto(txtProducto.getText(),Sucursal);

                if (aux.length != 0) { //Si su tamaño es = 0 es por que no recibio nada de la consulta
                    Object[] Producto = null; //arreglo que se mostrará en la tabla
                    for (int i = 0; i < aux.length; i++) {
                        Producto = new Object[aux[i].length + 2];
                        for (int j = 0; j < aux[i].length; j++) {
                            Producto[j] = aux[i][j];
                        }
                    }
                    Producto[4] = 1;
                    Producto[5] = Double.parseDouble(String.valueOf(Producto[4])) * Double.parseDouble(String.valueOf(Producto[3]));
                    ModelVenta.addRow(Producto);
                    tblVenta.setModel(ModelVenta);
                    Estilo.lblMensajes(lblAlerta, "Producto agregado", 3);
                } else {
                    Estilo.lblMensajes(lblAlerta, "El producto ingresado no esta registrado, por favor verifique.", 1);
                }
            }
        } else {
            Estilo.lblMensajes(lblAlerta, "Debe ingresar un código de barras válido", 1);
        }
        Util.txtLimpiar(txtProducto);
        Util.txtFoco(txtProducto);
        lblTotal.setText("" + PrecioTotal());
    }//GEN-LAST:event_txtProductoActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        Util.txtFoco(txtProducto);
    }//GEN-LAST:event_txtClienteActionPerformed

    private void JMnItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMnItemEliminarActionPerformed
        try{
        int fila = tblVenta.getSelectedRow();
        if (fila >= 0) {
            System.out.println(fila);
            ModelVenta.removeRow(fila);
        }
        }catch(Exception e){
            System.err.println("Error al capturar fila para eliminar en jTableVenta\n"+e.getMessage());
        }
    }//GEN-LAST:event_JMnItemEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckDinero;
    private javax.swing.JCheckBox CheckMaterial;
    private javax.swing.JMenuItem JMnItemEliminar;
    private javax.swing.JPopupMenu JPopMnTablaProductos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlerta;
    private javax.swing.JLabel lblDinElectro;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlClienteBuscar;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblVenta;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtBusqueda;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCliente;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtProducto;
    // End of variables declaration//GEN-END:variables
}
