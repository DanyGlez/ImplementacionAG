/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Dany Glez
 */
public class EjercicioDos {
  
    public static float[] vecPadre = new float[80];
    public static float[] vecMadre = new float[80];
    public static float[] fitnessPadre = new float[80];
    public static float[] fitnessMadre = new float[80];
    public static float[] Ganadores = new float[80];
    public static int Poblacion = 79;
    public static int aux,auxFit,auxMut,auxCruza = 0;
    public static float ratio_cruza = (float) 0.7;
    
public static void main(String[] args) {    
        inicializarPoblacion();
        for (int i = 0; i < vecPadre.length; i++) {
            System.out.println("Individuo " + i + " = " + vecPadre[i]);
        }
        System.out.println(" ");
        fitness();
        mutacion();
        System.out.println("");
        ganadores(); 
}
    
    public static float funcion_Fx(float X){
       return(10000*(X)-125*(X*X));    
    }
     
    public static void inicializarPoblacion() {
        if (aux <= Poblacion) {
            vecPadre[aux] = (float) (Math.random()*80); 
            vecMadre[aux] = (float) (Math.random()*80); 
            aux++;
            inicializarPoblacion();
        }
    }

    public static void fitness() {
        if (auxFit <= Poblacion) {
             fitnessPadre[auxFit]=funcion_Fx(vecPadre[auxFit]);
              fitnessMadre[auxFit]=funcion_Fx(vecMadre[auxFit]);
              auxFit++;
            fitness();
        }
    }
    
    public static void mutacion() {
        int ind1 = (int) (Math.random()*80);
        int ind2 = (int) (Math.random()*80);
        if (auxMut < 79) {
            if (ind1 != ind2) {
                System.out.println("Individuo: " + ind1 + " , " + " Individuo: " + ind2);
                cruza(ind1, ind2);
            }
            auxMut++;
            mutacion();
        }
    }

    public static void cruza(int x, int y) {
        float cruzado,res;
        float random = (float)(Math.random()*80);
        cruzado = (float) (random * (ratio_cruza) - ratio_cruza);
        System.out.println("Cruza =  " + cruzado);
        res = cruzado * fitnessMadre[y] + (1 - cruzado) * fitnessPadre[x];
        if (res > fitnessPadre[x]) {
            Ganadores[auxCruza] = res;
            auxCruza++;
        } else {
            Ganadores[auxCruza] = fitnessPadre[x];
            auxCruza++;
        }
    }

    public static void ganadores(){
        for (int i = 0; i < Ganadores.length-1; i++) {
            System.out.println("Ganadores: " + Ganadores[i]);
        }  
    }
    
}
