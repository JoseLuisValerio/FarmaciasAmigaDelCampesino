package Vista;

import Ayuda.Sesion;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Esta vista muestra la ventana principal del sistema, desde aqui se partirán a
 * todas las demás opciones
 *
 * @author Jose Luis
 */
public class Inicio extends javax.swing.JFrame implements Runnable {

    Ayuda.Sesion datos = new Ayuda.Sesion();
    Ayuda.Estilo Estilo;
    Controlador.Controlador_Inicio Controlador;
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Calendar c = new GregorianCalendar();
    String dia = Integer.toString(c.get(Calendar.DATE));
    String mes = Integer.toString(c.get(Calendar.MONTH)+1);
    String annio = Integer.toString(c.get(Calendar.YEAR));
    private Object [][] datosSucursal= null;

 

    public Inicio() {
        initComponents();
        Privilegios();
        Controlador = new Controlador.Controlador_Inicio();
        datosSucursal = Controlador.DatosSucursal();
        lblNombreSucursal.setText("Sucursal: "+(String)datosSucursal[0][0]);
        lblDireccion.setText("Direccion: "+(String)datosSucursal[0][1]);
        h1 = new Thread(this);
        h1.start();
        lblFecha.setText(dia+"/"+mes+"/"+annio);
        Estilo = new Ayuda.Estilo();

        Estilo.PnlTitulo(jPanel1, "Bienvenido");
        Estilo.PnlTitulo(jPanel2, "Datos de la sucursal");

        Estilo.MnIcon(MnArchivo, 1);
        Estilo.MnIcon(MnProductos, 2);
        Estilo.MnIcon(MnClientes, 3);
        Estilo.MnIcon(MnUsuarios, 5);
        Estilo.MnIcon(MnMovimientos, 6);
        Estilo.MnIcon(MnVentas, 9);
        Estilo.MnIcon(MnAdmin, 10);
        Estilo.MnIcon(MnReportes, 11);
        Estilo.MnIcon(MnInventarios, 13);
        Estilo.MnIcon(MnAcercade, 12);

        Estilo.mnitemIcon(MnItemCerrSesion, 1);
        Estilo.mnitemIcon(MnItemAddProd, 2);
        Estilo.mnitemIcon(MnItemSearchProd, 3);
        Estilo.mnitemIcon(MnItemTransProd, 4);
        Estilo.mnitemIcon(MnItemAddClient, 2);
        Estilo.mnitemIcon(MnItemAddMovimient, 2);
        Estilo.mnitemIcon(MnItemAddUser, 2);
        Estilo.mnitemIcon(MnItemAddMovimient, 2);
        Estilo.mnitemIcon(MnItemPedidos, 7);
        Estilo.mnitemIcon(MnItemProveedores, 8);
        Estilo.mnitemIcon(MnIntemAcomodar, 9);
        Estilo.mnitemIcon(MnItemVentas, 10);
        Estilo.mnitemIcon(MnItemInProveedor, 8);
        Estilo.mnitemIcon(MnItemInvSucursal, 11);
        Estilo.mnitemIcon(MnItemProductos, 12);
        Estilo.mnitemIcon(MnItemTipUsuario, 13);
        
        

        Estilo.frmInicial(this, "Farmacia y consultorio 'Amiga del campesino'");

        Estilo.lblLogo(lblEncabezado);
        Estilo.lblTitulo(lblNombre);
        Estilo.lblTitulo(lblTipo);
        Estilo.lblTitulo(lblUsuario);
        Estilo.lblTituloGrande(lblDireccion);
        Estilo.lblTituloGrande(lblNombreSucursal);
        Estilo.lblTituloGrande(lblFecha);
        Estilo.lblTituloGrande(lblHora);
        lblUsuario.setText(Sesion.LeerSesion("Usuario"));
        lblNombre.setText("<html>" + Sesion.LeerSesion("Nombre") + "</html>");
        lblTipo.setText(Sesion.LeerSesion("Tipo"));
    }
    
