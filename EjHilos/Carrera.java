package EjHilos;

public class Carrera {

    public static Corredor verificarDistancia(Corredor[] corredores){
            Corredor ganador = null;

            int longitud = corredores.length;

            try{
            for(int i=0;i<longitud;i++){
                    if(i==0){
                        ganador = corredores[i];
                    }else{
                        if(corredores[i].getAvance() > ganador.getAvance()){
                            ganador = corredores[i];
                        }
                    }
                } 
            }catch (NullPointerException np){
                System.out.println("el arreglo no estaba completo!");
            }
            return ganador;
        }
    public static void main(String[] args) {

        
        
    Corredor[] corredores = new Corredor[6];
    /*for(int i = 0; i<5;i++){ 
        String nombre = "Corredor " + (i+1);
        Corredor corredor = new Corredor(nombre);
        corredores[i] = corredor;
    }*/

    corredores[0] = new Corredor("P");
    corredores[1] = new Corredor("G");
    corredores[2] = new Corredor("F");
    corredores[3] = new Corredor("M");
    corredores[4] = new Corredor("J");
    corredores[5] = new Corredor("D");

    Thread c1 = new Thread(corredores[0], corredores[0].getNombre());
    Thread c2 = new Thread(corredores[1], corredores[1].getNombre());
    Thread c3 = new Thread(corredores[2], corredores[2].getNombre());
    Thread c4 = new Thread(corredores[3], corredores[3].getNombre());
    Thread c5 = new Thread(corredores[4], corredores[4].getNombre());
    Thread c6 = new Thread(corredores[5], corredores[5].getNombre());

    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();
    c6.start();


    try{
        c1.join();
        c2.join();
        c3.join();
        c4.join();
        c5.join();
        c6.join();
    }catch(Exception e){
        System.out.println("Ocurrio un error.");
    }


    Corredor ganador = verificarDistancia(corredores);

    System.out.println("El corredor que más distancia recorrió fue: " + ganador.getNombre() + " un total de " + ganador.getAvance() + " pasos.");

    }
}
