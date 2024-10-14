package dbentidades;

import entidades.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.RentarVideoJuegos;
import ui.RetornarVideoJuego;

/**
 *
 * @author tonym
 */
public class DbVistaAlquiler {

    private static final String encabezadoAlquiler = RentarVideoJuegos.ENCABEZADO;
    private static final String encabezadoRetorno = RetornarVideoJuego.ENCABEZADO;
    private static final String[] columnsNamesAlquiler = RentarVideoJuegos.ENCABEZADO_ARRAY;
    private static final String[] menuAlquiler = RentarVideoJuegos.menu;
    private static final String[] columnsNamesRetorno = RetornarVideoJuego.ENCABEZADO_ARRAY;
    private static final String[] menuRetorno = RetornarVideoJuego.menu;

    private static String titulo;
    private static String fecha_renta;
    private static String fecha_devolucion;
    private static String fecha_retorno;
    private static String correoUsuario;
    private static String passUsuario;
    private static int opcion = 0;
    private static int opcionRentar;
    private static int id_alquiler;
    private static int id_ejemplar;
    private static int rentado;
    private static int id_usuario;
    private static int intentosLoggIn = 0;
    private static boolean loggedIn = false;
    private static Usuario miUsuario;
    private static Alquiler miAlquiler;

    // GENERAR VISTA ALQUILER
    public static void createViewRent(Scanner scanner) {

        do {
            if (opcion == 1) {
                scanner.nextLine(); //Limpiar buffer
            }
            System.out.printf("\n%50s", encabezadoAlquiler);
            System.out.printf("\n%60s", "Favor introducir el código del video juego: ");
            String codigo = scanner.nextLine();

            // buscar titulo del juego
            titulo = DbEjemplar.getCopyNamebyCode(codigo);

            // confirmar que el codigo del ejemplar tiene un juego asignado
            if (!titulo.isEmpty()) {

                // imprimir titulo y opciones para alquilar
                System.out.printf("\n\t%-35s | %-12s | %-12s |", titulo, "1. Alquilar", " 2. Cancelar");
                System.out.println("\n-------------------------------------------------------------------------------");

                System.out.print("\n\tElija una opción: ");
                opcionRentar = scanner.nextInt();

                switch (opcionRentar) {
                    case 1 -> {
                        // log in de usuario
                        scanner.nextLine(); // Limpiar buffer
                        do {
                            System.out.print("\nFavor introducir correo electronico: ");
                            correoUsuario = scanner.nextLine();

                            System.out.print("Favor introducir su contraseña: ");
                            passUsuario = scanner.nextLine();

                            // buscar usuario
                            miUsuario = DbUsuario.getUsuarioByCorreoAndPass(correoUsuario, passUsuario);

                            // confirmar credenciales del usuario
                            loggedIn = DbUsuario.verificarCredenciales(correoUsuario, passUsuario, miUsuario);

                            if (!loggedIn) {
                                System.out.println("\n\tContraseña o usuario incorrecto");
                                System.out
                                        .println("\n-------------------------------------------------------------------------------\n");

                                intentosLoggIn++;
                            }

                        } while (!(intentosLoggIn > 2 && loggedIn) && !(intentosLoggIn > 2) && !loggedIn);
                        if (loggedIn) {
                            // buscar ejemplar
                            Ejemplar miEjemplar = DbEjemplar.getEjemplarByCodigo(codigo);
                            id_ejemplar = miEjemplar.getIdEjemplar();

                            // obtener idusuario
                            id_usuario = miUsuario.getIdusuario();

                            // crear alquiler
                            miAlquiler = new Alquiler(id_ejemplar, id_usuario);

                            // formatear fecha para que sea amigable con el usuario
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            fecha_renta = miAlquiler.getFecha_renta().format(formato);
                            fecha_devolucion = miAlquiler.getFecha_devolucion().format(formato);

                            try {
                                // enviar aquiler a la base de datos
                                DbAlquiler.insertNewAlquiler(miAlquiler);

                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.printf("| %-25s | %-12s | %-13s |\n", columnsNamesAlquiler[0], columnsNamesAlquiler[1], columnsNamesAlquiler[2]);
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.printf("| %-25s | %10s   | %14s   |\n", titulo, fecha_renta, fecha_devolucion);
                                System.out.println("-------------------------------------------------------------------------------");

                                // Actualizar estado rentado a true
                                rentado = 1;
                                DbEjemplar.updateRentField(rentado, id_ejemplar);
                                System.out.println("\n-------------------------------------------------------------------------------");
                                System.out.println("\n\tDisfruta del Juego!");

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                System.out.println("No es posible crear el Alquilar");
                            }
                        } else {
                            System.out.println("\n\tContraseña o usuario incorrecto y ha exedido el limite de intentos fallidos!!");
                        }
                    }
                    case 2 ->
                        System.out.println("\n\tOperación cancelada\n");
                    default ->
                        System.out.println("\n\tLa opcion no es valida\n");
                }
            } else {
                System.out.println("\n\tEl código introducido no es valido");
            }

            System.out.printf("\n\t[ %s \t%s] ", menuAlquiler[0], menuAlquiler[1]);
            opcion = scanner.nextInt();

        } while (opcion != 2);
        scanner.nextLine();

    }

