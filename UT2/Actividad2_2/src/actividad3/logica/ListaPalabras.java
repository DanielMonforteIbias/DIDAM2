/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad3.logica;

import java.util.ArrayList;

/**
 *
 * @author Tarde
 */
public class ListaPalabras {
    private static ArrayList<String>palabras=new ArrayList<>();
    
    public static void anadirPalabra(String palabra){
        palabras.add(palabra);
    }

    public static ArrayList<String> getPalabras() {
        return palabras;
    }
}
