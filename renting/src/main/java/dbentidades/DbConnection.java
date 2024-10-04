package dbentidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luisa
 */
public abstract class DbConnection {

    //Datos DB
    private static final String URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "overlord";
    private static final String USER = System.getenv("DB_USER_PRUEBA");
    private static final String PASS = System.getenv("DB_PASS_PRUEBA");

    //CONEXION DB
    public static Statement STATEMENT;

    //Métodos
    //MAKE CONNECTION
    public static Connection getConnection() {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DbConnection.URL + "/" + DbConnection.DATABASE, DbConnection.USER, DbConnection.PASS);
            STATEMENT = connection.createStatement();
            System.out.println("Data Base Connection OK");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
