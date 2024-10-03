
package ui;

import java.util.Arrays;

/**
 *
 * @author tonym
 */
public class PantallaPrincipal {
    private String mPp[];

    public PantallaPrincipal() {
        
    }
    public  String[] pantallaPrincipal(){
    this.mPp = new String[]{" Bienvenido a su Tienda favorita de Alquiler de Video Juegos",
            "*** O V E R L O R D ***",
            "1 ->> Consultar Lista de Video Juegos.",
            "2 ->> Rentar Video Juegos.",
            "3 ->> Retornar Video Juegos."};
    return mPp;
    }
    public PantallaPrincipal(String[] mPp) {
        this.mPp = mPp;
    }

    public String[] getmPp() {
        return mPp;
    }

    public void setmPp(String[] mPp) {
        this.mPp = mPp;
    }

    @Override
    public String toString() {
        return "PantallaPrincipal{" + "mPp=" + Arrays.toString(mPp) + '}';
    }
}
