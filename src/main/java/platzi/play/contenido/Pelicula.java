package platzi.play.contenido;

import java.time.LocalDate;

public class Pelicula {
    //Atributos
    public String titulo;
    public String descripcion;
    public int duracion;
    public String genero;
    public LocalDate fechaEstreno;
    public double calificacion;
    public boolean disponible;

    //Constructor


    //Métodos
    public void reproducir() {
        System.out.println("Reproduciendo la pelicula: " + titulo);
    }

    public String obtenerFichaTecnica() {
        return titulo + "(" + fechaEstreno.getYear() + ") \n" +
               "Genero: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Calificación: " + calificacion + "/5\n" +
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
}
