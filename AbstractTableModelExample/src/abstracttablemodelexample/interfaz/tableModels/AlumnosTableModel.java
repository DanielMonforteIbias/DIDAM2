/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracttablemodelexample.interfaz.tableModels;

import abstracttablemodelexample.beans.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tarde
 */
public class AlumnosTableModel extends AbstractTableModel{
    private List<Alumno>listaAlumno;
    private String columnas[]={"Nombre","Curso"};

    public AlumnosTableModel(List<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
    
    
    @Override
    public int getRowCount() {
        return listaAlumno.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0:
                return listaAlumno.get(i).getNombre();
            case 1:
                return listaAlumno.get(i).getCurso();
        }
        return null;                     
    }
    public String getColumnName(int i){
        return columnas[i];
    }
}
