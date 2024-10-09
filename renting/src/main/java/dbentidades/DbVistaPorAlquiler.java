
package dbentidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbVistaPorAlquiler {
    private static Statement vistaPorAlquilerStatement = DbConnection.STATEMENT;
    public static void getPorEjemplar(String codigo) {
        ResultSet resultado;
        String query = "SELECT j.titulo, e.idejemplar FROM ejemplares e "
                + "JOIN juegos j ON j.idjuego = e.id_juego "
                + "WHERE e.codigo = '"+codigo+"'";

        try {
            resultado = vistaPorAlquilerStatement.executeQuery(query);
            while (resultado.next()) {
                
                System.out.println(resultado.getString("titulo"));              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
