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

                try {
                    cuerda.balancearse(direccion);
                    balanceo = true;
                    Thread.sleep(2000);
                    cuerda.dejarBalancearse(direccion);
                } catch (Exception e) {

                }
            } else {
                cuerda.esperar(direccion);
                exito = cuerda.intentarBalancear(direccion);

            }
        }
    }
}
