package Guia3.Ej3;

public class hamsters implements Runnable {
    private plato p;
    private rueda r;
    private hamaca h;

    public hamsters(plato pl, rueda ru, hamaca ha) {
        this.p = pl;
        this.r = ru;
        this.h = ha;
    }

    public void run() {
        boolean comio = false;
        boolean rodo = false;
        boolean hamaco = false;

        while (!(comio && rodo && hamaco)) {
            if (!comio && p.accederPlato()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " esta comiendo");
                    Thread.sleep(200);
                    p.dejarPlato();
                    comio = true;
                } catch (Exception e) {
                    System.out.println("Se produjo un error.");
                }
            } else if (!rodo && r.accederRueda()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " esta durmiendo");
                    Thread.sleep(200);
                    r.dejarRueda();
                    rodo = true;
                } catch (Exception e) {
                    System.out.println("Se produjo un error.");
                }
            } else if (!hamaco && h.accederHamaca()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " se esta hamacando");
                    Thread.sleep(200);
                    h.dejarDeHamacarse();
                    hamaco = true;
                } catch (Exception e) {
                    System.out.println("Se produjo un error.");
                }
            }else{
                try{
                Thread.sleep(200);
            }catch(Exception e){
                System.out.println("Se produjo un error.");
            }
            }
        }
    }
}
