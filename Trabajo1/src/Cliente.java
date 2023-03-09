import java.security.PrivateKey;

public class Cliente {

    private String nombre;
    private int cedula;
    private int telefono;
    private String correo;
    private String direccion;

    private TipoCliente[]tipoClientes;

    public Cliente(String nombre, int cedula, int telefono, String correo, String direccion, TipoCliente[] tipoClientes) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.tipoClientes = tipoClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCliente[] getTipoClientes() {
        return tipoClientes;
    }

    public void setTipoClientes(TipoCliente[] tipoClientes) {
        this.tipoClientes = tipoClientes;
    }
}
