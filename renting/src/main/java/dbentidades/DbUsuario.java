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

        String query = "SELECT * FROM usuarios WHERE correo = '" + correo + "'"
                + " AND password = '" + pass + "'";
        try {
            resultado = usuarioStatement.executeQuery(query);
            while (resultado.next()) {
                miUsuario.setIdusuario(resultado.getInt("idusuario"));
                miUsuario.setNombre(resultado.getString("nombre"));
                miUsuario.setApellidos(resultado.getString("apellidos"));
                miUsuario.setCorreo(resultado.getString("correo"));
                miUsuario.setDireccion(resultado.getString("direccion"));
                miUsuario.setTelefono(resultado.getString("telefono"));
                miUsuario.setPassword(resultado.getString("password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miUsuario;
    }

    // METODO PARA LOGEAR USUARIO
    public static boolean verificarCredenciales(String correo, String pass, Usuario miUsuario) {
        boolean resultado = correo.equals(miUsuario.getCorreo()) && pass.equals(miUsuario.getPassword());
        return resultado;
    }

}
