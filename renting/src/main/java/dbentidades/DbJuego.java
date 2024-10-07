
package dbentidades;

import entidades.Juego;
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
     public static Juego getBusquedaPorNombre(String titulo) {
        Juego miJuego = new Juego();
        ResultSet resultado;
        String query = "select titulo, genero, estanteria from juegos where titulo like '" + titulo + "'";

        try {
            resultado = juegoStatement.executeQuery(query);
            while (resultado.next()) {
                miJuego.setTitulo(resultado.getString("titulo"));
                miJuego.setGenero(resultado.getString("genero"));
                miJuego.setEstanteria(resultado.getString("estanteria"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miJuego;
    }
    public static String insertNewJuego(Juego miJuego){
        String resultado;
        
        String query = "INSERT INTO `overlord`.`juegos` (`titulo`, `genero`, `estanteria`) "
                + "VALUES ('" + miJuego.getTitulo()
                + "', '"+ miJuego.getGenero()
                + "', '" + miJuego.getEstanteria()+ "')";
        try {
            juegoStatement.executeUpdate(query);
            resultado = "Juego insertado";
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Juego no insertado";
        }
    return resultado;
    }
}
