package entidades;

/**
 *
 * @author ronar
 */
public class Usuario {

    //atributos
    private int idusuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private String password;

    //constructores
    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String correo, String direccion, String telefono, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.password = password;
    }

    //getters
    public int getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    //setters
    
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //métodos
    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + ", password=" + password + '}';
    }
}
