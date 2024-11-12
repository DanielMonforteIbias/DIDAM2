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
    public void mouseClicked(MouseEvent me) { //Al hacer clic
        JLabel label=(JLabel)me.getSource(); //Obtenemos el label que ha producido el evento
        Pelicula peliculaSeleccionada=new Pelicula(); //Creamos un objeto película
        for(Pelicula p:LogicaNegocio.getListaPeliculas()){ //Recorremos la lista de películas para buscar la seleccionada
            if(p.getTitulo().equals(label.getName())){ //Si los títulos coinciden
                peliculaSeleccionada=p; //Guardamos la película
            }
        }
        String mensaje="Título: "+peliculaSeleccionada.getTitulo()+"\nPrecio: "+peliculaSeleccionada.getPrecio()+"\nPG: "+peliculaSeleccionada.getPg()+"\nGénero: "+peliculaSeleccionada.getGenero(); //Creamoe el mensaje con información de la película
        JOptionPane.showMessageDialog(label,mensaje, peliculaSeleccionada.getTitulo(),JOptionPane.INFORMATION_MESSAGE); //Sacamos el mensaje
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //Implementado porque es necesario al implementar la interfaz, pero no hace nada
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //Implementado porque es necesario al implementar la interfaz, pero no hace nada
    }

    @Override
    public void mouseEntered(MouseEvent me) { //Al entrar en el componente con el ratón
        JLabel label=(JLabel)me.getSource(); //Obtenemos el label que ha producido el evento
        label.setBorder(new LineBorder(Color.yellow)); //Cambiamos el borde a amarillo
    }

    @Override
    public void mouseExited(MouseEvent me) { //Al salir del componente con el ratón
        JLabel label=(JLabel)me.getSource(); //Obtenemos el label que ha producido el evento
        label.setBorder(null); //Quitamos el borde
    }
    
}
