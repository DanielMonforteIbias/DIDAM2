/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoCine.dao;

import proyectoCine.beans.Cine;
import proyectoCine.beans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fatima Mortahil Chachou
 * @author Daniel Monforte Ibias
 * @author Victoria del Pino De Paz
 */
public class GeneroDao {
    public static Genero getGenero(int idGenero) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Genero genero = null;

        try {
            String SQL = "SELECT * FROM Generos WHERE idGenero = ?";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, idGenero);
            rs = st.executeQuery();

            if (rs.next()) {
                genero = new Genero(rs.getInt("idGenero"), rs.getString("nombreGenero"));
            }

            return genero;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<Genero> listarGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
             String SQL = "SELECT * from Generos";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }
            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            Genero g;
            while (resultado.next()) {
                g = new Genero();
                g.setIdGenero(resultado.getInt("idGenero"));
                g.setNombreGenero(resultado.getString("nombreGenero"));
                lista.add(g);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }  
    
    
    public static Genero obtenerGeneroPorNombre(String nombreGenero) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Genero genero = null;

        try {
            String SQL = "SELECT * FROM Generos WHERE nombreGenero = ?";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, nombreGenero);
            rs = st.executeQuery();

            if (rs.next()) {
                genero = new Genero(rs.getInt("idGenero"), rs.getString("nombreGenero"));
            }

            return genero;
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
