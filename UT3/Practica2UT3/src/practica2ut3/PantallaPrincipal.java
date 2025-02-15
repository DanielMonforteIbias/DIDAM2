/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ut3;

import java.util.Locale;
import javax.swing.JOptionPane;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Tarde
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        jButtonAceitar.setEnabled(false);
        ValidationGroup group=validationPanel.getValidationGroup();
        group.add(jTextFieldNome,StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldCodigoPostal,StringValidators.minLength(5));
        group.add(jTextFieldCodigoPostal,StringValidators.maxLength(5));
        group.add(jTextFieldCodigoPostal,StringValidators.REQUIRE_VALID_INTEGER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAceitar = new javax.swing.JButton();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCodigoPostal = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelCodigoPostal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 300));
        setPreferredSize(new java.awt.Dimension(410, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(410, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAceitar.setText("Aceitar");
        jButtonAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceitarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 90, -1));

        validationPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                validationPanelStateChanged(evt);
            }
        });
        getContentPane().add(validationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 11, 410, 62));

        jTextFieldNome.setName("Nome"); // NOI18N
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 84, 201, -1));

        jTextFieldCodigoPostal.setName("Código postal"); // NOI18N
        getContentPane().add(jTextFieldCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 154, 201, -1));

        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 87, -1, -1));

        jLabelCodigoPostal.setText("Código postal:");
        getContentPane().add(jLabelCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 157, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceitarActionPerformed
        JOptionPane.showMessageDialog(this,"Forma correta");
    }//GEN-LAST:event_jButtonAceitarActionPerformed

    private void validationPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_validationPanelStateChanged
        if (validationPanel.getProblem()==null) jButtonAceitar.setEnabled(true);
        else jButtonAceitar.setEnabled(false);
    }//GEN-LAST:event_validationPanelStateChanged

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale.setDefault(new Locale("pt","PT"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceitar;
    private javax.swing.JLabel jLabelCodigoPostal;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JTextField jTextFieldCodigoPostal;
    private javax.swing.JTextField jTextFieldNome;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
