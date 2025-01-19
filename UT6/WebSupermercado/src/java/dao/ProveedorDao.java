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
import model.Proveedor;

/**
 *
 * @author Danim2205
 */
public class ProveedorDao {
    public static boolean registrarProveedor(Proveedor prov){
        Connection conexion=null;
        PreparedStatement st=null;
        try {
            String sql="INSERT INTO PROVEEDORES (nit,nombre,telefono,direccion,correo) VALUES (?,?,?,?,?);";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return false;
            st=conexion.prepareStatement(sql);
            st.setString(1,prov.getNit());
            st.setString(2,prov.getNombre());
            st.setString(3,prov.getTelefono());
            st.setString(4,prov.getDireccion());
            st.setString(5,prov.getCorreo());
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
    public static ArrayList<Proveedor> listarProveedores(){
        ArrayList<Proveedor>proveedores=new ArrayList<Proveedor>();
        Connection conexion=null;
        PreparedStatement st=null;
        ResultSet resultado=null;
        try {
            String sql="SELECT * FROM PROVEEDORES;";
            conexion=ConexionSupermercado.conectar();
            if(conexion==null) return null;
            st=conexion.prepareStatement(sql);
            resultado=st.executeQuery();
            while(resultado.next()){
                String nit=resultado.getString("nit");
                String nombre=resultado.getString("nombre");
                String telefono=resultado.getString("telefono");
                String direccion=resultado.getString("direccion");
                String email=resultado.getString("email");
                proveedores.add(new Proveedor(nit,nombre,telefono,direccion,email));
            }
            return proveedores;
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
