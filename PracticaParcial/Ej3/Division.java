package PracticaParcial.Ej3;

public class Division implements Runnable{
    private String o1;
    private String o2;
    private int division;
    private int or1;
    private int or2;
    private Organizador org;

    public Division(String o1, String o2, int div, int ora1, int ora2, Organizador orga){
        this.o1 = o1;
        this.o2 = o2;
        this.division = div;
        this.or1 = ora1;
        this.or2 = ora2;
        this.org = orga;
    }

    public void run(){
        int cont = 0;
        while(cont < 2){
            if(cont == 0){
                if(org.organizar(or1,division)){
                    cont++;
                }
            }else{
                if(org.organizar(or2,division)){
                    cont++;
                }
            }

            try {
                Thread.sleep(750);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }


}
