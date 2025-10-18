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
            System.out.println("Se agregó un átomo de Oxigeno.");

            if (Hesperando >= 2) {
                Hesperando = Hesperando - 2;
                Oesperando--;
                Hespera.release(2);
                mutex.release();
                HacerAgua();
            } else {
                mutex.release();
                Oespera.acquire();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void Hlisto(){
        try {
            mutex.acquire();
            Hesperando++;
            System.out.println("Se agregó un átomo de hidrogeno.");

            if(Hesperando>=2 && Oesperando>=1){
                Oesperando--;
                Hesperando = Hesperando - 2;
                Oespera.release();
                mutex.release();
                HacerAgua();
            }else{
                mutex.release();
                Hespera.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void HacerAgua() {
        try {
        
            if(recipiente.tryAcquire()){
                System.out.println("Se agregó una molécula de agua al recipiente! Quedan: " + recipiente.availablePermits() + " espacios.");
            }else{
                System.out.println("El recipiente está lleno. No se pudo agregar.");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
