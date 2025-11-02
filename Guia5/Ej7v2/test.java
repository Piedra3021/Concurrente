package Guia5.Ej7v2;

public class test {
    public static void main(String[] args) {
        BabuinoDer[] babuinosD = new BabuinoDer[17];
        BabuinoIzq[] babuinoI = new BabuinoIzq[17];
        Thread[] hilos = new Thread[17];
        ControlCuerda c = new ControlCuerda();

        for (int i = 0; i < hilos.length; i++) {
            if (i % 2 == 0 || i == hilos.length - 2) {
                babuinoI[i] = new BabuinoIzq(c);
                hilos[i] = new Thread(babuinoI[i], "Babuino " + i);

            } else {
                babuinosD[i] = new BabuinoDer(c);
            hilos[i] = new Thread(babuinosD[i], "Babuino " + i);
            }
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
