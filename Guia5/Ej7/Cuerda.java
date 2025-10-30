package Guia5.Ej7;

import java.util.concurrent.Semaphore;

public class Cuerda {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore cantP = new Semaphore(5);
    private int cantB = 0;
    private int dir = 0;
    private int cantBal = 0;

    public Cuerda() {

    }

    // 1 = Derecha. 2 = izquierda. 0 = neutro
    public boolean intentarBalancear(char d) {
        boolean res = false;
        if (dir == 0) {
            if (d == 'D') {
                try {
                    mutex.acquire();
                    res = true;
                    dir = 1;
                    mutex.release();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }else{
                try {
                    mutex.acquire();
                    res = true;
                    dir = 2;
                    mutex.release();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }else if(dir == 1 && d=='D'){
            try {
                    mutex.acquire();
                    res = true;
                    mutex.release();
                } catch (Exception e) {
                    // TODO: handle exception
                }
        }else if(dir==2 && d=='I'){
            try {
                    mutex.acquire();
                    res = true;
                    mutex.release();
                } catch (Exception e) {
                    // TODO: handle exception
                }
        }

        return res;
    }

    public void balancearse() throws InterruptedException{
        cantP.acquire();
        System.out.println(Thread.currentThread().getName() + " se balanceó. Se han balanceado: " + cantBal);
    }

    public void dejarBalancearse(){
        try {
                    mutex.acquire();
                    cantB--;
                    if(cantB==0){
                        dir=0;
                    }
                    cantP.release();
                    mutex.release();
                } catch (Exception e) {
                    // TODO: handle exception
                }
    }
}
