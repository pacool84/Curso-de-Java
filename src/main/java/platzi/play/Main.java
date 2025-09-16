package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello My Friend JAVA 👋🏻");

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

        // Creación de objetos
        Pelicula pelicula = new Pelicula(); // Instancia de la clase Pelicula
        pelicula.titulo = "The Matrix"; // Asignación de valor al atributo titulo
        pelicula.descripcion = "A computer hacker learns from mysterious rebels about the true nature of his reality";
        pelicula.duracion = 136;
        pelicula.genero = "Science Fiction";
        pelicula.fechaEstreno = LocalDate.of(2015, 10, 15);
        pelicula.calificacion = 3.3;
        pelicula.disponible = true;

        // Casting de tipos de datos
        long duracionLong = pelicula.duracion; // Conversión-CAST implícita de int a long
        int calificacionInt = (int) pelicula.calificacion; // Conversión-CAST explícita de double a int, se pierde la parte decimal
        long numeroDePremios = (int) Long.parseLong("25"); // Conversión-CAST explícita de String a long,

        System.out.println("------CASTING DE TIPOS DE DATOS------");
        System.out.println("Duración Long: " + duracionLong);
        System.out.println("Calificación Int: " +  calificacionInt);
        System.out.println("Números de premios: " + numeroDePremios);

        // Uso de métodos
        System.out.println("------FICHA TÉCNICA DE LA PELÍCULA------");
        System.out.println(pelicula.obtenerFichaTecnica());
        System.out.println("Es popular? " + pelicula.esPopular());

        // Nueva instancia para usuario
        Usuario usuario = new Usuario();
        usuario.nombre = "Sebastian";
        usuario.fechaRegistro = LocalDateTime.of(2025, 12, 24, 17, 15, 14);

        System.out.println("------USUARIO VIENDO PELÍCULA------");
        usuario.ver(pelicula);
        System.out.println(usuario.fechaRegistro);
    }
}
