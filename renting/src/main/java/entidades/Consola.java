package entidades;

/**
 *
 * @author ronar
 */
public class Consola {

    //atributos
    private int idconsola;
    private String nombre;

    //constructores
    public Consola() {
    }

    public Consola(String nombre) {
        this.nombre = nombre;
    }

    //getters
    public int getIdconsola() {
        return idconsola;
    }

    public String getNombre() {
        return nombre;
    }

    //setters
    public void setIdconsola(int idconsola) {
        this.idconsola = idconsola;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //métodos
    @Override
    public String toString() {
        return "Consola{" + "idconsola=" + idconsola + ", nombre=" + nombre + '}';
    }
}
