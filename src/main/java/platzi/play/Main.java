package platzi.play;

import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String VERSION = "1.0.0"; // final - constante, no se puede modificar o reasignar "Inmutable"
    public static final String NOMBRE_PLATAFORMA = "Hello My Friend JAVA 👋🏻 ";
    public static final int AGREGAR_CONTENIDO = 1;
    public static final int MOSTRAR_CONTENIDO = 2;
    public static final int BUSCAR_CONTENIDO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int ELIMINAR_CONTENIDO = 5;
    public static final int SALIR = 0;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println( NOMBRE_PLATAFORMA + " v" +  VERSION);

        cargarPeliculas(plataforma); // Cargar películas iniciales a la plataforma

        // Menú de opciones
        while (true) {
            int opcionElegida = ScannerUtils.capturarEntero("""
                    1. Agregar contenido a la plataforma
                    2. Mostrar todo el contenido de la plataforma
                    3. Buscar un contenido por su título
                    4. Buscar un contenido por su género
                    5. Eliminar un contenido
                    0. Salir de la plataforma
                    Elige una opción 
                    """);

            switch (opcionElegida) {
                case AGREGAR_CONTENIDO -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido: "); //Se puede realizar el ScannerUtils.capturarTexto por ser un método estático "static"
                    String genero = ScannerUtils.capturarTexto("Genero del contenido: ");
                    int duracion = ScannerUtils.capturarEntero("Duración del contenido (minutos): ");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido (0 - 5): ");

                    Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion); // Instancia de la clase Pelicula
                    plataforma.agregar(pelicula);
                    System.out.println("El contenido ha sido agregado exitosamente");
                }
                case MOSTRAR_CONTENIDO -> plataforma.mostrarPeliculas();
                case BUSCAR_CONTENIDO -> {
                    // FALTA IMPLEMENTAR
                    String nombreBuscado = ScannerUtils.capturarTexto("Ingresa el título del contenido a buscar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);
                    if(pelicula != null) {
                        System.out.println("Contenido encontrado: " + pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println("No se encontró contenido con el título: " + nombreBuscado);
                    }
                }
                case ELIMINAR_CONTENIDO -> {
                    // FALTA IMPLEMENTAR
                    String nombreEliminar = ScannerUtils.capturarTexto("Ingresa el título del contenido a eliminar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreEliminar);
                    if(pelicula != null) {
                        plataforma.eliminar(pelicula);
                        System.out.println("El contenido ha sido eliminado exitosamente. " + nombreEliminar);
                    } else {
                        System.out.println("No se encontró contenido con el título: " + nombreEliminar);
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    String generoBuscado = ScannerUtils.capturarTexto("Ingresa el género del contenido a buscar: ");
                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " contenidos encontrados del género " + generoBuscado.toUpperCase() );
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case SALIR -> System.exit(0);

                default -> System.out.println("Opción no válida, por favor elige una opción del 1 al 5");

            }
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula("Shrek", 90, "Animada"));
        plataforma.agregar(new Pelicula("Inception", 148, "Ciencia Ficcion"));
        plataforma.agregar(new Pelicula("Titanic", 195, "Drama", 4.6));
        plataforma.agregar(new Pelicula("John Wick", 101, "Accion"));
        plataforma.agregar(new Pelicula("El Conjuro", 112, "Terror", 3.0));
        plataforma.agregar(new Pelicula("Coco", 105, "Animada", 4.7));
        plataforma.agregar(new Pelicula("Interstellar", 169, "Ciencia Ficcion", 5));
        plataforma.agregar(new Pelicula("Joker", 122, "Drama"));
        plataforma.agregar(new Pelicula("Toy Story", 81, "Animada", 4.5));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, "Accion", 3.9));
    }
}
