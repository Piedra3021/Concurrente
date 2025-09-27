package Guia3.Ej5;

import java.util.Random;

public class Auto extends Vehiculo implements Runnable {

    private int combustible = 100;
    private Surtidor surtidor;

    public Auto(String pat, String mod, String mar, Surtidor surt) {
        super(pat, mod, mar);
        this.surtidor = surt;
    }

    public void run() {
        int surtido;
        System.out
                .println("El auto " + toString() + "(" + Thread.currentThread().getName() + ")" + " empezó a moverse");

        while (this.combustible > 0) {
            consumirCombustible();
            System.out.println("El auto " + toString() + "(" + Thread.currentThread().getName() + ") avanzó");

            if (estaReserva()) {
                if (surtidor.entrarSurtidor()) {
                    try {
                        surtido = surtidor.consumir(this.combustible);
                        Thread.sleep(100);
                        surtidor.dejarSurtidor();
                        this.combustible = this.combustible + surtido;
                    } catch (InterruptedException ie) {
                        System.out.println("Se produjo un error.");
                    }
                }
            }
            try{
                Thread.sleep(200);
            }catch(InterruptedException ie){
                System.out.println("Se produjo un error.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " se quedó sin combustible.");

    }

    public void consumirCombustible() {
        Random random = new Random();

        int consumo = (random.nextInt(25)) + 1;
        if (combustible < consumo) {
            combustible = 0;
        } else {
            combustible = combustible - consumo;
        }

        System.out.println(Thread.currentThread().getName() + " consumió " + consumo + " su combustible actual es: "
                + combustible);
    }

    public boolean estaReserva() {
        return (combustible < 25);
    }

    @Override
    public String toString() {
        return ("[" + getMarca() + " " + getModelo() + " " + getPatente() + "]");
    }

}
