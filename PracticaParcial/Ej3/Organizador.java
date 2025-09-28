package PracticaParcial.Ej3;

public class Organizador {
    private int turno = 1;
    private boolean finalizo = false;

    public Organizador() {

    }

    public boolean organizar(int oracion, int division) {
        boolean exito = false;
        synchronized (this) {
            if (turno == oracion) {
                exito = true;
                    System.out.println("División " + division + ": Oración " + oracion);
                turno++;
            }
        }
        return exito;
    }

}
