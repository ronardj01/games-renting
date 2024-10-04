
package dbentidades;

import java.sql.ResultSet;
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
            while(resultado.next()){
                System.out.println(resultado.getString("titulo"));
            }
        } catch (Exception e) {
        }
    }
}
