/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author tonym
 */
public class Ejemplar {

    private int idEjemplar;
    private String codigo;
    private int estanteriaC;
    private int estanteriaF;
    private boolean rentado;
    private int idConsola;
    private int idJuego;

    //CONSTANTE BOOLEAN
    private static final boolean RENTADO_POR_DEFECTO = false;

    public Ejemplar() {
        this.rentado = RENTADO_POR_DEFECTO;
    }

    public Ejemplar(String codigo, int estanteriaC, int estanteriaF, boolean rentado) {
        this.codigo = codigo;
        this.estanteriaC = estanteriaC;
        this.estanteriaF = estanteriaF;
        this.rentado = RENTADO_POR_DEFECTO;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstanteriaC() {
        return estanteriaC;
    }

    public void setEstanteriaC(int estanteriaC) {
        this.estanteriaC = estanteriaC;
    }

    public int getEstanteriaF() {
        return estanteriaF;
    }

    public void setEstanteriaF(int estanteriaF) {
        this.estanteriaF = estanteriaF;
    }

    public boolean isRentado() {
        return rentado;
    }

    public void setRentado(boolean rentado) {
        this.rentado = rentado;
    }
    // Getters de del id y FK
    public int getIdEjemplar() {
        return idEjemplar;
    }

    public int getIdConsola() {
        return idConsola;
    }

    public int getIdJuego() {
        return idJuego;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", codigo=" + codigo + ", estanteriaC=" + estanteriaC + ", estanteriaF=" + estanteriaF + ", rentado=" + rentado + ", idConsola=" + idConsola + ", idJuego=" + idJuego + '}';
    }

}
