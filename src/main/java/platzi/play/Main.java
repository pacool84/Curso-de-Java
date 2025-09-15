package platzi.play;

import platzi.play.contenido.Pelicula;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello My Friend JAVA");

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
        pelicula.anioEstreno = 1999;
        pelicula.calificacion = 3.3;
        pelicula.disponible = true;

        System.out.println(pelicula.obtenerFichaTecnica());
        System.out.println("Es popular? " + pelicula.esPopular());
    }
}
