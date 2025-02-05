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
public class Compra {
    private String pelicula;
    private int numeroAsientos;
    private String asientos;
    private int sala;
    private double precio;

    public Compra(String pelicula, int numeroAsientos, String asientos, int sala, double precio) {
        this.pelicula = pelicula;
        this.numeroAsientos=numeroAsientos;
        this.asientos = asientos;
        this.sala = sala;
        this.precio=precio;
    }

    public String getPelicula() {
        return pelicula;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }


    public String getAsientos() {
        return asientos;
    }

    public int getSala() {
        return sala;
    }
    
}
