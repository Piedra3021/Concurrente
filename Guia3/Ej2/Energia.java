package Guia3.Ej2;

public class Energia {
    private int energia = 10;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public synchronized void modifEnergia(String tipo) throws InterruptedException {
        if (energia > 0) {
            if (tipo.contains("criatura")) {
                if (energia < 3) {
                    energia = 0;
                } else {
                    energia = energia - 3;
                }
            } else {
                energia = energia + 3;
            }
            System.out.println("El hilo " + tipo + " modifico la energia. \nLa energia actual es: " + energia);
            if (energia <= 0) {
                System.out.println("La energía se ha acabado!");
            }
        } else {

            throw new InterruptedException("Error. Cantidad de energia insuficiente");
        }

    }
}
