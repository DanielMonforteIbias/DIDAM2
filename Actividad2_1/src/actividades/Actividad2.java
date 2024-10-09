/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.Scanner; //Importamos el escáner

/**
 *
 * @author Daniel Monforte Ibias
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in); //Declaramos el escáner para pedir inputs al usuario
        System.out.println("Este programa calcula la temperatura en Fahrenheit dada en Celsius"); //Mensaje informativo de qué hace el programa
        System.out.println("Introduce la temperatura en Celsius: "); //Pedimos al usuario la temperatura en grados Celsius
        double celsius=s.nextDouble(); //Leemos la temperatura (double para que pueda tener decimales
        double fahrenheit=(celsius * 9/5) + 32; //Calculamos la temperatura en Fahrenheit
        System.out.println(celsius+" grados Celsius equivalen a "+fahrenheit+" grados Fahrenheit"); //Imprimimos el resultado
    }
}
