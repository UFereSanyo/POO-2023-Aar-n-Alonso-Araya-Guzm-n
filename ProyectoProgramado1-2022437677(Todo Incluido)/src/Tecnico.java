public class Tecnico extends Empleado {
    private String especialidad;

    public Tecnico(String nombre, String cedula, String direccion, String fechaIngreso,String telefono, double salario, String especialidad) {
        super(nombre, cedula, direccion, fechaIngreso, telefono, salario);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double calcularSalarioBase() {
        double bonificacionEspecialidad = 0.0;
        if (especialidad == "Televisores") {
            bonificacionEspecialidad = 300.0;
        } else if (especialidad =="Computadoras") {
            bonificacionEspecialidad = 200.0;
        } else if (especialidad ==("Celulares")) {
            bonificacionEspecialidad = 100.0;
        }
        double salarioComisionado = getSalario()+bonificacionEspecialidad;
        return salarioComisionado;
    }

    double salarioBase = calcularSalarioBase();

    public double calcularSalario() {
        return salarioBase;
    }

    public double calcularQuincena() {
        return salarioBase / 2;
    }

    public double calcularSemana(){
        return salarioBase / 4;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "Nombre '" + getNombre() + '\'' +
                ", Cedula '" + getCedula() + '\'' +
                ", Direccion '" + getDireccion() + '\'' +
                ", FechaIngreso '" + getFechaIngreso() + '\'' +
                ", Telefono '" + getTelefono() + '\'' +
                ", Salario " + getSalario() + '\'' +
                ", Especialidad '" + especialidad + '\'' +
                ", SalarioBase " + salarioBase +
                '}';
    }
}