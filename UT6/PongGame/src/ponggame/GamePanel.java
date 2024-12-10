/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danim2205
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
    private final int WIDTH=800, HEIGHT=600;
    public static int puntosJ1,puntosJ2;
    private Thread gameThread;
    private boolean running;
    private final Ball ball;
    private final Paddle player1;
    private final Paddle player2;
    
    private File rutaFondo=new File("src/imgs/Background.png");
    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        ball=new Ball(WIDTH/2,HEIGHT/2,20,20);
        player1=new Paddle(10,HEIGHT/2-60,10,120);
        player2=new Paddle(WIDTH-20,HEIGHT/2-60,10,120);
        startGame();
    }
    
    private void startGame(){
        running=true;
        gameThread=new Thread(this);
        gameThread.start();
    }
    
    
    @Override
    public void run() {
        while(running){
            update();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update(){
        ball.move();
        ball.checkCollision(player1,player2,WIDTH,HEIGHT);
        player1.move(HEIGHT);
        player2.move(HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Importante dibujar el fondo antes que el resto
        ImageIcon background=new ImageIcon(rutaFondo.getAbsolutePath());
        g.drawImage(background.getImage(),0,0,null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30)); 
        g.drawString(puntosJ1+"", WIDTH/2-50,25);
        g.drawString(puntosJ2+"", WIDTH/2+50,25);
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_W)player1.setDirection(-1);
        if(key==KeyEvent.VK_S)player1.setDirection(1);
        if(key==KeyEvent.VK_UP)player2.setDirection(-1);
        if(key==KeyEvent.VK_DOWN)player2.setDirection(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_W || key==KeyEvent.VK_S)player1.setDirection(0);
        if(key==KeyEvent.VK_UP || key==KeyEvent.VK_DOWN)player2.setDirection(0);
    }
}
