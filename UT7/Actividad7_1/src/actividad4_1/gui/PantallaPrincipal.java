/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4_1.gui;

import actividad4_1.logica.Compra;
import actividad4_1.logica.ListaCompras;
import actividad4_1.logica.LogicaNegocio;
import actividad4_1.logica.MiMouseListener;
import actividad4_1.logica.Pelicula;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danim2205
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    AudioClip sound=java.applet.Applet.newAudioClip(getClass().getResource("/actividad4_1/sounds/Money.wav")); //Sonido inicializado por defecto
    private List<Pelicula>peliculas=LogicaNegocio.getListaPeliculas(); //Lista de películas
    private Pelicula peliculaActual; //Objeto para guardar la película actual
    private int asientos[]=new int[0]; //Array de asientos
    private int sala=0; //Número de sala
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/actividad4_1/imgs/Logo.png")).getImage()); //Icono de la aplicacion
        jLabelUsuario.setText(InicioSesion.getUsuario()); //Ponemos el usuario de la pantalla de inicio de sesión en el label de usuario
        jPopupMenuUsuario.add(jLabelUsuario); //Añadimos el label de usuario al menú de popUp
        jPopupMenuUsuario.add(jButtonCerrar); //Añadimos un botón de cerrar sesión al menú de popUp
        establecerColoresJOptionPane();
        ((DefaultEditor) jSpinnerNumeroAsientos.getEditor()).getTextField().setEditable(false); //Hacemos que el spinner de número de asientos no sea editable a mano
        LogicaNegocio.crearPeliculas(); //Creamos las películas por defecto 
        añadirListenersCartelera(); //Añadimos los listeners a todos los labels
        actualizarPeliculaActual(); //Ponemos los valores iniciales
        ListaCompras.setCompras(new ArrayList<Compra>()); //Vaciamos la lista para no ver las compras de otros clientes
        refrescarTabla(); //Refrescamos la tabla por primera vez para que se vea bien
        ayuda();
    }
    private void ayuda(){
        try {
            File file=new File("help"+File.separator+"help_set.hs"); //Obtenemos el fichero helpset
            URL hsUrl=file.toURI().toURL();
            HelpSet helpSet=new HelpSet(getClass().getClassLoader(),hsUrl);
            HelpBroker helpBroker=helpSet.createHelpBroker();
            //Ponemos la ayuda en el F1
            helpBroker.enableHelpKey(getRootPane(),"introduccion",helpSet);
            helpBroker.enableHelpKey(jButtonIntroduccion,"introduccion",helpSet);
            helpBroker.enableHelpKey(jButtonInicioSesion,"inicio_sesion",helpSet);
            helpBroker.enableHelpKey(jButtonComprarEntradas,"comprar_entrada",helpSet);
            helpBroker.enableHelpKey(jButtonVerCartelera,"ver_cartelera",helpSet);
            helpBroker.enableHelpKey(jButtonMisCompras,"mis_compras",helpSet);
            helpBroker.enableHelpKey(jButtonAcercaDe,"acercade",helpSet);
            //Ponemos cada ayuda en su boton
            helpBroker.enableHelpOnButton(jButtonIntroduccion,"introduccion",helpSet);
            helpBroker.enableHelpOnButton(jButtonInicioSesion,"inicio_sesion",helpSet);
            helpBroker.enableHelpOnButton(jButtonComprarEntradas,"comprar_entrada",helpSet);
            helpBroker.enableHelpOnButton(jButtonVerCartelera,"ver_cartelera",helpSet);
            helpBroker.enableHelpOnButton(jButtonMisCompras,"mis_compras",helpSet);
            helpBroker.enableHelpOnButton(jButtonAcercaDe,"acercade",helpSet);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HelpSetException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void refrescarTabla(){
        DefaultTableModel dtm=new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //Hacemos que las celdas no sean editables al hacer doble clic sobre ellas
        }
        };
        dtm.setColumnIdentifiers(new String[]{"Película","Num Asientos","Asientos","Sala","Precio"}); //Ponemos nombre a la columna
        ArrayList<Compra>listaCompras=ListaCompras.getCompras(); //Obtenemos el ArrayList de compras
        for(Compra c:listaCompras){ //Para cada compra de la lista
            String[]fila=new String[5]; //Creamos un Array de Strings de longitud 5
            fila[0]=c.getPelicula(); //Guardamos el título en la primera fila
            fila[1]=c.getNumeroAsientos()+""; //Guardamos el número de asientos en la segunda fila
            fila[2]=c.getAsientos(); //Guardamos los asientos en la tercera fila
            fila[3]="Sala "+c.getSala(); //Guardamos la sala en la cuarta fila
            fila[4]=c.getPrecio()+"€"; //Guardamos el precio en la quinta fila
            dtm.addRow(fila); //Añadimos el array a la tabla
        }
        jTableMisCompras.setModel(dtm); //Establecemos el modelo creado como el de la tabla
        
        jScrollPane1.getViewport().setBackground(new Color(0xFFFFFF)); //Establecemos el color de fondo del jScrollPane que contiene la tabla
        
        //Apartado visual de la tabla
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.BLACK); //Cambiamos el fondo del header
        headerRenderer.setForeground(Color.WHITE); //Cambiamos el color de fuente del header
        headerRenderer.setHorizontalAlignment(JLabel.CENTER); //Centramos el texto del header
        for (int i = 0; i < jTableMisCompras.getModel().getColumnCount(); i++) { //Para cada columna
            jTableMisCompras.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer); //Establecemos el header al que hemos creado
        }
    }
    private void establecerColoresJOptionPane(){
        UIManager UI=new UIManager();
        UIManager.put("control", Color.WHITE); //Cambia todos los fondos del JOptionPane
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuUsuario = new javax.swing.JPopupMenu();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelComprarEntrada = new javax.swing.JPanel();
        jPanelDatos = new javax.swing.JPanel();
        jLabelPrecio = new javax.swing.JLabel();
        jComboBoxPelicula = new javax.swing.JComboBox<>();
        jLabelPelicula = new javax.swing.JLabel();
        jLabelNumeroAsientos = new javax.swing.JLabel();
        jSpinnerNumeroAsientos = new javax.swing.JSpinner();
        jCheckBoxPrimeraFila = new javax.swing.JCheckBox();
        jButtonGenerarAsientos = new javax.swing.JButton();
        jPanelDatos1 = new javax.swing.JPanel();
        jLabelAsientos = new javax.swing.JLabel();
        jButtonConfirmarCompra = new javax.swing.JButton();
        jLabelSala = new javax.swing.JLabel();
        jLabelPeliculaActual = new javax.swing.JLabel();
        jPanelLogoCineRibera = new jpanellogocineribera.JPanelLogoCineRibera();
        jButtonUsuario = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        jPanelVerCartelera = new javax.swing.JPanel();
        jPanelPeliculas = new javax.swing.JPanel();
        jLabelTitanic = new javax.swing.JLabel();
        jLabelMillionDollarBaby = new javax.swing.JLabel();
        jLabelMinions = new javax.swing.JLabel();
        jLabelTheBoogeyman = new javax.swing.JLabel();
        jLabelJurassicPark = new javax.swing.JLabel();
        jLabelInsidious3 = new javax.swing.JLabel();
        jLabelCastilloAmbulante = new javax.swing.JLabel();
        jLabelElPadrino = new javax.swing.JLabel();
        jPanelMisCompras = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMisCompras = new javax.swing.JTable();
        jPanelAyuda = new javax.swing.JPanel();
        jPanelBotonesAyuda = new javax.swing.JPanel();
        jButtonIntroduccion = new javax.swing.JButton();
        jButtonInicioSesion = new javax.swing.JButton();
        jButtonComprarEntradas = new javax.swing.JButton();
        jButtonVerCartelera = new javax.swing.JButton();
        jButtonMisCompras = new javax.swing.JButton();
        jButtonAcercaDe = new javax.swing.JButton();

        jPopupMenuUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPopupMenuUsuario.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N

        jPanelComprarEntrada.setBackground(new java.awt.Color(255, 255, 255));
        jPanelComprarEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Configure su compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell", 1, 18))); // NOI18N
        jPanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPrecio.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabelPrecio.setText("Precio: ");
        jPanelDatos.add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jComboBoxPelicula.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jComboBoxPelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titanic", "Million Dollar Baby", "Los Minions", "The Boogeyman", "Jurassic Park", "Insidious 3", "El Castillo Ambulante", "El Padrino" }));
        jComboBoxPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeliculaActionPerformed(evt);
            }
        });
        jPanelDatos.add(jComboBoxPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 45, -1, -1));

        jLabelPelicula.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabelPelicula.setText("Película a ver:");
        jPanelDatos.add(jLabelPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 47, -1, -1));

        jLabelNumeroAsientos.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabelNumeroAsientos.setText("Número de asientos:");
        jPanelDatos.add(jLabelNumeroAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 108, -1, -1));

        jSpinnerNumeroAsientos.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jSpinnerNumeroAsientos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        jSpinnerNumeroAsientos.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinnerNumeroAsientos, ""));
        jSpinnerNumeroAsientos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerNumeroAsientosStateChanged(evt);
            }
        });
        jPanelDatos.add(jSpinnerNumeroAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 105, 60, -1));

        jCheckBoxPrimeraFila.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxPrimeraFila.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jCheckBoxPrimeraFila.setText("Asientos en primera fila");
        jPanelDatos.add(jCheckBoxPrimeraFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        jButtonGenerarAsientos.setBackground(new java.awt.Color(0, 0, 0));
        jButtonGenerarAsientos.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButtonGenerarAsientos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGenerarAsientos.setText("GENERAR ASIENTOS");
        jButtonGenerarAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarAsientosActionPerformed(evt);
            }
        });
        jPanelDatos.add(jButtonGenerarAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 360, -1));

        jPanelComprarEntrada.add(jPanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 520, 310));

        jPanelDatos1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatos1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Confirmar compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell", 1, 18))); // NOI18N
        jPanelDatos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAsientos.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabelAsientos.setText("ASIENTOS: ");
        jPanelDatos1.add(jLabelAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButtonConfirmarCompra.setBackground(new java.awt.Color(0, 0, 0));
        jButtonConfirmarCompra.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButtonConfirmarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmarCompra.setText("CONFIRMAR COMPRA");
        jButtonConfirmarCompra.setEnabled(false);
        jButtonConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarCompraActionPerformed(evt);
            }
        });
        jPanelDatos1.add(jButtonConfirmarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 360, -1));

        jLabelSala.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabelSala.setText("SALA: ");
        jPanelDatos1.add(jLabelSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jLabelSala.getAccessibleContext().setAccessibleName("SALA:");

        jPanelComprarEntrada.add(jPanelDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 520, 160));

        jLabelPeliculaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Titanic.png"))); // NOI18N
        jPanelComprarEntrada.add(jLabelPeliculaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));
        jPanelComprarEntrada.add(jPanelLogoCineRibera, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jButtonUsuario.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButtonUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Usuario.png"))); // NOI18N
        jButtonUsuario.setContentAreaFilled(false);
        jButtonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarioActionPerformed(evt);
            }
        });
        jPanelComprarEntrada.add(jButtonUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 40, 40));

        jLabelUsuario.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabelUsuario.setText("Usuario");
        jPanelComprarEntrada.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, -1));

        jButtonCerrar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCerrar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButtonCerrar.setText("Cerrar sesión");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanelComprarEntrada.add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, -1));

        jTabbedPane.addTab("Comprar entrada", jPanelComprarEntrada);

        jPanelVerCartelera.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVerCartelera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPeliculas.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanelPeliculas.setLayout(new java.awt.GridLayout(2, 4));

        jLabelTitanic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Titanic.png"))); // NOI18N
        jLabelTitanic.setName("Titanic"); // NOI18N
        jPanelPeliculas.add(jLabelTitanic);

        jLabelMillionDollarBaby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Million Dollar Baby.png"))); // NOI18N
        jLabelMillionDollarBaby.setName("Million Dollar Baby"); // NOI18N
        jPanelPeliculas.add(jLabelMillionDollarBaby);

        jLabelMinions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Los Minions.png"))); // NOI18N
        jLabelMinions.setName("Los Minions"); // NOI18N
        jPanelPeliculas.add(jLabelMinions);

        jLabelTheBoogeyman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/The Boogeyman.png"))); // NOI18N
        jLabelTheBoogeyman.setName("The Boogeyman"); // NOI18N
        jPanelPeliculas.add(jLabelTheBoogeyman);

        jLabelJurassicPark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Jurassic Park.png"))); // NOI18N
        jLabelJurassicPark.setName("Jurassic Park"); // NOI18N
        jPanelPeliculas.add(jLabelJurassicPark);

        jLabelInsidious3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/Insidious 3.png"))); // NOI18N
        jLabelInsidious3.setName("Insidious 3"); // NOI18N
        jPanelPeliculas.add(jLabelInsidious3);

        jLabelCastilloAmbulante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/El Castillo Ambulante.png"))); // NOI18N
        jLabelCastilloAmbulante.setName("El Castillo Ambulante"); // NOI18N
        jPanelPeliculas.add(jLabelCastilloAmbulante);

        jLabelElPadrino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividad4_1/imgs/El Padrino.png"))); // NOI18N
        jLabelElPadrino.setName("El Padrino"); // NOI18N
        jPanelPeliculas.add(jLabelElPadrino);

        jPanelVerCartelera.add(jPanelPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, -1, -1));

        jTabbedPane.addTab("Ver cartelera", jPanelVerCartelera);

        jPanelMisCompras.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMisCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMisCompras.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTableMisCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Película", "Num. Asientos", "Asientos", "Sala", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTableMisCompras);

        jPanelMisCompras.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 620));

        jTabbedPane.addTab("Mis compras", jPanelMisCompras);

        jPanelAyuda.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAyuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBotonesAyuda.setOpaque(false);
        jPanelBotonesAyuda.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        jButtonIntroduccion.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonIntroduccion.setText("Introduccion");
        jPanelBotonesAyuda.add(jButtonIntroduccion);

        jButtonInicioSesion.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonInicioSesion.setText("Inicio sesion");
        jPanelBotonesAyuda.add(jButtonInicioSesion);

        jButtonComprarEntradas.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonComprarEntradas.setText("Comprar entradas");
        jPanelBotonesAyuda.add(jButtonComprarEntradas);

        jButtonVerCartelera.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonVerCartelera.setText("Ver cartelera");
        jPanelBotonesAyuda.add(jButtonVerCartelera);

        jButtonMisCompras.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonMisCompras.setText("Mis compras");
        jPanelBotonesAyuda.add(jButtonMisCompras);

        jButtonAcercaDe.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jButtonAcercaDe.setText("Acerca de");
        jPanelBotonesAyuda.add(jButtonAcercaDe);

        jPanelAyuda.add(jPanelBotonesAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 440, 300));

        jTabbedPane.addTab("Ayuda", jPanelAyuda);

        getContentPane().add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));
        jTabbedPane.getAccessibleContext().setAccessibleName("Comprar entrada");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeliculaActionPerformed
        actualizarPeliculaActual(); //Actualizamos la película actual al elegir una nueva en el comboBox
    }//GEN-LAST:event_jComboBoxPeliculaActionPerformed

    private void jSpinnerNumeroAsientosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerNumeroAsientosStateChanged
        actualizarPeliculaActual(); //Actualizamos la película actual al modificar el número de asientos, para desactivar las opciones de compra con los parámetros anteriores ya que han cambiado
    }//GEN-LAST:event_jSpinnerNumeroAsientosStateChanged

    private void jButtonGenerarAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarAsientosActionPerformed
        jLabelAsientos.setText("ASIENTOS:"); //Inicializamos el texto a "ASIENTOS:" para que no se acumulen al darle varias veces
        jLabelSala.setText("SALA:"); //Inicializamos el texto a "SALA:" para que no se acumule al darle varias veces
        int numeroAsientos=(int)jSpinnerNumeroAsientos.getValue(); //Obtenemos el número de asientos
        asientos=new int[numeroAsientos]; //El array de asientos tendrá el tamaño del numero de asientos
        sala=jComboBoxPelicula.getSelectedIndex()+1; //La sala se decide por el índice del comboBox de película, sumando 1 ya que empieza en 0
        int i=0, asientoMaximo=0, asientoMinimo=0;
        if(jCheckBoxPrimeraFila.isSelected()){ //Si los asientos se quieren en primera fila
            asientoMaximo=10; //El máximo será 10
            asientoMinimo=1; //El mínimo será 1
        }
        else{ //Si no están en primera fila
            asientoMaximo=60; //El máximo será 60
            asientoMinimo=11; //El mínimo será 11
        }
        do{ //Generamos los asientos
            int aleatorio=generarNumeroAleatorio(asientoMinimo, asientoMaximo); //Generamos un asiento aleatorio
            boolean ocupado=false;
            for(int j=0;j<asientos.length;j++){ //Comprobamos si ya se ha incluido en esta compra
                if(asientos[j]==aleatorio) ocupado=true; //Si ya se ha incluido, no lo ponemos de nuevo
            }
            if(!ocupado){ //Si no se había incluido en la compra
                asientos[i]=aleatorio; //Lo incluimos
                i++;
            }
        }while(i<numeroAsientos);
        for(int j=0;j<asientos.length;j++){ //Actualizamos el label de asientos con los generados
            jLabelAsientos.setText(jLabelAsientos.getText()+"  "+asientos[j]);
        }
        jLabelSala.setText(jLabelSala.getText()+" "+sala); //Actualizamos el label de sale
        jButtonConfirmarCompra.setEnabled(true); //Activamos el botón de confirmar compra
        
    }//GEN-LAST:event_jButtonGenerarAsientosActionPerformed

    private void jButtonConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarCompraActionPerformed
        String mensaje="Compra de "+asientos.length+" asientos para ver "+peliculaActual.getTitulo()+".\nAsientos: "+Arrays.toString(asientos)+".\nSala "+sala; //Generamos el mensaje
        sound.play(); //Reproducimos el sonido de compra
        JOptionPane.showMessageDialog(this,mensaje,"Compra realizada",JOptionPane.INFORMATION_MESSAGE); //Mostramos el mensaje
        Compra c=new Compra(peliculaActual.getTitulo(),(int)jSpinnerNumeroAsientos.getValue(),Arrays.toString(asientos),sala,peliculaActual.getPrecio()*(int)jSpinnerNumeroAsientos.getValue()); //Creamos una compra con los detalles
        ListaCompras.anadirCompra(c);//La añadimos a la lista de compras
        refrescarTabla(); //Refrescamos la tabla para añadir la compra nueva
        limpiarCampos(); //Reseteamos los campos por defecto para una nueva compra
    }//GEN-LAST:event_jButtonConfirmarCompraActionPerformed

    private void jButtonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarioActionPerformed
        jPopupMenuUsuario.show(jButtonUsuario, -57, jButtonUsuario.getHeight()); //Al pulsar el icono de usuario, se muestra un popUp con el nombre y la opción de cerrar sesión
    }//GEN-LAST:event_jButtonUsuarioActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        InicioSesion inicioSesion=new InicioSesion(); //Al cerrar sesión se vuelve a la pantalla de inicio de sesión
        inicioSesion.setVisible(true);
        dispose(); //Se destruye esta pantalla
    }//GEN-LAST:event_jButtonCerrarActionPerformed

     private int generarNumeroAleatorio(int min, int max){
        Random random = new Random(); //Creamos un objeto de la clase random
        int number = random.nextInt((max-min) + 1) + min; //Generamos el número aleatorio
        return number; //Lo devolvemos
    }
     
    public void actualizarPeliculaActual(){
        jButtonConfirmarCompra.setEnabled(false); //Desactivamos el botón de compra, pues los detalles de la compra han cambiado y hay que generar asientos de nuevo
        jLabelAsientos.setText("ASIENTOS:"); //Reseteamos el label de asientos
        jLabelSala.setText("SALA:"); //Reseteamos el label de sala
        for(Pelicula p:peliculas){ //Recorremos la lista de peliculas para encontrar el objeto que corresponde con el index elegido en el combobox
            if(p.getTitulo().equals(jComboBoxPelicula.getSelectedItem())){ //Si los titulos coinciden
                peliculaActual=p; //Guardamos la pelicula actual
                jLabelPrecio.setText("Precio: "+peliculaActual.getPrecio()*(int)jSpinnerNumeroAsientos.getValue()+"€"); //Calculamos el precio
            }
        }
        jLabelPeliculaActual.setIcon(new ImageIcon(getClass().getResource("/actividad4_1/imgs/"+peliculaActual.getTitulo()+".png"))); //Actualizamos la imagen de la derecha
    }
    public void limpiarCampos(){
        //Restablecemos todos los campos a su valor por defecto
        jLabelAsientos.setText("ASIENTOS:");
        jLabelSala.setText("SALA:");
        jLabelPrecio.setText("Total: 0.0€");
        jComboBoxPelicula.setSelectedIndex(0);
        jSpinnerNumeroAsientos.setValue(1);
        jCheckBoxPrimeraFila.setSelected(false);
    }
    public void añadirListenersCartelera(){
        //Añadimos a todas las imágenes de la cartelera el Listener que hemos creado
        jLabelTitanic.addMouseListener(new MiMouseListener());
        jLabelMillionDollarBaby.addMouseListener(new MiMouseListener());
        jLabelTheBoogeyman.addMouseListener(new MiMouseListener());
        jLabelCastilloAmbulante.addMouseListener(new MiMouseListener());
        jLabelElPadrino.addMouseListener(new MiMouseListener());
        jLabelInsidious3.addMouseListener(new MiMouseListener());
        jLabelMinions.addMouseListener(new MiMouseListener());
        jLabelJurassicPark.addMouseListener(new MiMouseListener());
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
    private javax.swing.JButton jButtonAcercaDe;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonComprarEntradas;
    private javax.swing.JButton jButtonConfirmarCompra;
    private javax.swing.JButton jButtonGenerarAsientos;
    private javax.swing.JButton jButtonInicioSesion;
    private javax.swing.JButton jButtonIntroduccion;
    private javax.swing.JButton jButtonMisCompras;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JButton jButtonVerCartelera;
    private javax.swing.JCheckBox jCheckBoxPrimeraFila;
    private javax.swing.JComboBox<String> jComboBoxPelicula;
    private javax.swing.JLabel jLabelAsientos;
    private javax.swing.JLabel jLabelCastilloAmbulante;
    private javax.swing.JLabel jLabelElPadrino;
    private javax.swing.JLabel jLabelInsidious3;
    private javax.swing.JLabel jLabelJurassicPark;
    private javax.swing.JLabel jLabelMillionDollarBaby;
    private javax.swing.JLabel jLabelMinions;
    private javax.swing.JLabel jLabelNumeroAsientos;
    private javax.swing.JLabel jLabelPelicula;
    private javax.swing.JLabel jLabelPeliculaActual;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelSala;
    private javax.swing.JLabel jLabelTheBoogeyman;
    private javax.swing.JLabel jLabelTitanic;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelAyuda;
    private javax.swing.JPanel jPanelBotonesAyuda;
    private javax.swing.JPanel jPanelComprarEntrada;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelDatos1;
    private jpanellogocineribera.JPanelLogoCineRibera jPanelLogoCineRibera;
    private javax.swing.JPanel jPanelMisCompras;
    private javax.swing.JPanel jPanelPeliculas;
    private javax.swing.JPanel jPanelVerCartelera;
    private javax.swing.JPopupMenu jPopupMenuUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerNumeroAsientos;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableMisCompras;
    // End of variables declaration//GEN-END:variables
}
