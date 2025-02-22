/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrondEnd;
import BackEnd.CEmpleados;
import BackEnd.CProductos;
import BackEnd.Conexion;
import Backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author robek
 */
public class RUD_E extends javax.swing.JFrame {
    /**
     * Creates new form RUD_E
     */
    public RUD_E() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTITULO1 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        cbGenero = new javax.swing.JComboBox<>();
        txtContrasena = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Curp");
        jLabel2.setInheritsPopupMenu(false);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setInheritsPopupMenu(false);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("telefono");
        jLabel4.setInheritsPopupMenu(false);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Genero");
        jLabel5.setInheritsPopupMenu(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Apellido");
        jLabel9.setInheritsPopupMenu(false);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 140, -1));
        jPanel1.add(txtCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, -1));
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, -1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        lblTITULO1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTITULO1.setText("Agregar Empleado");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
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
                        .addContainerGap(14, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(cbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, -1));

        lblContrasena.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContrasena.setText("Contraseña");
        jPanel1.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bote-de-basura.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 50, 60));

        btnSelect.setBackground(new java.awt.Color(204, 204, 255));
        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 60, 60));

        btnEditar.setBackground(new java.awt.Color(204, 204, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lapiz.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 290, 60, 60));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/giphy.gif"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed

    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        Empleados Em=new Empleados();
        Em.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtNombre.getText().isEmpty()) {

            try {
                // Obtener los valores del formulario
                String CURP = txtCURP.getText();
                // Crear el objeto CProductos
                CEmpleados p = new CEmpleados();

                // Llamar al método update con los parámetros adecuados
                p.delete(CURP);
                txtApellido.setText("");
                txtNombre.setText("");
                txtTel.setText("");
                cbGenero.setSelectedIndex(0);
                txtCURP.setText("");
                txtContrasena.setText("");

                // Notificación de éxito (puedes personalizar el mensaje según sea necesario)
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
            } catch (NumberFormatException e) {
                // Mostrar error si cantidad o precio no son números válidos
                JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para cantidad y precio.");
            }
        } else {
            // Si alguno de los campos está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        if (!"".equalsIgnoreCase(txtCURP.getText())) {

            String CURP = txtCURP.getText();

            // Llamar al método select para obtener los productos correspondientes
            CEmpleados categoria = new CEmpleados();
            String[] productDetails = categoria.select(CURP);

            if (productDetails.length > 0 && productDetails[2] != null) {

                txtCURP.setText(productDetails[2]);

                String lastname = productDetails[1];
                txtApellido.setText(String.valueOf(lastname));

                String firstname = productDetails[0];
                txtNombre.setText(String.valueOf(firstname));
                
                int phone = Integer.parseInt(productDetails[3]);
                txtTel.setText(String.valueOf(phone));
                
                String password = productDetails[4];
                txtContrasena.setText(String.valueOf(password));
                
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el CURP del Cliente.");
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Validar que los campos no estén vacíos
        if (!txtNombre.getText().isEmpty() &&
            !txtCURP.getText().isEmpty() &&
            !txtContrasena.getText().isEmpty()) {

            try {
                // Obtener los valores del formulario
                String apellido=txtApellido.getText();
                String name = txtNombre.getText();
                String CURP = txtCURP.getText();
                int Tel=Integer.parseInt(txtTel.getText());
                String Contrasena = txtContrasena.getText(); // Validación implícita para precios
                int id = cbGenero.getSelectedIndex();
                // Crear el objeto CProductos
                CEmpleados e = new CEmpleados();

                // Llamar al método update con los parámetros adecuados
                e.update(apellido,name,CURP,Contrasena,Tel);
                txtNombre.setText("");
                txtApellido.setText("");
                txtCURP.setText("");
                txtTel.setText("");
                txtContrasena.setText("");
                cbGenero.setSelectedIndex(0);

                // Notificación de éxito (puedes personalizar el mensaje según sea necesario)
                JOptionPane.showMessageDialog(null, "Cliente editado exitosamente.");
            } catch (NumberFormatException e) {
                // Mostrar error si cantidad o precio no son números válidos
                JOptionPane.showMessageDialog(null, "Por favor ingresa valores numéricos válidos para cantidad y precio.");
            }
        } else {
            // Si alguno de los campos está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(RUD_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RUD_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RUD_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RUD_E.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RUD_E().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblTITULO1;
    private javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
