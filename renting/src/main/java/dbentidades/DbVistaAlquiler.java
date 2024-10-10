package dbentidades;

import entidades.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int opcion;
        int id_ejemplar;
        int rentado;
        int id_usuario = 1; //Hardcode

        //buscar titulo del juego
        titulo = DbEjemplar.getCopyNamebyCode(codigo);

        if (!titulo.isEmpty()) {

            //imprimir titulo y opciones para alquilar
            System.out.printf("\n\t%-35s | %-12s | %-12s |", titulo, "1. Alquilar", " 2. Cancelar");
            System.out.print("\nElija una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                //buscar ejemplar 
                Ejemplar miEjemplar = DbEjemplar.getEjemplarByCodigo(codigo);
                id_ejemplar = miEjemplar.getIdEjemplar();

                //crear alquiler
                Alquiler miAlquiler = new Alquiler(id_ejemplar, id_usuario);

                //formatear fecha para que sea amigable con el usuario
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                fecha_renta = miAlquiler.getFecha_renta().format(formato);
                fecha_devolucion = miAlquiler.getFecha_devolucion().format(formato);

                try {
                    //enviar aquiler a la base de datos
                    DbAlquiler.insertNewAlquiler(miAlquiler);
                    System.out.printf("\n%16s %22s %22s", "Juegos", "Fecha_Renta", "Fecha_Devolución");
                    System.out.printf("\n%16s %16s %18s", titulo, fecha_renta, fecha_devolucion);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("No es posible crear el Alquilar");
                }

            }
        } else {
            System.out.println("El código introducido no es valido");
        }

        scanner.nextLine();
    }
}
