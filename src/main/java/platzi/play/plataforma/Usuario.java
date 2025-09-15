package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

public class Usuario {
    // Atributos
    public String nombre;
    public String email;

    // Constructor

    // Métodos
    public void ver(Pelicula pelicula) {
        System.out.println("--------------------------------");
        System.out.println(nombre + " está viendo la película ");
        pelicula.reproducir();
    }
}
