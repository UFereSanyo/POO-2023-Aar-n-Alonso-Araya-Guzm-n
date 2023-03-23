import java.util.LinkedList;

public class Agenda{

    private LinkedList<Contacto> laAgenda;

    public Agenda(){
        this.laAgenda = new LinkedList<Contacto>();
    }

    public void agregarContacro(Contacto c){
        this.laAgenda.add(c);
    }

    public void imprimirAgenda(){
        for (Contacto c: this.laAgenda){
            System.out.println(c);;
        }
    }

    private Contacto[] contactos;

    public Agenda(Contacto[] contactos) {
        this.contactos = contactos;
    }

    public Contacto[] getContactos() {
        return contactos;
    }

    public void setContactos(Contacto[] contactos) {
        this.contactos = contactos;

    }



}
