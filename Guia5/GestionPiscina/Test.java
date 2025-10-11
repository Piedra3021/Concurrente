package Guia5.GestionPiscina;

public class Test {
    public static void main(String[] args) {
        Persona[] personas = new Persona[10];
        Thread[] hilos = new Thread[10];
        GestorPiscina piscina = new GestorPiscina();

        for(int i = 0; i < personas.length; i++){
            personas[i] = new Persona("Persona " + (i+1), piscina);
            hilos[i] = new Thread(personas[i], "Persona " + (i+1));
        }

        for(int i =0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}
