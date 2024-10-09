package ui;

/**
 *
 * @author tonym
 */
public abstract class PantallaBusquedaNombre {

    public static final String[] ENCABEZADO_ARRAY = { "Juegos", "Consola", "Estanteria", "Unidades" };
    public static final String ENCABEZADO = "Favor Elegir una opción: ";

    public static String[] getMenu() {
        String[] menu = { "1->> Hacer nueva Busqueda. ",
                "2->> Volver al Menú Anterior." };
        return menu;
    }
}
