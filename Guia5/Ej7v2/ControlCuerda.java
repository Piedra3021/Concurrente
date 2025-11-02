package Guia5.Ej7v2;

import java.util.concurrent.Semaphore;

class ControlCuerda {

    int enCuerda = 0; // Babuinos actualmente cruzando
    int direccionActual = 0; // 0 = libre, 1 = L→R, -1 = R→L
    int cruzadosL = 0; // Contador de los que cruzaron de izquierda
    int cruzadosR = 0; // Contador de los que cruzaron de derecha

    private Semaphore mutex = new Semaphore(1); // protege variables compartidas
    private Semaphore limite = new Semaphore(5); // máximo 5 babuinos a la vez
    private Semaphore turno = new Semaphore(1); // asegura una sola dirección
    private Semaphore EsperarCambio = new Semaphore(0); // Espera el cambio

    public void entrarIzquierda() throws InterruptedException {
        mutex.acquire();
        if (direccionActual == -1) { // si vienen del otro lado
            mutex.release();
            EsperarCambio.acquire(); // espera hasta que terminen los R→L
            mutex.acquire();
            direccionActual = 1;
        } else if (direccionActual == 0) {
            direccionActual = 1; // cuerda libre, toma el sentido
        }

        enCuerda++;
        if (enCuerda == 1) {
            turno.acquire(); // bloquea el otro sentido
        }
        mutex.release();
        limite.acquire(); // espera si hay 5 babuinos en la cuerda
    }

    public void salirIzquierda() {
        limite.release(); // libera un lugar
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
        }
        enCuerda--;
        if (enCuerda == 0) {
            direccionActual = 0; // cuerda libre
            EsperarCambio.release(); // permite paso al otro lado
        }
        turno.release();
        cruzadosL++;
        mutex.release();
    }

    public void entrarDerecha() throws InterruptedException {
        mutex.acquire();
        if (direccionActual == 1) { // si vienen los del otro lado
            mutex.release();
            EsperarCambio.acquire();
            mutex.acquire();
            direccionActual = -1;
        } else if (direccionActual == 0) {
            direccionActual = -1;
        }

        enCuerda++;
        if (enCuerda == 1) {
            turno.acquire();
        }
        mutex.release();
        limite.acquire();
    }

    public void salirDerecha() {
        limite.release();
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
        }
        enCuerda--;
        if (enCuerda == 0) {
            direccionActual = 0;
            EsperarCambio.release();
        }
        turno.release();
        cruzadosR++;
        mutex.release();
    }
}
