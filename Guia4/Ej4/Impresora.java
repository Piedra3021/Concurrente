package Guia4.Ej4;

import java.util.concurrent.Semaphore;

public class Impresora {
    private Semaphore sem1 = new Semaphore(1);

    public Impresora(){

    }

    public void imprimir(){
        try{
            sem1.acquire();
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
    }

    public void dejarDeImprimir(){
            sem1.release();
    }

    public boolean intentarImprimir(){
        return sem1.tryAcquire();
    }


}
