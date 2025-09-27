package Guia3.Ej5;

public class Ciudad {
    public static void main(String[] args) {
        Auto[] autos = new Auto[7];
        Thread[] hilos = new Thread[7];
        Surtidor surtidor = new Surtidor();

        for(int i = 0; i < autos.length; i++){
            autos[i] = new Auto("AF" + i, "modelo " + i, "Mazda", surtidor);
            hilos[i] = new Thread(autos[i], "auto " + i);
        }

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}
