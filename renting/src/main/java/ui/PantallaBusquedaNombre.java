package ui;

/**
 *
 * @author tonym
 */
public abstract class PantallaBusquedaNombre {

    public static String[] getMenu() {
        String[] menu
                = { "1->> Siguiente Página. ",
                    "2->> Página Anterior.",
                    "3->> Hacer Nueva Búsqueda.",
                    "4->> Volver al Menú Anterior."};
        return menu;
    }
}
