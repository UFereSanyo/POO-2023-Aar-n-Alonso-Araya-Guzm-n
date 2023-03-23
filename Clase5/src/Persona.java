public class Persona {

    public Persona(){
    }

    private String nomPer;
    private int cedPer;
    private int edadPer;

    public Persona(String nomPer, int cedPer, int edadPer) {
        this.nomPer = nomPer;
        this.cedPer = cedPer;
        this.edadPer = edadPer;
    }

    public String getNomPer() {
        return nomPer;
    }

    public void setNomPer(String nomPer) {
        this.nomPer = nomPer;
    }

    public int getCedPer() {
        return cedPer;
    }

    public void setCedPer(int cedPer) {
        this.cedPer = cedPer;
    }

    public int getEdadPer() {
        return edadPer;
    }

    public void setEdadPer(int edadPer) {
        this.edadPer = edadPer;
    }
}
