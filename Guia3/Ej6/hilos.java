package Guia3.Ej6;

public class hilos implements Runnable {
    private int min;
    private int max;
    private contador cont;
    private int[] arreglo;

    public hilos(int mi, int ma, contador c, int[] arreglo){
        this.min = mi;
        this.max = ma;
        this.cont = c;
        this.arreglo = arreglo;
    }
    public void run(){
        int sumaParcial = 0;
        for(int i = min; i <= max;i++){
            sumaParcial = sumaParcial + arreglo[i];
        }

        cont.sumar(sumaParcial);
    }
}
