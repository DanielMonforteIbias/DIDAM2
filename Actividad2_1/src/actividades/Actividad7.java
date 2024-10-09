/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Daniel Monforte Ibias
 */
public class Actividad7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa calcula la media de 5 calificaciones dadas"); //Mensaje informando del propósito del programa
        Scanner s=new Scanner(System.in); //Declaramos el escáner
        double notas[]=new double[5]; //Array que contendrá las notas
        double suma=0; //Suma que servirá posteriormente para la media
        for(int i=0;i<notas.length;i++){ //Recorremos el array de notas para rellenarlo
            double nota=0; //Variable para guardar la nota
            boolean notaValida=false; //Variable para comprobar si la nota es válida
            do{
                System.out.println("Introduce la nota "+(i+1)); //Pedimos al usuario la nota, i+1 porque el bucle va del 0 al 4 pero las notas del 1 al 5
                nota=s.nextDouble(); //Leemos la nota del usuario
                if(nota<0 || nota>10){ //Si la nota es menor que 0 o mayor que 10
                    System.out.println("La nota introducida no es válida"); //Informamos al usuario de que no es válida
                    notaValida=false; //Como no es válida, se volverá a pedir
                }
                else notaValida=true; //Si no es menor que 0 o mayor que 10, es válida
            }while(!notaValida);
            notas[i]=nota; //Guardamos la nota
            suma+=nota; //Sumamos la nota al total
        }
        System.out.println("Notas introducidas: "+Arrays.toString(notas)); //Imprimimos las notas
        System.out.println("Media total: "+(suma/notas.length)); //Imprimimos la media, que es la suma entre la cantidad de notas;
    }
    
}
