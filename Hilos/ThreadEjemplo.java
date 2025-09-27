package Hilos;

public class ThreadEjemplo implements Runnable {
    String nombre;

    public ThreadEjemplo(String nombre){
        this.nombre = nombre;
    }
  
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(i + " " + Thread.currentThread().getName());
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadEjemplo te1 = new ThreadEjemplo("Maria Jose");
        Thread t1 = new Thread(te1, "Maria Jose");
        ThreadEjemplo te2 = new ThreadEjemplo("Jose Maria");
        Thread t2 = new Thread(te2, "Jose Maria");
        t1.start();
        t2.start();
       
        System.out.println("Termina thread main");
    }
}
