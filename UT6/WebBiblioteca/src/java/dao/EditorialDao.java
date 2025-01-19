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
import model.Editorial;

/**
 *
 * @author Danim2205
 */
public class EditorialDao {
    public static boolean registrarEditorial(Editorial ed){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="INSERT INTO EDITORIALES (nit,nombre,telefono,direccion,email,sitioweb) VALUES (?,?,?,?,?,?);";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(1,ed.getNit());
            st.setString(2,ed.getNombre());
            st.setString(3,ed.getTelefono());
            st.setString(4,ed.getDireccion());
            st.setString(5,ed.getEmail());
            st.setString(6,ed.getSitioweb());
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
    public static ArrayList<Editorial> listarEditoriales(){
        ArrayList<Editorial>editoriales=new ArrayList<Editorial>();
        Connection conexion=null;
        PreparedStatement st=null;
        ResultSet resultado=null;
        try {
            String sql="SELECT * FROM EDITORIALES;";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return null;
            st=conexion.prepareStatement(sql);
            resultado=st.executeQuery();
            while(resultado.next()){
                String nit=resultado.getString("nit");
                String nombre=resultado.getString("nombre");
                String telefono=resultado.getString("telefono");
                String direccion=resultado.getString("direccion");
                String email=resultado.getString("email");
                String sitioweb=resultado.getString("sitioweb");
                editoriales.add(new Editorial(nit,nombre,telefono,direccion,email,sitioweb));
            }
            return editoriales;
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
