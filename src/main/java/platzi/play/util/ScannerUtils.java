package platzi.play.util;

import platzi.play.contenido.Genero;

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

        // Validar que el usuario ingrese un número válido
        while (!SCANNER.hasNextInt()) {
            System.out.println("Por favor ingresa un NÚMERO válido.");
            SCANNER.next(); // Limpiar la entrada inválida
        }

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;

    }

    // Método para capturar decimales
    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextDouble()) {
            System.out.println("Por favor ingresa un NÚMERO decimal válido.");
            SCANNER.next(); // Limpiar la entrada inválida
        }
        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;
    }

    // Método para capturar Generos
    public static Genero capturaGenero(String mensaje) {
        while(true) {
            String entrada = capturarTexto(mensaje);
            try {
                return Genero.valueOf(entrada.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Género inválido. Los géneros válidos son:");
                for (Genero genero : Genero.values()) {
                    System.out.println("- " + genero);
                }
            }

        }
    }
}
