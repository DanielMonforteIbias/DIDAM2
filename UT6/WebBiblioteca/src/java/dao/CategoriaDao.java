/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author Danim2205
 */
public class CategoriaDao {
    public static boolean registrarCategoria(Categoria cat){
        try {
            String sql="INSERT INTO CATEGORIAS(nombre) VALUES('?');";
            Connection conexion=ConexionBiblioteca.conectar();
            PreparedStatement st=conexion.prepareStatement(sql);
            st.setString(1,cat.getNombre());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static ArrayList<Categoria> listarCategorias(Categoria cat){
        try {
            ArrayList<Categoria>categorias=new ArrayList<Categoria>();
            String sql="SELECT * FROM CATEGORIAS;";
            Connection conexion=ConexionBiblioteca.conectar();
            PreparedStatement st=conexion.prepareStatement(sql);
            ResultSet resultado=st.executeQuery();
            while(resultado.next()){
                int codigo=resultado.getInt("codigo");
                String nombre=resultado.getString("nombre");
                categorias.add(new Categoria(codigo,nombre));
            }
            return categorias;
        } catch (SQLException ex) {
            return null;
        }
    }
}
