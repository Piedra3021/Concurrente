package Guia5.Ej3;

public class Oxigeno extends Atomo implements Runnable {
    public Oxigeno(char t, recipienteDeAgua r){
        super(t, r);
    }


    public void run(){
        recipiente.Olisto();

    }
}
