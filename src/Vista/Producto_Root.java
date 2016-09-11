package Vista;

import Controlador.Controlador_Producto_Root;
import javax.swing.table.DefaultTableModel;
import Ayuda.Estilo;
import Ayuda.Validacion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class Producto_Root extends javax.swing.JFrame {

    /**
     * Creates new form Producto_Agregar
     */
    Ayuda.Estilo Estilo = new Ayuda.Estilo();
    private Object[][] datostabla;
    String[] columnas = {"Código", "Nombre", "Activo", "Descripcion", "Precio Publico", "Precio Compra", "Stock", "Proveedor", "Sucursal"};
    Controlador_Producto_Root ctr = new Controlador_Producto_Root();
    String idprovedor = "";

    public Producto_Root() {
        initComponents();
        mostrar_tabla();
        cargarCombos();
        Estilo.frmInicial(this, "Producto Administrador");
        limpia();
        Estilo.lblTitulo(lblopciones);
        Estilo.lblLogo(lblEncabezado);
        Estilo.lblBody(jLabel1);
        Estilo.lblBody(jLabel2);
        Estilo.lblBody(jLabel3);
        Estilo.lblBody(jLabel4);
        Estilo.lblBody(jLabel5);
        Estilo.lblBody(jLabel6);
        Estilo.lblBody(jLabel7);
        Estilo.lblBody(jLabel8);
        Estilo.lblBody(jLabel9);
        Estilo.MnIcon(mnArchivo, 1);
        Estilo.MnIcon(mnProveedor, 8);
        Estilo.MnIcon(mnPedido, 7);
        Estilo.mnitemIcon(menuItemAgregar, 2);
        Estilo.mnitemIcon(menuItemBuscar, 3);
        Estilo.mnitemIcon(menuItemEditar, 5);
        Estilo.mnitemIcon(menuItemTransaccion, 4);
        Estilo.mnitemIcon(mnItemProveedor, 2);
        Estilo.mnitemIcon(mnItemPedido, 4);
        Estilo.BtnOpcion(btnAgregar, 1);
        Estilo.BtnOpcion(btnCancelar, 3);
        Estilo.BtnOpcion(btnGuardar, 2);
        Estilo.BtnOpcion(btnpedido, 4);
        btnGuardar.setVisible(false);
        txtCodigo.setEnabled(false);
        desactivarStock();
        desactivar();
    }

    public void mostrar_tabla() {
        datostabla = ctr.consulta_Productos();
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
        Estilo.lblMensajes(lblmensaje, "Hace falta producto", 1);
        btnAgregar.setVisible(false);
        //rbtBuscar.setSelected(true);
        desactivar();

    }

    public void mostrartodo() {
        datostabla = ctr.mostrarProductos();
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
        Estilo.lblMensajes(lblmensaje, "Agregado con Exito", 3);
    }

    public void bucarProductoCodigo(String codigo) {
        datostabla = ctr.buscaProductosCodigo(codigo);
        if (datostabla.length == 0) {
            this.activar();
            if (rbtBuscar.isSelected() == false) {
                cmbSucursal.setEnabled(false);
            }
            Estilo.lblMensajes(lblmensaje, "Producto no existe", 2);
        }
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void bucarProductoActivo(String activo) {
        datostabla = ctr.buscaProductosaActivo(activo);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void buscarProductoNombre(String Nombre) {
        datostabla = ctr.buscaProductosaNombre(Nombre);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void buscarProductoDescripcion(String Descripcion) {
        datostabla = ctr.buscaProductosaDescripcion(Descripcion);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void cargarCombos() {
        Object[] sucursales = ctr.cargaSucursal("sucursal");
        cmbSucursal.removeAllItems();
        cmbSucursal.addItem("SELECIONES SUCURSAL");
        for (int i = 0; i < sucursales.length; i++) {
            cmbSucursal.addItem(sucursales[i]);
        }
        Object[] Proveedores = ctr.cargaProveedor("proveedor");
        cmbProveedor.removeAllItems();
        cmbProveedor.addItem("SELECCIONE PROVEEDOR");
        for (int i = 0; i < Proveedores.length; i++) {
            cmbProveedor.addItem(Proveedores[i]);
        }
    }

    public void buscarSucursal(String Sucursal) {
        datostabla = ctr.buscaProductosSucursal(Sucursal);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void buscarProveedor(String Proveedor) {
        datostabla = ctr.buscaProductosProveedor(Proveedor);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProducto.setModel(datos);
    }

    public void limpia() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtActivo.setText("");
        txtPPublico.setText("");
        txtPCompra.setText("");
        txtCodigo.setText("");
        spStock.setValue(0);
        Estilo.txtfDescripcion(txtCodigo, "Código de Producto");
        Estilo.txtfDescripcion(txtNombre, "Nombre del Producto");
        Estilo.txtfDescripcion(txtActivo, "Nombre del Activo");
        Estilo.txtfDescripcion(txtPPublico, "Precio al Publico ");
        Estilo.txtfDescripcion(txtPCompra, "Precio de Compra ");

    }

    public void desactivar() {
        txtPCompra.setEnabled(false);
        txtPPublico.setEnabled(false);
        spStock.setEnabled(false);
    }

    public void desactivarStock() {
        txtNombre.setEnabled(false);
        txtActivo.setEnabled(false);
        txtDescripcion.setEnabled(false);
        cmbProveedor.setEnabled(false);
        cmbSucursal.setEnabled(false);
        txtPCompra.setEnabled(false);
        txtPPublico.setEnabled(false);
        spStock.setEnabled(true);
    }

    public void activar() {
        txtNombre.setEnabled(true);
        txtActivo.setEnabled(true);
        txtDescripcion.setEnabled(true);
        cmbProveedor.setEnabled(true);
        cmbSucursal.setEnabled(true);
        txtPCompra.setEnabled(true);
        txtPPublico.setEnabled(true);
        spStock.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtActivo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPPublico = new org.edisoncor.gui.textField.TextFieldRectBackground();
        spStock = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPCompra = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel8 = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        cmbProveedor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        lblmensaje = new javax.swing.JLabel();
        btnpedido = new javax.swing.JButton();
        rbtBuscar = new javax.swing.JRadioButton();
        rbtAgregar = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        rbtModificar = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        lblopciones = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblEncabezado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnArchivo = new javax.swing.JMenu();
        menuItemBuscar = new javax.swing.JMenuItem();
        menuItemAgregar = new javax.swing.JMenuItem();
        menuItemEditar = new javax.swing.JMenuItem();
        menuItemTransaccion = new javax.swing.JMenuItem();
        mnProveedor = new javax.swing.JMenu();
        mnItemProveedor = new javax.swing.JMenuItem();
        mnPedido = new javax.swing.JMenu();
        mnItemPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCodigo.setDescripcion("Código de producto");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombre.setDescripcion("Código de producto");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        txtActivo.setDescripcion("Código de producto");
        txtActivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtActivoKeyPressed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nombre");

        jLabel3.setText("Activo");

        jLabel4.setText("Descripcíon");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel5.setText("Precio Público");

        txtPPublico.setDescripcion("Código de producto");

        spStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel6.setText("Stock");

        jLabel7.setText("Precio Compra");

        txtPCompra.setDescripcion("Código de producto");

        jLabel8.setText("Sucursal");

        cmbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalActionPerformed(evt);
            }
        });

        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });

        jLabel9.setText("Proveedor");

        lblmensaje.setText("LABEL DE MENSAJES");

        btnpedido.setText("HACER PEDIDO");
        btnpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpedidoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtBuscar);
        rbtBuscar.setText("Buscar");
        rbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtAgregar);
        rbtAgregar.setText("Agregar");
        rbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAgregarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbtModificar);
        rbtModificar.setText("Modificar");
        rbtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtModificarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblopciones.setText("Opciones");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProducto);

        mnArchivo.setText("Archivo");
        mnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivoActionPerformed(evt);
            }
        });

        menuItemBuscar.setText("Buscar");
        menuItemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarActionPerformed(evt);
            }
        });
        mnArchivo.add(menuItemBuscar);

        menuItemAgregar.setText("Agregar");
        menuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarActionPerformed(evt);
            }
        });
        mnArchivo.add(menuItemAgregar);

        menuItemEditar.setText("Editar");
        menuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarActionPerformed(evt);
            }
        });
        mnArchivo.add(menuItemEditar);

        menuItemTransaccion.setText("Transacción");
        menuItemTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTransaccionActionPerformed(evt);
            }
        });
        mnArchivo.add(menuItemTransaccion);

        jMenuBar1.add(mnArchivo);

        mnProveedor.setText("Proveedor");

        mnItemProveedor.setText("Agregar");
        mnItemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemProveedorActionPerformed(evt);
            }
        });
        mnProveedor.add(mnItemProveedor);

        jMenuBar1.add(mnProveedor);

        mnPedido.setText("Pedido");

        mnItemPedido.setText("Hacer Pedido");
        mnItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemPedidoActionPerformed(evt);
            }
        });
        mnPedido.add(mnItemPedido);

        jMenuBar1.add(mnPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(167, 167, 167))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addComponent(btnpedido))))
                        .addComponent(jScrollPane2)
                        .addComponent(lblopciones, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtBuscar)
                                .addComponent(rbtAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(rbtModificar))
                        .addGap(700, 700, 700)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnpedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblopciones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtModificar)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActivoKeyPressed
        if (rbtBuscar.isSelected() == true || rbtModificar.isSelected() == true) {
            this.bucarProductoActivo(txtActivo.getText());
        }
    }//GEN-LAST:event_txtActivoKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (rbtBuscar.isSelected() == true || rbtModificar.isSelected() == true) {
            this.buscarProductoDescripcion(txtDescripcion.getText());
        }     // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (rbtBuscar.isSelected() == true || rbtModificar.isSelected() == true) {
            this.buscarProductoNombre(txtNombre.getText());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void rbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAgregarActionPerformed
        this.desactivarStock();
        limpia();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(true);
        btnGuardar.setVisible(false);
        Estilo.lblMensajes(lblmensaje, "", 4);

    }//GEN-LAST:event_rbtAgregarActionPerformed

    private void cmbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalActionPerformed
        String valor = (String) cmbSucursal.getSelectedItem();
        if (rbtBuscar.isSelected() == true || rbtModificar.isSelected() == true) {
            if (valor != "SELECIONES SUCURSAL") {
                buscarSucursal(valor);
            }
        }
    }//GEN-LAST:event_cmbSucursalActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        String valor = (String) cmbProveedor.getSelectedItem();
        if (rbtBuscar.isSelected() == true || rbtModificar.isSelected() == true) {
            if (valor != "SELECCIONE PROVEEDOR") {
                buscarProveedor(valor);
            }
        } // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void rbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBuscarActionPerformed
        activar();
        desactivar();
        limpia();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(false);
        Estilo.lblMensajes(lblmensaje, "", 4);
        btnGuardar.setVisible(false);
    }//GEN-LAST:event_rbtBuscarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

        String id = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String activo = txtActivo.getText();
        String descripcion = txtDescripcion.getText();
        String ppublico = txtPPublico.getText();
        String pcompra = txtPCompra.getText();
        String stock = Integer.toString((int) spStock.getValue());
        String categoria1 = ctr.obtenerIdProveedor((String) cmbProveedor.getSelectedItem());
        //

        if (txtNombre.isEnabled() == false && txtActivo.isEnabled() == false && txtDescripcion.isEnabled() == false) {
            ctr.actualizarStock(id, "1", stock);
            mostrartodo();
            limpia();

        } else {
            if (txtNombre.getText().isEmpty() == false && txtActivo.getText().isEmpty() == false && txtDescripcion.getText().isEmpty() == false && cmbProveedor.getSelectedIndex() != 0 && (int) spStock.getValue() > 0) {
                ctr.ingresarProductoNuevo(id, nombre, activo, descripcion, ppublico, pcompra, categoria1, "1");
                ctr.ingresarDetalleNuevo(id, "1", stock, "0", "1");
                mostrartodo();
                limpia();
                this.desactivarStock();
                Estilo.lblMensajes(lblmensaje, "Producto Agregado", 3);
            } else {
                Estilo.lblMensajes(lblmensaje, "HAY CAMPOS SIN LLENAR", 1);
            }
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

        if (rbtBuscar.isSelected() == true) {
            this.bucarProductoCodigo(txtCodigo.getText());
            txtCodigo.setText("");
        } else if (rbtAgregar.isSelected() == true) {
            this.bucarProductoCodigo(txtCodigo.getText());
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpedidoActionPerformed
        Producto_Root_Pedido Pedido = new Producto_Root_Pedido();

        Pedido.setVisible(true);
    }//GEN-LAST:event_btnpedidoActionPerformed

    private void rbtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtModificarActionPerformed
        activar();
        limpia();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(false);
        btnGuardar.setVisible(true);
        cmbProveedor.setEnabled(false);
        cmbSucursal.setEnabled(false);
        spStock.setEnabled(false);


    }//GEN-LAST:event_rbtModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpia();
        Estilo.lblMensajes(lblmensaje, "Función Cancelada", WIDTH);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String id = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String activo = txtActivo.getText();
        String descripcion = txtDescripcion.getText();
        String ppublico = txtPPublico.getText();
        String pcompra = txtPCompra.getText();

        if (txtNombre.getText().isEmpty() == false && txtActivo.getText().isEmpty() == false && txtDescripcion.getText().isEmpty() == false && txtPPublico.getText().isEmpty() == false && txtPCompra.getText().isEmpty() == false) {
            if (ctr.actualizaProducto(id, nombre, activo, descripcion, ppublico, pcompra) == true) {
                mostrartodo();
                limpia();
            } else {
                Estilo.lblMensajes(lblmensaje, "NO SE PUDO ACTUALIZAR", 3);
            }
        } else {
            JOptionPane.showMessageDialog(null, "los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void mnItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemPedidoActionPerformed
        Producto_Root_Pedido Pedido = new Producto_Root_Pedido();

        Pedido.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_mnItemPedidoActionPerformed

    private void menuItemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarActionPerformed
        activar();
        desactivar();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(false);
        Estilo.lblMensajes(lblmensaje, "", 4);
        btnGuardar.setVisible(false);
        rbtBuscar.setSelected(true);// TODO add your handling code here:
    }//GEN-LAST:event_menuItemBuscarActionPerformed

    private void menuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarActionPerformed
        activar();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(false);
        btnGuardar.setVisible(true);
        cmbProveedor.setEnabled(false);
        cmbSucursal.setEnabled(false);
        spStock.setEnabled(false);
        rbtModificar.setSelected(true);
    }//GEN-LAST:event_menuItemEditarActionPerformed

    private void mnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivoActionPerformed
        this.desactivarStock();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(true);
        btnGuardar.setVisible(false);
        Estilo.lblMensajes(lblmensaje, "", 4);        // TODO add your handling code here:
    }//GEN-LAST:event_mnArchivoActionPerformed

    private void menuItemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarActionPerformed
        activar();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(false);
        btnGuardar.setVisible(true);
        cmbProveedor.setEnabled(false);
        cmbSucursal.setEnabled(false);
        spStock.setEnabled(false);
        rbtAgregar.setSelected(true);// TODO add your handling code here:
    }//GEN-LAST:event_menuItemAgregarActionPerformed

    private void menuItemTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTransaccionActionPerformed
        Producto_Root_Transaccion tran = new Producto_Root_Transaccion();
        tran.setVisible(true);
    }//GEN-LAST:event_menuItemTransaccionActionPerformed

    private void mnItemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemProveedorActionPerformed
        Proveedor prov = new Proveedor();
        prov.setVisible(true);
    }//GEN-LAST:event_mnItemProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(Producto_Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto_Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto_Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto_Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto_Root().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnpedido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblopciones;
    private javax.swing.JMenuItem menuItemAgregar;
    private javax.swing.JMenuItem menuItemBuscar;
    private javax.swing.JMenuItem menuItemEditar;
    private javax.swing.JMenuItem menuItemTransaccion;
    private javax.swing.JMenu mnArchivo;
    private javax.swing.JMenuItem mnItemPedido;
    private javax.swing.JMenuItem mnItemProveedor;
    private javax.swing.JMenu mnPedido;
    private javax.swing.JMenu mnProveedor;
    private javax.swing.JRadioButton rbtAgregar;
    private javax.swing.JRadioButton rbtBuscar;
    private javax.swing.JRadioButton rbtModificar;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTable tblProducto;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtActivo;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPCompra;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPPublico;
    // End of variables declaration//GEN-END:variables
}
