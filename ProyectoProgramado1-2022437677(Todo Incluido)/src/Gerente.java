public class Gerente extends Empleado {
    private String area;

    public Gerente(String nombre, String cedula, String direccion, String fechaIngreso, String telefono, double salario, String area) {
        super(nombre, cedula, direccion, fechaIngreso, telefono, salario);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double calcularSalario() {
        return getSalario();
    }

    public double calcularQuincena() {
        return getSalario() / 2;
    }

    public double calcularSemana(){
        return getSalario() / 4;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "Nombre '" + getNombre() + '\'' +
                ", Cedula '" + getCedula() + '\'' +
                ", Direccion '" + getDireccion() + '\'' +
                ", FechaIngreso " + getFechaIngreso() +
                ", Telefono '" + getTelefono() + '\'' +
                ", Salario " + getSalario() +
                ", Area '" + area + '\'' +
                '}';
    }
}
