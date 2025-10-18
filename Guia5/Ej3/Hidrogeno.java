package Guia5.Ej3;

public class Hidrogeno extends Atomo implements Runnable {
    public Hidrogeno( recipienteDeAgua r){
        super(r);
    }

    public void run(){
        recipiente.Hlisto();

    }
}
