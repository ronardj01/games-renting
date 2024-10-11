package dbentidades;

import entidades.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author tonym
 */
public class DbVistaAlquiler {

    private static Statement vistaPorAlquilerStatement = DbConnection.STATEMENT;

    //GENERAR VISTA ALQUILER
    public static void createViewRent(Scanner scanner) {
        System.out.printf("\n%60s", "Favor introducir el código del video juego: ");
        String codigo = scanner.nextLine();

        //varibales
        String titulo;
        String fecha_renta;
        String fecha_devolucion;
        String correoUsuario;
        String passUsuario;
        int opcion;
        int id_ejemplar;
        int RENTADO = 1;
        int id_usuario;
        int intentosLoggIn = 0;
        boolean loggedIn = false;
        Usuario miUsuario;

        //buscar titulo del juego
        titulo = DbEjemplar.getCopyNamebyCode(codigo);

        //confirmar que el codigo del ejemplar tiene un juego asignado
        if (!titulo.isEmpty()) {

            //imprimir titulo y opciones para alquilar
            System.out.printf("\n\t%-35s | %-12s | %-12s |", titulo, "1. Alquilar", " 2. Cancelar");
            System.out.println("\n-------------------------------------------------------------------------------");

            System.out.print("\n\tElija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    //log in de usuario
                    scanner.nextLine(); //Limpiar buffer
                    do {
                        System.out.print("\nFavor introducir correo electronico: ");
                        correoUsuario = scanner.nextLine();

                        System.out.print("Favor introducir su contraseña: ");
                        passUsuario = scanner.nextLine();

                        //buscar usuario
                        miUsuario = DbUsuario.getUsuarioByCorreoAndPass(correoUsuario, passUsuario);

                        //confirmar credenciales del usuario
                        loggedIn = DbUsuario.verificarCredenciales(correoUsuario, passUsuario, miUsuario);

                        if (!loggedIn) {
                            System.out.println("\n\tContraseña o usuario incorrecto");
                            System.out.println("\n-------------------------------------------------------------------------------\n");

                            intentosLoggIn++;
                        }

                    } while (!(intentosLoggIn > 2 && loggedIn) && !(intentosLoggIn > 2) && !loggedIn);
                    if (loggedIn) {
                        //buscar ejemplar
                        Ejemplar miEjemplar = DbEjemplar.getEjemplarByCodigo(codigo);
                        id_ejemplar = miEjemplar.getIdEjemplar();

                        //obtener idusuario
                        id_usuario = miUsuario.getIdusuario();

                        //crear alquiler
                        Alquiler miAlquiler = new Alquiler(id_ejemplar, id_usuario);

                        //formatear fecha para que sea amigable con el usuario
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        fecha_renta = miAlquiler.getFecha_renta().format(formato);
                        fecha_devolucion = miAlquiler.getFecha_devolucion().format(formato);

                        try {
                            //enviar aquiler a la base de datos
                            DbAlquiler.insertNewAlquiler(miAlquiler);
                            
                            System.out.println("-------------------------------------------------------------------------------");
                            System.out.printf("| %-25s | %-12s | %-13s |\n", "Juegos", "Fecha Renta", "Fecha Devolución");
                            System.out.println("-------------------------------------------------------------------------------");
                            System.out.printf("| %-25s | %10s   | %14s   |\n", titulo, fecha_renta, fecha_devolucion);
                            System.out.println("-------------------------------------------------------------------------------");

                            //Actualizar estado rentado a true
                            DbEjemplar.updateRentField(RENTADO, id_ejemplar);
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

        scanner.nextLine();
    }
}
