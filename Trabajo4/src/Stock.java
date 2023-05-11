import java.util.LinkedList;
public class Stock {

    // relaciones
    //para representar que el stock tiene muchos proveedores a los que comprar carros se usará una lista LinkedList
    private LinkedList<Proveedor> proveedores;

    //para representar que el stock tiene muchos carros se usará una lista LinkedList
    private LinkedList<Carro> carros;

    //atributos de la clase Stock

    //constructor de la clase Stock
    Stock(){
        this.proveedores = new LinkedList<Proveedor>();
        this.carros = new LinkedList<Carro>();
    }

    Cliente getInformacionComprador(String matricula){
        return null;
    }

    LinkedList<Carro> getCarros(){//solo carros que no tengan cliente, osea que no hayan sido comprados
        return this.carros;
    }
}
