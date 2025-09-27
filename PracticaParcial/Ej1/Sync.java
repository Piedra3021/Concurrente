package PracticaParcial.Ej1;

import java.util.concurrent.Semaphore;

public class Sync {
    private Semaphore sem1 = new Semaphore(0);
    private Semaphore sem2 = new Semaphore(0);

    public Sync(){

    }

    public void notificarEncargado(){
        sem1.release();
    }

    public void notificarCliente(){
        sem2.release();
    }

    public void accionEncargado(){
        try {
            sem1.acquire();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void accionCliente(){
        try {
            sem2.acquire();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
