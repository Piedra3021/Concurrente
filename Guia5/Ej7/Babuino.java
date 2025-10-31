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
            exito = cuerda.intentarBalancear(direccion);
            if (exito) {
                System.out.println(Thread.currentThread().getName() + " se logró balancear. Dirección: " + direccion);

                try {
                    cuerda.balancearse();
                    balanceo = true;
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " Se dejó de balancear");
                    cuerda.dejarBalancearse();
                } catch (Exception e) {

                }
            } else {
                System.out.println(Thread.currentThread().getName() + " no pudo balancearse. Dirección: " + direccion);
                cuerda.esperar();

            }
        }
    }
}
