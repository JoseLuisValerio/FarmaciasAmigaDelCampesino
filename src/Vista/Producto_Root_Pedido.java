/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ayuda.ConectorCorreos;
import Ayuda.Estilo;
import Ayuda.Sesion;
import Controlador.Controlador_Producto_Root_Pedido;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Luis
 */
public class Producto_Root_Pedido extends javax.swing.JFrame {

    Estilo estilo = new Estilo();
    Calendar c = new GregorianCalendar();
    String Fecha = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH) + 1) + "/" + Integer.toString(c.get(Calendar.YEAR));
    String Usuario = Sesion.LeerSesion("idUsuario");
    private Object[][] datostabla;
    String[] columnas = {"Código", "Nombre", "Activo", "Descripion", "Stock"};
    Controlador_Producto_Root_Pedido ctr = new Controlador_Producto_Root_Pedido();
    Object[] fila = new Object[5];
    Controlador.Reportes Ticket = new Controlador.Reportes();
    ConectorCorreos enviar = new ConectorCorreos();

    public Producto_Root_Pedido() {

        initComponents();
        cargaProveedores();
        cargaPocaExistencia("ssa");
        cargaProductos();
        estilo.frmInicial(this,"Pedidos");
        estilo.txtfDescripcion(txtCodigo, "Código de Producto");
        estilo.lblLogo(lblEncabezado);
        estilo.lblBody(jLabel1);
        estilo.lblBody(jLabel2);
        estilo.lblBody(jLabel3);
        estilo.MnIcon(jMenu1, 1);
        estilo.BtnOpcion(Limpiar, 3);
        estilo.BtnOpcion(btnPedido, 4);
        btnPedido.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnAgregar.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnEliminar.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnPedido.setText("Hacer Pedido");
        
    }

    public void cargaPocaExistencia(String valor) {
        datostabla = ctr.cargaPocaExistencia(valor);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblPedido.setModel(datos);

    }

    public void cargaProductos() {
        datostabla = ctr.cargaProductos();
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProductos.setModel(datos);
    }

    public void cargaProveedores() {
        Object[] sucursales = ctr.cargaProveedores("proveedor");
        cmbProveedor.removeAllItems();
        cmbProveedor.addItem("SELECCIONE PROVEEDOR");
        for (int i = 0; i < sucursales.length; i++) {
            cmbProveedor.addItem(sucursales[i]);
        }
    }

    public void buscarProveedor(String valor) {
        datostabla = ctr.buscarProducto(txtCodigo.getText(), valor);
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProductos.setModel(datos);

    }

    public void limpiar() {
        txtCodigo.setText("");
        txtCorreo.setText("");
        datostabla = null;
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProductos.setModel(datos);
        tblPedido.setModel(datos);
        spcantidad.setValue(0);
        cmbProveedor.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtCodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        lblmensaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spcantidad = new javax.swing.JSpinner();
        cmbProveedor = new javax.swing.JComboBox();
        txtCorreo = new javax.swing.JTextField();
        btnPedido = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        lblEncabezado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        txtCodigo.setDescripcion("Código de producto");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        jLabel3.setText("Codigo");

        jLabel1.setText("Productos");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar >>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Eliminar.png"))); // NOI18N
        btnEliminar.setText("<< Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPedido);

        jLabel2.setText("Pedido");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbProveedorMouseClicked(evt);
            }
        });
        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });

        txtCorreo.setEditable(false);

        btnPedido.setText("Hacer Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(spcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(19, 19, 19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(lblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(136, 136, 136)
                                        .addComponent(txtCorreo))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Limpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked

    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        datostabla = ctr.buscarProducto(txtCodigo.getText(), cmbProveedor.getSelectedItem().toString());
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblProductos.setModel(datos);
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int cantidad;
        int cor = tblProductos.getSelectedRow();
        cantidad = Integer.parseInt(spcantidad.getValue().toString());
        if (cor < 0) {
            estilo.lblMensajes(lblmensaje, "Seleccionar un producto", 2);
        } else {
            if (cantidad <= 0) {
                estilo.lblMensajes(lblmensaje, "No ha dado la cantidad de Producto", 2);
            } else {
                String codigo = (tblProductos.getValueAt(cor, 0).toString());
                String nombre = (tblProductos.getValueAt(cor, 1).toString());
                String Descripcion = (tblProductos.getValueAt(cor, 2).toString());
                String activo = (tblProductos.getValueAt(cor, 3).toString());
                String existencia = (tblProductos.getValueAt(cor, 4).toString());

                DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();

                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = activo;
                fila[3] = Descripcion;
                fila[4] = spcantidad.getValue().toString();

                modelo.addRow(fila);

                tblPedido.setModel(modelo);
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPedido.getModel();

        int a = tblPedido.getSelectedRow();
        if (a < 0) {
            estilo.lblMensajes(lblmensaje, "Seleccione un producto", 2);
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea Eliminar el registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {
                model.removeRow(a);
                estilo.lblMensajes(lblmensaje, "Registro Eliminado", 3);

            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
//        datostabla = ctr.buscarProducto(txtCodigo.getText());
        //      DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        //    tblProductos.setModel(datos);
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        String valor = (String) cmbProveedor.getSelectedItem();
        buscarProveedor(valor);
        cargaPocaExistencia(valor);
        String correo = ctr.Correo(valor);
        txtCorreo.setText(correo);
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void cmbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorMouseClicked

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        if (datostabla == null) {
            estilo.lblMensajes(lblmensaje, "No a selecionado productos", 1);
        } else {
            if (cmbProveedor.getSelectedIndex() != 0) {
                String idProveedor = ctr.idProveedor(cmbProveedor.getSelectedItem().toString());

                if (ctr.nuevoPedido(Fecha, Usuario, idProveedor) == true) {
                    String idpedido = ctr.ultimoIdpedido("pedido", Fecha);
                    estilo.lblMensajes(lblmensaje, "Pedido Realizado", 3);

                    for (int i = 0; i < tblPedido.getRowCount(); i++) {

                        String codigo = (String) tblPedido.getValueAt(i, 0);
                        String stock = (String) tblPedido.getValueAt(i, 4);

                        ctr.nuevoDetallePedido(codigo, stock, idpedido.toString());

                    }
                    Ticket.pedido(idpedido);
                    enviar.mail("Espero esté pasando un excelente día por este medio me permito hacerle el pedido del producto descrito en el archivo adjunto, de antemano reciba un coordial saludo de su amigo Bulmaro Torreblanca Guerrero", "Pedido de Producto Farmacia Amiga del Campesino", "ReportePedido" + idpedido + ".pdf", "src/Jaspers/ReportePedido" + idpedido + ".pdf", txtCorreo.getText());
                } else {
                    estilo.lblMensajes(lblmensaje, "No se ha podido hacer el pedido", 1);
                }
                datostabla = null;
                DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
                tblPedido.setModel(datos);
                cmbProveedor.setSelectedIndex(0);
                spcantidad.setValue(0);
                tblProductos.setModel(datos);
            } else {
                estilo.lblMensajes(lblmensaje, "Debe seleccionar Proveedor", 1);

            }
        }

    }//GEN-LAST:event_btnPedidoActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        limpiar();
//        enviar.mail("hola", "prueba","");
        // Ticket.pedido("31");
    }//GEN-LAST:event_LimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Producto_Root_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto_Root_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto_Root_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto_Root_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto_Root_Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPedido;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JSpinner spcantidad;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTable tblProductos;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigo;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
