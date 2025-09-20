package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    // Atributos
    private String nombre;
    private String email;
    private LocalDateTime fechaRegistro;

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

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
