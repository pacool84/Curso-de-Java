package platzi.play.plataforma;

import platzi.play.contenido.Contenido;
import platzi.play.contenido.Genero;
import platzi.play.contenido.ResumenContenido;
import platzi.play.excepcion.PeliculaExistenteException;
import platzi.play.util.FileUtils;

import java.util.*;

public class Plataforma {
    private String nombre;
    private List<Contenido> contenido; // Entre Plataforma y Contenido hay una relación de Agregación
    private Map<Contenido, Integer> visualizaciones;

    // Constructor
    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>(); // Inicializar la lista de contenido
        this.visualizaciones = new HashMap<>(); // Inicializar el mapa de visualizaciones

    }

    // Método para agregar una película
    public void agregar(Contenido elemento){
        Contenido contenido = this.buscarPorTitulo(elemento.getTitulo());
        if(contenido != null) {
            throw new PeliculaExistenteException(elemento.getTitulo());
        }
        FileUtils.escribirContenido(elemento); // Escribir en el archivo
        this.contenido.add(elemento);
    }

    //Método para reproducir una película
    public void reproducir(Contenido contenido) {
        int conteoActual = this.visualizaciones.getOrDefault(contenido , 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " + conteoActual + " veces. ");

        this.contarVisualizacion(contenido);
        contenido.reproducir();
    }

    private void contarVisualizacion(Contenido contenido) {
        int conteoActual = this.visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido, conteoActual + 1);
    }

    // Método para recorrer y mostrar las películas
    public List<String> getTitulos(){
//        for(int i = 0; i < this.contenido.size(); i++){
//            System.out.println(contenido.get(i).getTitulo());
//        }

//        contenido.forEach(contenido -> System.out.println(contenido.getTitulo())); // Uso de expresión lambda, forma simplificada de escribir un metodo

        return contenido.stream().
                map(Contenido::getTitulo)
                .toList();
    }

    // Método para eliminar una película
    public void eliminar(Contenido elemento){
        this.contenido.remove(elemento);
    }

    // Método para buscar una película por título
    public Contenido buscarPorTitulo(String titulo) {
//        for(Contenido pelicula : contenido) {
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

    public List<Contenido> buscarPorGenero(Genero genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Contenido> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Contenido> getMostPopulars() {
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() >= 4.0)
                .sorted(Comparator.comparingDouble(Contenido::getCalificacion).reversed())
                .toList();
    }
    public Contenido getPeliculaMasLarga() {
        return contenido.stream()
                .max(Comparator.comparingInt(Contenido::getDuracion))
                .orElse(null);
    }

    public int getDuracionTotal() {
        return contenido.stream()
                .mapToInt(Contenido::getDuracion)
                .sum();
    }

    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(mamadas -> new ResumenContenido(mamadas.getTitulo(), mamadas.getDuracion(), mamadas.getGenero()))
                .toList();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contenido> getContenido() {
        return contenido;
    }

    public void setContenido(List<Contenido> contenido) {
        this.contenido = contenido;
    }
}
