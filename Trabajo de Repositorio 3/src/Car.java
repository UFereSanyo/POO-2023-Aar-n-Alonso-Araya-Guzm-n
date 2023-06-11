import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private String licensePlate;
    private double purchasePrice;
    private double salePrice;
    private String type;
    private boolean needsRepair;
    private List<String> repairs;

    public Car(String brand, String model, String licensePlate, double purchasePrice, double salePrice, String type) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.type = type;
        this.needsRepair = false;
        this.repairs = new ArrayList<>();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public String getType() {
        return type;
    }

    public boolean needsRepair() {
        return needsRepair;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public void addRepair(String repairType) {
        repairs.add(repairType);
    }

    public List<String> getRepairs() {
        return repairs;
    }
}
