package Guia5.Ej7;

public class test {
    public static void main(String[] args){
        Babuino[] babuinos = new Babuino[17];
        Thread[] hilos = new Thread[17];
        Cuerda c = new Cuerda();

        for(int i = 0; i < babuinos.length;i++){
            if(i%2==0 || i == babuinos.length-2){
                babuinos[i] = new Babuino('I', c);
                
            }else{
                babuinos[i] = new Babuino('D', c);
            }
            hilos[i] = new Thread(babuinos[i], "Babuino " + i);
        }

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
    }
}
