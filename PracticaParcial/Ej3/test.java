package PracticaParcial.Ej3;

public class test {
    public static void main(String[] args) {
        Organizador org = new Organizador();
        Division[] divisiones = new Division[5];
        String[] oraciones = new String[25];
        Thread[] hilos = new Thread[divisiones.length];

        for (int i = 0; i < oraciones.length; i++) {
            oraciones[i] = (i + 1) + "";
        }
        if(oraciones.length >= divisiones.length*2){
            for (int i = 0; i < divisiones.length; i++) {
                {
                    int ultima = ((divisiones.length * 2) + 1) - (i + 1);
                    if (ultima < oraciones.length) {
                        divisiones[i] = new Division(oraciones[i], oraciones[ultima], (i + 1),
                                (i + 1), ultima, org);
                    } else {
                        divisiones[i] = new Division(oraciones[i], oraciones[oraciones.length - 1], (i + 1),
                                (i + 1), oraciones.length, org);
                    }
                    hilos[i] = new Thread(divisiones[i]);
                }
            }

            for (int i = 0; i < hilos.length; i++) {
                hilos[i].start();
            }
        }else{
            System.out.println("nuh uh.");
        }
    }
}
