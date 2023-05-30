public class Vendedor extends Empleado {
    private double comision;
    private double salarioBase;

    public Vendedor(String nombre, String cedula, String direccion,String fechaIngreso,String telefono, double salario, double comision) {
        super(nombre, cedula, direccion,fechaIngreso, telefono, salario);
        this.comision = comision;
        this.salarioBase = salario + comision;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public double calcularQuincena() {
        return salarioBase / 2;
    }

    public double calcularSemana() {
        return salarioBase / 4;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
        this.salarioBase = getSalario() + comision;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "Nombre '" + getNombre() + '\'' +
                ", Cedula '" + getCedula() + '\'' +
                ", Direccion '" + getDireccion() + '\'' +
                ", FechaIngreso " + getFechaIngreso() + '\'' +
                ", Telefono '" + getTelefono() + '\'' +
                ", Salario " + getSalario() +
                ", Comision " + comision +
                ", SalarioBase " + salarioBase +
                '}';
    }
}