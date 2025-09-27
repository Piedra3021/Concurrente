package Guia3.Ej6;

public class contador {
    private int resultado = 0;

    public contador(){

    }

    public int getResultado() {
        return resultado;
    }

    public synchronized int sumar(int num){
        System.out.println(Thread.currentThread().getName() + " está sumando " + num);
        resultado = resultado + num;
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    
}
