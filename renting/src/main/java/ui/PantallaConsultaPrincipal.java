package ui;

/**
 *
 * @author tonym
 */
public abstract class PantallaConsultaPrincipal {
    
    public static final String ENCABEZADO = "Lista de Video Juegos Disponibles";
    
    public static String[] getMenu() {
        String[] menu = {
            "1. ->> Buscar por nombre. ",
            "2. ->> Juegos de PS4. ",
            "3. ->> Juegos de PS5.",
            "4. ->> Juegos de XBOX.",
            "5. ->> Juegos de Nintendo.",
            "6. ->> Juegos de PC.",
            "7. ->> Juegos Consolas Retro.",
            "0. ->> Volver al Menú Principal."};
        return menu;
    }

}
