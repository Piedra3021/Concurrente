package PracticaParcial.Ej1;

public class Parque {
    private Tobogan t1;
    private Tobogan t2;

    public Parque(Tobogan t1, Tobogan t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public void pararseTobogan(int i){
        try {
            if(i == 0){
                t1.lanzarse();
            }else{
                t2.lanzarse();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void salirTobogan(int i){
        try {
            if(i == 0){
                t1.salirTobogan();
            }else{
                t2.salirTobogan();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    

}
