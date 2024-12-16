/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut6_actividad2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Tarde
 */
public class JuegoPanel extends JPanel implements ActionListener{
    private Timer timer;
    private int x,y,velX,velY;
    private int characterWidth, characterHeight;
    private ImageIcon personaje=new ImageIcon(new File("src/imgs/nave.png").getAbsolutePath());
    private ImageIcon fondo=new ImageIcon(new File("src/imgs/background.png").getAbsolutePath());
    public JuegoPanel(){
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new TAdapter());
        x=50;
        y=50;
        velX=0;
        velY=0;
        characterWidth=personaje.getIconWidth();
        characterHeight=personaje.getIconHeight();
        timer=new Timer(10,this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo.getImage(),0,0,null);
        //g.setColor(Color.red);
        //g.fillRect(x,y,characterWidth,characterHeight);
        g.drawImage(personaje.getImage(),x,y,null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        mover();
        repaint();
    }
    private void mover(){
        x+=velX;
        y+=velY;
        if(x<0)x=0;
        if(y<0)y=0;
        if(y+characterHeight>this.getHeight())y=this.getHeight()-characterHeight;
        if(x+characterWidth>this.getWidth())x=this.getWidth()-characterWidth;
    }
    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            if(key==KeyEvent.VK_LEFT || key==KeyEvent.VK_A)velX=-2;
            if(key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_D)velX=2;
            if(key==KeyEvent.VK_DOWN || key==KeyEvent.VK_S)velY=2;
            if(key==KeyEvent.VK_UP || key==KeyEvent.VK_W)velY=-2;
        
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            if(key==KeyEvent.VK_LEFT || key==KeyEvent.VK_A || key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_D)velX=0;
            if(key==KeyEvent.VK_DOWN || key==KeyEvent.VK_S || key==KeyEvent.VK_UP || key==KeyEvent.VK_W)velY=0;
        }
    
    }
}
