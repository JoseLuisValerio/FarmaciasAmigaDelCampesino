package Vista;

import Controlador.Controlador_Producto_Root;
import javax.swing.table.DefaultTableModel;
import Ayuda.Estilo;
import Ayuda.Validacion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Estilo.lblTitulo(lblopciones);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        lblmensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rbtBuscar = new javax.swing.JRadioButton();
        rbtAgregar = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        rbtModificar = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        lblopciones = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemBuscar = new javax.swing.JMenuItem();
        menuItemAgregar = new javax.swing.JMenuItem();
        menuItemEditar = new javax.swing.JMenuItem();
        menuItemTransaccion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

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

        spStock.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

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

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProductoMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        lblmensaje.setText("LABEL DE MENSAJES");

        jButton1.setText("HACER PEDIDO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jMenu1.setText("Producto");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuItemBuscar.setText("Buscar");
        menuItemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemBuscar);

        menuItemAgregar.setText("Agregar");
        menuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemAgregar);

        menuItemEditar.setText("Editar");
        menuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemEditar);

        menuItemTransaccion.setText("Transacción");
        menuItemTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTransaccionActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemTransaccion);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Proveedor");

        jMenuItem4.setText("Agregar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Pedido");

        jMenuItem5.setText("Hacer Pedido");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rbtModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(47, 47, 47)
                        .addComponent(btnAgregar)
                        .addGap(46, 46, 46)
                        .addComponent(btnCancelar)
                        .addGap(48, 48, 48))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtBuscar)
                                .addComponent(rbtAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblopciones)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(167, 167, 167))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jButton1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel4))))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblopciones)
                .addGap(18, 18, 18)
                .addComponent(rbtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtModificar)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Producto_Root_Pedido Pedido = new Producto_Root_Pedido();

        Pedido.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int cor = tblProducto.getSelectedRow();
        txtCodigo.setText((tblProducto.getValueAt(cor, 0).toString()));
        txtNombre.setText((tblProducto.getValueAt(cor, 1).toString()));
        txtActivo.setText((tblProducto.getValueAt(cor, 2).toString()));
        txtDescripcion.setText((tblProducto.getValueAt(cor, 3).toString()));
        txtPCompra.setText((tblProducto.getValueAt(cor, 5).toString()));
        txtPPublico.setText((tblProducto.getValueAt(cor, 4).toString()));
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        this.desactivarStock();
        txtCodigo.setEnabled(true);
        btnAgregar.setVisible(true);
        btnGuardar.setVisible(false);
        Estilo.lblMensajes(lblmensaje, "", 4);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Proveedor prov = new Proveedor();
        prov.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void tblProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProductoMouseEntered

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblopciones;
    private javax.swing.JMenuItem menuItemAgregar;
    private javax.swing.JMenuItem menuItemBuscar;
    private javax.swing.JMenuItem menuItemEditar;
    private javax.swing.JMenuItem menuItemTransaccion;
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
