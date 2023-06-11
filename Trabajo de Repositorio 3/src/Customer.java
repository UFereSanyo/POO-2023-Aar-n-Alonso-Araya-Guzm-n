import java.util.ArrayList;
import java.util.List;

class Customer extends Person {
    private List<Car> carsBought;
    private List<Car> carsReserved;

    public Customer(String name, String id, String phoneNumber, String email, String address) {
        super(name, id, phoneNumber, email, address);
        this.carsBought = new ArrayList<>();
        this.carsReserved = new ArrayList<>();
    }

    public void buyCar(Car car) {
        carsBought.add(car);
    }

    public void reserveCar(Car car) {
        carsReserved.add(car);
    }

    public List<Car> getCarsBought() {
        return carsBought;
    }

    public List<Car> getCarsReserved() {
        return carsReserved;
    }
}
