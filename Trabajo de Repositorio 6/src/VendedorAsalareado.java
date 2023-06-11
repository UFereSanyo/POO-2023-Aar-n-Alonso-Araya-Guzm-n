public class VendedorAsalareado extends Vendedor{
    private Double salario;

    VendedorAsalareado(String nombre, int cedula, String correo, int telefono, String direccion, Double salario){
        super(nombre, cedula, correo, telefono, direccion);
        this.salario = salario;
    }
}
