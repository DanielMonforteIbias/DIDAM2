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
import model.Producto;

/**
 *
 * @author Danim2205
 */
public class ProductoDao {
    public static boolean registrarProducto(Producto prod) {
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="INSERT INTO PRODUCTOS (codigo,nombre,descripcion,cantidad,precio,codigo_categoria,nit_proveedor) VALUES (?,?,?,?,?,?,?);";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setInt(1,prod.getCodigo());
            st.setString(2,prod.getNombre());
            st.setString(3,prod.getDescripcion());
            st.setInt(4,prod.getCantidad());
            st.setFloat(5,prod.getPrecio());
            st.setInt(6,prod.getCodigoCategoria());
            st.setString(7,prod.getNitProveedor());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean actualizarProducto(Producto prod){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="UPDATE PRODUCTOS SET nombre=?, descripcion=?, cantidad=?, precio=?, codigo_categoria=?, nit_proveedor=? WHERE codigo=?;";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setInt(7,prod.getCodigo());
            st.setString(1,prod.getNombre());
            st.setString(2,prod.getDescripcion());
            st.setInt(3,prod.getCantidad());
            st.setFloat(4,prod.getPrecio());
            st.setInt(5,prod.getCodigoCategoria());
            st.setString(6,prod.getNitProveedor());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean borrarProducto(Producto prod){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="DELETE FROM PRODUCTOS WHERE codigo=?";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setInt(1,prod.getCodigo());
            if(st.executeUpdate()>0) return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }finally{
            try {
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<Producto> listarProductos(){
        ArrayList<Producto>productos=new ArrayList<Producto>();
        Connection conexion=null;
        PreparedStatement st=null;
        ResultSet resultado=null;
        try {
            String sql="SELECT * FROM PRODUCTOS;";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return null;
            st=conexion.prepareStatement(sql);
            resultado=st.executeQuery();
            while(resultado.next()){
                int codigo=resultado.getInt("codigo");
                String nombre=resultado.getString("nombre");
                String descripcion=resultado.getString("descripcion");
                int cantidad=resultado.getInt("cantidad");
                float precio=resultado.getFloat("precio");
                int codigoCategoria=resultado.getInt("codigo_categoria");
                String nitProveedor=resultado.getString("nit_proveedor");
                productos.add(new Producto(codigo,nombre,descripcion,cantidad,precio,codigoCategoria,nitProveedor));
            }
            return productos;
        } catch (SQLException ex) {
            return null;
        }finally{
            try {
                if(resultado!=null) resultado.close();
                if(st!=null) st.close();
                if(conexion!=null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
