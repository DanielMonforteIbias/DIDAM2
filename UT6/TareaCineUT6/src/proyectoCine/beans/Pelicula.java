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
public class Pelicula {
    private int idPelicula;
    private String nombrePelicula;
    private Genero genero;
    private boolean visto;
    private Cine cine;
    private int calificacion; // (1-5 estrellas)


    public Pelicula(int idPelicula, String nombrePelicula, Genero genero, boolean visto, Cine cine, int calificacion) {
        this.idPelicula=idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.visto = visto;
        this.cine = cine;
        this.calificacion = calificacion;

    }
    
    public Pelicula(String nombrePelicula, Genero genero, boolean visto, Cine cine, int calificacion) {
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.visto = visto;
        this.cine = cine;
        this.calificacion = calificacion;
    }
    
    public Pelicula() {
        
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }
    
    
     public int getCalificacion() {
        return calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            this.calificacion = calificacion;
        } else {
            this.calificacion = 0; // Valor predeterminado si es inválido
        }
    }

    

}
