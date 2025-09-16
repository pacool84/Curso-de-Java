package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    // Atributos
    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;

    // Constructor

    // Métodos
    public void ver(Pelicula pelicula) {
        System.out.println("--------------------------------");
        System.out.println(nombre + " está viendo la película ");
        pelicula.reproducir();
    }
}
