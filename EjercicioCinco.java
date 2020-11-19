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
public class EjercicioCinco {
    
    public static float[] vecPadre = new float[55];
    public static float[] vecMadre = new float[55];
    public static float[] fitnessPadre = new float[55];
    public static float[] fitnessMadre = new float[55];
    public static float[] Ganadores = new float[55];
    public static int Poblacion = 54;
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
        return (float)(-12.5*(X*X)+(1375*(X))-(1500));
    }
     
    public static void inicializarPoblacion() {
        if (aux <= Poblacion) {
            vecPadre[aux] = (float) (Math.random()*55); 
            vecMadre[aux] = (float) (Math.random()*55); 
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
        int ind1 = (int) (Math.random()*55);
        int ind2 = (int) (Math.random()*55);
        if (auxMut < 54) {
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
        float random = (float)(Math.random()*55);
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
