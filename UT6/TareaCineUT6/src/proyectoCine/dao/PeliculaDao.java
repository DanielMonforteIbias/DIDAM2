/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoCine.dao;

import proyectoCine.beans.Cine;
import proyectoCine.beans.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoCine.beans.Genero;

/**
 * @author Fatima Mortahil Chachou
 * @author Daniel Monforte Ibias
 * @author Victoria del Pino De Paz
 */
public class PeliculaDao {

    public static ArrayList<Pelicula> listarPeliculas() {
        ArrayList<Pelicula> lista = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet resultado = null;
        try {
            String SQL = "SELECT * from Peliculas"; //Obtenemos todas las peliculas
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }
            st = con.prepareStatement(SQL);
            resultado = st.executeQuery();

            Pelicula p;
            while (resultado.next()) { //Recorremos el ResultSet y añadimos la pelicula creada a la lista
                p = new Pelicula();
                p.setIdPelicula(resultado.getInt("idPelicula"));
                p.setNombrePelicula(resultado.getString("nombrePelicula"));
                p.setGenero(GeneroDao.getGenero(resultado.getInt("idGenero")));
                p.setVisto(resultado.getBoolean("visto"));
                p.setCine(CineDao.getCine(resultado.getInt("idCine")));
                p.setCalificacion(resultado.getInt("calificacion")); // Obtener la calificación

                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

    }

    public static boolean registrarPelicula(Pelicula p) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            String SQL = "INSERT INTO Peliculas (nombrePelicula, idGenero, visto, idCine,calificacion) VALUES (?, ?, ?, ?, ?)"; //Haremos un insert
            con = Conexion.conectar();
            if (con == null) {
                return false;
            }
            st = con.prepareStatement(SQL);
            //Ponemos los parametros del insert
            st.setString(1, p.getNombrePelicula());
            st.setInt(2, p.getGenero().getIdGenero());
            st.setBoolean(3, p.isVisto());
            st.setInt(4, p.getCine().getIdCine());
            st.setInt(5, p.getCalificacion()); // Guardamos la calificación
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static boolean modificarPelicula(Pelicula p) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            String SQL = "UPDATE peliculas SET idGenero=?, visto=?, idCine=?, calificacion=? WHERE nombrePelicula=?"; //Haremos un update
            con = Conexion.conectar();
            if (con == null) {
                return false;
            }
            st = con.prepareStatement(SQL);
            //Ponemos los parametros de la consulta
            st.setInt(1,p.getGenero().getIdGenero());
            st.setBoolean(2, p.isVisto());
            st.setInt(3, p.getCine().getIdCine());
            st.setInt(4, p.getCalificacion());
            st.setString(5, p.getNombrePelicula());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Pelicula obtenerPeliculaPorTitulo(String titulo) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT * FROM Peliculas WHERE nombrePelicula = ?"; //Obtenemos la pelicula con el titulo que coincida
            con = Conexion.conectar();
            if (con == null) {
                return null;
            }
            st = con.prepareStatement(SQL);
            st.setString(1, titulo); //Ponemos el titulo recibido en el parametro
            rs = st.executeQuery();
            if (rs.next()) { //Si hay resultados, devolvemos la pelicula creada con los datos obtenidos
                Pelicula p = new Pelicula();
                p.setIdPelicula(rs.getInt("idPelicula"));
                p.setNombrePelicula(rs.getString("nombrePelicula"));
                p.setGenero(GeneroDao.getGenero(rs.getInt("idGenero")));
                p.setVisto(rs.getBoolean("visto"));
                p.setCine(CineDao.getCine(rs.getInt("idCine")));
                p.setCalificacion(rs.getInt("calificacion"));
                return p;
            }
            return null; //Si no, devolvemos null
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean eliminarPelicula(String titulo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            String SQL = "DELETE FROM Peliculas WHERE nombrePelicula = ?"; //Haremos un Delete en la que tenga el nombre recibido
            con = Conexion.conectar();
            if (con == null) {
                return false;
            }
            st = con.prepareStatement(SQL);
            st.setString(1, titulo); //Ponemos el parametro
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PeliculaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static List<Pelicula> filtrarPeliculas(String genero, String cine) { 
    List<Pelicula> peliculas = new ArrayList<>();
    String consulta = " SELECT p.nombrePelicula, g.nombreGenero, p.visto, c.nombreCine, p.calificacion\n" +
"        FROM Peliculas p\n" +
"        JOIN Generos g ON p.idGenero = g.idGenero\n" +
"        JOIN Cines c ON p.idCine = c.idCine\n" +
"        WHERE 1=1"; //Se pone where 1=1 para tener una condicion inicial y poder añadir otras

    // Añadir condiciones según los filtros
    if (!genero.equals("Todos")) {
        consulta += " AND g.nombreGenero = ?";
    }
    if (!cine.equals("Todos")) {
        consulta += " AND c.nombreCine = ?";
    }

    try (Connection connection = Conexion.conectar();
         PreparedStatement statement = connection.prepareStatement(consulta)) {

        int paramIndex = 1;
        if (!genero.equals("Todos")) {
            statement.setString(paramIndex++, genero);
        }
        if (!cine.equals("Todos")) {
            statement.setString(paramIndex++, cine);
        }

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) { //Mientrras haya resultados, creamos una pelicula con esos datos y la añadimos a la lista
            String nombre=resultSet.getString("nombrePelicula");
            Genero generoPelicula=GeneroDao.obtenerGeneroPorNombre(resultSet.getString("nombreGenero"));
            boolean visto=resultSet.getBoolean("visto");
            Cine cinePelicula=CineDao.obtenerCinePorNombre(resultSet.getString("nombreCine"));
            int calificacion=resultSet.getInt("calificacion");
            peliculas.add(new Pelicula(nombre,generoPelicula,visto,cinePelicula,calificacion));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return peliculas;
}
}
