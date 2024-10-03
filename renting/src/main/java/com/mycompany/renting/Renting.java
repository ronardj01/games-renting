
package com.mycompany.renting;

import java.util.Arrays;
import ui.PantallaPrincipal;

/**
 *
 * @author ronar
 */
public class Renting {

    public static void main(String[] args) {
        PantallaPrincipal menu = new PantallaPrincipal();
        String[] mPp;
        mPp = menu.pantallaPrincipal();
        for (String mPp1 : mPp) {
            System.out.println(mPp1);
        }
        //System.out.println(Arrays.toString(mPp));
    }
}
