public abstract class Empleado {
    private String nombre;
    private String cedula;
    private String direccion;
    private String fechaIngreso;
    private String telefono;
    private double salario;

    public Empleado(String nombre, String cedula, String direccion, String fechaIngreso,String telefono,double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
        this.salario = salario;
    }

    public Empleado(String nombre, String cedula, String telefono, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre '" + (nombre != null ? nombre : "") + '\'' +
                ", Cedula '" + (cedula != null ? cedula : "") + '\'' +
                ", Direccion '" + (direccion != null ? direccion : "") + '\'' +
                ", FechaIngreso " + (fechaIngreso != null ? fechaIngreso : "") +
                ", Telefono '" + (telefono != null ? telefono : "") + '\'' +
                ", Salario " + salario +
                '}';
    }
}