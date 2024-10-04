package vistas;

/**
 *
 * @author tonym
 */
public class VistaAlquiler {
    private String titulo;
    private int fecha_renta;
    private int fecha_devolucion;
    private int fecha_retorno;

    public VistaAlquiler() {
    }

    public VistaAlquiler(String titulo, int fecha_renta, int fecha_devolucion, int fecha_retorno) {
        this.titulo = titulo;
        this.fecha_renta = fecha_renta;
        this.fecha_devolucion = fecha_devolucion;
        this.fecha_retorno = fecha_retorno;
    }

    public VistaAlquiler(int fecha_devolucion, int fecha_retorno) {
        this.fecha_devolucion = fecha_devolucion;
        this.fecha_retorno = fecha_retorno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFecha_renta() {
        return fecha_renta;
    }

    public void setFecha_renta(int fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public int getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(int fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getFecha_retorno() {
        return fecha_retorno;
    }

    public void setFecha_retorno(int fecha_retorno) {
        this.fecha_retorno = fecha_retorno;
    }

    @Override
    public String toString() {
        return "VistaAlquiler{" + "titulo=" + titulo + ", fecha_renta=" + fecha_renta + ", fecha_devolucion=" + fecha_devolucion + ", fecha_retorno=" + fecha_retorno + '}';
    }
    
}
