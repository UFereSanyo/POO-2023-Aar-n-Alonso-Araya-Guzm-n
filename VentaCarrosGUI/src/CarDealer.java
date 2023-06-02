class CarDealer {
    private CarInventory inventory;

    public CarDealer() {
        inventory = new CarInventory();
    }

    public void buyCar(Car car) {
        inventory.addCar(car);
    }

    public void sellCar(Car car) {
        inventory.getCars().remove(car);
    }

    public CarInventory getInventory() {
        return inventory;
    }
}
