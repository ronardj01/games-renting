package ui;

/**
 *
 * @author ronar
 */
public abstract class ListaPorConsola {

    //método
    public static String[] getMenu() {
        String[] menu = {"1->> Siguiente Página.", "2->> Página Anterior.", "3->> Volver al Menú Anterior."};
        return menu;
    }
}
