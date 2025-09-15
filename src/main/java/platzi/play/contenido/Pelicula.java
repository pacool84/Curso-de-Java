package platzi.play.contenido;

public class Pelicula {
    //Atributos
    public String titulo;
    public String descripcion;
    public int duracion;
    public String genero;
    public int anioEstreno;
    public double calificacion;
    public boolean disponible;

    //Constructor


    //Metodos
    public void reproducir() {
        System.out.println("Reproduciendo la pelicula: " + titulo);
    }

    public String obtenerFichaTecnica() {
        return titulo + "(" + anioEstreno + ") \n" +
               "Genero: " + genero + "\n" +
               "Duracion: " + duracion + " minutos\n" +
               "Calificacion: " + calificacion + "/5\n" +
               "Descripcion: " + descripcion + "\n" +
               (disponible ? "Disponible para ver" : "No disponible para ver");
    }

    public void calificar(double calificacion) {
        if(calificacion >= 0 && calificacion <=5) {
            this.calificacion = calificacion;
        } else {
            System.out.println("Calificacion invalida. Debe estar entre 0 y 5");
        }
    }

    public boolean esPopular() {
        return calificacion >= 4.0;
    }
}
