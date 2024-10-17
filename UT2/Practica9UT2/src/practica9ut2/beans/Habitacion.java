/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9ut2.beans;

/**
 *
 * @author Tarde
 */
public class Habitacion {
    private int numeroHabitacion;
    private String tipoHabitacion;
    private String disponibilidad;

    public Habitacion(int numeroHabitacion, String tipoHabitacion, String disponibilidad) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponibilidad = disponibilidad;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }
    public String[] toArrayString(){
        String s[]=new String[3];
        s[0]=numeroHabitacion+"";
        s[1]=tipoHabitacion;
        s[2]=disponibilidad;
        return s;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
