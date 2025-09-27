package Guia3.Ej3;

public class plato {
    private boolean libre = true;

    public synchronized boolean accederPlato(){
        boolean retorno = false;
        if(libre){
            retorno = true;
            libre = false;
        }
        return retorno;
    }

    public synchronized void dejarPlato(){
        libre = true;
    }
}
