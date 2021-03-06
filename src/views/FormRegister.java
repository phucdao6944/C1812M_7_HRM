/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.User;
import java.awt.Color;
import javax.swing.JOptionPane;
import static views.FormLogin._usr;

/**
 *
 * @author Queen
 */
public class FormRegister extends javax.swing.JFrame {

    /**
     * Creates new form FormRegister
     */
    public FormRegister() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LabelUsernameRegister = new javax.swing.JLabel();
        LabelPasswordRegister = new javax.swing.JLabel();
        RegisterUsername = new javax.swing.JTextField();
        LabelPasswordConfirmRegister = new javax.swing.JLabel();
        SubmitRegister = new javax.swing.JButton();
        SignInNow = new javax.swing.JLabel();
        RegisterPassword = new javax.swing.JPasswordField();
        RegisterPasswordConfirm = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(540, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(206, 206, 206))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(369, 393));

        LabelUsernameRegister.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        LabelUsernameRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelUsernameRegister.setText("Username");

        LabelPasswordRegister.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        LabelPasswordRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelPasswordRegister.setText("Password");

        RegisterUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(153, 204, 255), java.awt.Color.white));
        RegisterUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RegisterUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterUsernameActionPerformed(evt);
            }
        });

        LabelPasswordConfirmRegister.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        LabelPasswordConfirmRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelPasswordConfirmRegister.setText("Password Confirm");

        SubmitRegister.setBackground(new java.awt.Color(102, 153, 255));
        SubmitRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubmitRegister.setForeground(new java.awt.Color(255, 255, 255));
        SubmitRegister.setText("Submit");
        SubmitRegister.setAlignmentX(0.5F);
        SubmitRegister.setBorder(null);
        SubmitRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitRegisterMouseClicked(evt);
            }
        });

        SignInNow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SignInNow.setForeground(new java.awt.Color(102, 153, 255));
        SignInNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SignInNow.setText("Already have an account? Sign in");
        SignInNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignInNow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SignInNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignInNowMouseClicked(evt);
            }
        });

        RegisterPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(153, 204, 255), java.awt.Color.white));

        RegisterPasswordConfirm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 204, 255), java.awt.Color.white));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(RegisterPasswordConfirm)
                    .addComponent(RegisterPassword)
                    .addComponent(RegisterUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(LabelPasswordRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUsernameRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(SubmitRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(SignInNow))
                    .addComponent(LabelPasswordConfirmRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LabelUsernameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegisterUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelPasswordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegisterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelPasswordConfirmRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegisterPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(SubmitRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SignInNow)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterUsernameActionPerformed

    private void SignInNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInNowMouseClicked
        if (this.isVisible()) {
            this.setVisible(false);
        }
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_SignInNowMouseClicked

    private void SubmitRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitRegisterMouseClicked
        if (!this.validateLogin()) {
            User u = new User();
            u.setEmail(RegisterUsername.getText());
            u.setPassword(RegisterPassword.getText());
            if (_usr.login(u).getEmail() != null) {
                JOptionPane.showConfirmDialog(null,
                        "Đăng nhập thành công!", "Login", JOptionPane.DEFAULT_OPTION);
                this.setVisible(false);
                new MainJframe(u).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SubmitRegisterMouseClicked

    public boolean validateLogin() {
        StringBuilder errorText = new StringBuilder();

        if (RegisterUsername.getText().length() == 0) {
            errorText.append("Vui lòng nhập tên đăng nhập!\n");
            RegisterUsername.setBackground(Color.ORANGE);
        }

        if (RegisterPassword.getText().length() == 0) {
            errorText.append("Vui lòng nhập mật khẩu!\n");
            RegisterPassword.setBackground(Color.ORANGE);
        }
        if (RegisterPassword.getText().length() != 0 && RegisterPasswordConfirm.getText().length() == 0) {
            errorText.append("Vui lòng xác nhận mật khẩu!\n");
            RegisterPasswordConfirm.setBackground(Color.ORANGE);
        }
        if ((RegisterPasswordConfirm.getText().length() != 0 && RegisterUsername.getText().length() != 0) && RegisterPasswordConfirm.getText() != RegisterPassword.getText()) {
            errorText.append("Mật khẩu không trùng khớp!\n");
        }
        if (errorText.length() == 0) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, errorText, "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPasswordConfirmRegister;
    private javax.swing.JLabel LabelPasswordRegister;
    private javax.swing.JLabel LabelUsernameRegister;
    private javax.swing.JPasswordField RegisterPassword;
    private javax.swing.JPasswordField RegisterPasswordConfirm;
    private javax.swing.JTextField RegisterUsername;
    private javax.swing.JLabel SignInNow;
    private javax.swing.JButton SubmitRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
