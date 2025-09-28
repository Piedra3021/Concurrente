package PracticaParcial.Ej2;

public class Imagen implements Runnable{
    private String metadatos;
    private Espera sala;
    private espacioEdicion espacio;
    private Sincronizador sync;

    

    public Imagen(String metadatos, Espera sala, espacioEdicion espacio, Sincronizador sync) {
        this.metadatos = metadatos;
        this.sala = sala;
        this.espacio = espacio;
        this.sync = sync;
    }



    public void run(){

        sala.entrarSalaEspera();
        espacio.entrarEspacio();
        sala.salirEspera();
        sync.notificarApp();
        sync.actuarImagen();
        System.out.println(Thread.currentThread().getName() + " fue editada");
        try {
            System.out.println("Guardando...");
            Thread.sleep(750);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(Thread.currentThread().getName() + " fue guardada");
        espacio.salir();
        
    }
}
