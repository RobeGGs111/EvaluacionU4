package FrondEnd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import BackEnd.Conexion;
import BackEnd.CVentas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Alrjandro Padilla
 */
public class Ventas_cajas extends javax.swing.JFrame {

    /**
     * Creates new form Ventas_cajas
     */
    Conexion cx;
    CVentas n= new CVentas();
    String user;
    int caja;
    String f;
    int idUser;
    double total;
    double iva;
    public Ventas_cajas(String nombre, int caja) {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        cx = new Conexion("TIENDA");
        // Tener la fecha 
        this.user=nombre;
        this.caja=caja;
        this.idUser=n.idUser(user);
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         f = fecha.format(formato);
        TxtFecha.setText(f);
        TxtNombre.setText(n.name(user));
    }
    public Ventas_cajas () {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void actualizarTotales() {
         double subtotal = 0.0;
    
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object importeObj = modelo.getValueAt(i, 4); // Columna de importe
            if (importeObj != null && importeObj instanceof Double) {
                subtotal += (double) importeObj;
            }
        }

         iva = subtotal * 0.16; 
        total = subtotal + iva;

        String[] totales = {
            "$ "+String.format("%.2f", subtotal),
            "$ "+String.format("%.2f", iva),
            "$ "+String.format("%.2f", total)
        };
        lista.setListData(totales);
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
        jPanel3 = new javax.swing.JPanel();
        lblTITULO1 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btnMas = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEliminarT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        lblTITULO1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTITULO1.setText("Ventas");
        lblTITULO1.setToolTipText("");

        btnsalir1.setBackground(new java.awt.Color(204, 204, 255));
        btnsalir1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsalir1.setText("Salir");
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });

        btnRegresar1.setBackground(new java.awt.Color(204, 204, 255));
        btnRegresar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTITULO1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(btnRegresar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir1)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTITULO1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Precio", "Cantidad", "Importe"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 530, 140));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Empleado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 70, -1));

        TxtNombre.setBackground(new java.awt.Color(204, 204, 204));
        TxtNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TxtNombre.setEnabled(false);
        TxtNombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Subtotal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("IVA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, 20));

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, -1));

        TxtFecha.setBackground(new java.awt.Color(204, 204, 204));
        TxtFecha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        TxtFecha.setForeground(new java.awt.Color(0, 0, 0));
        TxtFecha.setCaretColor(new java.awt.Color(0, 0, 0));
        TxtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TxtFecha.setEnabled(false);
        TxtFecha.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        TxtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        lista.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lista.setForeground(new java.awt.Color(204, 204, 204));
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$ 0.00", "$ 0.00", "$ 0.00", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.setEnabled(false);
        lista.setSelectionForeground(new java.awt.Color(204, 204, 204));
        lista.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(lista);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 90, 70));

        btnMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas.png"))); // NOI18N
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        jPanel1.add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 50, -1));

        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menos.png"))); // NOI18N
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 50, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 50, 40));

        btnEliminarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/EliminarT.png"))); // NOI18N
        btnEliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Menos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Borrar Uno");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 60, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Borar Todos");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-azul-degradado-lujo-abstracto-azul-oscuro-liso-banner-estudio-vineta-negra.jpg"))); // NOI18N
        Fondo.setFocusable(false);
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
                cx.conectar();
                cx.desconectar();
                System.exit(0);
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
            Menu menu = new Menu(user, caja);
            menu.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void TxtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaActionPerformed

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        try {
        int Id = Integer.parseInt(txtBuscar.getText().trim());
        Object[] producto = n.buscarProductoPorId(Id);

        if (producto != null) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
             int cantidadDisponible=(int) producto[3];
            boolean productoE = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Object FilaObj = modelo.getValueAt(i, 0);
                
                if (FilaObj != null && FilaObj instanceof Integer) {
                    int idDeFila = (int) FilaObj;
                    if (idDeFila == Id) {
                        int cantidad = (int) modelo.getValueAt(i, 3);  
                        double precioUnitario = (double) modelo.getValueAt(i, 2); 
                        if (cantidad < cantidadDisponible){
                                cantidad += 1;  
                                modelo.setValueAt(cantidad, i, 3);  
                                double nuevoImporte = cantidad * precioUnitario;
                                modelo.setValueAt(nuevoImporte, i, 4); 
                        }else{
                                  JOptionPane.showMessageDialog(this, "No puedes agregar más de la cantidad disponible en la base");
                        }

                        productoE = true;  
                        break;  
                    }
                }
            }
            if (!productoE) {
                if(1<=cantidadDisponible){
                        Object[] nuevaFila = {
                            producto[0],  
                            producto[1],  
                            producto[2],  
                            1,            
                            (double) producto[2]  
                        };
                        modelo.addRow(nuevaFila);
                }else{
                       JOptionPane.showMessageDialog(this, "No puedes agregar más de la cantidad disponible en la base");
                }
                
            }
            actualizarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado o descontinuado");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un ID de producto válido");
    }
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            n.realizarTransaccion( modelo,idUser,f,total,n.name(user),iva);
            modelo.setRowCount(0);
            txtBuscar.setText("");
            actualizarTotales();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        int selecionaLaFila = jTable1.getSelectedRow();  
        if (selecionaLaFila != -1) {
            int productoID=(int) jTable1.getValueAt(selecionaLaFila, 0);
            Object[] producto = n.buscarProductoPorId(productoID);
            if(producto !=null){
                int cantidadDisponible = (int) producto[3];
                int cantidad = Integer.parseInt(jTable1.getValueAt(selecionaLaFila, 3).toString());
                if(cantidad<cantidadDisponible){
                     cantidad++;
                     jTable1.setValueAt(cantidad, selecionaLaFila, 3);
                     double precio = Double.parseDouble(jTable1.getValueAt(selecionaLaFila, 2).toString()); 
                     double importe = cantidad * precio;
                     jTable1.setValueAt(importe, selecionaLaFila, 4); 
                     actualizarTotales();
                }else{
                         JOptionPane.showMessageDialog(this, "No puedes agregar más de la cantidad disponible en la base");
                }
            
            }  else{
                JOptionPane.showMessageDialog(null, "El producto no está disponible o está descontinuado.");
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Por favor Seleccione una fila.");
        }
       
    }//GEN-LAST:event_btnMasActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
         int selecionaLaFila = jTable1.getSelectedRow();
        if (selecionaLaFila != -1) {
            int cantidad = Integer.parseInt(jTable1.getValueAt(selecionaLaFila, 3).toString());
            if (cantidad > 1) {
                cantidad--;  
                jTable1.setValueAt(cantidad, selecionaLaFila, 3); 
                double precio = Double.parseDouble(jTable1.getValueAt(selecionaLaFila, 2).toString()); 
                double importe = cantidad * precio;
                
                jTable1.setValueAt(importe, selecionaLaFila, 4); 
                actualizarTotales();
            } else if (cantidad == 1) {
                
                ((DefaultTableModel) jTable1.getModel()).removeRow(selecionaLaFila);
                actualizarTotales();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor Seleccione una fila.");
        }
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int selecionaLaFila = jTable1.getSelectedRow(); 
          if (selecionaLaFila != -1) {
              int cantidad = Integer.parseInt(jTable1.getValueAt(selecionaLaFila, 3).toString());
               ((DefaultTableModel) jTable1.getModel()).removeRow(selecionaLaFila);
               actualizarTotales();
          }else {
            JOptionPane.showMessageDialog(null, "Por favor Seleccione una fila.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTActionPerformed
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            actualizarTotales();
    }//GEN-LAST:event_btnEliminarTActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas_cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas_cajas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTITULO1;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
