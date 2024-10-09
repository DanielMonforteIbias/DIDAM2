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
public class Actividad8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Este programa consiste en adivinar un número aleatorio entre 1 y 100");
        Scanner s=new Scanner(System.in);
        boolean victoria=false; //Variable que servira para controlar cuándo gana el usuario
        int intentos=0; //Variable que guardará los intentos
        int aleatorio=(int)(Math.random()*100+1); //Math.random genera un número del 0 al 1 sin incluir el 1, al multiplicarlo por 100 sería de 0 a 99
                                                //Al sumar 1 será del 1 al 100
        do{
            System.out.println("Intenta adivinar el número aleatorio: "); //Pedimos el número al usuario
            int intento=s.nextInt(); //Guardamos el input del usuario
            if (intento==aleatorio) victoria=true; //Si el intento del usuario coincide con el aleatorio, ha ganado
            else{ //Si el usuario no ha acertado
                if (aleatorio>intento) System.out.println("El número aleatorio es mayor que "+intento); //Damos pistas al usuario si el aleatorio es mayor
                else System.out.println("El número aleatorio es menor que "+intento); //Damos pistas al usuario si el aleatorio es menor
            }
            intentos++; //Sumamos 1 intento
        }while(!victoria); //Cuando victoria deje de ser false, se saldrá del bucle
        System.out.println("Acertaste! El número secreto era "+aleatorio); //Informamos al usuario de la victoria
        System.out.println("Número de intentos: "+intentos); //Imprimimos el número de intentos;
    }
}