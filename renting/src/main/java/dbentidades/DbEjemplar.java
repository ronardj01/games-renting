package dbentidades;

import entidades.Ejemplar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ronar
 */
public class DbEjemplar {

    private static Statement ejemplarStatement = DbConnection.STATEMENT;

    public static Ejemplar getEjemplarByCodigo(String codigo) {
        Ejemplar miEjemplar = new Ejemplar();
        ResultSet resultado;
        String query = "SELECT e.idejemplar, e.codigo, e.rentado, e.id_consola, e.id_juego FROM ejemplares e"
                + " WHERE e.codigo = '" + codigo + "'";

        try {
            resultado = ejemplarStatement.executeQuery(query);
            while (resultado.next()) {
                miEjemplar.setIdejemplar(resultado.getInt("idejemplar"));
                miEjemplar.setCodigo(resultado.getString("codigo"));
                miEjemplar.setRentado(resultado.getInt("rentado"));
                miEjemplar.setId_consola(resultado.getInt("id_consola"));
                miEjemplar.setId_juego(resultado.getInt("id_juego"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miEjemplar;
    }

    public static ArrayList<Ejemplar> getEjemplarByRent(int rentado) {
        ArrayList<Ejemplar> misEjemplares = new ArrayList<>();

        ResultSet resultado;
        String query = "SELECT e.idejemplar, e.codigo, e.rentado, e.id_consola, e.id_juego FROM ejemplares e"
                + " WHERE e.rentado = " + rentado;

        try {
            resultado = ejemplarStatement.executeQuery(query);
            while (resultado.next()) {
                Ejemplar miEjemplar = new Ejemplar();

                miEjemplar.setIdejemplar(resultado.getInt("idejemplar"));
                miEjemplar.setCodigo(resultado.getString("codigo"));
                miEjemplar.setRentado(resultado.getInt("rentado"));
                miEjemplar.setId_consola(resultado.getInt("id_consola"));
                miEjemplar.setId_juego(resultado.getInt("id_juego"));

                misEjemplares.add(miEjemplar);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misEjemplares;
    }

    public static void insertNewEjemplar(Ejemplar newEjemplar) throws SQLException {
        String query = "INSERT INTO `overlord`.`ejemplares` (`codigo`, `rentado`, `id_consola`, `id_juego`)"
                + " VALUES ('" + newEjemplar.getCodigo() + "', '"
                + newEjemplar.isRentado() + "', '"
                + newEjemplar.getIdConsola() + "', '"
                + newEjemplar.getIdJuego() + "')";

        ejemplarStatement.executeUpdate(query);
    }
}
