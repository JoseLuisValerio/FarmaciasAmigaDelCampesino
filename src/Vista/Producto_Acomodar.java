/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ayuda.Estilo;
import Controlador.Controlador_Producto_Acomodar;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Luis
 */
public class Producto_Acomodar extends javax.swing.JFrame {
    Estilo estilo = new Estilo();

    private Object[][] datostabla;
    String[] columnas = {"Código", "Nombre", "Activo", "Precio", "Stock", "Area"};
    Controlador_Producto_Acomodar ctr = new Controlador_Producto_Acomodar();
    Object[] fila = new Object[4];
    public Producto_Acomodar() {
        initComponents();
        mostrarProducto();
        cargarAreas();
        estilo.lblBody(jLabel3);
        estilo.frmInicial(this,"Acomodar");
        estilo.txtfDescripcion(txtCodigo, "Código de Producto");
        estilo.lblLogo(lblEncabezado);
        estilo.lblBody(jLabel3);
        estilo.lblBody(jLabel6);
        estilo.lblBody(jLabel7);
        estilo.BtnOpcion(Limpiar, 3);
        estilo.BtnOpcion(btnAcomodar, 4);
        estilo.BtnOpcion(btnAreaNueva, 1);
        estilo.PnlTitulo(pnlProductos, "Todos los productos");
        estilo.PnlTitulo(pnlAcomodar, "Productos para acomodar");
        btnAcomodar.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnAgregar.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnEliminar.setFont(new java.awt.Font("Britannic Bold", Font.PLAIN, 12));
        btnAcomodar.setText("Acomodar");
    }
    public void mostrarProducto(){
    datostabla = ctr.mostrarProductos();
    DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
    tblProductos.setModel(datos);
    }
    public void buscar(String busqueda){
    datostabla = ctr.buscarProducto(busqueda);
    DefaultTableModel datos =  new DefaultTableModel(datostabla, columnas);
    tblProductos.setModel(datos);
    }
     public void cargarAreas() {
        Object[] Areas = ctr.cargaAreas();
        cmbAreas.removeAllItems();
        cmbAreas.addItem("SELECIONES AREA");
        for (int i = 0; i < Areas.length; i++) {
            cmbAreas.addItem((String) Areas[i]);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmensaje = new javax.swing.JLabel();
        btnAcomodar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        lblEncabezado = new javax.swing.JLabel();
        pnlProductos = new javax.swing.JPanel();
        txtCodigo = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlAcomodar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaccion = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtArea = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnAreaNueva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAcomodar.setText("Acomodar");
        btnAcomodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcomodarActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtCodigo.setDescripcion("Código de producto");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        jLabel3.setText("Filtrar por código:");

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

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(121, 121, 121))))
        );

        tblTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre ", "Activo", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblTransaccion);

        jLabel6.setText("Area");

        cmbAreas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Nueva Area");

        txtArea.setDescripcion("Código de producto");

        btnAreaNueva.setText("Agregar");
        btnAreaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAcomodarLayout = new javax.swing.GroupLayout(pnlAcomodar);
        pnlAcomodar.setLayout(pnlAcomodarLayout);
        pnlAcomodarLayout.setHorizontalGroup(
            pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcomodarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAcomodarLayout.createSequentialGroup()
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7))
                        .addGroup(pnlAcomodarLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48))
                        .addComponent(cmbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAcomodarLayout.createSequentialGroup()
                        .addGroup(pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAreaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlAcomodarLayout.setVerticalGroup(
            pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcomodarLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pnlAcomodarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAcomodarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAreaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlAcomodar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnAcomodar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(671, 671, 671))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlAcomodar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAcomodar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       DefaultTableModel model = (DefaultTableModel) tblTransaccion.getModel();

        int a = tblTransaccion.getSelectedRow();
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

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int cor = tblProductos.getSelectedRow();
        if (cor < 0) {
            estilo.lblMensajes(lblmensaje, "Seleccionar un producto", 2);
        } else {
                String codigo = (tblProductos.getValueAt(cor, 0).toString());
                String nombre = (tblProductos.getValueAt(cor, 1).toString());
                String activo = (tblProductos.getValueAt(cor, 2).toString());
                String existencia = (tblProductos.getValueAt(cor, 5).toString());
                
                DefaultTableModel modelo = (DefaultTableModel) tblTransaccion.getModel();

                    fila[0] = codigo;
                    fila[1] = nombre;
                    fila[2] = activo;
                    fila[3] = existencia;

                    modelo.addRow(fila);

                    tblTransaccion.setModel(modelo);
                            
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        String buscar = txtCodigo.getText();
        this.buscar(buscar);
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnAreaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaNuevaActionPerformed
        String area = txtArea.getText();
        if (area.length() > 0){
        ctr.ingresarNuevaArea(area);
        this.cargarAreas();
        Ayuda.Utilidades Util = new Ayuda.Utilidades();
        Util.txtLimpiar(txtArea);
        }else {
        estilo.lblMensajes(lblmensaje,"Debe Ingrear la Nueva Area",2);
        }
    }//GEN-LAST:event_btnAreaNuevaActionPerformed

    private void btnAcomodarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcomodarActionPerformed
        String Area=ctr.idArea(cmbAreas.getSelectedItem().toString());
        if (datostabla == null) {
            estilo.lblMensajes(lblmensaje, "No a selecionado productos", 1);
        } else {
            for (int i = 0; i < tblTransaccion.getRowCount(); i++) {
                if (cmbAreas.getSelectedIndex() != 0) {
                    String codigo = (String) tblTransaccion.getValueAt(i, 0);
                    if(ctr.actualizarArea(codigo, Area)== true){
                    estilo.lblMensajes(lblmensaje,"Areas Asignadas", 3);
                    }else {
                    estilo.lblMensajes(lblmensaje,"No a podido Asignar Area", 1);
                    }
                } else {
                    estilo.lblMensajes(lblmensaje, "Debe seleccione un Area", 1);
                    break;
                }
            }            
            String[] columnas1 = {"Código", "Nombre", "Activo" ,"Stock"};
        datostabla = null;
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas1);
        tblTransaccion.setModel(datos);
        cmbAreas.setSelectedIndex(0);
        mostrarProducto();
        }
    }//GEN-LAST:event_btnAcomodarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        String[] columnas1 = {"Código", "Nombre", "Activo" ,"Stock"};
        datostabla = null;
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas1);
        tblTransaccion.setModel(datos);
        cmbAreas.setSelectedIndex(0);
        mostrarProducto();
        estilo.lblMensajes(lblmensaje, "", 4);
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
            java.util.logging.Logger.getLogger(Producto_Acomodar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto_Acomodar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto_Acomodar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto_Acomodar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto_Acomodar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton btnAcomodar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAreaNueva;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cmbAreas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JPanel pnlAcomodar;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblTransaccion;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtArea;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtCodigo;
    // End of variables declaration//GEN-END:variables
}
