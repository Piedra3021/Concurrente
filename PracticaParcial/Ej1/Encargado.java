package PracticaParcial.Ej1;

import java.util.Random;

public class Encargado implements Runnable {
    private Sync sincronizador;
    private int cantClientes;

    public Encargado(Sync sinc, int cant) {
        this.sincronizador = sinc;
        this.cantClientes = cant;
    }

    public void run() {
        int i = 0;
        while (i < cantClientes) {
            sincronizador.accionEncargado();
            try {
                System.out.println(Thread.currentThread().getName() + " está eligiendo el tobogan.");
                Thread.sleep(500);

            } catch (Exception e) {
                // TODO: handle exception
            }
            sincronizador.notificarCliente();
            i++;
        }
    }

    public int elegirTobogan() {
        Random random = new Random();
        int num = random.nextInt(2);
        System.out.println("El encargado ha seleccionado el tobogan " + (num+1) + " para el cliente " + Thread.currentThread().getName());
        return num;
    }
}
