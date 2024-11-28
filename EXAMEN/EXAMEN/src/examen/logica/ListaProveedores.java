/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.logica;

import java.util.ArrayList;

/**
 *
 * @author Tarde
 */
public class ListaProveedores {
    private static ArrayList<Proveedor>proveedores=new ArrayList<>();
    public static void anadirProveedor(Proveedor p){
        proveedores.add(p);
    }

    public static ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public static void setProveedores(ArrayList<Proveedor> proveedores) {
        ListaProveedores.proveedores = proveedores;
    }
    
}
