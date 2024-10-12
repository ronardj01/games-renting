
package dbentidades;

import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tonym
 */
public class DbUsuario {
    //CONEXION 
    private static Statement usuarioStatement = DbConnection.STATEMENT;
    
    // METODO DE BUSQUEDA DE USUARIO POR CORREO & PASS
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
    
    // METODO DE BUSQUEDA POR ID DE USUARIO
    public static Usuario getUsuarioPorId(int idusuario){
        Usuario miUsuario = new Usuario();
        ResultSet resultado;
        String query = "SELECT * FROM usuarios WHERE idusuario = '" + idusuario + "'";
        try {
            resultado = usuarioStatement.executeQuery(query);
            while(resultado.next()){
                miUsuario.setIdusuario(resultado.getInt("idusuario"));
                miUsuario.setNombre(resultado.getString("nombre"));
                miUsuario.setApellidos(resultado.getString("apellidos"));
                miUsuario.setCorreo(resultado.getString("correo"));
                miUsuario.setDireccion(resultado.getString("direccion"));
                miUsuario.setTelefono(resultado.getString("telefono"));
                miUsuario.setPassword(resultado.getString("password"));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return miUsuario;
    }
    
    // METODO PARA INSERTAR USUARIO
    public static void insertUsuario(Usuario newUsuario) throws SQLException{
        String query = "INSERT INTO `overlord`.`usuarios` (`nombre`, `apellidos`, `correo`, `direccion`, `telefono`, `password`) "
                + "VALUES ('"+ newUsuario.getNombre() +
                "', '" + newUsuario.getApellidos() +
                "', '"+ newUsuario.getCorreo() +
                "', '" + newUsuario.getDireccion() +
                "', '" + newUsuario.getTelefono() +
                "', '" + newUsuario.getPassword() + "')";
                usuarioStatement.executeUpdate(query);
        
    
    }
    
}
