/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut4;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import practica1ut4.gui.InicioSesion;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.FindingNemoSkin");
        InicioSesion inicioSesion=new InicioSesion();
        inicioSesion.setVisible(true);
    }
}
