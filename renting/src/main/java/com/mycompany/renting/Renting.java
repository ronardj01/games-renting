package com.mycompany.renting;

import ui.PantallaConsultaPrincipal;
import ui.PantallaPrincipal;

/**
 *
 * @author ronar
 */
public class Renting {

    public static void main(String[] args) {

        //CADENAS FORMATEADAS
        String companyName = String.format("\n%50s\n", "*** " + PantallaPrincipal.COMPANY_NAME + " ***");
        
        //IMPRIMIR LOGO Y NOMBRE DE LA COMPAÑIA
        System.out.print(companyName);
        
        //Pantalla principal
        int opcion = 4;
        do{
            getMenu(PantallaPrincipal.BIENVENIDA, PantallaPrincipal.getMenuPrincipal());
            
            
        } while(opcion != 4);

        /*
        String encabezado = String.format("%70s\n", "Bienvenido a su Tienda favorita de Alquiler de Video Juegos");
        String encabezadoVistaConsola = String.format("%-30s %-14s Estanteria\n", "Juegos", "Unidades");
        String encabezadoCodigoJuego = String.format("\n%65s", "Favor introducir el código del video juego: over-234p");
        */
        
    }
    
    public static void getMenu(String encabezadoMenu, String[] menu) {
        String encabezado = String.format("\n%70s\n", encabezadoMenu);
        System.out.println(encabezado);
        
        //menu
        for(String opcion : menu) {
            System.out.println(opcion);
        }        
    }
}
