package Guia5.Ej7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore sEsperaIzq = new Semaphore(0);
    private Semaphore sEsperaDer = new Semaphore(0);
    private Semaphore cantP = new Semaphore(5);
    private int cantB = 0;
    private int dir = 0;
    private int RL = 0;
    private int LR = 0;

    public Cuerda() {

    }

    // 1 = Derecha. 2 = izquierda. 0 = neutro
    public boolean intentarBalancear(char d) {
        boolean res = false;
        try {
            mutex.acquire();
            if (dir == 0) {
                if (d == 'D' && cantB < 5) {
                    res = true;
                    dir = 1;
                    cantB++;
                } else if (cantB < 5) {
                    res = true;
                    dir = 2;
                    cantB++;
                }
            } else if (dir == 1 && d == 'D' && cantB < 5) {
                res = true;
                cantB++;
            } else if (dir == 2 && d == 'I' && cantB < 5) {
                res = true;
                cantB++;
            }
        } catch (InterruptedException ie) {

        }
        mutex.release();
        return res;
    }

    public void balancearse(char d) throws InterruptedException {
        cantP.acquire();
        if (d == 'D') {
            System.out.println(Thread.currentThread().getName() + " se balanceó de derecha a izquierda");
        } else {
            System.out.println(Thread.currentThread().getName() + " se balanceó de izq a der");
        }
    }

    public void dejarBalancearse(char d) {
        try {
            mutex.acquire();
            cantB--;
            cantP.release();
            if (cantB == 0) {
                dir = 0;
                if (d == 'D' && RL != 0) {
                    sEsperaDer.release(RL);
                    RL = 0;
                } else if (d == 'D') {
                    sEsperaIzq.release();
                    LR--;
                } else if (d == 'I' && LR != 0) {
                    sEsperaIzq.release(LR);
                    LR = 0;
                } else {
                    sEsperaDer.release();
                    RL--;
                }
            } else {
                if (d == 'D') {
                    sEsperaDer.release();
                    if (RL > 0) {
                        RL--;
                    }
                } else {
                    sEsperaIzq.release();
                    if (LR > 0) {
                        LR--;
                    }
                }
            }
            mutex.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperar(char d) {
        try {
            if (d == 'D') {
                mutex.acquire();
                RL++;
                mutex.release();
                sEsperaDer.acquire();
            } else {
                mutex.acquire();
                LR++;
                mutex.release();
                sEsperaIzq.acquire();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
