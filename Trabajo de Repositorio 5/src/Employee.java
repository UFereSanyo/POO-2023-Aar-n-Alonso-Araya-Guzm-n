class Employee extends Person {
    private double salary;

    public Employee(String name, String id, String phone, String email, String address, double salary) {
        super(name, id, phone, email, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
