package Guia3.Ej3;

public class hamaca {
    private boolean libre = true;

    public hamaca(){

    }

    public synchronized boolean accederHamaca(){
        boolean retorno = false;
        if(libre){
            retorno = true;
            libre = false;
        }
        return retorno;
    }

    public synchronized void dejarDeHamacarse(){
        libre = true;
    }

}
