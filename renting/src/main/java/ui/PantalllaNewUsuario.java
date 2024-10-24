
package ui;

/**
 *
 * @author tonym
 */
public abstract class  PantalllaNewUsuario {
    //métodos
    public static final String ENCABEZADO = "Lista de Video Juegos Disponibles";
    
    public static String[] getMenu() {
        String[] menu = {
            "1. ->> Nuevo usuario. ",
            "0. ->> volver atras"};
        return menu;
    }
}
