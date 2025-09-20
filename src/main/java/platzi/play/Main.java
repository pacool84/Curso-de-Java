package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static final String VERSION = "1.0.0"; // final - constante, no se puede modificar o reasignar "Inmutable"
    public static final String NOMBRE_PLATAFORMA = "Hello My Friend JAVA 👋🏻 ";

    public static void main(String[] args) {

        System.out.println( NOMBRE_PLATAFORMA + " v" +  VERSION);

//        // Leer desde consola
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Cual es tu nombre? ");
//        String nombre = scanner.nextLine();
//
//        System.out.println("👋🏻 Hola mi buen amigo " + nombre);
//
//        System.out.println(nombre +  " Cuantos años tienes? ");
//        int edad = scanner.nextInt();
//
//        System.out.println(nombre + " ahora se que tienes la edad de " + edad + " años");

        // Trabajando con las utilerías de ScannerUtils
        String nombre = ScannerUtils.capturarTexto("Nombre del contenido: "); //Se puede realizar el ScannerUtils.capturarTexto por ser un método estático "static"
        String genero = ScannerUtils.capturarTexto("Genero del contenido: ");
        int duracion = ScannerUtils.capturarEntero("Duración del contenido (minutos): ");
        double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido (0 - 5): ");

        // Creación de objetos
        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion); // Instancia de la clase Pelicula

//        pelicula.descripcion = "A computer hacker learns from mysterious rebels about the true nature of his reality";
//        pelicula.calificacion = calificacion;


//        pelicula.titulo = nombre; // Asignación de valor al atributo titulo
//        pelicula.duracion = duracion;
//        pelicula.genero = genero;
//        pelicula.fechaEstreno = LocalDate.of(2015, 10, 15);
//        pelicula.disponible = true;

        System.out.println(pelicula.obtenerFichaTecnica());

        // Casting de tipos de datos
//        long duracionLong = pelicula.duracion; // Conversión-CAST implícita de int a long
//        int calificacionInt = (int) pelicula.calificacion; // Conversión-CAST explícita de double a int, se pierde la parte decimal
//        long numeroDePremios = (int) Long.parseLong("25"); // Conversión-CAST explícita de String a long,
//
//        System.out.println("------CASTING DE TIPOS DE DATOS------");
//        System.out.println("Duración Long: " + duracionLong);
//        System.out.println("Calificación Int: " +  calificacionInt);
//        System.out.println("Números de premios: " + numeroDePremios);
//
//        // Uso de métodos
//        System.out.println("------FICHA TÉCNICA DE LA PELÍCULA------");
//        System.out.println(pelicula.obtenerFichaTecnica());
//        System.out.println("Es popular? " + pelicula.esPopular());
//
//        // Nueva instancia para usuario
        Usuario usuario = new Usuario("Sebastian", "chevy@hotmail.com");
//        usuario.nombre = "Sebastian";
//        usuario.fechaRegistro = LocalDateTime.of(2025, 12, 24, 17, 15, 14);
//
        System.out.println("------USUARIO VIENDO PELÍCULA------");
        usuario.ver(pelicula);
//        System.out.println(usuario.fechaRegistro);
    }
}
