package vistas;

/**
 *
 * @author tonym
 */
public class VistaEjemplar {
    private String titulo;
    private String consola;
    private int estanteria;
    private int unidades;

    public VistaEjemplar() {
    }

    public VistaEjemplar(String titulo, String consola, int estanteria, int unidades) {
        this.titulo = titulo;
        this.consola = consola;
        this.estanteria = estanteria;
        this.unidades = unidades;
    }

    public VistaEjemplar(String titulo, String consola, int estanteria) {
        this.titulo = titulo;
        this.consola = consola;
        this.estanteria = estanteria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(int estanteria) {
        this.estanteria = estanteria;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "VistaEjemplar{" + "titulo=" + titulo + ", consola=" + consola + ", estanteria=" + estanteria + ", unidades=" + unidades + '}';
    }
    
}