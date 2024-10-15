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
public class Actividad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in); //Declaramos el escáner
        System.out.println("Este programa calcula el factorial de un número entero positivo");
        int n1=0; //Declaramos el número, fuera del bucle para usarlo más adelante
        do{
            System.out.println("Introduce un número entero positivo: ");
            n1=s.nextInt();
            if(n1<=0) System.out.println("El número introducido no es positivo");
        }while(n1<=0); //Hasta que el número dado no sea positivo se seguirán pidiendo números al usuario
        
        int i=n1; //Guardamos el valor de n1 en i. Necesario porque i lo vamos a modificar durante el while, pero más adelante queremos imprimir el valor inicial, que se queda en n1
        int factorial=n1; //El valor inicial del factorial es el número introducido
        while (i>1){ //Mientras i sea mayor que 1 (no mayor que 0, porque en ese caso en la última pasada i valdría 1, y i-1 valdría 0, así que al multiplicar el factorial por 0 el resultado final sería 0
            factorial*=(i-1); //El factorial se va acumulando multiplicándose por el número anterior
            i--; //Reducimos en 1 el valor de i
        }
        System.out.println("El factorial de "+n1+" es "+factorial); //Imprimimos el resultado
    }
}
