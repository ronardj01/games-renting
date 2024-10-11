/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbentidades;

import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbUsuario {

    private static Statement usuarioStatement = DbConnection.STATEMENT;

    public static Usuario getUsuarioByCorreoAndPass(String correo, String pass) {
        Usuario miUsuario = new Usuario();
        ResultSet resultado;

        String query = "SELECT * FROM usuarios WHERE correo = 'correo'"
                + " AND password = 'pass'";
        try {
            resultado = usuarioStatement.executeQuery(query);
            while (resultado.next()) {
                miUsuario.getIdusuario(resultado.getInt("idusario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miUsuario;
    }

}
