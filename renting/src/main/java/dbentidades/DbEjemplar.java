package dbentidades;

import entidades.Ejemplar;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ronar
 */
public class DbEjemplar {

    private static Statement ejemplarStatement = DbConnection.STATEMENT;

    public static void getEjemplarByName(String name) {
        //Ejemplar miEjemplar = new Ejemplar();
        ResultSet resultado;
        String query = "SELECT j.titulo, c.nombre, e.estanteriaC, e.estanteriaF FROM ejemplares e"
                + " JOIN juegos j ON e.id_juego = j.idjuego"
                + " JOIN consolas c ON e.id_consola = c.idconsola"
                + " WHERE j.titulo LIKE '" + name + "%' AND e.rentado = 0;";

        try {
            resultado = ejemplarStatement.executeQuery(query);
            while (resultado.next()) {
                System.out.println(resultado.getString("titulo"));
                System.out.println(resultado.getString("nombre"));
                System.out.println(resultado.getString("estanteriaC")); 
                System.out.println(resultado.getString("estanteriaF"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return miEjemplar;
    }
}
