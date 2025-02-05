/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4_1.logica;

/**
 *
 * @author Danim2205
 */
public class Pelicula {
    private String titulo;
    private double precio;
    private String pg;
    private String genero;

    public Pelicula(String titulo, double precio, String pg, String genero) {
        this.titulo = titulo;
        this.precio = precio;
        this.pg = pg;
        this.genero = genero;
    }
    public Pelicula() {
        this.titulo = "";
        this.precio = 0;
        this.pg = "";
        this.genero = "";
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
