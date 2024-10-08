package entidades;

/**
 *
 * @author tonym
 */
public class Juego {

    private int idjuego;
    private String titulo;
    private String genero;
    private String estanteria;

    public Juego(String titulo, String genero, String estanteria) {
        this.titulo = titulo;
        this.genero = genero;
        this.estanteria = estanteria;
    }

    public Juego() {
    }

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstanteria() {
        return this.estanteria;
    }

    public void setEstanteria(String estanteria) {
        this.estanteria = estanteria;
    }

    public int getIdJuego() {
        return idjuego;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idjuego + ", titulo=" + titulo + ", genero=" + genero + ", estanteria=" + estanteria + '}';
    }
}
