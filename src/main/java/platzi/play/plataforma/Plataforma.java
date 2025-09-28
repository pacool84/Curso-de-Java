package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Entre Plataforma y Contenido hay una relación de Agregación

    // Constructor
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>(); // Inicializar la lista de contenido

    }

    // Método para agregar una película
    public void agregar(Pelicula elemento){
        this.contenido.add(elemento);
    }

    // Método para recorrer y mostrar las películas
    public void mostrarPeliculas(){
        for(int i = 0; i < this.contenido.size(); i++){
            System.out.println(contenido.get(i).getTitulo());
        }
    }

    // Método para eliminar una película
    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    // Método para buscar una película por título
    public Pelicula buscarPorTitulo(String titulo) {
        for(Pelicula pelicula : contenido) {
            if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                return pelicula; // Retorna la película si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra la película
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public void setContenido(List<Pelicula> contenido) {
        this.contenido = contenido;
    }
}
