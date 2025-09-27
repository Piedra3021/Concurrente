package Guia3.Ej2;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Entidad[] arreglo = new Entidad[6];
        Energia en = new Energia();
        int cont = 1;
        int cont2 = 1;
  

        for(int i = 0; i<arreglo.length;i++){
            int tipo = obtenerTipo();
            if(tipo==0){
                arreglo[i] = new Entidad("criatura " + cont2,en);
                System.out.println("Se creó una criatura");
                cont2++;
            }else{
                arreglo[i] = new Entidad("el sanador " + cont,en);
                System.out.println("Se creó un sanador");
                cont++;
            }
        }

        Thread[] hilos = new Thread[6];
        for(int i = 0;i < hilos.length;i++){
            hilos[i] = new Thread(arreglo[i]);
        }

        for(int i = 0; i<hilos.length; i++){
            hilos[i].start();
        }
    }

    public static int obtenerTipo(){
            Random num = new Random();

            int numR = num.nextInt(4);

            return numR;
        }
}
