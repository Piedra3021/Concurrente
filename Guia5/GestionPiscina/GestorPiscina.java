package Guia5.GestionPiscina;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    private Semaphore salaDeEspera = new Semaphore(1);
    private Semaphore Piscina = new Semaphore(5);

    public GestorPiscina() {

    }

    public void entrarSalaDeEspera() {
        try {
            salaDeEspera.acquire();
            System.out.println(Thread.currentThread().getName() + " entró a la sala de espera");
        } catch (Exception e) {

        }
    }

    public void entrarPiscina() {
        try {
            Piscina.acquire();
            System.out.println(Thread.currentThread().getName() + " entró a la piscina");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void dejarPiscina() {
        System.out.println(Thread.currentThread().getName() + " dejó la piscina");
        Piscina.release();

    }

    public void dejarSalaEspera() {
        System.out.println(Thread.currentThread().getName() + " dejó la sala de espera");
        salaDeEspera.release();
    }
}
