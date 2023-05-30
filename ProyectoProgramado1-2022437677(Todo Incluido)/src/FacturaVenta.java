import java.util.ArrayList;

class FacturaVenta{
    private ArrayList<Articulo> articulos;
    private double descuento;

    public FacturaVenta(ArrayList articulos,  double descuento) {
        this.articulos = articulos;
        this.descuento = descuento;
    }

    public double calcularTotal() {
        double total = 0;
        for (Articulo articulo : getArticulos()) {
            total += articulo.getPrecio();

        }
        double descontado = descuento * 0.01 * total;
        total = total - descontado;
        return total;
    }

    // getters y setters para los atributos

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "FacturaVenta{" +
                ", articulos=" + articulos +
                ", descuento=" + descuento +
                '}';
    }
}