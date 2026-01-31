package platzi.play;

import platzi.play.contenido.Genero;
import platzi.play.contenido.Idioma;
import platzi.play.contenido.Pelicula;

public class MainStackHeap {
    public static void main(String[] args) {
        Pelicula reyLeon = new Pelicula("El rey Leon", 120, Genero.ANIMACION, 4.5);
        Pelicula harryPotter = new Pelicula("Harry Potter", 150, Genero.FANTASIA, 4.3);

        reyLeon = harryPotter; // Ambas variables apuntan al mismo objeto en memoria heap

//        reyLeon.titulo = "El Hobbit"; // Modificando el título a través de la referencia reyLeon, cualquier valor que se modifique a través de una referencia afectará al mismo objeto en memoria heap
//
//        System.out.println(reyLeon.titulo);
//        System.out.println(harryPotter.titulo);
    }
}