    public static void createViewRetonar(Scanner scanner) {
        do {
            if (opcion == 1) {
                scanner.nextLine(); //Limpiar buffer
            }
            System.out.printf("\n%50s", encabezadoRetorno);
            System.out.printf("\n%60s", "Favor introducir el código del video juego: ");
            String codigo = scanner.nextLine();

            // buscar titulo del juego
            titulo = DbEjemplar.getCopyNamebyCode(codigo);

            if (!titulo.isEmpty()) {

                // imprimir titulo y opciones para alquilar
                System.out.printf("\n\t%-35s | %-12s | %-12s |", titulo, "1. Retornar", " 2. Cancelar");
                System.out.println("\n-------------------------------------------------------------------------------");

                System.out.print("\n\tElija una opción: ");
                opcionRentar = scanner.nextInt();

                switch (opcionRentar) {
                    case 1 -> {
                        // log in de usuario
                        scanner.nextLine(); // Limpiar buffer
                        do {
                            System.out.print("\nFavor introducir correo electronico: ");
                            correoUsuario = scanner.nextLine();

                            System.out.print("Favor introducir su contraseña: ");
                            passUsuario = scanner.nextLine();

                            // buscar usuario
                            miUsuario = DbUsuario.getUsuarioByCorreoAndPass(correoUsuario, passUsuario);

                            // confirmar credenciales del usuario
                            loggedIn = DbUsuario.verificarCredenciales(correoUsuario, passUsuario, miUsuario);

                            if (!loggedIn) {
                                System.out.println("\n\tContraseña o usuario incorrecto");
                                System.out
                                        .println("\n-------------------------------------------------------------------------------\n");

                                intentosLoggIn++;
                            }

                        } while (!(intentosLoggIn > 2 && loggedIn) && !(intentosLoggIn > 2) && !loggedIn);

                        if (loggedIn) {
                            // buscar ejemplar
                            Ejemplar miEjemplar = DbEjemplar.getEjemplarByCodigo(codigo);
                            id_ejemplar = miEjemplar.getIdEjemplar();

                            // obtener idusuario
                            id_usuario = miUsuario.getIdusuario();

                            //buscar idalquiler por idusuario, idejemplar y rentado = 1
                            try {
                                id_alquiler = DbAlquiler.getIdAlquilerRented(id_ejemplar, id_usuario, 1);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                            //buscar alquiler especifico por idalquiler
                            miAlquiler = DbAlquiler.getAlquilerPorId(id_alquiler);
                            miAlquiler.setFecha_retorno(LocalDate.now());

                            // formatear fecha para que sea amigable con el usuario
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            fecha_renta = miAlquiler.getFecha_renta().format(formato);
                            fecha_devolucion = miAlquiler.getFecha_devolucion().format(formato);
                            fecha_retorno = miAlquiler.getFecha_retorno().format(formato);
                            int dias_retraso = (int) ChronoUnit.DAYS.between(miAlquiler.getFecha_devolucion(), miAlquiler.getFecha_retorno());

                            try {
                                //ACTUALIZAR ALQUILER Y ACTUALIZAR ESTADO RETORNADO DEL EJEMPLAR
                                //actualizar alquiler
                                DbAlquiler.updateFechaRetorno(id_alquiler, miAlquiler.getFecha_retorno());
                             
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            System.out.println("---------------------------------------------------------------------------------");
                            System.out.printf("| %-25s | %-12s | %-13s | %13s |\n", columnsNamesRetorno[0], columnsNamesRetorno[1], columnsNamesRetorno[2], columnsNamesRetorno[3]);
                            System.out.println("-------------------------------------------------------------------------------");
                            System.out.printf("| %-25s | %10s   | %14s   | %14s  |\n", titulo, fecha_renta, fecha_devolucion, dias_retraso);
                            System.out.println("---------------------------------------------------------------------------------");

                        } else {
                            System.out.println("\n\tContraseña o usuario incorrecto y ha exedido el limite de intentos fallidos!!");
                        }

                    }
                }

            } else {
                System.out.println("\n\tEl código introducido no es valido");
            }

        } while (opcion != 2);
        scanner.nextLine();
    }
}
