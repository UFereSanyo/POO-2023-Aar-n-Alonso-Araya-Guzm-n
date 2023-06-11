import java.util.LinkedList;
public class Cliente extends Persona{

    //relacion el cliente puede comprar muchos carros, se usará una lista LinkedList
    private LinkedList<Carro> carrosComprados;
    private Boolean aComprado;

    Cliente(String nombre, int cedula, String correo, int telefono, String direccion){
        super(nombre, cedula, correo, telefono, direccion);
        this.aComprado = false;
    }
}
