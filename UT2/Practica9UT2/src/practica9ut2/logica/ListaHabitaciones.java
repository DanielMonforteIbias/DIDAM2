/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9ut2.logica;

import java.util.ArrayList;
import java.util.List;
import practica9ut2.beans.Habitacion;

/**
 *
 * @author Tarde
 */
public class ListaHabitaciones {
    private static List<Habitacion>habitaciones=new ArrayList<Habitacion>();

    public static List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public static void inicializarLista(){
        habitaciones.add(new Habitacion(1,"Simple","Ocupada"));
        habitaciones.add(new Habitacion(2,"Suite","Disponible"));
        habitaciones.add(new Habitacion(3,"Simple","Ocupada"));
        habitaciones.add(new Habitacion(4,"Doble","Disponible"));
        habitaciones.add(new Habitacion(5,"Doble","Ocupada"));
    }
}
