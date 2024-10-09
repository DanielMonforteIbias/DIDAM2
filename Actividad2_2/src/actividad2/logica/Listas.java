/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2.logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tarde
 */
public class Listas {
    private static List<String>vocales=new ArrayList<String>();
    private static List<String>consonantes=new ArrayList<String>();
    
    public static void anadirPalabra(List<String> lista, String palabra){
        lista.add(palabra);
    }

    public static List<String> getVocales() {
        return vocales;
    }

    public static List<String> getConsonantes() {
        return consonantes;
    }
    
}
