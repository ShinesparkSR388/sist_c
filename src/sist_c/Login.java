/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sist_c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Janto
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Bg2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_ = new javax.swing.JPasswordField();
        pass_ = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icon_1.png"))); // NOI18N
        bg.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 150, 180));

        Bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/bg.png"))); // NOI18N
        bg.add(Bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, 491));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/icon_1 - copia.png"))); // NOI18N
        jLabel1.setText("Accounting System");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 280, -1));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CONTRASEÑA");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 240, 30));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("INICIAR SESIÓN");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 240, 60));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("USUARIO");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 240, 30));

        user_.setBackground(new java.awt.Color(153, 153, 153));
        user_.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        user_.setForeground(new java.awt.Color(255, 255, 255));
        user_.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        bg.add(user_, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 280, 30));

        pass_.setBackground(new java.awt.Color(153, 153, 153));
        pass_.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pass_.setForeground(new java.awt.Color(255, 255, 255));
        pass_.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        bg.add(pass_, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 280, 30));

        btnEntrar.setBackground(new java.awt.Color(0, 51, 255));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        bg.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
      
        
        // Variables para almacenar los datos
        Boolean datauser = false;
        String usuario = "";
        String password = "";
        usuario = user_.getText();
        password = pass_.getText();
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("SELECT * FROM user WHERE username='" + usuario + "' AND password='" + password + "'");

            if (rs.next()) {
                datauser = true;
            } else {
                System.out.println("No se encontraron registros en la tabla 'user' con el ID especificado.");
            }

            cn.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Username: " + datauser);

        if(datauser){
            System.out.println("Usuario y Contraseña correcta, acceso permitido.");
            new menu().setVisible(true);
            dispose();
        }
        else{
            System.out.println("Usuario o Contraseña incorrecta, acceso denegado.");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bg2;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass_;
    private javax.swing.JPasswordField user_;
    // End of variables declaration//GEN-END:variables
}
