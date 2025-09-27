package Guia3.Ej7;

public class cadena {
    private String cadena = "";
    private boolean libre = true;
    private int turno = 0;
    // 1 = A, 2 = B, 3 = C

    public cadena() {

    }

    public boolean empezarAgregar(char Carac) {
        boolean resultado = false;
        System.out.println(Carac + " está intentando agregar en turno " + turno);
        if (libre) {
            if ((turno == 0 && Carac == 'A') || (turno == 1 && Carac == 'B') || (turno == 2 && Carac == 'C')) {
                libre = false;
                resultado = true;
            }

        }
        return resultado;
    }

    public synchronized void agregarCadena(String cad) {
        cadena = cadena + cad;
    }

    public void dejarAgregar() {
        turno = ((turno + 1) % 3);
        libre = true;
    }

    public String getCadena() {
        return cadena;
    }

}
