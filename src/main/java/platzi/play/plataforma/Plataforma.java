package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<String> getTitulos(){
//        for(int i = 0; i < this.contenido.size(); i++){
//            System.out.println(contenido.get(i).getTitulo());
//        }

//        contenido.forEach(contenido -> System.out.println(contenido.getTitulo())); // Uso de expresión lambda, forma simplificada de escribir un metodo

        return contenido.stream().
                map(Pelicula::getTitulo)
                .toList();
    }

    // Método para eliminar una película
    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    // Método para buscar una película por título
    public Pelicula buscarPorTitulo(String titulo) {
//        for(Pelicula pelicula : contenido) {
//            if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
//                return pelicula; // Retorna la película si se encuentra
//            }
//        }
//        return null; // Retorna null si no se encuentra la película

        return contenido.stream()// Stream es una secuencia de elementos que soporta operaciones agregadas
                .filter(contenido -> contenido.getTitulo() // Filtra los elementos del stream
                        .equalsIgnoreCase(titulo)).findFirst() // Encuentra el primer elemento que cumple con la condición
                .orElse(null);

    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return contenido.stream().filter(contenido -> contenido.getGenero().equalsIgnoreCase(genero)).toList();
    }

    public List<Pelicula> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMostPopulars() {
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() >= 4.0)
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .toList();
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();
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
