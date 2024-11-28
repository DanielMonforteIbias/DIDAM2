/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import examen.gui.Login;
import java.util.Locale;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Tarde
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("es","ES"));//Establecemos el idioma
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistSilverSkin"); //Le damos el Look and Feel
        Login login=new Login(); //Creamos una pantalla de Login
        login.setVisible(true); //La hacemos visible
    }
}
