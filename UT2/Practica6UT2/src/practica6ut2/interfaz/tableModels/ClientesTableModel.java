/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6ut2.interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import practica6ut2.beans.Cliente;

/**
 *
 * @author Tarde
 */
public class ClientesTableModel extends AbstractTableModel{
    private List<Cliente>clientes;
    private String columnas[]={"Nombre Completo","Check in","Check out","Número habitación","Tipo habitación"};

    public ClientesTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0:
                return clientes.get(i).getNombreCompleto();
            case 1:
                return clientes.get(i).getCheckin();
            case 2:
                return clientes.get(i).getCheckout();
            case 3:
                return clientes.get(i).getNumHabitacion();
            case 4:
                return clientes.get(i).getTipoHabitacion();
        }
        return null; 
    }
    public String getColumnName(int i){
        return columnas[i];
    }
}
