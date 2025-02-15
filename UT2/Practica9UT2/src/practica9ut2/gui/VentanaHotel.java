/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9ut2.gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import practica9ut2.beans.Habitacion;
import practica9ut2.logica.ListaHabitaciones;

/**
 *
 * @author Usuario
 */
public class VentanaHotel extends javax.swing.JFrame {

    /**
     * Creates new form VentanaHotel
     */
    public VentanaHotel() {
        initComponents();
        ListaHabitaciones.inicializarLista();
    }
    
    private void actualizarTabla(){
        DefaultTableModel dtm=new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"Número habitación","Tipo habitación","Disponibilidad"});
        for (Habitacion h:ListaHabitaciones.getHabitaciones()){
            int random=(int)(Math.random()*2); //Generamos un numero aleatorio entre 0 y 1
            if (random==1) h.setDisponibilidad("Disponible");
            else h.setDisponibilidad("Ocupada");
            dtm.addRow(h.toArrayString());
        }
        jTableHabitaciones.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelRegistroHuespedes = new javax.swing.JPanel();
        jLabelNombreHuesped = new javax.swing.JLabel();
        jTextFieldNombreHuesped = new javax.swing.JTextField();
        jComboBoxTipoHabitacion = new javax.swing.JComboBox<>();
        jCheckBoxDesayunoIncluido = new javax.swing.JCheckBox();
        jButtonRegistrarHuesped = new javax.swing.JButton();
        jLabelInformacionIngreso = new javax.swing.JLabel();
        jButtonDetallesReserva = new javax.swing.JButton();
        jPanelDisponibilidadHabitaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHabitaciones = new javax.swing.JTable();
        jButtonActualizarDisponibilidad = new javax.swing.JButton();
        jButtonVerHabitacionesDisponibles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNombreHuesped.setText("Nombre del huésped:");

        jComboBoxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sencilla", "Doble", "Suite" }));

        jCheckBoxDesayunoIncluido.setText("Reserva con desayuno incluido");

        jButtonRegistrarHuesped.setText("Registrar huésped");
        jButtonRegistrarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarHuespedActionPerformed(evt);
            }
        });

        jLabelInformacionIngreso.setText("a");

        jButtonDetallesReserva.setText("Ver detalles de la reserva");
        jButtonDetallesReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetallesReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegistroHuespedesLayout = new javax.swing.GroupLayout(jPanelRegistroHuespedes);
        jPanelRegistroHuespedes.setLayout(jPanelRegistroHuespedesLayout);
        jPanelRegistroHuespedesLayout.setHorizontalGroup(
            jPanelRegistroHuespedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroHuespedesLayout.createSequentialGroup()
                .addGroup(jPanelRegistroHuespedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistroHuespedesLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabelNombreHuesped)
                        .addGap(51, 51, 51)
                        .addGroup(jPanelRegistroHuespedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRegistrarHuesped)
                            .addComponent(jCheckBoxDesayunoIncluido)
                            .addComponent(jComboBoxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDetallesReserva)))
                    .addGroup(jPanelRegistroHuespedesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelInformacionIngreso)))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanelRegistroHuespedesLayout.setVerticalGroup(
            jPanelRegistroHuespedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroHuespedesLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanelRegistroHuespedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreHuesped)
                    .addComponent(jTextFieldNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jComboBoxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jCheckBoxDesayunoIncluido)
                .addGap(65, 65, 65)
                .addComponent(jButtonRegistrarHuesped)
                .addGap(45, 45, 45)
                .addComponent(jButtonDetallesReserva)
                .addGap(30, 30, 30)
                .addComponent(jLabelInformacionIngreso)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Registro de huéspedes", jPanelRegistroHuespedes);

        jTableHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número habitación", "Tipo habitación", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableHabitaciones);

        jButtonActualizarDisponibilidad.setText("Actualizar disponibilidad de habitaciones");
        jButtonActualizarDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarDisponibilidadActionPerformed(evt);
            }
        });

        jButtonVerHabitacionesDisponibles.setText("Ver habitaciones disponibles");
        jButtonVerHabitacionesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerHabitacionesDisponiblesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisponibilidadHabitacionesLayout = new javax.swing.GroupLayout(jPanelDisponibilidadHabitaciones);
        jPanelDisponibilidadHabitaciones.setLayout(jPanelDisponibilidadHabitacionesLayout);
        jPanelDisponibilidadHabitacionesLayout.setHorizontalGroup(
            jPanelDisponibilidadHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(jPanelDisponibilidadHabitacionesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonActualizarDisponibilidad)
                .addGap(114, 114, 114)
                .addComponent(jButtonVerHabitacionesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDisponibilidadHabitacionesLayout.setVerticalGroup(
            jPanelDisponibilidadHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisponibilidadHabitacionesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanelDisponibilidadHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizarDisponibilidad)
                    .addComponent(jButtonVerHabitacionesDisponibles))
                .addGap(0, 74, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Disponibilidad de habitaciones", jPanelDisponibilidadHabitaciones);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelMainLayout.createSequentialGroup()
                    .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetallesReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetallesReservaActionPerformed
        String mensaje="";
        mensaje+="Huésped: "+jTextFieldNombreHuesped.getText();
        mensaje+=", en habitación "+jComboBoxTipoHabitacion.getSelectedItem().toString();
        if (jCheckBoxDesayunoIncluido.isSelected()) mensaje+=", con desayuno incluido";
        JOptionPane.showMessageDialog(this, mensaje,"Detalles reserva",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonDetallesReservaActionPerformed

    private void jButtonVerHabitacionesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerHabitacionesDisponiblesActionPerformed

        ListaHabitacionesDisponibles dialogo=new ListaHabitacionesDisponibles(this,false);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButtonVerHabitacionesDisponiblesActionPerformed

    private void jButtonRegistrarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarHuespedActionPerformed
        String mensaje="";
        mensaje+="Huésped "+jTextFieldNombreHuesped.getText();
        mensaje+=" registrado en habitación "+jComboBoxTipoHabitacion.getSelectedItem().toString();
        if (jCheckBoxDesayunoIncluido.isSelected()) mensaje+=" con desayuno incluido";
        jLabelInformacionIngreso.setText(mensaje);
    }//GEN-LAST:event_jButtonRegistrarHuespedActionPerformed

    private void jButtonActualizarDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarDisponibilidadActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButtonActualizarDisponibilidadActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarDisponibilidad;
    private javax.swing.JButton jButtonDetallesReserva;
    private javax.swing.JButton jButtonRegistrarHuesped;
    private javax.swing.JButton jButtonVerHabitacionesDisponibles;
    private javax.swing.JCheckBox jCheckBoxDesayunoIncluido;
    private javax.swing.JComboBox<String> jComboBoxTipoHabitacion;
    private javax.swing.JLabel jLabelInformacionIngreso;
    private javax.swing.JLabel jLabelNombreHuesped;
    private javax.swing.JPanel jPanelDisponibilidadHabitaciones;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelRegistroHuespedes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableHabitaciones;
    private javax.swing.JTextField jTextFieldNombreHuesped;
    // End of variables declaration//GEN-END:variables
}
