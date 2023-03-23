public class Telefono extends Persona{

    public Telefono(){
        super();
    }

    private int numTel;

    public Telefono(int numTel) {
        this.numTel = numTel;
    }

    public Telefono(String nomPer, int cedPer, int edadPer, int numTel) {
        super(nomPer, cedPer, edadPer);
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "numTel=" + numTel +
                '}';
    }
}
