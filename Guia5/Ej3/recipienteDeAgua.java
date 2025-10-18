package Guia5.Ej3;

import java.util.concurrent.Semaphore;

public class recipienteDeAgua {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore Oespera = new Semaphore(0);
    private Semaphore Hespera = new Semaphore(0);
    private Semaphore recipiente;
    private int Oesperando = 0;
    private int Hesperando = 0;

    public recipienteDeAgua(int c) {
        recipiente = new Semaphore(c);
    }

    public void Olisto() {
        try {
            mutex.acquire();
            Oesperando++;

            if (Hesperando >= 2) {
                System.out.println("Se agregó un átomo de Oxigeno. Inicia el proceso");
                Hesperando = Hesperando - 2;
                Oesperando--;
                Hespera.release(2);
                mutex.release();
                HacerAgua();
            } else {
                System.out.println("Un atomo de oxigeno está esperando");
                mutex.release();
                Oespera.acquire();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void Hlisto() {
        try {
            mutex.acquire();
            Hesperando++;

            if (Hesperando >= 2 && Oesperando >= 1) {
                System.out.println("Se agregó un átomo de hidrogeno. Inicia el proceso");
                Oesperando--;
                Hesperando = Hesperando - 2;
                Oespera.release();
                mutex.release();
                HacerAgua();
            } else {
                System.out.println("Un átomo de hidrogeno está esperando.");
                mutex.release();
                Hespera.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void HacerAgua() {
        try {
            mutex.acquire();
            if (recipiente.tryAcquire()) {
                System.out.println("Se agregó una molécula de agua al recipiente! Quedan: "
                        + recipiente.availablePermits() + " espacios.");
            } else {
                System.out.println("El recipiente está lleno. No se pudo agregar.");
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
