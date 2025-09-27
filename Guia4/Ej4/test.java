package Guia4.Ej4;

public class test {
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[15];
        Impresora[] impresoras = new Impresora[5];
        Thread[] hilos = new Thread[15];
        SalaDeEspera salaDeEspera = new SalaDeEspera();
        GestorImpresoras gestor;

        for(int i = 0; i < impresoras.length; i++){
            impresoras[i] = new Impresora();
        }

        gestor = new GestorImpresoras(impresoras);

        for(int i = 0; i < clientes.length; i++){
            clientes[i] = new Cliente("Cliente " + i, i + "" + i + "" + i, gestor, salaDeEspera);
            hilos[i] = new Thread(clientes[i], "Cliente " + i);
        }

        for(int i = 0; i < clientes.length; i++){
            hilos[i].start();
        }

    }
}
