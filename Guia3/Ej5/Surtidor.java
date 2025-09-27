package Guia3.Ej5;

public class Surtidor {

    private int combustibleMax = 1000;
    private boolean libre = true;

    public synchronized boolean entrarSurtidor(){
        System.out.println(Thread.currentThread().getName() + " está intentando entrar al surtidor.");
        boolean retorno = false;
        if(libre){
            libre = false;
            retorno = true;
            System.out.println(Thread.currentThread().getName() + " logró entrar al surtidor.");
        }else{
            System.out.println(Thread.currentThread().getName() + " no logró entrar al surtidor");
        }
        return retorno;
    }

    public synchronized int consumir(int comb){
        int cant = 100 - comb;
        if(combustibleMax > cant){
        combustibleMax = combustibleMax - cant;
        System.out.println("Se consumieron: " + cant + " del surtidor. Cantidad actual: " + combustibleMax);
}else{
    cant = combustibleMax;
    combustibleMax = 0;
    System.out.println("Se consumió toda la gasolina disponible.");
}
        return cant;
    }

    public synchronized void dejarSurtidor(){
        System.out.println(Thread.currentThread().getName() + " dejó el surtidor.");
        libre = true;
    }

}
