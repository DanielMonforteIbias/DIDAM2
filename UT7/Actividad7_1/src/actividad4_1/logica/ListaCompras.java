/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4_1.logica;

import java.util.ArrayList;

/**
 *
 * @author Danim2205
 */
public class ListaCompras {
    private static ArrayList<Compra>compras=new ArrayList<>();
    
    public static void anadirCompra(Compra compra){
        compras.add(compra);
    }

    public static ArrayList<Compra> getCompras() {
        return compras;
    }

    public static void setCompras(ArrayList<Compra> compras) {
        ListaCompras.compras = compras;
    }
    
}
