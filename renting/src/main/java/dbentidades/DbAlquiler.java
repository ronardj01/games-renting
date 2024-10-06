/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbentidades;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbAlquiler {
    private static Statement alquiler = DbConnection.STATEMENT;
    public static void getAlquiler(String codigo){
        // Alquiler alquiler = Alquiler();
        ResultSet resultado;
        String query = "SELECT j.titulo, c.nombre, e.codigo, a.fecha_renta, "
                + "a.fecha_devolucion, u.nombre AS Usuario_nombre, "
                + "u.apellidos AS Usuario_apellido, count(j.titulo) AS alquilado "
                + "from ejemplares e JOIN juegos j ON j.idjuego = e.id_juego "
                + "JOIN consola_juegos cj ON j.idjuego = cj.id_juego "
                + "JOIN consolas c ON c.idconsola = cj.id_consola "
                + "JOIN alquileres a ON a.id_ejemplar = e.idejemplar "
                + "JOIN usuarios u ON u.idusuario = a.id_usuario "
                + "where e.codigo like \"codigo\" "
                + "group by j.titulo, c.nombre, e.codigo, a.fecha_renta, a.fecha_devolucion, u.nombre, u.apellidos";
        try {
            resultado = alquiler.executeQuery(query);
            while(resultado.next()){
                System.out.println(resultado.getString("titulo"));
                System.out.println(resultado.getString("nombre"));
                System.out.println(resultado.getString("codigo"));
                System.out.println(resultado.getString("fecha_renta"));
                System.out.println(resultado.getString("fecha_devolucion"));
                System.out.println(resultado.getString("nombre"));
                System.out.println(resultado.getString("apellidos"));
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
