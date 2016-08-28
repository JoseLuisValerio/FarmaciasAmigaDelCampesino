package Vista;

import Controlador.Controlador_Usuario;
import javax.swing.table.DefaultTableModel;

/**
 * Esta vista permite la creación y edición de usuarios o empleados a traves de
 * la selección de tipo de se asignan los permisos necesarios.
 *
 * @author root
 */
public class Usuario extends javax.swing.JFrame {

    Ayuda.Estilo Estilo;
    Ayuda.Utilidades Util;
    Ayuda.Validacion Valido;
    private Object[][] datostabla;
    String[] columnas = {"Usuario", "Tipo", "Nombre", "A. Paterno", "A. Materno"};
    Controlador.Controlador_Usuario Controlador;

    public Usuario() {
        initComponents();
        Controlador = new Controlador_Usuario();
        Estilo = new Ayuda.Estilo();
        Util = new Ayuda.Utilidades();
        Valido = new Ayuda.Validacion();
        Estilo.lblBody(jLabel1);
        Estilo.lblBody(jLabel2);
        Estilo.lblBody(jLabel3);
        Estilo.lblBody(jLabel4);
        Estilo.lblBody(jLabel5);
        Estilo.lblBody(jLabel6);
        Estilo.lblBody(jLabel7);
        Estilo.lblLogo(lblEncabezado);
        Estilo.lblMensajes(lblAlerta, "", 4);

        Estilo.BtnOpcion(btnAdd, 1);
        Estilo.BtnOpcion(btnUpdate, 2);
        Estilo.BtnOpcion(btnCancel, 3);

        Estilo.PnlTitulo(jPanel1, "Datos del usuario/empleado");
        Estilo.PnlTitulo(jPanel2, "Usuarios/empleados registrados");

        Estilo.frmInicial(this, "Usuarios/empleados");

        Estilo.txtfDescripcion(txtAPaterno, "Apellido paterno");
        Estilo.txtfDescripcion(txtAMaterno, "Apellido materno");
        Estilo.txtfDescripcion(txtNombre, "Nombre(s)");
        Estilo.txtfDescripcion(txtUsuario, "Nombre de usuario");

        //Inicio de valores iniciales
        MostrarTabla();
        LlenarcmbTipos();
        Util.botonHabilitar(btnUpdate, false);

    }

    /**
     * Muestra todos los usuarios de la tabla Usuario en la tabla
     */
    private void MostrarTabla() {
        datostabla = Controlador.ConsultaUsuarios();
        DefaultTableModel datos = new DefaultTableModel(datostabla, columnas);
        tblUsuarios.setModel(datos);
    }

    /**
     * Llena los combos de los tipos
     */
    private void LlenarcmbTipos() {
        Object[] Tipos = Controlador.CargaTipos();
        cmbTipo.removeAllItems();
        cmbTipo.addItem("");
        for (int i = 0; i < Tipos.length; i++) {
            cmbTipo.addItem((String) Tipos[i]);
        }
    }
    
    private void Limpiar(){
        Util.passLimpiar(passField1);
        Util.passLimpiar(passField2);
        Util.txtLimpiar(txtNombre);
        Util.txtLimpiar(txtUsuario);
        Util.txtLimpiar(txtAPaterno);
        Util.txtLimpiar(txtAMaterno);
        Util.passLimpiar(passField1);
        Util.passLimpiar(passField2);
        Util.botonHabilitar(btnAdd, true);
        Util.botonHabilitar(btnUpdate, false);
        MostrarTabla();
        Util.txtFoco(txtUsuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEncabezado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAMaterno = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtAPaterno = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtNombre = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passField1 = new javax.swing.JPasswordField();
        passField2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblAlerta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Ape. Materno:");

        jLabel5.setText("Nombre(s):");

        jLabel6.setText("Ape. Paterno:");

        jLabel7.setText("Confirme:");

        cmbTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAdd.setText("jButton1");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("jButton1");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("jButton1");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtAPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passField2)
                            .addComponent(passField1)
                            .addComponent(cmbTipo, 0, 191, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblAlerta.setText("Mensajes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlerta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String Password = new String(passField1.getPassword());
        if(!Valido.txtVacio(txtNombre) && !Valido.txtVacio(txtUsuario) && !Valido.txtVacio(txtAMaterno) && !Valido.txtVacio(txtAPaterno) && !Valido.ComboVacio(cmbTipo)){
        if(!Controlador.ExisteUsuario(txtUsuario.getText())){
        if (Controlador.InsertarUsuario(txtUsuario.getText(), Password, cmbTipo.getSelectedItem().toString(), txtNombre.getText(), txtAPaterno.getText(), txtAMaterno.getText())) {
            Estilo.lblMensajes(lblAlerta, "Usuario Registrado exitosamente ", 3);
            MostrarTabla();
            Limpiar();
        } else {
            Estilo.lblMensajes(lblAlerta, "Ha ocurrido un error al insertar el usuario", 2);
        }
        }else{
            Estilo.lblMensajes(lblAlerta, "El nombre de usuario ya existe. Por favor cambielo", 2);
        }
        }else{
            Estilo.lblMensajes(lblAlerta, "Fantan datos, por favor verifique", 1);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMousePressed
        int fila = tblUsuarios.getSelectedRow();
        if (fila >= 0) {
            txtUsuario.setText(String.valueOf(tblUsuarios.getValueAt(fila, 0)));
            //cmbTipo 
            txtNombre.setText(String.valueOf(tblUsuarios.getValueAt(fila, 2)));
            txtAPaterno.setText(String.valueOf(tblUsuarios.getValueAt(fila, 3)));
            txtAMaterno.setText(String.valueOf(tblUsuarios.getValueAt(fila, 4)));
            Util.botonHabilitar(btnUpdate, true);
            Util.botonHabilitar(btnAdd, false);
            Util.txtHabilitar(txtUsuario, false);
        }
    }//GEN-LAST:event_tblUsuariosMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(Valido.PassCompara(passField1, passField2)){
        String Password = new String(passField1.getPassword());
        if(Controlador.ActualizarUsuario(txtUsuario.getText(), Password, cmbTipo.getSelectedItem().toString(), txtNombre.getText(), txtAPaterno.getText(), txtAMaterno.getText())){
            Estilo.lblMensajes(lblAlerta, "Usuario actualizado correctamente", 3);
            Limpiar();
            Util.txtHabilitar(txtUsuario, true);
        }else{
            Estilo.lblMensajes(lblAlerta, "Ha ocurrido un error al actualizar usuario", 2);
        }
    }else{
            Estilo.lblMensajes(lblAlerta, "Las contraseñas no coinciden, verifique", 1);
            }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Limpiar();
        Estilo.lblMensajes(lblAlerta, "", 4);
        Util.txtHabilitar(txtUsuario, true);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlerta;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JPasswordField passField1;
    private javax.swing.JPasswordField passField2;
    private javax.swing.JTable tblUsuarios;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtAMaterno;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtAPaterno;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtNombre;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtUsuario;
    // End of variables declaration//GEN-END:variables
}
