package Hilos;

/*public class MiHilo implements Runnable {
    String nombreHilo;

   public MiHilo(String nombre){
    this.nombreHilo = nombre;
   }

    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aquí
    public void run() {
        System.out.println("Comenzando " + nombreHilo);
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + nombreHilo + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando " + nombreHilo);
    }*/
    public class MiHilo extends Thread{

        public MiHilo(String nombre){
            super(nombre);
        }

        public void run() {
        System.out.println("Comenzando " + Thread.currentThread().getName());
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + Thread.currentThread().getName() + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(Thread.currentThread().getName() + "Interrumpido.");
        }
        System.out.println("Terminando " + Thread.currentThread().getName());
    }
}
