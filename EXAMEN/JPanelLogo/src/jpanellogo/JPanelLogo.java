/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanellogo;

/**
 *
 * @author Tarde
 */
public class JPanelLogo extends javax.swing.JPanel {

    /**
     * Creates new form JPanelLogo
     */
    public JPanelLogo() {
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

        jLabelNombre = new javax.swing.JLabel();
        jLabelLogo2 = new javax.swing.JLabel();
        jLabelLogo1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(139, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombre.setFont(new java.awt.Font("Consolas", 1, 60)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(139, 0, 0));
        jLabelNombre.setText("TEAM ROCKET");
        jLabelNombre.setOpaque(true);
        add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 15, -1, -1));

        jLabelLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LogoPequeno.png"))); // NOI18N
        jLabelLogo2.setToolTipText("");
        add(jLabelLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LogoPequeno.png"))); // NOI18N
        jLabelLogo1.setToolTipText("");
        add(jLabelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLogo1;
    private javax.swing.JLabel jLabelLogo2;
    private javax.swing.JLabel jLabelNombre;
    // End of variables declaration//GEN-END:variables
}
