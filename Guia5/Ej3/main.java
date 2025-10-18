package Guia5.Ej3;

public class main{
    public static void main(String[] args) {
        recipienteDeAgua recipiente = new recipienteDeAgua(2);
        Thread[] hilos = new Thread[9];
        for(int i = 0; i < hilos.length;i++){
            if(i%3==0){
                hilos[i] = new Thread(new Oxigeno(recipiente));
            }else{
                hilos[i] = new Thread(new Hidrogeno(recipiente));
            }
        }

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}