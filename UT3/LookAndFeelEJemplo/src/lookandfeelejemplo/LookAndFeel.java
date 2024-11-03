/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lookandfeelejemplo;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Usuario
 */
public class LookAndFeel {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Sking"); //Aunque tengan un $1 en el nombre no se añade aqui
        Ventana v=new Ventana();
        v.setVisible(true);
    }
}
