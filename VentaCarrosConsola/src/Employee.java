class Employee extends Person {
    private double salary;

    public Employee(String name, String id, String phoneNumber, String email, String address, double salary) {
        super(name, id, phoneNumber, email, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
