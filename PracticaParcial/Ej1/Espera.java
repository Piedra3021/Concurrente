package PracticaParcial.Ej1;

import java.util.concurrent.Semaphore;

public class Espera {
    private int esperando = 0;
    private Semaphore espera = new Semaphore(1);
    private Semaphore mutex = new Semaphore(1);

    public void habilitarLanzar(){
        espera.release();
    }

    public void esperar(){
        try {
            this.aumentarEspera();
            espera.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void aumentarEspera(){
        try {
            mutex.acquire();
            esperando++;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirEspera(){
        try {
            mutex.acquire();
            esperando--;
            mutex.release();
            System.out.println(Thread.currentThread().getName() + " se fue.");
            espera.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
