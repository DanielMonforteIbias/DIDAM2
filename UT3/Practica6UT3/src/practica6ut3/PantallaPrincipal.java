/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6ut3;

import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Tarde
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    AudioClip sound=java.applet.Applet.newAudioClip(getClass().getResource("/practica6ut3/sounds/Meow.wav"));
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/practica6ut3/imgs/Animals.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelEnunciado = new javax.swing.JLabel();
        jRadioButtonDog = new javax.swing.JRadioButton();
        jRadioButtonCat = new javax.swing.JRadioButton();
        jRadioButtonParrot = new javax.swing.JRadioButton();
        jRadioButtonWhale = new javax.swing.JRadioButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonCorrect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("ENGLISH EXAM");
        jPanel.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, -1, -1));

        jLabelEnunciado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEnunciado.setText("Listen to the following sound and indicate what type of animal it is");
        jPanel.add(jLabelEnunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));

        buttonGroup1.add(jRadioButtonDog);
        jRadioButtonDog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonDog.setText("Dog");
        jPanel.add(jRadioButtonDog, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, -1, -1));

        buttonGroup1.add(jRadioButtonCat);
        jRadioButtonCat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonCat.setText("Cat");
        jPanel.add(jRadioButtonCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 135, -1, -1));

        buttonGroup1.add(jRadioButtonParrot);
        jRadioButtonParrot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonParrot.setText("Parrot");
        jPanel.add(jRadioButtonParrot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, -1, -1));

        buttonGroup1.add(jRadioButtonWhale);
        jRadioButtonWhale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButtonWhale.setText("Whale");
        jPanel.add(jRadioButtonWhale, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButtonPlay.setBackground(new java.awt.Color(51, 153, 255));
        jButtonPlay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPlay.setText("Play");
        jButtonPlay.setActionCommand("");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });
        jPanel.add(jButtonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jButtonStop.setBackground(new java.awt.Color(255, 102, 102));
        jButtonStop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });
        jPanel.add(jButtonStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jButtonCorrect.setBackground(new java.awt.Color(0, 255, 0));
        jButtonCorrect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCorrect.setText("Correct");
        jButtonCorrect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCorrectActionPerformed(evt);
            }
        });
        jPanel.add(jButtonCorrect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica6ut3/imgs/Animals.png"))); // NOI18N
        jPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCorrectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCorrectActionPerformed
        if(jRadioButtonCat.isSelected()) JOptionPane.showMessageDialog(this,"Correct! The answer was Cat","Correct!",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(this,"Incorrect! The answer was Cat","Incorrect!",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonCorrectActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        sound.loop();
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        sound.stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

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
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCorrect;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEnunciado;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JRadioButton jRadioButtonCat;
    private javax.swing.JRadioButton jRadioButtonDog;
    private javax.swing.JRadioButton jRadioButtonParrot;
    private javax.swing.JRadioButton jRadioButtonWhale;
    // End of variables declaration//GEN-END:variables
}
