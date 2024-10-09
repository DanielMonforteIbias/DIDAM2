/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionclientes.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tarde
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String provincia;
    private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //Para las horas HH en formato 24h y hh en formato 12h

    public Cliente(String nombre, String apellidos, Date fechaAlt, String provincia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlt;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String[] toArrayString(){
        String s[]=new String[4];
        s[0]=nombre;
        s[1]=apellidos;
        s[2]=sdf.format(fechaAlta);
        s[3]=provincia;
        return s;
    }
}
