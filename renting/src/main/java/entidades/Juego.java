/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author tonym
 */
public class Juego {

    private int idJuego;
    private String titulo;
    private String genero;

    public Juego(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    public Juego() {
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

    public int getIdJuego() {
        return idJuego;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idJuego + ", titulo=" + titulo + ", genero=" + genero + '}';
    }

}
