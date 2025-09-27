package Exceptions;

import java.util.*;

public class PruebaExcep {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*try {
            System.out.println("Ingrese su edad");
            int edad = sc.nextInt();
            System.out.println(verificarEdad(edad));
        } catch (ArithmeticException ea) {
            System.out.println(ea.getMessage());
        }*/

        try {
            System.out.println("Ingrese un numero de la ruleta! [1 | 3 | 5 | 7 | 9]");
            int num = sc.nextInt();
            System.out.println(ruleta(num));
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }
    }

    public static int verificarEdad(int edad) throws ArithmeticException {

        if (edad < 18) {
            throw new ArithmeticException("No tiene la edad suficiente");
        }

        return edad;
    }

    public static String ruleta(int num) throws ArithmeticException {

        if (num != 7) {
            throw new ArithmeticException("Mala suerte, sigue intentando!");
        }

        return "Felicidades!";
    }
}
