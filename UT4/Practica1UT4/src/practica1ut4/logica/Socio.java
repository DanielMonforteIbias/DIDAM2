/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut4.logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Socio {
    private String nombre;
    private String apellidos;
    private String nif;
    private String email;
    private String nacionalidad;
    private boolean notificaciones;
    private ArrayList<String>preferencias;

    public Socio(String nombre, String apellidos, String nif, String email, String nacionalidad, boolean notificaciones, ArrayList<String> preferencias) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.notificaciones = notificaciones;
        this.preferencias = preferencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public ArrayList<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(ArrayList<String> preferencias) {
        this.preferencias = preferencias;
    }
    
}