    private void Privilegios(){
        if(!Sesion.LeerSesion("Tipo").equals("Administrador")){
            MnAdmin.setEnabled(false);
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNombreSucursal = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnArchivo = new javax.swing.JMenu();
        MnItemCerrSesion = new javax.swing.JMenuItem();
        MnProductos = new javax.swing.JMenu();
        MnItemAddProd = new javax.swing.JMenuItem();
        MnItemSearchProd = new javax.swing.JMenuItem();
        MnIntemAcomodar = new javax.swing.JMenuItem();
        MnVentas = new javax.swing.JMenu();
        MnClientes = new javax.swing.JMenu();
        MnItemAddClient = new javax.swing.JMenuItem();
        MnMovimientos = new javax.swing.JMenu();
        MnItemAddMovimient = new javax.swing.JMenuItem();
        MnAdmin = new javax.swing.JMenu();
        MnUsuarios = new javax.swing.JMenu();
        MnItemAddUser = new javax.swing.JMenuItem();
        MnItemTipUsuario = new javax.swing.JMenuItem();
        MnItemProductos = new javax.swing.JMenuItem();
        MnItemTransProd = new javax.swing.JMenuItem();
        MnItemPedidos = new javax.swing.JMenuItem();
        MnItemProveedores = new javax.swing.JMenuItem();
        MnReportes = new javax.swing.JMenu();
        MnItemVentas = new javax.swing.JMenuItem();
        MnInventarios = new javax.swing.JMenu();
        MnItemInProveedor = new javax.swing.JMenuItem();
        MnItemInvSucursal = new javax.swing.JMenuItem();
        MnAcercade = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblHora.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblFecha.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N

        lblNombreSucursal.setText("jLabel1");

        lblDireccion.setText("jLabel1");
        lblDireccion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Datos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(lblNombreSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        MnItemAddProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemAddProdMousePressed(evt);
            }
        });
        MnProductos.add(MnItemAddProd);

