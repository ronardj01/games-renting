package vistas;

import java.time.LocalDate;

/**
 *
 * @author tonym
 */
public class VistaAlquiler {
    private String titulo;
    private LocalDate fecha_renta;
    private LocalDate fecha_devolucion;
    private LocalDate fecha_retorno;

    public VistaAlquiler() {
    }

    public VistaAlquiler(String titulo, LocalDate fecha_renta, LocalDate fecha_devolucion, LocalDate fecha_retorno) {
        this.titulo = titulo;
        this.fecha_renta = fecha_renta;
        this.fecha_devolucion = fecha_devolucion;
        this.fecha_retorno = fecha_retorno;
    }

    public VistaAlquiler(LocalDate fecha_devolucion, LocalDate fecha_retorno) {
        this.fecha_devolucion = fecha_devolucion;
        this.fecha_retorno = fecha_retorno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha_renta() {
        return fecha_renta;
    }

    public void setFecha_renta(LocalDate fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public LocalDate getFecha_retorno() {
        return fecha_retorno;
    }

    public void setFecha_retorno(LocalDate fecha_retorno) {
        this.fecha_retorno = fecha_retorno;
    }

    @Override
    public String toString() {
        return "VistaAlquiler{" + "titulo=" + titulo + ", fecha_renta=" + fecha_renta + ", fecha_devolucion=" + fecha_devolucion + ", fecha_retorno=" + fecha_retorno + '}';
    }
    
}
