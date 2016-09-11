
package Vista;

import Ayuda.Sesion;



/**
 * Esta vista muestra la ventana principal del sistema, desde aqui se partirán a todas las demás opciones
 * @author Jose Luis
 */
public class Inicio extends javax.swing.JFrame {
    Ayuda.Sesion datos = new Ayuda.Sesion();
    Ayuda.Estilo Estilo;
    
    public Inicio() {
        initComponents();
        Estilo = new Ayuda.Estilo();
        
        Estilo.PnlTitulo(jPanel1, "Bienvenido");
        Estilo.PnlTitulo(jPanel2, "Acciones disponibles");
        
        Estilo.MnIcon(MnArchivo, 1);
        Estilo.MnIcon(MnProductos, 2);
        Estilo.MnIcon(MnClientes, 3);
        Estilo.MnIcon(MnCaja, 4);
        Estilo.MnIcon(MnUsuarios, 5);
        Estilo.MnIcon(MnMovimientos, 6);
        Estilo.MnIcon(MnPedidos, 7);
        Estilo.MnIcon(MnProveedores, 8);
        Estilo.MnIcon(MnVentas, 9);
        
        Estilo.mnitemIcon(MnItemCerrSesion, 1);
        Estilo.mnitemIcon(MnItemAddProd, 2);
        Estilo.mnitemIcon(MnItemSearchProd, 3);
        Estilo.mnitemIcon(MnItemTransProd, 4);
        Estilo.mnitemIcon(MnItemAddClient, 2);
        Estilo.mnitemIcon(MnItemDesClient, 5);
        Estilo.mnitemIcon(MnItemCortCaja, 6);
        Estilo.mnitemIcon(MnItemAddMovimient, 2);
        Estilo.mnitemIcon(MnItemAddUser, 2);
        Estilo.mnitemIcon(MnItemAddMovimient, 2);
        Estilo.mnitemIcon(MnItemPedidos, 7);
        Estilo.mnitemIcon(MnItemProveedores, 2);
        
        Estilo.frmInicial(this, "Farmacia y consultorio 'Amiga del campesino'");
        
        Estilo.lblLogo(lblEncabezado);
        Estilo.lblTitulo(lblNombre);
        Estilo.lblTitulo(lblTipo);
        Estilo.lblTitulo(lblUsuario);
        lblUsuario.setText(Sesion.LeerSesion("Usuario"));
        lblNombre.setText("<html>"+Sesion.LeerSesion("Nombre")+"</html>");
        lblTipo.setText(Sesion.LeerSesion("Tipo"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnArchivo = new javax.swing.JMenu();
        MnItemCerrSesion = new javax.swing.JMenuItem();
        MnProductos = new javax.swing.JMenu();
        MnItemAddProd = new javax.swing.JMenuItem();
        MnItemSearchProd = new javax.swing.JMenuItem();
        MnItemTransProd = new javax.swing.JMenuItem();
        MnVentas = new javax.swing.JMenu();
        MnClientes = new javax.swing.JMenu();
        MnItemAddClient = new javax.swing.JMenuItem();
        MnItemDesClient = new javax.swing.JMenuItem();
        MnCaja = new javax.swing.JMenu();
        MnItemCortCaja = new javax.swing.JMenuItem();
        MnUsuarios = new javax.swing.JMenu();
        MnItemAddUser = new javax.swing.JMenuItem();
        MnMovimientos = new javax.swing.JMenu();
        MnItemAddMovimient = new javax.swing.JMenuItem();
        MnPedidos = new javax.swing.JMenu();
        MnItemPedidos = new javax.swing.JMenuItem();
        MnProveedores = new javax.swing.JMenu();
        MnItemProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/UserLogin.png"))); // NOI18N

        lblNombre.setText("NOMBRE");

        lblTipo.setText("TIPO");

        lblUsuario.setText("USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(211, 211, 211))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MnArchivo.setText("Archivo");

        MnItemCerrSesion.setText("Cerrar sesión");
        MnItemCerrSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemCerrSesionMousePressed(evt);
            }
        });
        MnArchivo.add(MnItemCerrSesion);

        jMenuBar1.add(MnArchivo);

        MnProductos.setText("Productos");

        MnItemAddProd.setText("Agregar");
        MnProductos.add(MnItemAddProd);

        MnItemSearchProd.setText("Buscar");
        MnProductos.add(MnItemSearchProd);

        MnItemTransProd.setText("Transferir a sucursal");
        MnProductos.add(MnItemTransProd);

        jMenuBar1.add(MnProductos);

        MnVentas.setText("Ventas");
        MnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnVentasMousePressed(evt);
            }
        });
        jMenuBar1.add(MnVentas);

        MnClientes.setText("Clientes");

        MnItemAddClient.setText("Agregar/Editar");
        MnItemAddClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemAddClientMousePressed(evt);
            }
        });
        MnClientes.add(MnItemAddClient);

        MnItemDesClient.setText("Descuento");
        MnClientes.add(MnItemDesClient);

        jMenuBar1.add(MnClientes);

        MnCaja.setText("Caja");

        MnItemCortCaja.setText("Corte de Caja");
        MnCaja.add(MnItemCortCaja);

        jMenuBar1.add(MnCaja);

        MnUsuarios.setText("Usuarios");

        MnItemAddUser.setText("Agregar/Editar usuarios");
        MnItemAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemAddUserMousePressed(evt);
            }
        });
        MnUsuarios.add(MnItemAddUser);

        jMenuBar1.add(MnUsuarios);

        MnMovimientos.setText("Movimientos");

        MnItemAddMovimient.setText("Ingresar/retirar dinero");
        MnMovimientos.add(MnItemAddMovimient);

        jMenuBar1.add(MnMovimientos);

        MnPedidos.setText("Pedidos");

        MnItemPedidos.setText("Ver pedidos");
        MnPedidos.add(MnItemPedidos);

        jMenuBar1.add(MnPedidos);

        MnProveedores.setText("Proveedores");

        MnItemProveedores.setText("Agregar/Modificar Proveedores");
        MnProveedores.add(MnItemProveedores);

        jMenuBar1.add(MnProveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void MnItemCerrSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemCerrSesionMousePressed
        Controlador.Reportes Ticket = new Controlador.Reportes();
        Controlador.Controlador_Venta Controlador = new Controlador.Controlador_Venta();
        Ticket.TicketCorte(Controlador.ObtenerSucursal());
        Ayuda.Sesion.cerrarSesion();
        this.dispose();
        Login Ventana = new Login();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemCerrSesionMousePressed

    private void MnItemAddUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddUserMousePressed
        Usuario Ventana = new Usuario();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddUserMousePressed

    private void MnItemAddClientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddClientMousePressed
        Cliente Ventana = new Cliente();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddClientMousePressed

    private void MnVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnVentasMousePressed
        Venta Ventana = new Venta();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnVentasMousePressed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnArchivo;
    private javax.swing.JMenu MnCaja;
    private javax.swing.JMenu MnClientes;
    private javax.swing.JMenuItem MnItemAddClient;
    private javax.swing.JMenuItem MnItemAddMovimient;
    private javax.swing.JMenuItem MnItemAddProd;
    private javax.swing.JMenuItem MnItemAddUser;
    private javax.swing.JMenuItem MnItemCerrSesion;
    private javax.swing.JMenuItem MnItemCortCaja;
    private javax.swing.JMenuItem MnItemDesClient;
    private javax.swing.JMenuItem MnItemPedidos;
    private javax.swing.JMenuItem MnItemProveedores;
    private javax.swing.JMenuItem MnItemSearchProd;
    private javax.swing.JMenuItem MnItemTransProd;
    private javax.swing.JMenu MnMovimientos;
    private javax.swing.JMenu MnPedidos;
    private javax.swing.JMenu MnProductos;
    private javax.swing.JMenu MnProveedores;
    private javax.swing.JMenu MnUsuarios;
    private javax.swing.JMenu MnVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipo;
    public static javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
