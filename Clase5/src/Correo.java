public class Correo extends Persona{

    public Correo(){
        super();
    }

    private String dirCor;

    public Correo(String dirCor) {
        this.dirCor = dirCor;
    }

    public Correo(String nomPer, int cedPer, int edadPer, String dirCor) {
        super(nomPer, cedPer, edadPer);
        this.dirCor = dirCor;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "dirCor='" + dirCor + '\'' +
                '}';
    }
}
