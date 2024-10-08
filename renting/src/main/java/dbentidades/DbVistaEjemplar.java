package dbentidades;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import vistas.*;

/**
 *
 * @author ronar
 */
public class DbVistaEjemplar {

    private static Statement vistaEjemplarStatement = DbConnection.STATEMENT;

    public static ArrayList<VistaEjemplar> getVistaEjemplares(String nombreJuego) {

        ArrayList<VistaEjemplar> misVistasEjemplares = new ArrayList<>();
        ResultSet resultado;

        String query = "SELECT c.nombre, j.titulo, j.estanteria,"
                + " COUNT(c.nombre) AS unidades"
                + " FROM ejemplares e"
                + " JOIN juegos j ON e.id_juego = j.idjuego"
                + " JOIN consolas c ON e.id_consola = c.idconsola"
                + " WHERE j.titulo LIKE '%" + nombreJuego + "%'"
                + " AND e.rentado = 0"
                + " GROUP BY j.titulo, c.nombre, j.estanteria;";

        try {
            resultado = vistaEjemplarStatement.executeQuery(query);
            while (resultado.next()) {
                VistaEjemplar miVistaEjemplar = new VistaEjemplar();
                miVistaEjemplar.setConsola(resultado.getString("nombre"));
                miVistaEjemplar.setTitulo(resultado.getString("titulo"));
                miVistaEjemplar.setEstanteria(resultado.getString("estanteria"));
                miVistaEjemplar.setUnidades(resultado.getInt("unidades"));

                misVistasEjemplares.add(miVistaEjemplar);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misVistasEjemplares;
    }
}
