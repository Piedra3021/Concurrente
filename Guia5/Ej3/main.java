package Guia5.Ej3;

public class main{
    public static void main(String[] args) {
        recipienteDeAgua recipiente = new recipienteDeAgua(1);
        Oxigeno ox1 = new Oxigeno(recipiente);
        Oxigeno ox2 = new Oxigeno(recipiente);
        Hidrogeno[] hidros = new Hidrogeno[6];
        Thread[] hilos = new Thread[6];
        for(int i = 0; i < hilos.length;i++){
            hidros[i] = new Hidrogeno(recipiente);
            if(i==0){
                hilos[i] = new Thread(ox1);
            }else if(i==3){
                hilos[i] = new Thread(ox2);
            }else{
                hilos[i] = new Thread(hidros[i]);
            }
        }

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}