package platzi.play;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Genero;
import platzi.play.contenido.Idioma;

public class MainStackHeap {
    public static void main(String[] args) {
        Contenido reyLeon = new Contenido("El rey Leon", 120, Genero.ANIMACION, Idioma.ESPAÑOL);
        Contenido harryPotter = new Contenido("Harry Potter", 150, Genero.FANTASIA, Idioma.INGLES);

        reyLeon = harryPotter; // Ambas variables apuntan al mismo objeto en memoria heap

//        reyLeon.titulo = "El Hobbit"; // Modificando el título a través de la referencia reyLeon, cualquier valor que se modifique a través de una referencia afectará al mismo objeto en memoria heap
//
//        System.out.println(reyLeon.titulo);
//        System.out.println(harryPotter.titulo);
    }
}
