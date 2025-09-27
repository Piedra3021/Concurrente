package Guia3.Ej7;

public class escritores implements Runnable {
    private char caracter;
    private int cantidad;
    private cadena cad;

    public escritores(char carac, int cant, cadena cade) {
        this.caracter = carac;
        this.cantidad = cant;
        this.cad = cade;
    }

    public void run() {
        String cadena = this.generarCadena();
        int cantidad = 0;
        while (cantidad < 3) {
            if (cad.empezarAgregar(caracter)) {
                cad.agregarCadena(cadena);
                cad.dejarAgregar();
                cantidad++;
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException ie){
                System.out.println("Se produjo un error.");
            }
        }

    }

    public String generarCadena() {
        String retorno = "";
        for (int i = 0; i < cantidad; i++) {
            retorno = retorno + caracter;
        }
        return retorno;
    }
}
