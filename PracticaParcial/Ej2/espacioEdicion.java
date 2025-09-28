package PracticaParcial.Ej2;

import java.util.concurrent.Semaphore;

public class espacioEdicion {
    private Semaphore espacio = new Semaphore(1);

    public espacioEdicion(){

    }

    public void entrarEspacio(){
        try {
            espacio.acquire();
            System.out.println(Thread.currentThread().getName() + " entró al espacio de edición.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salir(){
        System.out.println(Thread.currentThread().getName() + " salió del espacio de edición.");
        espacio.release();
    }
}
