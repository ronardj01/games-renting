package ui;

public abstract class PantallaPrincipal {
    
    public static final String COMPANY_NAME = "O V E R L O R D";
    public static final String BIENVENIDA = "Bienvenido a su Tienda favorita de Alquiler de Video Juegos";

    public static String[] getMenuPrincipal() {
        String[] menu = {"1 ->> Consultar Lista de Video Juegos.", "2 ->> Rentar Video Juegos.", "3 ->> Retornar Video Juegos."};
        return menu;
    }
}
