package Guia5.Ej3;

public class Oxigeno extends Atomo implements Runnable {
    public Oxigeno(recipienteDeAgua r){
        super(r);
    }


    public void run(){
        recipiente.Olisto();

    }
}
