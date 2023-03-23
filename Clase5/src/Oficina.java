public class Oficina extends Persona {

    public Oficina(){
        super();
    }

    private int numOfi;

    public Oficina(int numOfi) {
        this.numOfi = numOfi;
    }

    public Oficina(String nomPer, int cedPer, int edadPer, int numOfi) {
        super(nomPer, cedPer, edadPer);
        this.numOfi = numOfi;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "numOfi=" + numOfi +
                '}';
    }
}
