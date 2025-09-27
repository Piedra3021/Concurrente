package Guia3.Ej7;

import java.util.zip.CRC32;

public class main {
    public static void main(String[] args) {
        cadena cad = new cadena();
        escritores[] letras = new escritores[3];
        Thread[] hilos = new Thread[3];

        letras[0] = new escritores('A', 3, cad);
        letras[1] = new escritores('B', 2, cad);
        letras[2] = new escritores('C', 5, cad);

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(letras[i]);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException ie) {
                System.out.println("Se produjo un error.");
            }
        }

        System.out.println(cad.getCadena());
    }
}
