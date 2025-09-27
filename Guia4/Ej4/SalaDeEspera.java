package Guia4.Ej4;

import java.util.concurrent.Semaphore;
public class SalaDeEspera {
    private Semaphore espera = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);
    private int contador = 0;

    public SalaDeEspera(){

    }

    public void permitirClientes(){
        espera.release();
    }

    public void entrarSalaDeEspera(){
        try {
            espera.acquire();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sumarContador(){
        try {
            mutex.acquire();
            contador++;
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void verificarSala(){
        try {
            mutex.acquire();
            if(contador>0){
                contador--;
                this.permitirClientes();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        mutex.release();
    }
}
