package PracticaParcial.Ej2;

public class Aplicacion implements Runnable {
    private Sincronizador sync;

    public Aplicacion(Sincronizador sync) {
        this.sync = sync;
    }

    public void run() {
        while (true) {
            sync.actuarApp();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
            sync.notificarImagen();
        }
    }

}
