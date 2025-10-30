package Guia5.Ej7;

public class Babuino implements Runnable {
    private char direccion;
    private Cuerda cuerda;
    private boolean balanceo = false;

    public Babuino(char d, Cuerda c) {
        this.direccion = d;
        this.cuerda = c;
    }

    public void run() {
        boolean exito = cuerda.intentarBalancear(direccion);
        while (!balanceo) {
            if (exito) {
                System.out.println(Thread.currentThread().getName() + " se logró balancear. Dirección: " + direccion);

                try {
                    cuerda.balancearse();
                    balanceo = true;
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                cuerda.dejarBalancearse();
            } else {
                System.out.println(Thread.currentThread().getName() + " no pudo balancearse. Espera");
            }
        }
    }
}
