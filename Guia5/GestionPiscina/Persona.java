package Guia5.GestionPiscina;

public class Persona implements Runnable {
    public String nombre;
    public GestorPiscina piscina;

    public Persona(String nombre, GestorPiscina p){
        this.nombre = nombre;
        this.piscina = p;
    }

    public void run(){
        piscina.entrarSalaDeEspera();
        piscina.entrarPiscina();
        piscina.dejarSalaEspera();
        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            // TODO: handle exception
        }
        piscina.dejarPiscina();

    }
}
