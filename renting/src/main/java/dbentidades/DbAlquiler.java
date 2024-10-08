/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbentidades;

import entidades.Alquiler;
import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tonym
 */
public class DbAlquiler {

    private static Statement alquiler = DbConnection.STATEMENT;

    public static Alquiler getPorUsuario(int id_usuario) {
        Alquiler miAlquiler = new Alquiler();
        ResultSet resultado;
        String query = "SELECT idalquiler, fecha_renta, fecha_devolucion, fecha_retorno, id_ejemplar, id_usuario FROM alquileres  WHERE id_usuario = '" + id_usuario + "'";

        try {
            resultado = alquiler.executeQuery(query);
            while (resultado.next()) {
                miAlquiler.setIdalquiler(resultado.getInt("idalquiler"));
                miAlquiler.setFecha_renta(LocalDate.parse(resultado.getString("fecha_renta")));
                miAlquiler.setFecha_devolucion(LocalDate.parse(resultado.getString("fecha_devolucion")));
                miAlquiler.setFecha_retorno(LocalDate.parse(resultado.getString("fecha_retorno")));
                miAlquiler.setId_ejemplar(resultado.getInt("id_ejemplar"));
                miAlquiler.setId_usuario(resultado.getInt("id_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miAlquiler;
    }

    public static Alquiler getAlquilerPorId(int idalquiler) {
        Alquiler miAlquiler = new Alquiler();
        ResultSet resultado;
        String query = "SELECT idalquiler, fecha_renta, fecha_devolucion, fecha_retorno, id_ejemplar, id_usuario FROM alquileres  WHERE idalquiler = '" + idalquiler + "'";
        try {
            resultado = alquiler.executeQuery(query);
            while (resultado.next()) {
                miAlquiler.setIdalquiler(resultado.getInt("idalquiler"));
                miAlquiler.setFecha_renta(LocalDate.parse(resultado.getString("fecha_renta")));
                miAlquiler.setFecha_devolucion(LocalDate.parse(resultado.getString("fecha_devolucion")));
                miAlquiler.setFecha_retorno(LocalDate.parse(resultado.getString("fecha_retorno")));
                miAlquiler.setId_ejemplar(resultado.getInt("id_ejemplar"));
                miAlquiler.setId_usuario(resultado.getInt("id_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miAlquiler;
    }

    public static Alquiler getPorDevolucion(LocalDate fechaDevolucion) {
        Alquiler miAlquiler = new Alquiler();
        ResultSet resultado;

        // La funcion esta trabajando con datos Hardcodeados --------->getPorDevolucion()<-----------
        String fechaDevolucionStr = fechaDevolucion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String query = "SELECT * FROM alquileres WHERE fecha_devolucion = '" + fechaDevolucionStr + "'";
        try {
            resultado = alquiler.executeQuery(query);
            while (resultado.next()) {
                 miAlquiler.setIdalquiler(resultado.getInt("idalquiler"));
                miAlquiler.setFecha_renta(LocalDate.parse(resultado.getString("fecha_renta")));
                miAlquiler.setFecha_devolucion(LocalDate.parse(resultado.getString("fecha_devolucion")));
                miAlquiler.setFecha_retorno(LocalDate.parse(resultado.getString("fecha_retorno")));
                miAlquiler.setId_ejemplar(resultado.getInt("id_ejemplar"));
                miAlquiler.setId_usuario(resultado.getInt("id_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miAlquiler;
    }
    public static void insertNewAlquiler(Alquiler newAlquiler) throws SQLException {
        String query = "INSERT INTO `overlord`.`alquileres` (`fecha_renta`, `fecha_devolucion`, `id_ejemplar`, `id_usuario`) "
                + " VALUES ('" + newAlquiler.getFecha_renta() + "', '"
                + newAlquiler.getFecha_devolucion() + "', '"
                + newAlquiler.getId_ejemplar() + "', '"
                + newAlquiler.getId_usuario() + "')";


        
        alquiler.executeUpdate(query);
    }
}
