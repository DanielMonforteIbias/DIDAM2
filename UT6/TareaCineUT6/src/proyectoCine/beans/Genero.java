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
public class Genero {
    private int idGenero;
    private String nombreGenero;

    public Genero(int idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }
    public Genero(){
        this.idGenero=0;
        this.nombreGenero="";
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
}
