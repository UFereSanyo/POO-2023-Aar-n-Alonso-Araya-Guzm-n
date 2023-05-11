import java.util.LinkedList;
public class Carro {

    //primero las relaciones:

    //un cliente puede tener muchas reparaciones, para representar la relación se usará lista LinkedList
    private LinkedList<Reparacion> reparaciones;

    //un carro tiene un proveedor, para representar la relación se usará un objeto de la clase Proveedor
    private Proveedor proveedor;

    //el carro tiene un cliente, para representar la relación se usará un objeto de la clase Cliente
    private Cliente cliente;

    //el carro tiene un vendedor, para representar la relación se usará un objeto de la clase Vendedor
    private Vendedor vendedor;

    //carro no necesita saber el stock ya que solo existe un stock de carros

    //atributos de la clase Carro
    private String marca;
    private String modelo;
    private String matricula;
    private Double precioVenta;
    private Double precioCompra;
    private String tipoCarro;
    private Boolean vendido;
    private String lugarExposicion;

    //constructor de la clase Carro
    Carro(String marca, String modelo, String matricula, Double precioVenta, Double precioCompra, String tipoCarro, Boolean vendido, String lugarExposicion){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.tipoCarro = tipoCarro;
        this.vendido = vendido;
        this.lugarExposicion = lugarExposicion;
        this.reparaciones = new LinkedList<Reparacion>();
    }

    //agregar proveedor
    public void agregarProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    //agregar cliente
    public void agregarCliente(Cliente cliente){
        this.cliente = cliente;
        this.vendido = true; //si al carro se le asigna un cliente es porque ya fue vendido
    }

    //agregar vendedor
    public void agregarVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }

}
