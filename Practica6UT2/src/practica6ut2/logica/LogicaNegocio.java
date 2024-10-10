/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6ut2.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import practica6ut2.beans.Cliente;

/**
 *
 * @author Tarde
 */
public class LogicaNegocio {
    public List<Cliente>listaClientes=new ArrayList<>();

    public LogicaNegocio() {
        listaClientes=new ArrayList<>();
        listaClientes.add(new Cliente("Raul Perez","08/10/2024","10/10/2024",5,"Simple"));
        listaClientes.add(new Cliente("Juan Rodriguez","10/10/2024","12/10/2024",4,"Doble"));
        listaClientes.add(new Cliente("Paco Sanchez","06/10/2024","13/10/2024",6,"Simple"));
        listaClientes.add(new Cliente("Laura Martinez","04/10/2024","10/10/2024",10,"Doble"));
        listaClientes.add(new Cliente("Nerea Fernandez","11/10/2024","14/10/2024",8,"Deluxe"));
        listaClientes.add(new Cliente("Pablo Rodriguez","08/10/2024","12/10/2024",1,"Doble"));
        listaClientes.add(new Cliente("Mauro Lopez","04/10/2024","08/10/2024",3,"Deluxe"));
        listaClientes.add(new Cliente("Celia Blanco","10/10/2024","14/10/2024",2,"Simple"));
        listaClientes.add(new Cliente("Claudia Martinez","09/10/2024","10/10/2024",8,"Simple"));
        listaClientes.add(new Cliente("Jose Pitillo","02/10/2024","15/10/2024",14,"Simple"));
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
