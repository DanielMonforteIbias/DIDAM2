/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.Scanner; //Importamos la utilidad del escáner

/**
 *
 * @author Daniel Monforte Ibias
 */
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in); //Declaramos el escáner para pedir inputs al usuario
        System.out.println("Este programa realiza la suma de dos números dados por el usuario"); //Texto informativo de lo que hace el programa
        System.out.println("Introduce el primer número: "); //Pedimos al usuario el primer número
        int n1=s.nextInt(); //Leemos el número entero que introduzca el usuario
        System.out.println("Introduce el segundo número: "); //Pedimos al usuario el segundo número
        int n2=s.nextInt(); //Leemos el segundo número entero del usuario
        int resultado=n1+n2; //Calculamos el resultado sumando los dos números
        System.out.println(n1+" + "+n2+" = "+resultado); //Imprimimos el resultado por pantalla
    }
}
