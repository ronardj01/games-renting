package entidades;

import java.time.LocalDate;

/**
 *
 * @author ronar
 */
public class Alquiler {

    //atributos
    private int idalquiler;
    private LocalDate fecha_renta;
    private LocalDate fecha_devolucion;
    private LocalDate fecha_retorno;
    private int id_ejemplar;
    private int id_usuario;

    private final LocalDate FECHA_RENTA = LocalDate.now();

    //consturctores
    public Alquiler() {
        this.fecha_renta = this.FECHA_RENTA;
        this.fecha_devolucion = this.FECHA_RENTA.plusDays(10);
    }

    public Alquiler(int id_ejemplar, int id_usuario) {
        this.fecha_renta = this.FECHA_RENTA;
        this.fecha_devolucion = this.FECHA_RENTA.plusDays(10);
        this.id_ejemplar = id_ejemplar;
        this.id_usuario = id_usuario;
    }

    //getters
    public int getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(int idalquiler) {
        this.idalquiler = idalquiler;
    }

    public LocalDate getFecha_renta() {
        return fecha_renta;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public LocalDate getFecha_retorno() {
        return fecha_retorno;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    //setters
    public void setFecha_renta(LocalDate fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setFecha_retorno(LocalDate fecha_retorno) {
        this.fecha_retorno = fecha_retorno;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    //métodos
    @Override
    public String toString() {
        return "Alquiler{" + "idalquiler=" + idalquiler + ", fecha_renta=" + fecha_renta + ", fecha_devolucion=" + fecha_devolucion + ", fecha_retorno=" + fecha_retorno + ", id_ejemplar=" + id_ejemplar + ", id_usuario=" + id_usuario + '}';
    }

}
