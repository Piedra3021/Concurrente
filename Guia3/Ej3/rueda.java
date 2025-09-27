package Guia3.Ej3;

public class rueda {
    private boolean libre = true;

    public synchronized boolean accederRueda(){
        boolean retorno = false;
        if(libre){
            retorno = true;
            libre = false;
        }
        return retorno;
    }

    public synchronized void dejarRueda(){
        libre = true;
    }
}
