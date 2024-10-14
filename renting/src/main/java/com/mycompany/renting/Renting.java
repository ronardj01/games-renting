package com.mycompany.renting;

import dbentidades.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import ui.*;
import vistas.*;

/**
 *
 * @author ronar
 */
public class Renting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // CREAR CONEXIÓN
        Connection miConexion = DbConnection.getConnection();

        // CADENAS FORMATEADAS
        String companyName = String.format("\n%50s\n", "*** " + PantallaPrincipal.COMPANY_NAME + " ***");

        // Pantallas
        int opcion;
        String nombre = "";

        do {
            // IMPRIMIR LOGO Y NOMBRE DE LA COMPAÑIA
            System.out.print(companyName);

            // PANTALLA PRINCIPAL
            getMenuMain(PantallaPrincipal.BIENVENIDA, PantallaPrincipal.getMenuPrincipal());
            System.out.print("\nFavor introduzca una opcion para ingresar: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                // PRINCIPAL BUSQUEDA
                case 1 -> {
                    // CONSULTAR LISTA DE VIDEO JUEGOS DISPONIBLES
                    int opcionBusqueda;
                    do {
                        System.out.println(companyName);

                        getMenuMain(PantallaConsultaPrincipal.ENCABEZADO, PantallaConsultaPrincipal.getMenu());
                        System.out.print("favor introducir una opcion de busqueda: ");
                        opcionBusqueda = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        switch (opcionBusqueda) {

                            case 1 -> {
                                // BUSQUEDA POR NOMBRE
                                int opcionNombre;
                                do {
                                    System.out.println(companyName);
                                    System.out.print("Favor introducir nombre de video Juego: ");
                                    nombre = scanner.nextLine();

                                    // LLamar pantalla Busqueda por nombre
                                    getListByName(nombre);

                                    System.out.print("Selecione una opción: ");
                                    opcionNombre = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar buffer

                                } while (opcionNombre != 2);
                            }
                        }
                    } while (opcionBusqueda != 0);
                }
                case 2 -> {
                    //  RENTAR VIDEO JUEGO
                    scanner.nextLine(); //Limpiar buffer
                    System.out.println(companyName);
                    DbVistaAlquiler.createViewRent(scanner);
                }

                case 3 -> {
                    // RETORNAR VIDEO JUEGO
                    scanner.nextLine(); //Limpiar buffer
                    System.out.println(companyName);
                    DbVistaAlquiler.createViewRetonar(scanner);
                }

                case 4 ->
                    System.out.println("Hasta luego!!!");
                default ->
                    System.out.println("Favor elija una opción correcta.");
            }

        } while (opcion != 4);

        try {
            miConexion.close();
            System.out.println("conexión cerrada exitosamente!!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("no fue posible cerrar la conexión.");
        }
    }

    // METODOS PARA EL MAIN
    public static void getMenuMain(String encabezadoMenu, String[] menu) {
        String encabezado = String.format("\n%70s\n", encabezadoMenu);
        System.out.println(encabezado);

        // menu
        for (String opcion : menu) {
            System.out.println(opcion);
        }
    }

    public static void getListByName(String nombre) {
        // BUSCAR EJEMPLAR POR NOMBRE EN DB
        String[] encabezadoArray = PantallaBusquedaNombre.ENCABEZADO_ARRAY;
        String busquedaNombre = String.format("\n| %-30s | %-18s | %-15s | %s |",
                encabezadoArray[0], encabezadoArray[1],
                encabezadoArray[2], encabezadoArray[3]);
        System.out.print("------------------------------------------------------------------------------------");
        System.out.println(busquedaNombre);
        System.out.print("------------------------------------------------------------------------------------");

        // IMPRIMIR DESDE DB LOS EJEMPLARES NO RENTADOS POR NOMBRE
        ArrayList<VistaEjemplar> ejemplaresNombre = DbVistaEjemplar.getVistaEjemplares(nombre);
        for (int i = 0; i < ejemplaresNombre.size(); i++) {
            System.out.printf("\n| %-30s | %-18s | %-15s | %4d     |",
                    ejemplaresNombre.get(i).getTitulo(),
                    ejemplaresNombre.get(i).getConsola(),
                    ejemplaresNombre.get(i).getEstanteria(),
                    ejemplaresNombre.get(i).getUnidades());
            System.out.print("\n------------------------------------------------------------------------------------");
        }

        getMenuMain(PantallaBusquedaNombre.ENCABEZADO, PantallaBusquedaNombre.getMenu());
    }
}
