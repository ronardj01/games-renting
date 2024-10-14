package dbentidades;

import entidades.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import ui.RentarVideoJuegos;

/**
 *
 * @author tonym
 */
public class DbVistaAlquiler {

  private static final String encabezado = RentarVideoJuegos.ENCABEZADO;
  private static String[] columnsNames = RentarVideoJuegos.ENCABEZADO_ARRAY;
  private static String[] menu = RentarVideoJuegos.Menu;
  
    private static String titulo;
    private static String fecha_renta;
    private static String fecha_devolucion;
    private static String correoUsuario;
    private static String passUsuario;
    private static int opcion = 0;
    private static int opcionRentar;
    private static int id_ejemplar;
    private static int rentado;
    private static int id_usuario;
    private static int intentosLoggIn = 0;
    private static boolean loggedIn = false;
    private static Usuario miUsuario;

  // GENERAR VISTA ALQUILER
  public static void createViewRent(Scanner scanner) {
    

    do {
      if(opcion == 1) scanner.nextLine(); //Limpiar buffer
      System.out.printf("\n%50s", encabezado);
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
              Alquiler miAlquiler = new Alquiler(id_ejemplar, id_usuario);

              // formatear fecha para que sea amigable con el usuario
              DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
              fecha_renta = miAlquiler.getFecha_renta().format(formato);
              fecha_devolucion = miAlquiler.getFecha_devolucion().format(formato);

              try {
                // enviar aquiler a la base de datos
                DbAlquiler.insertNewAlquiler(miAlquiler);

                System.out.println("-------------------------------------------------------------------------------");
                System.out.printf("| %-25s | %-12s | %-13s |\n", columnsNames[0], columnsNames[1], columnsNames[2]);
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

      System.out.printf("\n\t[ %s \t%s] ", menu[0], menu[1]);
      opcion = scanner.nextInt();
      
    } while (opcion != 2);
    scanner.nextLine();

  }
}
