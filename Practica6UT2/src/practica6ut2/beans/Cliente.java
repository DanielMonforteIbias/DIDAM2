/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6ut2.beans;

import java.util.Date;

/**
 *
 * @author Tarde
 */
public class Cliente {
    private String nombreCompleto;
    private Date checkin;
    private Date checkout;
    private int numHabitacion;
    private String tipoHabitacion;

    public Cliente(String nombreCompleto, Date checkin, Date checkout, int numHabitacion, String tipoHabitacion) {
        this.nombreCompleto = nombreCompleto;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numHabitacion = numHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    
}
