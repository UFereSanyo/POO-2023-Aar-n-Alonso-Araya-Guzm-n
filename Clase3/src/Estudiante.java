public class Estudiante {

    private String nombre;
    private int edad;
    private int año;
    private String carrera;

    public Estudiante(String nombre, int edad, int año, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.edad = edad;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", año=" + año +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}

