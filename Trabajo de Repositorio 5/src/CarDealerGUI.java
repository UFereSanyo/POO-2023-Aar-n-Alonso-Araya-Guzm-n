import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class CarDealerGUI {
    private CarDealer dealer;
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JButton findButton;
    private JButton stockButton;
    private JButton buyButton;
    private JButton sellButton;
    private JButton repairButton;

    public CarDealerGUI() {
        dealer = new CarDealer();

        frame = new JFrame("Car Dealer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        addButton = new JButton("Add Car");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform add car operation
                String brand = JOptionPane.showInputDialog(frame, "Enter the car brand:");
                String model = JOptionPane.showInputDialog(frame, "Enter the car model:");
                String licensePlate = JOptionPane.showInputDialog(frame, "Enter the car license plate:");
                double purchasePrice = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the purchase price:"));
                double sellingPrice = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the selling price:"));
                String type = JOptionPane.showInputDialog(frame, "Enter the car type:");

                Car car = new Car(brand, model, licensePlate, purchasePrice, sellingPrice, type);

                dealer.getInventory().addCar(car);

                JOptionPane.showMessageDialog(frame, "Car added successfully!");
            }
        });

        findButton = new JButton("Find Car");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform find car operation
                String licensePlate = JOptionPane.showInputDialog(frame, "Enter the license plate:");

                Car car = dealer.getInventory().findCarByLicensePlate(licensePlate);

                if (car != null) {
                    String carInfo = "Brand: " + car.getBrand() + "\n"
                            + "Model: " + car.getModel() + "\n"
                            + "License Plate: " + car.getLicensePlate() + "\n"
                            + "Purchase Price: " + car.getPurchasePrice() + "\n"
                            + "Selling Price: " + car.getSellingPrice() + "\n"
                            + "Type: " + car.getType();
                    JOptionPane.showMessageDialog(frame, carInfo);
                } else {
                    JOptionPane.showMessageDialog(frame, "Car not found!");
                }
            }
        });

        stockButton = new JButton("View Stock");
        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform view stock operation
                List<Car> cars = dealer.getInventory().getCars();
                String stockInfo = "Stock:\n";
                for (Car car : cars) {
                    stockInfo += "Brand: " + car.getBrand() + ", Model: " + car.getModel() + ", License Plate: "
                            + car.getLicensePlate() + ", Type: " + car.getType() + "\n";
                }
                JOptionPane.showMessageDialog(frame, stockInfo);
            }
        });

        buyButton = new JButton("Buy Car");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform buy car operation
                String brand = JOptionPane.showInputDialog(frame, "Enter the car brand:");
                String model = JOptionPane.showInputDialog(frame, "Enter the car model:");
                String licensePlate = JOptionPane.showInputDialog(frame, "Enter the car license plate:");
                double purchasePrice = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the purchase price:"));
                double sellingPrice = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter the selling price:"));
                String type = JOptionPane.showInputDialog(frame, "Enter the car type:");

                Car car = new Car(brand, model, licensePlate, purchasePrice, sellingPrice, type);

                dealer.buyCar(car);

                JOptionPane.showMessageDialog(frame, "Car bought successfully!");
            }
        });

        sellButton = new JButton("Sell Car");
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform sell car operation
                String licensePlate = JOptionPane.showInputDialog(frame, "Enter the license plate:");

                Car car = dealer.getInventory().findCarByLicensePlate(licensePlate);

                if (car != null) {
                    dealer.sellCar(car);
                    JOptionPane.showMessageDialog(frame, "Car sold successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Car not found!");
                }
            }
        });

        repairButton = new JButton("Repair Car");
        repairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform repair car operation
                String licensePlate = JOptionPane.showInputDialog(frame, "Enter the license plate:");
                String repairType = JOptionPane.showInputDialog(frame, "Enter the repair type (mechanical, electrical, or body):");

                Car car = dealer.getInventory().findCarByLicensePlate(licensePlate);

                if (car != null) {
                    JOptionPane.showMessageDialog(frame, "Car repaired successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Car not found!");
                }
            }
        });

        panel.add(addButton);
        panel.add(findButton);
        panel.add(stockButton);
        panel.add(buyButton);
        panel.add(sellButton);
        panel.add(repairButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
