package PracticaParcial.Ej1;

import java.util.concurrent.Semaphore;

public class Tobogan {
    private Semaphore disponible = new Semaphore(1);

    public boolean intentarLanzarse(){
        return disponible.tryAcquire();
    }

    public void salirTobogan(){
        disponible.release();
    }

    public void lanzarse(){
        try {
            disponible.acquire();
            System.out.println(Thread.currentThread().getName() + " se lanzó.");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
