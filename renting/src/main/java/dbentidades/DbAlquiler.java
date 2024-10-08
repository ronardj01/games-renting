/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbentidades;

import entidades.Alquiler;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbAlquiler {

    private static Statement alquiler = DbConnection.STATEMENT;

    public static Alquiler getAlquilerPorId(int idalquiler) {
         Alquiler miAlquiler = new Alquiler();
        ResultSet resultado;
        String query = "SELECT idalquiler, fecha_renta, fecha_devolucion, fecha_retorno, id_ejemplar, id_usuario FROM alquileres  WHERE idalquiler = '" + idalquiler + "'";
        try {
            resultado = alquiler.executeQuery(query);
            while (resultado.next()) {
                miAlquiler.setIdalquiler(resultado.getInt("idalquiler"));
                miAlquiler.setFecha_renta(resultado.getString("fecha_renta"));
                miAlquiler.setFecha_devolucion(resultado.getString("fecha_devolucion"));
                miAlquiler.setFecha_retorno(resultado.getString("fecha_retorno"));
                miAlquiler.setId_ejemplar(resultado.getInt("id_ejemplar"));
                miAlquiler.setId_usuario(resultado.getInt("id_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miAlquiler;
    }
}
