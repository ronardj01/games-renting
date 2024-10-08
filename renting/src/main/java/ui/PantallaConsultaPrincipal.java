package ui;

/**
 *
 * @author tonym
 */
public abstract class PantallaConsultaPrincipal {
    
    public static final String ENCABEZADO = "Lista de Video Juegos Disponibles";
    
    public static String[] getMenu() {
        String[] menu = {
            "0. ->> Buscar por nombre. ",
            "1. ->> Juegos de PS4. ",
            "2. ->> Juegos de PS5.",
            "3. ->> Juegos de XBOX.",
            "4. ->> Juegos de Nintendo.",
            "5. ->> Juegos de PC.",
            "6. ->> Juegos Consolas Retro.",
            "7. ->> Volver al Menú Principal."};
        return menu;
    }

}
