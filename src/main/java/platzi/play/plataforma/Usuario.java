package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    // Atributos
    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;

    // Constructor
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now(); // Fecha y hora actual
    }

    // Métodos
    public void ver(Pelicula pelicula) {
        System.out.println("--------------------------------");
        System.out.println(nombre + " está viendo la película ");
        pelicula.reproducir();
    }
}
