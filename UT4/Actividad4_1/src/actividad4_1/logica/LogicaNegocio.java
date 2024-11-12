/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4_1.logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danim2205
 */
public class LogicaNegocio {
    private static List<Pelicula>listaPeliculas=new ArrayList<>();
    
    public static void crearPeliculas(){ //Películas por defecto
        listaPeliculas.add(new Pelicula("Titanic",4.5,"PG-16","Drama"));
        listaPeliculas.add(new Pelicula("Million Dollar Baby",5.0,"PG-16","Acción"));
        listaPeliculas.add(new Pelicula("Los Minions",4.0,"PG-3","Comedia"));
        listaPeliculas.add(new Pelicula("The Boogeyman",4.5,"PG-18","Terror"));
        listaPeliculas.add(new Pelicula("Jurassic Park",4.25,"PG-16","Acción"));
        listaPeliculas.add(new Pelicula("Insidious 3",5,"PG-18","Terror"));
        listaPeliculas.add(new Pelicula("El Castillo Ambulante",4.25,"PG-7","Aventura"));
        listaPeliculas.add(new Pelicula("El Padrino",4.75,"PG-16","Crimen"));
    }
    public static List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
}
