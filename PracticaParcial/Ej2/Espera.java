package PracticaParcial.Ej2;

import java.util.concurrent.Semaphore;

import Guia3.Ej6.contador;

public class Espera {
    private Semaphore sEspera = new Semaphore(1);
    private Semaphore mutex = new Semaphore(1);
    private int esperando = 0;

    public Espera(){

    }

    public void entrarSalaEspera(){
        try {
            this.aumentarEsperando();
            System.out.println(Thread.currentThread().getName() + " entró a la sala de espera.");
            sEspera.acquire();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void aumentarEsperando(){
        try {
            mutex.acquire();
            esperando++;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirEspera(){
        this.salirEsperando();
        System.out.println(Thread.currentThread().getName() + " salió de la sala de espera.");
        sEspera.release();
    }

    private void salirEsperando(){
        try {
            mutex.acquire();
            esperando--;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
