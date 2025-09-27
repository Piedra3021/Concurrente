package ej7;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5,
                2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1,
                1 });
        long initialTime = System.currentTimeMillis();
        CajeroThread cajero1 = new CajeroThread("Cajero 1",cliente1,initialTime);
        CajeroThread cajero2 = new CajeroThread("Cajero 2",cliente2,initialTime);
        // Tiempo inicial de referencia

        Thread c1 = new Thread(cajero1);
        Thread c2 = new Thread(cajero2);
        c1.start();
        c2.start();
    }

    
}
