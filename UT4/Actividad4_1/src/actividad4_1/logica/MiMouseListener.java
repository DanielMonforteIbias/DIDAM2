/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4_1.logica;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Danim2205
 */
public class MiMouseListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent me) {
        JLabel label=(JLabel)me.getSource();
        Pelicula peliculaSeleccionada=new Pelicula();
        for(Pelicula p:LogicaNegocio.getListaPeliculas()){
            if(p.getTitulo().equals(label.getName())){
                peliculaSeleccionada=p;
            }
        }
        String mensaje="Título: "+peliculaSeleccionada.getTitulo()+"\nPrecio: "+peliculaSeleccionada.getPrecio()+"\nPG: "+peliculaSeleccionada.getPg()+"\nGénero: "+peliculaSeleccionada.getGenero();
        JOptionPane.showMessageDialog(label,mensaje, peliculaSeleccionada.getTitulo(),JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        JLabel label=(JLabel)me.getSource();
        label.setBorder(new LineBorder(Color.yellow));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        JLabel label=(JLabel)me.getSource();
        label.setBorder(null);
    }
    
}
