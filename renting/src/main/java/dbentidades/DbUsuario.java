/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbentidades;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbUsuario {

    private static Statement usuarioStatement = DbConnection.STATEMENT;

    public static void getUsuario(String correo, String password) {
        ResultSet resultado;

        String query = "SELECT * FROM usuarios WHERE correo = 'correo'"
                + " AND password = 'password'"; 
        try {
            resultado = usuarioStatement.executeQuery(query);
            while(resultado.next()){
                System.out.println("Inicio de sesion exitoso");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
