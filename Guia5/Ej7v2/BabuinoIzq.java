package Guia5.Ej7v2;

class BabuinoIzq implements Runnable {
    private ControlCuerda control;

    public BabuinoIzq(ControlCuerda c) {
        this.control = c;
    }

    public void run() {
        try {
            control.entrarIzquierda();
            System.out.println(Thread.currentThread().getName() + " cruzando L->R");
           // Thread.sleep((int) Math.random() * 10000); // simula cruce
            control.salirIzquierda();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
