package com.mycompany.renting;

import dbentidades.DbJuego;
import java.util.Scanner;
import ui.*;

/**
 *
 * @author ronar
 */
public class Renting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //CADENAS FORMATEADAS
        String companyName = String.format("\n%50s\n", "*** " + PantallaPrincipal.COMPANY_NAME + " ***");

        //IMPRIMIR LOGO Y NOMBRE DE LA COMPAÑIA
        System.out.print(companyName);

        //Pantallas
        int opcion;
        String nombre = "";
        do {
            //PANTALLA PRINCIPAL
            getMenuMain(PantallaPrincipal.BIENVENIDA, PantallaPrincipal.getMenuPrincipal());
            System.out.print("\nFavor introduzca una opcion para ingresar: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                //PRINCIPAL BUSQUEDA
                case 1 -> {
                    getMenuMain(PantallaConsultaPrincipal.ENCABEZADO, PantallaConsultaPrincipal.getMenu());
                    System.out.print("favor introducir una opcion de busqueda: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); //Limpiar buffer
                    switch (opcion) {
                        //BUSQUEDA POR NOMBRE
                        case 1 -> {
                            System.out.print("Favor introducir nombre de video Juego: ");
                            nombre = scanner.nextLine();
                            //BUSCAR EJEMPLAR POR NOMBRE EN DB
             
                            
                            String[] encabezadoArray = PantallaBusquedaNombre.ENCABEZADO_ARRAY;
                            String busquedaNombre = String.format("\n%-30s %-15s %s\n",
                                    encabezadoArray[0], encabezadoArray[1], encabezadoArray[2]);
                            System.out.println(busquedaNombre);
                            
                            getMenuMain(PantallaBusquedaNombre.ENCABEZADO, PantallaBusquedaNombre.getMenu());
                            
                            
                            
                            

                        }
                    }
                }
            }

        } while (opcion != 4);

        System.out.println("Hast luego!!!");
        /*
        String encabezado = String.format("%70s\n", "Bienvenido a su Tienda favorita de Alquiler de Video Juegos");
        String encabezadoVistaConsola = String.format("%-30s %-14s Estanteria\n", "Juegos", "Unidades");
        String encabezadoCodigoJuego = String.format("\n%65s", "Favor introducir el código del video juego: over-234p");
         */

    }

    public static void getMenuMain(String encabezadoMenu, String[] menu) {
        String encabezado = String.format("\n%70s\n", encabezadoMenu);
        System.out.println(encabezado);

        //menu
        for (String opcion : menu) {
            System.out.println(opcion);
        }
    }
}
