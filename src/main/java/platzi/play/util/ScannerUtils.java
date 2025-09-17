package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    // static.- nos permite definir que este atributo no depende de ningún objeto si no de la clase en general
    public static Scanner scanner = new Scanner(System.in);

    // Método para capturar texto
    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje + ": ");
        return scanner.nextLine();
    }

    // Método para capturar enteros
    public static int capturarEntero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;

    }

    // Método para capturar decimales
    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }
}
