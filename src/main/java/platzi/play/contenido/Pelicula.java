package platzi.play.contenido;


/* Herencia, es el concepto que permite crear una nueva clase a partir de una clase existente.
La clase existente se llama clase padre o superclase, y la nueva clase se llama clase hija o subclase.
Esta hereda los atributos y métodos de la clase padre, y puede agregar nuevos atributos y métodos, o modificar los existentes.
*/

public class Pelicula extends Contenido {

    //Constructor
    public Pelicula(String titulo, int duracion, Genero genero, double calificacion) {
        super(titulo, duracion, genero, calificacion);
    }

    @Override // Sobrescritura de método abstracto
    public void reproducir() {
        System.out.println("Reproduciendo película " + getTitulo());

    }
}
