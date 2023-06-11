import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class CarInventorySystem {
    private Scanner scanner;
    private List<Car> cars;
    private List<CommissionEmployee> commissionEmployees;
    private List<Customer> customers;

    public CarInventorySystem() {
        this.scanner = new Scanner(System.in);
        this.cars = new ArrayList<>();
        this.commissionEmployees = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    sellCar();
                    break;
                case 3:
                    repairCar();
                    break;
                case 4:
                    buyCarsFromSupplier();
                    break;
                case 5:
                    listCarsInStock();
                    break;
                case 6:
                    listCarsSoldByCommissionEmployees();
                    break;
                case 7:
                    listCarsBoughtByCustomers();
                    break;
                case 8:
                    listCarsReservedByCustomers();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Program exited.");
    }

    private void printMenu() {
        System.out.println("===== Car Inventory System Menu =====");
        System.out.println("1. Add a car");
        System.out.println("2. Sell a car");
        System.out.println("3. Repair a car");
        System.out.println("4. Buy cars from supplier");
        System.out.println("5. List cars in stock");
        System.out.println("6. List cars sold by commission employees");
        System.out.println("7. List cars bought by customers");
        System.out.println("8. List cars reserved by customers");
        System.out.println("9. Exit program");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addCar() {
        System.out.print("Enter car brand: ");
        String brand = scanner.next();
        System.out.print("Enter car model: ");
        String model = scanner.next();
        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.next();
        System.out.print("Enter purchase price: ");
        double purchasePrice = scanner.nextDouble();
        System.out.print("Enter sale price: ");
        double salePrice = scanner.nextDouble();
        System.out.print("Enter car type (rental, industrial, off-road): ");
        String type = scanner.next();

        Car car = new Car(brand, model, licensePlate, purchasePrice, salePrice, type);
        cars.add(car);

        System.out.println("Car added to stock: " + car.getBrand() + " " + car.getModel() + " (License Plate: " +
                car.getLicensePlate() + ")");
    }

    private void sellCar() {
        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.next();

        Car car = findCarByLicensePlate(licensePlate);
        if (car != null && !car.needsRepair()) {
            System.out.print("Enter customer ID: ");
            String customerId = scanner.next();

            Customer customer = findCustomerById(customerId);
            if (customer != null) {
                customer.buyCar(car);
                System.out.println("Car sold to customer: " + customer.getName());
            } else {
                System.out.println("Customer not found.");
            }
        } else {
            System.out.println("Car not found or cannot be sold.");
        }
    }

    private void repairCar() {
        System.out.print("Enter car license plate: ");
        String licensePlate = scanner.next();

        Car car = findCarByLicensePlate(licensePlate);
        if (car != null && car.needsRepair()) {
            System.out.print("Enter repair type (mechanical, electrical, body): ");
            String repairType = scanner.next();

            car.addRepair(repairType);
            car.setNeedsRepair(false);

            System.out.println("Car repaired: " + car.getBrand() + " " + car.getModel() + " (License Plate: " +
                    car.getLicensePlate() + ")");
        } else {
            System.out.println("Car not found or does not need repair.");
        }
    }

    private void buyCarsFromSupplier() {
        System.out.print("Enter number of cars to buy: ");
        int numCars = scanner.nextInt();

        for (int i = 0; i < numCars; i++) {
            String brand = generateRandomBrand();
            String model = generateRandomModel();
            String licensePlate = generateLicensePlate();
            double purchasePrice = generateRandomPrice(5000, 20000);
            double salePrice = purchasePrice + (purchasePrice * 0.1);
            String type = generateRandomType();

            Car car = new Car(brand, model, licensePlate, purchasePrice, salePrice, type);
            cars.add(car);
        }

        System.out.println(numCars + " cars bought from supplier.");
    }

    private void listCarsInStock() {
        System.out.println("Cars in stock:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " " + car.getModel() + " (License Plate: " + car.getLicensePlate() +
                    ")");
        }
    }

    private void listCarsSoldByCommissionEmployees() {
        System.out.println("Cars sold by commission employees:");
        for (CommissionEmployee employee : commissionEmployees) {
            List<Car> carsSold = employee.getCarsSold();
            if (!carsSold.isEmpty()) {
                System.out.println("Employee: " + employee.getName());
                for (Car car : carsSold) {
                    System.out.println("- " + car.getBrand() + " " + car.getModel() + " (License Plate: " +
                            car.getLicensePlate() + ")");
                }
            }
        }
    }

    private void listCarsBoughtByCustomers() {
        System.out.println("Cars bought by customers:");
        for (Customer customer : customers) {
            List<Car> carsBought = customer.getCarsBought();
            if (!carsBought.isEmpty()) {
                System.out.println("Customer: " + customer.getName());
                for (Car car : carsBought) {
                    System.out.println("- " + car.getBrand() + " " + car.getModel() + " (License Plate: " +
                            car.getLicensePlate() + ")");
                }
            }
        }
    }

    private void listCarsReservedByCustomers() {
        System.out.println("Cars reserved by customers:");
        for (Customer customer : customers) {
            List<Car> carsReserved = customer.getCarsReserved();
            if (!carsReserved.isEmpty()) {
                System.out.println("Customer: " + customer.getName());
                for (Car car : carsReserved) {
                    System.out.println("- " + car.getBrand() + " " + car.getModel() + " (License Plate: " +
                            car.getLicensePlate() + ")");
                }
            }
        }
    }

    private Car findCarByLicensePlate(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    private String generateRandomBrand() {
        String[] brands = {"Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "BMW"};
        return brands[new Random().nextInt(brands.length)];
    }

    private String generateRandomModel() {
        String[] models = {"Camry", "Civic", "F-150", "Silverado", "Golf", "X5"};
        return models[new Random().nextInt(models.length)];
    }

    private String generateLicensePlate() {
        StringBuilder licensePlate = new StringBuilder();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        for (int i = 0; i < 3; i++) {
            licensePlate.append(letters.charAt(new Random().nextInt(letters.length())));
        }

        for (int i = 0; i < 3; i++) {
            licensePlate.append(numbers.charAt(new Random().nextInt(numbers.length())));
        }

        return licensePlate.toString();
    }

    private double generateRandomPrice(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    private String generateRandomType() {
        String[] types = {"Rental", "Industrial", "Off-road"};
        return types[new Random().nextInt(types.length)];
    }
}
