package platzi.play.contenido;

import java.time.LocalDate;

public class Pelicula {
    //Atributos
    private String titulo;
    private String descripcion;
    private int duracion;
    private Genero genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;
    private Idioma idioma;


    //Constructor
    public Pelicula(String titulo, int duracion, Genero genero, Idioma idioma) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = LocalDate.now(); // Fecha actual
        this.disponible = true; // Por defecto la pelicula está disponible
        this.idioma = idioma;
    }

    //Otra forma de crear un constructor
    public Pelicula(String titulo, int duracion, Genero genero, double calificacion, Idioma idioma) {
        this(titulo, duracion, genero, idioma); // Llamada al constructor anterior
        this.calificar(calificacion);
    }

    //Métodos
    public void reproducir() {
        System.out.println("Reproduciendo la pelicula: " + titulo);
    }

    public String obtenerFichaTecnica() {
        return titulo + "(" + fechaEstreno.getYear() + ") \n" +
               "Genero: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Calificación: " + calificacion + "/5\n" +
                "Idioma: " + idioma + "\n" +
               "Descripción: " + descripcion + "\n" +
               (disponible ? "Disponible para ver" : "No disponible para ver");
    }

    public void calificar(double calificacion) {
        if(calificacion >= 0 && calificacion <=5) {
            this.calificacion = calificacion;
        } else {
            System.out.println("Calificación invalida. Debe estar entre 0 y 5");
        }
    }

    public boolean esPopular() {
        return calificacion >= 4.0;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
