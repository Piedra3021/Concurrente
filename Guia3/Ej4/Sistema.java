package Guia3.Ej4;

public class Sistema {
    public static void main(String[] args) {
        Area[] areas = new Area[6];
        Visitantes[] visitantes = new Visitantes[6];
        Thread[] hilos = new Thread[6];

        for(int i = 0; i< areas.length; i++){
            areas[i] = new Area();
        }

        for(int i = 0; i<visitantes.length;i++){
            visitantes[i] = new Visitantes(areas);
        }

        for(int i = 0; i<hilos.length;i++){
            hilos[i] = new Thread(visitantes[i], "Visitante " + i);
        }

        for(int i = 0; i<hilos.length;i++){
            hilos[i].start();
        }
    }
    
}
