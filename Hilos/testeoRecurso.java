package Hilos;

import Hilos.ej7.Cliente;

public class testeoRecurso {
    public static void main(String[] args) {
        int[] carrito = {2,5,7,5,3};
        Cliente juan = new Cliente("Juan Lopez", carrito);
        Cliente ines = new Cliente("Ines Garcia", carrito);
        ines.start();
        juan.start();
    }
}
