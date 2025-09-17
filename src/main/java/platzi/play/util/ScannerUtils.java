package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    // static.- nos permite definir que este atributo no depende de ningún objeto si no de la clase en general
    public static final Scanner SCANNER = new Scanner(System.in);

    // Método para capturar texto
    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    // Método para capturar enteros
    public static int capturarEntero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;

    }

    // Método para capturar decimales
    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;
    }
}
