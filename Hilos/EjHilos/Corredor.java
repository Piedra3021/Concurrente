package Hilos.EjHilos;

public class Corredor implements Runnable {
    String nombre;
    int avance;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.avance = 0;
    }



    public String getNombre() {
        return nombre;
    }


    public int getAvance() {
        return avance;
    }


    public void run() {
        try {
            while (this.avance < 100) {
                this.avanzar();
                Thread.sleep(400);
            }
        } catch (Exception e) {
            System.out.println("Corredor: " + this.nombre + " No se ejecutó correctamente.");
        }
        System.out.println(nombre + " finalizó la carrera!");
        
    }

    public void avanzar() {
        int cant = (int) (Math.random() * 10) + 1;
        this.avance = this.avance + cant;
        System.out.println(this.nombre + " avanzó.");
    }
}
