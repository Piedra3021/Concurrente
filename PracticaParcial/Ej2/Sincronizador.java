package PracticaParcial.Ej2;

import java.util.concurrent.Semaphore;

public class Sincronizador {
    private Semaphore sem1 = new Semaphore(0);
    private Semaphore sem2 = new Semaphore(0);

    public Sincronizador(){

    }

    public void notificarApp(){
        try {
            sem1.acquire();
            System.out.println("La aplicación fue notificada.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void notificarImagen(){
        try {
            sem2.acquire();
            System.out.println("La imagen fue notificada.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void actuarApp(){
        sem1.release();
    }

    public void actuarImagen(){
        sem2.release();
    }
}
