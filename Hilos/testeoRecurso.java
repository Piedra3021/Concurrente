package Hilos;

import ej7.Cliente;

public class testeoRecurso {
    public static void main(String[] args) {
        Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        ines.start();
        juan.start();
    }
}
