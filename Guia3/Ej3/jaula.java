package Guia3.Ej3;

public class jaula {
    public static void main(String[] args) {
        plato p = new plato();
        rueda r = new rueda();
        hamaca h = new hamaca();
        hamsters[] hamster = new hamsters[6];
        Thread[] hilos = new Thread[6];

        for(int i = 0; i<hamster.length; i++){
            hamster[i] = new hamsters(p, r, h);
        }

        for(int i = 0; i<hilos.length;i++){
            hilos[i] = new Thread(hamster[i], "Hamster " + i);
        }

        for(int i = 0; i<hilos.length;i++){
            hilos[i].start();
        }
    }
}
