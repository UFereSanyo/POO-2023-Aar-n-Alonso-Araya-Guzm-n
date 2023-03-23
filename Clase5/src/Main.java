import java.util.LinkedList;

public class Main {

    public static void main(String[]args){

        LinkedList<Contacto> lista = new LinkedList<Contacto>();

        lista.add(new Contacto(new Persona("Oscar", 204450632,44),"Bajo Arenal"));
        lista.add(new Contacto("Pedro", 409650332, 56, "Javillos"));

        Agenda laAgenda = new Agenda();
        laAgenda.agregarContacro(new Telefono());

    }
}
