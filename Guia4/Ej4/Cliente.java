package Guia4.Ej4;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private String impresion;
    private GestorImpresoras tienda;
    private int cantImpresoras;
    private SalaDeEspera sala;

    public Cliente(String nom, String cad, GestorImpresoras t, SalaDeEspera se) {
        this.nombre = nom;
        this.impresion = cad;
        this.tienda = t;
        this.cantImpresoras = t.cantImpresoras();
        this.sala = se;
    }

    public void run() {
        boolean exito = false;
        while (!exito) {
            exito = this.imprimir();
            this.manejarSala(exito);
        }
    }

    public void manejarSala(boolean exito) {
        if (!exito) {
            sala.sumarContador();
            System.out.println(Thread.currentThread().getName() + " Entró a la sala de espera.");
            sala.entrarSalaDeEspera();
            System.out.println(Thread.currentThread().getName() + " Salió de la sala de espera.");
        } else {
            sala.verificarSala();
        }
    }

    public boolean imprimir() {
        boolean exito = false;
        int i = 0;
        while (i < cantImpresoras && !exito) {
            if (tienda.imprimir(i)) {
                System.out.println(Thread.currentThread().getName() + " Está imprimiendo en la impresoras " + i);
                exito = true;

                try {
                    Thread.sleep(1000);
                    System.out.println(
                            Thread.currentThread().getName() + " Terminó de imprimir. Liberó la impresora " + i);
                    tienda.dejarDeImprimir(i);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } else {
                i++;
            }
        }
        return exito;
    }
}
