package Guia5.Ej3;

public class main{
    public static void main(String[] args) {
        int x = 6;
        recipienteDeAgua recipiente = new recipienteDeAgua(x);
        Thread[] hilos = new Thread[15];
        for(int i = 0; i < hilos.length;i++){
            if(i%3==0){
                hilos[i] = new Thread(new Oxigeno(recipiente));
            }else{
                hilos[i] = new Thread(new Hidrogeno(recipiente));
            }
        }


        System.out.println("Cantidad de espacios disponibles en el recipiente: " + x);
        System.out.println("Cantidad de átomos: " + hilos.length);
        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}