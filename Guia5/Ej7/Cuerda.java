package Guia5.Ej7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore sEspera = new Semaphore(0);
    private Semaphore cantP = new Semaphore(5);
    private int cantB = 0;
    private int dir = 0;

    public Cuerda() {

    }

    // 1 = Derecha. 2 = izquierda. 0 = neutro
    public boolean intentarBalancear(char d) {
        boolean res = false;
        try {
            mutex.acquire();
            if (dir == 0) {
                if (d == 'D') {
                    res = true;
                    dir = 1;
                } else {
                    res = true;
                    dir = 2;
                }
            } else if (dir == 1 && d == 'D') {
                res = true;
            } else if (dir == 2 && d == 'I') {
                try {
                    res = true;
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } catch (InterruptedException ie) {

        }
        mutex.release();
        return res;
    }

    public void balancearse() throws InterruptedException {
        cantP.acquire();
        cantB++;
    }

    public void dejarBalancearse() {
        try {
            mutex.acquire();
            cantB--;
            if (cantB == 0) {
                dir = 0;
            }
            cantP.release();
            sEspera.release();
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperar() {
        try {
            sEspera.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
