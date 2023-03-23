public class Persona {

    private String nombre;
    private String apellidos;
    private int edad;
    private boolean mayorEdad;

    public Persona(String nombre, String apellidos, int edad, boolean mayorEdad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.mayorEdad = mayorEdad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isMayorEdad() {
        return mayorEdad;
    }

    public void setMayorEdad(boolean mayorEdad) {
        this.mayorEdad = mayorEdad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", mayorEdad=" + mayorEdad +
                '}';
    }


}
