package entidades;

/**
 *
 * @author ronar
 */
public class Alquiler {

    //atributos
    private int idalquiler;
    private String fecha_renta;
    private String fecha_devolucion;
    private String fecha_retorno;
    private int id_ejemplar;
    private int id_usuario;

    //consturctores
    public Alquiler() {
    }

    public Alquiler(String fecha_renta, String fecha_devolucion, int id_ejemplar, int id_usuario) {
        this.fecha_renta = fecha_renta;
        this.fecha_devolucion = fecha_devolucion;
        this.id_ejemplar = id_ejemplar;
        this.id_usuario = id_usuario;
    }

    //getters
    public int getIdalquiler() {
        return idalquiler;
    }

    public String getFecha_renta() {
        return fecha_renta;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public String getFecha_retorno() {
        return fecha_retorno;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    //setters
    public void setFecha_renta(String fecha_renta) {
        this.fecha_renta = fecha_renta;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setFecha_retorno(String fecha_retorno) {
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
