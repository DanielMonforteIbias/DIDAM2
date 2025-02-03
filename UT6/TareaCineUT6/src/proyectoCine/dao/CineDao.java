/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoCine.dao;

import proyectoCine.beans.Cine;
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
public class CineDao {

    public static Cine getCine(int idCine) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cine cine = null;

        try {
            String SQL = "SELECT * FROM Cines WHERE idCine = ?";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setInt(1, idCine);
            rs = st.executeQuery();

            if (rs.next()) {
                cine = new Cine(rs.getInt("idCine"), rs.getString("nombreCine"), rs.getString("direccionCine"));
            }

            return cine;
        } catch (SQLException ex) {
            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Cine> listarCines() {
        ArrayList<Cine> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            String SQL = "SELECT * from Cines";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }
            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            Cine c;
            while (resultado.next()) {
                c = new Cine();
                c.setIdCine(resultado.getInt("idCine"));
                c.setNombreCine(resultado.getString("nombreCine"));
                c.setDireccionCine(resultado.getString("direccionCine"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public static boolean registrarCine(Cine c) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            String SQL = "INSERT INTO CINES (nombreCine, direccionCine) VALUES (?,?);";
            con = Conexion.conectar();
            if (con == null) {
                return false;
            }
            st = con.prepareStatement(SQL);
            st.setString(1, c.getNombreCine());
            st.setString(2, c.getDireccionCine());
            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean comprobarCine(String nombreCine) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null; // Se necesita para manejar la consulta SELECT
        try {
            String SQL = "SELECT * FROM Cines WHERE nombreCine = ?;";
            con = Conexion.conectar();
            if (con == null) {
                return false;
            }
            st = con.prepareStatement(SQL);
            st.setString(1, nombreCine);
            rs = st.executeQuery(); // Usar executeQuery() para SELECT

            return rs.next(); // Si hay resultados, significa que el cine existe

        } catch (SQLException ex) {
            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Cine obtenerCinePorNombre(String nombreCine) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cine cine = null;

        try {
            String SQL = "SELECT * FROM Cines WHERE nombreCine = ?";
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }

            st = con.prepareStatement(SQL);
            st.setString(1, nombreCine);
            rs = st.executeQuery();

            if (rs.next()) {
                cine = new Cine(rs.getInt("idCine"), rs.getString("nombreCine"), rs.getString("direccionCine"));
            }

            return cine;
        } catch (SQLException ex) {
            Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CineDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
