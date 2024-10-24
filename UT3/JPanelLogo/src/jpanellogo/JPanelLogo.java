/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanellogo;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tarde
 */
public class JPanelLogo extends JPanel implements Serializable{
    private Image logo=new ImageIcon(getClass().getResource("/jpanellogo/imgs/Logo.png")).getImage();
    public JPanelLogo(){
        
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(logo, 0,0, this);
    }
}
