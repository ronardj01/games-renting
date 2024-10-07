
package entidades;

/**
 *
 * @author tonym
 */
public class Ejemplar {

    private int idejemplar;
    private String codigo;
    private int rentado;
    private int id_consola;
    private int id_juego;

    //CONSTANTE 
    private static final int RENTADO_POR_DEFECTO = 0;

    public Ejemplar() {
        this.rentado = RENTADO_POR_DEFECTO;
    }

    public Ejemplar(String codigo, int id_consola, int id_juego) {
        this.codigo = codigo;
        this.rentado = RENTADO_POR_DEFECTO;
        this.id_consola = id_consola;
        this.id_juego = id_juego;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int isRentado() {
        return rentado;
    }

    public void setRentado(int rentado) {
        this.rentado = rentado;
    }
    
    // Getters de del id y FK
    public int getIdEjemplar() {
        return idejemplar;
    }

    public int getIdConsola() {
        return id_consola;
    }

    public int getIdJuego() {
        return id_juego;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "idEjemplar=" + idejemplar + ", codigo=" + codigo + ", rentado=" + rentado + ", id_consola=" + id_consola + ", id_juego=" + id_juego + '}';
    }

    

}
