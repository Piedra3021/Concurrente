package Guia5.Ej7v2;

class BabuinoDer implements Runnable {
    private ControlCuerda control;

    public BabuinoDer(ControlCuerda c) {
        this.control = c;
    }

    public void run() {
        try {
            control.entrarDerecha();
            System.out.println(Thread.currentThread().getName() + " cruzando R->L");
           // Thread.sleep((int) Math.random() * 10000); // simula cruce
            control.salirDerecha();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}