package Guia3.Ej2;

public class Entidad implements Runnable {
    private String nombre;
    private Energia energia;

    public void run(){

        for(int i = 0; i < 3;i++){
        try{    
            energia.modifEnergia(this.nombre);
            Thread.sleep(500);
    }catch(InterruptedException ie){
       System.out.println(ie.getMessage());
    }
}
    }

    public Entidad(String n, Energia sc) {
        this.nombre = n;
        this.energia = sc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
