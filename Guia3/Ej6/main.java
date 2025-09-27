package Guia3.Ej6;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random num = new Random();
        int min = 0;

        int[] arreglo = new int[50000];
        hilos[] hilos = new hilos[1000];
        Thread[] hiloThreads = new Thread[1000];
        contador c = new contador();
        int dif = (arreglo.length / hilos.length);
        int max = dif - 1;

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (num.nextInt(10)) + 1;
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new hilos(min, max, c, arreglo);
            hiloThreads[i] = new Thread(hilos[i], "hilo " + i);
            min = max + 1;
            max = max + dif;
        }

        for (int i = 0; i < hiloThreads.length; i++) {
            hiloThreads[i].start();
        }

        for (int i = 0; i < hiloThreads.length; i++) {
            try{
                hiloThreads[i].join();
            }catch(InterruptedException ie){
                System.out.println("Ocurrió un error");
            }
        }
        System.out.println(c.getResultado());

    }
}
