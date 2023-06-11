import java.util.ArrayList;
import java.util.List;

class CommissionEmployee extends Employee {
    private List<Car> carsSold;

    public CommissionEmployee(String name, String id, String phoneNumber, String email, String address, double salary) {
        super(name, id, phoneNumber, email, address, salary);
        this.carsSold = new ArrayList<>();
    }

    public void sellCar(Car car) {
        carsSold.add(car);
    }

    public List<Car> getCarsSold() {
        return carsSold;
    }
}
