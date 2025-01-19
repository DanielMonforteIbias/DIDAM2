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
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="INSERT INTO CATEGORIAS(nombre) VALUES(?);";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(1,cat.getNombre());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static ArrayList<Categoria> listarCategorias(){
        ArrayList<Categoria>categorias=new ArrayList<Categoria>();
        Connection conexion=null;
        PreparedStatement st=null;
        ResultSet resultado=null;
        try {
            String sql="SELECT * FROM CATEGORIAS;";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return null;
            st=conexion.prepareStatement(sql);
            resultado=st.executeQuery();
            while(resultado.next()){
                int codigo=resultado.getInt("codigo");
                String nombre=resultado.getString("nombre");
                categorias.add(new Categoria(codigo,nombre));
            }
            return categorias;
        } catch (SQLException ex) {
            return null;
        }finally{
            try {
                if(resultado!=null) resultado.close();
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}