        MnItemSearchProd.setText("Buscar");
        MnItemSearchProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemSearchProdMousePressed(evt);
            }
        });
        MnProductos.add(MnItemSearchProd);

        MnIntemAcomodar.setText("Acomodar");
        MnIntemAcomodar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnIntemAcomodarMousePressed(evt);
            }
        });
        MnProductos.add(MnIntemAcomodar);

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

        jMenuBar1.add(MnClientes);

        MnMovimientos.setText("Movimientos");

        MnItemAddMovimient.setText("Ingresar/retirar dinero");
        MnItemAddMovimient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemAddMovimientMousePressed(evt);
            }
        });
        MnMovimientos.add(MnItemAddMovimient);

        jMenuBar1.add(MnMovimientos);

        MnAdmin.setText("Administrativos");

        MnUsuarios.setText("Usuarios");

        MnItemAddUser.setText("Agregar/Editar usuarios");
        MnItemAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemAddUserMousePressed(evt);
            }
        });
        MnUsuarios.add(MnItemAddUser);

        MnAdmin.add(MnUsuarios);

        MnItemTipUsuario.setText("Tipos de Cliente");
        MnItemTipUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemTipUsuarioMousePressed(evt);
            }
        });
        MnAdmin.add(MnItemTipUsuario);

        MnItemProductos.setText("Productos");
        MnItemProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemProductosMousePressed(evt);
            }
        });
        MnAdmin.add(MnItemProductos);

        MnItemTransProd.setText("Transferir a sucursal");
        MnItemTransProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemTransProdMousePressed(evt);
            }
        });
        MnAdmin.add(MnItemTransProd);

        MnItemPedidos.setText("Hacer pedido");
        MnItemPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemPedidosMousePressed(evt);
            }
        });
        MnAdmin.add(MnItemPedidos);

        MnItemProveedores.setText("Proveedor");
        MnItemProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemProveedoresMousePressed(evt);
            }
        });
        MnAdmin.add(MnItemProveedores);

        MnReportes.setText("Reportes");

        MnItemVentas.setText("Ventas");
        MnItemVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemVentasMousePressed(evt);
            }
        });
        MnReportes.add(MnItemVentas);

        MnInventarios.setText("Inventarios");

        MnItemInProveedor.setText("Por Proveedor");
        MnItemInProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemInProveedorMousePressed(evt);
            }
        });
        MnInventarios.add(MnItemInProveedor);

        MnItemInvSucursal.setText("Por Sucursal");
        MnItemInvSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MnItemInvSucursalMousePressed(evt);
            }
        });
        MnInventarios.add(MnItemInvSucursal);

        MnReportes.add(MnInventarios);

        MnAdmin.add(MnReportes);

        jMenuBar1.add(MnAdmin);

        MnAcercade.setText("Acerca de");
        MnAcercade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnAcercadeMouseClicked(evt);
            }
        });
        jMenuBar1.add(MnAcercade);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnItemCerrSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemCerrSesionMousePressed
        Controlador.Reportes Ticket = new Controlador.Reportes();
        String Sucursal=Controlador.ObtenerSucursal();
        String Fecha= dia+"/"+mes+"/"+annio;
        String idUsuario =Sesion.LeerSesion("idUsuario");
        if(Controlador.HayMovimientos(Fecha, idUsuario)){
            Ticket.CorteConMov(Sucursal,Fecha,idUsuario);
        }else{
            Ticket.CorteSinMov(Sucursal, Fecha, idUsuario);
        }
        Ayuda.Sesion.cerrarSesion();
        Controlador.CajaCero();
        this.dispose();
        Login Ventana = new Login();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemCerrSesionMousePressed

    private void MnItemAddUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddUserMousePressed
        Usuario Ventana = new Usuario();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddUserMousePressed

    private void MnVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnVentasMousePressed
        Venta Ventana = new Venta();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnVentasMousePressed

    private void MnItemAddProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddProdMousePressed
        Vista.Producto_Consultar_Add Ventana = new Vista.Producto_Consultar_Add();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddProdMousePressed

    private void MnItemSearchProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemSearchProdMousePressed
        Vista.Producto_Consultar Ventana = new Vista.Producto_Consultar();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemSearchProdMousePressed

    private void MnItemTransProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemTransProdMousePressed
        Vista.Producto_Root_Transaccion Ventana = new Vista.Producto_Root_Transaccion();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemTransProdMousePressed

    private void MnItemAddClientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddClientMousePressed
        Cliente Ventana = new Cliente();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddClientMousePressed

    private void MnItemAddMovimientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemAddMovimientMousePressed
        Vista.Movimiento Ventana = new Vista.Movimiento();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemAddMovimientMousePressed

    private void MnItemPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemPedidosMousePressed
        Vista.Producto_Root_Pedido Ventana = new Vista.Producto_Root_Pedido();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemPedidosMousePressed

    private void MnItemProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemProveedoresMousePressed
        Vista.Proveedor Ventana = new Vista.Proveedor();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemProveedoresMousePressed

    private void MnIntemAcomodarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnIntemAcomodarMousePressed
        Vista.Producto_Acomodar Ventana = new Vista.Producto_Acomodar();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnIntemAcomodarMousePressed

    private void MnItemVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemVentasMousePressed
        Vista.Reportes Ventana = new Vista.Reportes();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemVentasMousePressed

    private void MnItemInProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemInProveedorMousePressed
        Controlador.Reportes Report= new Controlador.Reportes();
        Report.InventarioProveedor();
    }//GEN-LAST:event_MnItemInProveedorMousePressed

    private void MnItemInvSucursalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemInvSucursalMousePressed
        Controlador.Reportes Report= new Controlador.Reportes();
        Report.InventarioSucursalTodas();
    }//GEN-LAST:event_MnItemInvSucursalMousePressed

    private void MnItemProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemProductosMousePressed
        Vista.Producto_Root Ventana = new Vista.Producto_Root();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemProductosMousePressed

    private void MnItemTipUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnItemTipUsuarioMousePressed
        Vista.TipoCliente Ventana = new Vista.TipoCliente();
        Ventana.setVisible(true);
    }//GEN-LAST:event_MnItemTipUsuarioMousePressed

    private void MnAcercadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnAcercadeMouseClicked
        About a = new About();
        a.setVisible(true);
    }//GEN-LAST:event_MnAcercadeMouseClicked

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
    private javax.swing.JMenu MnAcercade;
    private javax.swing.JMenu MnAdmin;
    private javax.swing.JMenu MnArchivo;
    private javax.swing.JMenu MnClientes;
    private javax.swing.JMenuItem MnIntemAcomodar;
    private javax.swing.JMenu MnInventarios;
    private javax.swing.JMenuItem MnItemAddClient;
    private javax.swing.JMenuItem MnItemAddMovimient;
    private javax.swing.JMenuItem MnItemAddProd;
    private javax.swing.JMenuItem MnItemAddUser;
    private javax.swing.JMenuItem MnItemCerrSesion;
    private javax.swing.JMenuItem MnItemInProveedor;
    private javax.swing.JMenuItem MnItemInvSucursal;
    private javax.swing.JMenuItem MnItemPedidos;
    private javax.swing.JMenuItem MnItemProductos;
    private javax.swing.JMenuItem MnItemProveedores;
    private javax.swing.JMenuItem MnItemSearchProd;
    private javax.swing.JMenuItem MnItemTipUsuario;
    private javax.swing.JMenuItem MnItemTransProd;
    private javax.swing.JMenuItem MnItemVentas;
    private javax.swing.JMenu MnMovimientos;
    private javax.swing.JMenu MnProductos;
    private javax.swing.JMenu MnReportes;
    private javax.swing.JMenu MnUsuarios;
    private javax.swing.JMenu MnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreSucursal;
    private javax.swing.JLabel lblTipo;
    public static javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            if((hora.equals("11") && minutos.equals("00")&&segundos.equals("00"))||(hora.equals("04")&& minutos.equals("09")&&segundos.equals("00"))||(hora.equals("08"))&& minutos.equals("00")&&segundos.equals("00")){
            AlertasFaltaProductos alerta = new AlertasFaltaProductos ();
            alerta.setVisible(true);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
}
