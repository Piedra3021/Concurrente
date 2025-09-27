package Puerto;

import Avion.Avion;

public class pruebas {
    public static void main(String[] args) {
        Cliente c = new Cliente("Pedro", "Beltran", 30807303);
        Avion a = new Avion("AAAA", 32, 2025);

        Alquiler alq = new Alquiler(c, a);
        System.out.println(alq.toString());
    }

}
