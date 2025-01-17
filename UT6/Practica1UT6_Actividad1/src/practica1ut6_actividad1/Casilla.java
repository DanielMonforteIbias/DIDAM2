/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut6_actividad1;

/**
 *
 * @author Tarde
 */
public class Casilla {
    private int valor;
    private boolean descubierta;
    
    public Casilla(){
        this.valor=0;
        this.descubierta=false;
    }
    
    public Casilla(int valor){
        this.valor=valor;
        this.descubierta=false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }
    
}
