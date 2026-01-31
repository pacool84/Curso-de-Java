package platzi.play.contenido;

public class Documental extends Contenido implements Promocionable {
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

    @Override // Sobrescritura de método abstracto
    public void reproducir() {
        System.out.println("Reproduciendo el documental " + getTitulo() + " narrador por " + getNarrador());

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

    //Este método es de la interfaz Promocionable
    @Override
    public String promocionar() {
        return "Descubre el documental " + this.getTitulo() + " narrado por " + narrador;
    }
}
