import java.util.List;

class CarInventory {
    private List<Car> cars;

    public CarInventory() {
        cars = new java.util.ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findCarByLicensePlate(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }
}
