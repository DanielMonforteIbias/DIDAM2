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
        listaClientes.add(new Cliente("Raul Perez",new Date("08-10-2024"),new Date("10-10-2024"),5,"Simple"));
        listaClientes.add(new Cliente("Juan Rodriguez",new Date("04-10-2024"),new Date("12-10-2024"),4,"Doble"));
        listaClientes.add(new Cliente("Paco Sanchez",new Date("05-10-2024"),new Date("13-10-2024"),6,"Simple"));
        listaClientes.add(new Cliente("Laura Martinez",new Date("06-10-2024"),new Date("10-10-2024"),10,"Doble"));
        listaClientes.add(new Cliente("Nerea Fernandez",new Date("02-10-2024"),new Date("12-10-2024"),8,"Deluxe"));
        listaClientes.add(new Cliente("Pablo Rodriguez",new Date("08-10-2024"),new Date("11-10-2024"),1,"Doble"));
        listaClientes.add(new Cliente("Mauro Lopez",new Date("07-10-2024"),new Date("15-10-2024"),3,"Deluxe"));
        listaClientes.add(new Cliente("Celia Blanco",new Date("05-10-2024"),new Date("10-10-2024"),2,"Simple"));
        listaClientes.add(new Cliente("Claudia Martinez",new Date("01-10-2024"),new Date("09-10-2024"),8,"Simple"));
        listaClientes.add(new Cliente("Jose Pitillo",new Date("05-10-2024"),new Date("12-10-2024"),14,"Simple"));
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
