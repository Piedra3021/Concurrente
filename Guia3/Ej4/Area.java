package Guia3.Ej4;

public class Area {
    private boolean disponible = true;

    public Area() {
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public synchronized boolean ocupar() {
        boolean resultado = false;
        if (disponible == true) {
            this.disponible = false;
            resultado = true;
        }
        return resultado;
    }

    public synchronized void dejarDeOcupar(){
        this.disponible = true;
    }

}
