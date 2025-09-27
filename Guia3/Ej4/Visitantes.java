package Guia3.Ej4;

import java.util.Random;

public class Visitantes implements Runnable {
    private Area[] areas;

    public Visitantes(Area[] area) {
        this.areas = area;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
           int area = this.obtenerArea();
            if (area > 0 && area < areas.length) {
                System.out.println("El " + Thread.currentThread().getName() + " está intentando ocupar el lugar " + area);
                if (areas[area].ocupar()) {
                    System.out.println("El area fue ocupada con éxito! (" + Thread.currentThread().getName() + " area " + area + ")");
                    try {
                        Thread.sleep(1000);
                        areas[area].dejarDeOcupar();
                        System.out.println("El area " + area + " ha sido desocupada.");
                    } catch (Exception e) {
                        System.out.println("Se produjo un error.");
                    }
                } else {
                    System.out.println("Esta area está ocupada! (" + Thread.currentThread().getName() + " area " + area + ")");
                }
            }
        }
    }

    public int obtenerArea(){
            Random num = new Random();

            int numR = num.nextInt(6);

            return numR;
        }
}
