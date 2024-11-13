/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut4.logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ListaSocios {
    private static ArrayList<Socio>listaSocios=new ArrayList<Socio>();

    public static void añadirSocio(Socio s){
        listaSocios.add(s);
    }
    public static ArrayList<Socio> getListaSocios() {
        return listaSocios;
    }
    
}
