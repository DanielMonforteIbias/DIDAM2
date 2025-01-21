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
import model.Libro;

/**
 *
 * @author Danim2205
 */
public class LibroDao {
    public static boolean registrarLibro(Libro lib) {
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="INSERT INTO LIBROS (isbn,titulo,descripcion,nombre_autor,publicacion,fecha_registro,codigo_categoria,nit_editorial) VALUES (?,?,?,?,?,(select now()),?,?);";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(1,lib.getIsbn());
            st.setString(2,lib.getTitulo());
            st.setString(3,lib.getDescripcion());
            st.setString(4,lib.getNombreAutor());
            st.setString(5,lib.getPublicacion());
            st.setInt(6,lib.getCodigoCategoria());
            st.setString(7,lib.getNitEditorial());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean actualizarLibro(Libro lib){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="UPDATE LIBROS SET titulo=?,descripcion=?,nombre_autor=?,publicacion=?,codigo_categoria=?,nit_editorial=? WHERE isbn=?;";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(7,lib.getIsbn());
            st.setString(1,lib.getTitulo());
            st.setString(2,lib.getDescripcion());
            st.setString(3,lib.getNombreAutor());
            st.setString(4,lib.getPublicacion());
            st.setInt(5,lib.getCodigoCategoria());
            st.setString(6,lib.getNitEditorial());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean borrarLibro(Libro lib){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="DELETE FROM LIBROS WHERE isbn=?";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(1,lib.getIsbn());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<Libro> listarLibros(){
        ArrayList<Libro>libros=new ArrayList<Libro>();
        Connection conexion=null;
        PreparedStatement st=null;
        ResultSet resultado=null;
        try {
            String sql="SELECT * FROM LIBROS;";
            conexion=ConexionBiblioteca.conectar();
            if(conexion==null) return null;
            st=conexion.prepareStatement(sql);
            resultado=st.executeQuery();
            while(resultado.next()){
                String isbn=resultado.getString("isbn");
                String titulo=resultado.getString("titulo");
                String descripcion=resultado.getString("descripcion");
                String nombreAutor=resultado.getString("nombre_autor");
                String publicacion=resultado.getString("publicacion");
                String fechaRegistro=resultado.getString("fecha_registro");
                int codigoCategoria=resultado.getInt("codigo_categoria");
                String nitEditorial=resultado.getString("nit_editorial");
                libros.add(new Libro(isbn,titulo,descripcion,nombreAutor,publicacion,fechaRegistro,codigoCategoria,nitEditorial));
            }
            return libros;
        } catch (SQLException ex) {
            return null;
        }finally{
            try {
                if(resultado!=null) resultado.close();
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
