public class Vendedor extends Persona{
    Vendedor(String nombre, int cedula, String correo, int telefono, String direccion){
        super(nombre, cedula, correo, telefono, direccion);
    }

    public Boolean realizarVenta(Cliente cliente, Carro vehiculo){
        return null;
    }
}
