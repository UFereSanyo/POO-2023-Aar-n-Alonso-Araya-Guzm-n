public class Curso {

    private String nombre;
    private String descripción;
    private int capacidad;
    private int indiceActual;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private Estudiante[] estudiantes;

    public Curso(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estudiantes = new Estudiante[capacidad];

    }

    public void  agregarEstudiante( Estudiante p){
        if (indiceActual < this.capacidad) {
            this.estudiantes[indiceActual] = p;
            indiceActual ++ ;
        }
        else System.out.println("No se puede agregar más");
    }





    @Override
    public String toString() {
        return "Clase{" +
                "nombre='" + nombre + '\'' +
                ", descripción='" + descripción + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
