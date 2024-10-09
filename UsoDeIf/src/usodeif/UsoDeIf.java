/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeif;

import java.util.Scanner;

/**
 *
 * @author Tarde
 */
public class UsoDeIf {
    public static void main (String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int n1=s.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int n2=s.nextInt();
        int resultado=n1+n2;
        if (resultado>0) System.out.println("El resultado es positivo");
        else if (resultado<0) System.out.println("El resultado es negativo");
        else System.out.println("El resultado es 0");
    }
}
