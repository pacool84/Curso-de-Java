package platzi.play;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Idioma;
import platzi.play.contenido.Pelicula;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;
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
    public static final int VER_POPULARES = 5;
    public static final int VER_MAS_POPULARES = 6;
    public static final int PELICULA_MAS_LARGA = 7;
    public static final int REPRODUCIR_PELICULA = 8;
    public static final int ELIMINAR_CONTENIDO = 9;
    public static final int SALIR = 0;

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);
        System.out.println( NOMBRE_PLATAFORMA + " v" +  VERSION);

        cargarPeliculas(plataforma); // Cargar películas iniciales a la plataforma

        System.out.println("Mas de " + plataforma.getDuracionTotal() + " minutos de  contenido \n");

        // Menú de opciones
        while (true) {
            int opcionElegida = ScannerUtils.capturarEntero("""
                    1. Agregar contenido a la plataforma
                    2. Mostrar todo el contenido de la plataforma
                    3. Buscar un contenido por su título
                    4. Buscar un contenido por su género
                    5. Mostrar populares 
                    6. Mostrar películas con calificación mayor a 4 
                    7. Mostrar la película más larga
                    8. Reproducir una película
                    9. Eliminar un contenido
                    0. Salir de la plataforma
                    Elige una opción 
                    """);

            switch (opcionElegida) {
                case AGREGAR_CONTENIDO -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido: "); //Se puede realizar el ScannerUtils.capturarTexto por ser un método estático "static"
                    Genero genero = ScannerUtils.capturaGenero("Genero del contenido: ");
                    Idioma idioma = ScannerUtils.capturaIdioma("Idioma del contenido: ");
                    int duracion = ScannerUtils.capturarEntero("Duración del contenido (minutos): ");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación del contenido (0 - 5): ");

                    try {
                        Pelicula pelicula = new Pelicula(nombre, duracion, genero, calificacion, idioma); // Instancia de la clase Pelicula
                        plataforma.agregar(pelicula);
                        System.out.println("El contenido ha sido agregado exitosamente");
                    } catch (PeliculaExistenteException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case MOSTRAR_CONTENIDO -> {
                    List<ResumenContenido> contenidosResumidos = plataforma.getResumenes();
                    contenidosResumidos.forEach(resumen -> System.out.println(resumen.toString())); //Llamado por método de referencia
                }
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
                    Genero generoBuscado = ScannerUtils.capturaGenero("Ingresa el género a buscar: ");
                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(contenidoPorGenero.size() + " contenidos encontrados del género " + generoBuscado + ":\n");
                    contenidoPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarEntero("Cantidad de películas populares a mostrar: ");

                    List<Pelicula> contenidosPopulares = plataforma.getPopulares(cantidad);
                    contenidosPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case REPRODUCIR_PELICULA -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir: ");
                    Pelicula contenido = plataforma.buscarPorTitulo(nombre);

                    if(contenido != null) {
                        plataforma.reproducir(contenido);
                    } else {
                        System.out.println(nombre + " no se encuentra en el catálogo de la plataforma");
                    }
                }
                case VER_MAS_POPULARES -> {
                    List<Pelicula> contenidosMasPopulares = plataforma.getMostPopulars();
                    System.out.println("Peliculas con calificación mayor o igual a 4.0: \n");
                    contenidosMasPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }
                case PELICULA_MAS_LARGA -> {
                    System.out.println("Película más larga de la plataforma: \n");
                    Pelicula peliculaMasLarga = plataforma.getPeliculaMasLarga();
                    System.out.println(peliculaMasLarga.obtenerFichaTecnica() + "\n");
                }
                case SALIR -> System.exit(0);

                default -> System.out.println("Opción no válida, por favor elige una opción del 1 al 5");

            }
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula("Shrek", 90, Genero.ANIMACION, Idioma.ESPAÑOL));
        plataforma.agregar(new Pelicula("Inception", 148, Genero.CIENCIA_FICCION, Idioma.INGLES));
        plataforma.agregar(new Pelicula("Titanic", 195, Genero.DRAMA, 4.6, Idioma.INGLES));
        plataforma.agregar(new Pelicula("John Wick", 101, Genero.ACCION, Idioma.INGLES));
        plataforma.agregar(new Pelicula("El Conjuro", 112, Genero.HORROR, 3.0, Idioma.FRANCES));
        plataforma.agregar(new Pelicula("Coco", 105, Genero.ANIMACION, 4.7, Idioma.ESPAÑOL));
        plataforma.agregar(new Pelicula("Interstellar", 169, Genero.CIENCIA_FICCION, 5, Idioma.INGLES));
        plataforma.agregar(new Pelicula("Joker", 122, Genero.DRAMA, 4.3, Idioma.INGLES));
        plataforma.agregar(new Pelicula("Toy Story", 81, Genero.ANIMACION, 4.5, Idioma.ESPAÑOL));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, Genero.ACCION, 3.9, Idioma.INGLES));
    }
}

//Retos
// 1. Filtar aquellas peliculas con calificación mayor o igual a 4.0, las mas populares
//Solución
// 1.1 Crear la constante VER_MAS_POPULARES = # ✔
// 1.2 Agregar la nueva opcion al menu del programa ✔
// 1.3 Agregar el nuevo CASE que gestionara la nueva opcion, desde aqui llamaremos al nuevo metodo ✔
// 1.4 Crear un nuevo metodo en la clase Plataforma para filtrar por peliculas >= 4
// 1.5 Ajustar el CASE creado previamente para procesar los datos de las peliculas >= 4

// 2. Obtener la pelicula mas larga de la plataforma
// Solución
// 2.1 Crear la constante PELICULA_MAS_LARGA = #
// 2.2 Agregar la nueva opcion al menu del programa
// 2.3 Agregar el nuevo CASE que gestionara la nueva opcion, desde aqui llamaremos al nuevo metodo
// 2.4 Crear un nuevo metodo en la clase Plataforma para obtener la pelicula mas larga

// 3 Crear atributos extras en la clase Pelicula que sean idioma(Español, Ingles, Aleman) y calidad (HD, FULL HD, 4K) y que cada uno de ellos sea un ENUM ✔
// 3.1 Agregar los nuevos atributos a la clase Pelicula ✔
// 3.2 Modificar los constructores para agregar los nuevos atributos ✔
// 3.3 Modificar el método obtenerFichaTecnica para mostrar los nuevos atributos ✔
// 3.4 Modificar el método cargarPeliculas para agregar los nuevos atributos ✔
// 3.5 Modificar el CASE AGREGAR_CONTENIDO para capturar los nuevos atributos ✔
// 3.6 Crear un nuevo CASE para filtrar por idioma
// 3.7 Crear un nuevo CASE para filtrar por calidad
