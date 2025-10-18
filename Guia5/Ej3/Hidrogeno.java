package Guia5.Ej3;

public class Hidrogeno extends Atomo implements Runnable {
    public Hidrogeno(char t, recipienteDeAgua r){
        super(t,r);
    }

    public void run(){
        recipiente.Hlisto();

    }
}
