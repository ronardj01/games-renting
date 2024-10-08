package dbentidades;

import entidades.Juego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ronar
 */
public abstract class DbJuego {

    private static Statement juegoStatement = DbConnection.STATEMENT;

    public static void getJuego() {
        ResultSet resultado;
        String query = "SELECT * FROM juegos";

        try {
            resultado = juegoStatement.executeQuery(query);
            while (resultado.next()) {
                System.out.println(resultado.getString("titulo"));
            }
        } catch (Exception e) {
        }
    }

    public static Juego BusquedaPorNombre(String titulo) {
        Juego miJuego = new Juego();
        ResultSet resultado;
        String query = "select idjuego, titulo, genero, estanteria from juegos where titulo like '" + titulo + "%'";

        try {
            resultado = juegoStatement.executeQuery(query);
            while (resultado.next()) {
                miJuego.setIdjuego(resultado.getInt("idjuego"));
                miJuego.setTitulo(resultado.getString("titulo"));
                miJuego.setGenero(resultado.getString("genero"));
                miJuego.setEstanteria(resultado.getString("estanteria"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miJuego;
    }

    public static Juego getBusquedaPorId(int idjuego) {
        Juego miJuego = new Juego();
        ResultSet resultado;
        String query = "select idjuego, titulo, genero, estanteria from juegos where idjuego = '" + idjuego + "'";

        try {
            resultado = juegoStatement.executeQuery(query);
            while (resultado.next()) {
                miJuego.setIdjuego(resultado.getInt("idjuego"));
                miJuego.setTitulo(resultado.getString("titulo"));
                miJuego.setGenero(resultado.getString("genero"));
                miJuego.setEstanteria(resultado.getString("estanteria"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miJuego;
    }

    public static void insertNewJuego(Juego miJuego) throws SQLException {

        String query = "INSERT INTO `overlord`.`juegos` (`titulo`, `genero`, `estanteria`) "
                + "VALUES ('" + miJuego.getTitulo()
                + "', '" + miJuego.getGenero()
                + "', '" + miJuego.getEstanteria() + "')";

        juegoStatement.executeUpdate(query);

    }
}
