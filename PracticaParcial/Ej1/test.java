package PracticaParcial.Ej1;

public class test {
    public static void main(String[] args) {
        Sync sincronizador = new Sync();
        Persona[] personas = new Persona[6];
        Thread[] hilos = new Thread[7];
        Tobogan t1 = new Tobogan();
        Tobogan t2 = new Tobogan();
        Parque parque = new Parque(t1, t2);
        
        Encargado encargado = new Encargado(sincronizador, personas.length);
        Espera sEspera = new Espera();

        for(int i = 0; i < personas.length; i++){
            personas[i] = new Persona(sincronizador, sEspera, parque, encargado);
            hilos[i] = new Thread(personas[i], "Persona " + (i+1));

        }

        hilos[6] = new Thread(encargado, "Encargado");

        for(int i = 0; i < hilos.length; i++){
            hilos[i].start();
        }
        
    }
}
