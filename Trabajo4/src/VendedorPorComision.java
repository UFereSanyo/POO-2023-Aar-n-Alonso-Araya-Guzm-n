public class VendedorPorComision extends Vendedor{
    private int carrosVendidos;
    VendedorPorComision(String nombre, int cedula, String correo, int telefono, String direccion){
        super(nombre, cedula, correo, telefono, direccion);
        this.carrosVendidos = 0;
    }
}
