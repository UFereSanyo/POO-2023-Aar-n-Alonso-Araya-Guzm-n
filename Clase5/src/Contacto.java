public class Contacto {

    public Contacto(){
    }

    private Persona laPersona;
    private String dirPer;

    public Contacto(Persona laPersona, String dirPer) {
        this.laPersona = laPersona;
        this.dirPer = dirPer;
    }

    public Contacto (String nombre,int cedula, int edad, String dirPer){
        this.laPersona = new Persona(nombre, cedula, edad);
        this.dirPer = dirPer;


    }

}
