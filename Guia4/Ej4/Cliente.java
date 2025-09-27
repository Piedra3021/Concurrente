package Guia4.Ej4;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private String impresion;
    private boolean impreso = false;
    private Impresora[] impresoras;
    private Semaphore semPermisos;

    public Cliente(String nom, String cad, Impresora[] impreso, int cantImpresoras) {
        this.nombre = nom;
        this.impresion = cad;
        this.impresoras = impreso;
        semPermisos = new Semaphore(cantImpresoras);
    }

    public void run2() {
        int i = 0;
        int longi = impresoras.length;

        while ((i < longi) && (!impreso)) {

            if (impresoras[i].intentarImprimir()) {
                try {
                    Thread.sleep(500);
                    System.out
                            .println("El cliente " + nombre + " imprimió " + impresion + " en la impresora " + (i + 1));
                    impresoras[i].dejarDeImprimir();
                    impreso = true;
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            } else {
                i++;

                if (i == longi) {
                    i = 0;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(nombre + " no pudo imprimir en ninguna. Está esperando...");
                }
            }

        }
    }

    public void run() {
        int i = 0;
        try {
            semPermisos.acquire();
        } catch (Exception e) {
            System.out.println(e);
        }
        while (!impreso && i<impresoras.length) {
            if (impresoras[i].intentarImprimir()) {
                try {
                    Thread.sleep(500);
                    System.out
                            .println("El cliente " + nombre + " imprimió " + impresion + " en la impresora " + (i + 1));
                    impresoras[i].dejarDeImprimir();
                    semPermisos.release();
                    impreso = true;
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            } else {
                i++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(i == impresoras.length){
                    i = 0;
                }
            }
        }
    }

}
