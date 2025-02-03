/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoCine.beans;

/**
 * @author Fatima Mortahil Chachou
 * @author Daniel Monforte Ibias
 * @author Victoria del Pino De Paz
 */
public class Cine {
    private int idCine;
    private String nombreCine;
    private String direccionCine;

    public Cine() {
        this.idCine=0;
        this.nombreCine="";
        this.direccionCine="";
    }

    public Cine(int idCine, String nombreCine, String direccionCine) {
        this.idCine=idCine;
        this.nombreCine = nombreCine;
        this.direccionCine = direccionCine;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getDireccionCine() {
        return direccionCine;
    }

    public void setDireccionCine(String direccionCine) {
        this.direccionCine = direccionCine;
    }
    
    
}
