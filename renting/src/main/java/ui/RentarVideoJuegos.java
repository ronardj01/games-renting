package ui;

/**
 *
 * @author ronar
 */
public abstract class RentarVideoJuegos {

    //métodos
    public static final String[] ENCABEZADO_ARRAY = {"Titulo", "fecha renta", "fecha devolucion"};
    public static final String ENCABEZADO = "Rentar video juego";

    public static String[] getMenu() {
        String[] menu
                = {"1.->> Rentar otro juego.",
                    "2.->> Salir e imprimir."};
        return menu;
    }
}
