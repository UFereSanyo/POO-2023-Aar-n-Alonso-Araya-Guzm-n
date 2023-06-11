class Car {
    private String brand;
    private String model;
    private String licensePlate;
    private double purchasePrice;
    private double sellingPrice;
    private String type;

    public Car(String brand, String model, String licensePlate, double purchasePrice, double sellingPrice, String type) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
