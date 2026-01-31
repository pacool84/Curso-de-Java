package platzi.play.contenido;

public class Documental extends Contenido {
    //Atributos
    private String narrador;

    //Constructor
    public Documental(String titulo, int duracion, Genero genero, double calificacion, Idioma idioma) {
        super(titulo, duracion, genero, calificacion, idioma);
    }

    public Documental(String titulo, int duracion, Genero genero, double calificacion, String narrador) {
        super(titulo, duracion, genero, calificacion);
        this.narrador = narrador; // Debe de ser siempre despues de la llamada a super()
    }

    //Getters y Setters
    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    @Override
    public String obtenerFichaTecnica() {
        String ficha = super.obtenerFichaTecnica();
        if (narrador == null || narrador.isBlank()) {
            return ficha;
        }
        return ficha + "\n" + "Narrador: " + narrador;
    }
}
