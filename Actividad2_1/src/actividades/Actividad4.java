/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.Scanner;

/**
 *
 * @author Daniel Monforte Ibias
 */
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in); //Declaramos el escáner
        System.out.println("Este programa imprime la tabla de multiplicar de un número dado"); //Información de lo que hace el programa
        System.out.println("Introduce el número del que quieres obtener la tabla: "); //Pedimos al usuario el número
        int n1=s.nextInt(); //Leemos el input del usuario, un número entero
        for(int i=1;i<=10;i++){ //Ejecutamos el bucle 10 veces, empezando en el 1 y terminando en el 10
            int producto=n1*i; //Calculamos el producto
            System.out.println(n1+" x "+i+" = "+producto); //Imprimimos el resultado
        }
    }
}
