/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tarde
 */
public class JPanelImagen extends JPanel implements Serializable{
    private ImagenFondo imagenFondo;
    public JPanelImagen(){

    }

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (imagenFondo!=null){
            if(imagenFondo.getRutaImagen()!=null && imagenFondo.getRutaImagen().exists()){
            ImageIcon imagen=new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());
            BufferedImage imagenSaturada=saturarImagen(toBufferedImage(imagen.getImage()), imagenFondo.getSaturacion());
            imagen=new ImageIcon(imagenSaturada);
            Graphics2D g2d=(Graphics2D)grphcs;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagenFondo.getOpacidad()));
            grphcs.drawImage(imagen.getImage(), 0,0, this);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }  
        }
        
    }  
    
    public static BufferedImage saturarImagen(BufferedImage image, float saturacion) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                float[] hsb = Color.RGBtoHSB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF, null);
                hsb[1]*=saturacion;
                if(hsb[1]>1) hsb[1]=1;
                newImage.setRGB(x, y, Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
            }
        }
        return newImage;
    }
    
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) return (BufferedImage) img;
        BufferedImage bimage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }
}
