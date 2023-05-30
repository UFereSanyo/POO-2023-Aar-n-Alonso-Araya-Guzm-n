import java.util.ArrayList;

class FacturaReparacion {
    private ArrayList<Item> items;

    public FacturaReparacion(ArrayList items) {
        this.items = items;

    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : getItems()) {
            total += item.getPrecio();
        }
        return total;
    }

    // getters y setters para los atributos
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "FacturaReparacion{" +
                "items=" + items +
                '}';
    }
}