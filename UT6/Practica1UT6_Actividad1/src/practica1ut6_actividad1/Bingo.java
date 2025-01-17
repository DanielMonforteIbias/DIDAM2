/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ut6_actividad1;

/**
 *
 * @author Tarde
 */
public class Bingo {
    public static Casilla tarjeta[][]=new Casilla[5][5];
    
    public static void inicializarTarjeta(){
        for(int i=0;i<tarjeta.length;i++){
            for(int j=0;j<tarjeta[0].length;j++){
                tarjeta[i][j]=new Casilla();
            }
        }
    }
    public static void rellenarTarjeta(){
        inicializarTarjeta();
        int aleatorio=0;
        boolean repetido=false;
        for(int i=0;i<tarjeta.length;i++){
            for(int j=0;j<tarjeta[0].length;j++){
                do{
                    repetido=false;
                    aleatorio=(int)((Math.random()*75+1));
                    if(!buscarNumero(aleatorio))tarjeta[i][j]=new Casilla(aleatorio);
                    else repetido=true; 
                }while(repetido);
            }
        }
    }
    public static boolean buscarNumero(int n){
        for(int i=0;i<tarjeta.length;i++){
            for(int j=0;j<tarjeta[0].length;j++){
                if((tarjeta[i][j].getValor())==n) return true;
            }
        }
        return false;
    }
    public static void imprimirTarjeta(){
        for(int i=0;i<tarjeta.length;i++){
            for(int j=0;j<tarjeta[0].length;j++){
                System.out.printf("%3s",tarjeta[i][j]);
            }
            System.out.println();
        }
    }
}
