package PracticaParcial.Ej2;

public class test {
    //Imagenes, Aplicacion
    //Sincronizador
    //espacioEdicion

    public static void main(String[] args) {
        Imagen[] imagenes = new Imagen[10];
        Sincronizador sync = new Sincronizador();
        espacioEdicion espacio = new espacioEdicion();
        Espera sala = new Espera();
        Aplicacion app = new Aplicacion(sync);
        Thread[] hilos = new Thread[11];

        for(int i = 0; i<imagenes.length;i++){
            imagenes[i] = new Imagen(i+i+i+i+"", sala, espacio, sync);
            hilos[i] = new Thread(imagenes[i], "imagen " + i);
        }

        hilos[(hilos.length-1)] = new Thread(app, "Photo editor");

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}
