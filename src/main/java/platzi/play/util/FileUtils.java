package platzi.play.util;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class FileUtils {
    public static List<Pelicula> leerContenido() {


        try {
            List<String> lineas = Files.readAllLines(Paths.get("contenido.txt"));

            lineas.forEach(linea -> {
                String[] datos = linea.split("\\|"); //Segmentar por el caracter |

                if (datos.length == 5) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]); // Convertir String a int
                    Genero genero = Genero.valueOf(datos[2].toUpperCase()); // Convertir String a Genero (ENUM)
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3]); // Convertir String a double
                    LocalDate fechaEstreno = LocalDate.parse(datos[4]); // Convertir String a LocalDate

                    Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);
                    pelicula.setFechaEstreno(fechaEstreno);

                    plataforma.agregar(pelicula);

                }
            });

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de contenido: " + e.getMessage());
        }
    }
}
