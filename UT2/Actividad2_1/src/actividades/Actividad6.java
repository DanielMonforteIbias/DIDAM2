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
public class Actividad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in); //Declaramos el escáner
        System.out.println("Este programa cuenta las vocales de una palabra dada"); //Mensaje informando del propósito del programa
        System.out.println("Introduce la palabra: "); //Pedimos la palabra al usuario
        String palabra=s.next(); //Leemos la palabra que introduzca el usuario
        int contadorVocales=0; //Declaramos el contador de vocales
        for(int i=0;i<palabra.length();i++){ //Bucle para recorrer la palabra
            if (comprobarVocal(palabra.charAt(i)+"")){ //Comprobamos si el carácter actual es una vocal con un método
                contadorVocales++; //Incrementamos el contador de vocales en 1
            }
        }
        System.out.println("La palabra "+palabra+" tiene "+contadorVocales+" vocales"); //Imprimimos la palabra y el numero de vocales que tiene
    }
    public static boolean comprobarVocal(String vocal){ //Este método comprueba si el parámetro que recibe es una vocal
        return vocal.matches("[AEIOUaeiou]"); //Devuelve true si el caráter es alguno de los siguientes: A E I O U a e i o u, y false si no
    }
}