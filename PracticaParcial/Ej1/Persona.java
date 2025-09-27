package PracticaParcial.Ej1;

public class Persona implements Runnable{
    private Sync sincronizador;
    private Espera sEspera;
    private Parque parqueA;
    private Tobogan t1;
    private Tobogan t2;
    private Encargado encargado;

    

    public Persona(Sync sincronizador, Espera sEspera, Parque parqueA, Encargado encargado) {
        this.sincronizador = sincronizador;
        this.sEspera = sEspera;
        this.parqueA = parqueA;
        this.encargado = encargado;
    }



    public void run(){
        
        sEspera.esperar();
        sincronizador.notificarEncargado();
        int t = encargado.elegirTobogan();
        parqueA.pararseTobogan(t);
        sincronizador.accionCliente();
        sEspera.salirEspera();
        parqueA.salirTobogan(t);

    }
}
