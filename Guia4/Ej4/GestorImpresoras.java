package Guia4.Ej4;

public class GestorImpresoras {
  public static void main(String[] args) {
    Impresora[] impresoras = new Impresora[3];
    Cliente[] clientes = new Cliente[10];
    Thread[] hilos = new Thread[10];
    for(int i = 0; i < impresoras.length; i++){
        impresoras[i] = new Impresora();
    }

    for(int i = 0; i < clientes.length; i++){
        clientes[i] = new Cliente("Cliente " + (i+1), i + "" + i + "" + i +"" + i, impresoras,3);
        hilos[i] = new Thread(clientes[i], "Cliente " + i);
    }

    for(int i = 0; i < hilos.length; i++){
        hilos[i].start();
    }
  }

}
