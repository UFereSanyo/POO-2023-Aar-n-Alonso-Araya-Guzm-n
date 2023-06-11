import java.util.LinkedList;
public class Proveedor {

    //primero relaciones

    //un proveedor puede tener muchos carros, para representar la relación se usará lista LinkedList
    private LinkedList<Carro> carros;

    //atributos de la clase Proveedor
    private String nombreProveedor;

    //constructor de la clase Proveedor
    Proveedor(String nombreProveedor){
        this.nombreProveedor = nombreProveedor;
        this.carros = new LinkedList<Carro>();
    }

    //agregar carro
    public void agregarCarro(Carro carro){
        this.carros.add(carro);
    }

    Carro comprarCarro(String marca, String modelo){
        return null;
    }
}
