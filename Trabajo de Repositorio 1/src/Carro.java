import java.util.ArrayList;

public class Carro extends Empresa {

    private String matricula;
    private String marca;
    private String modelo;
    private int precioCompra;
    private int precioVenta;
    private String exposicion;

    private Proveedor[] proveedores;

    private Reparacion[] reparaciones;

    private TipoCarro[] tipoCarros;

    public Carro(String matricula, String marca, String modelo, int precioCompra, int precioVenta, String exposicion, Proveedor[] proveedores, Reparacion[] reparaciones, TipoCarro[] tipoCarros) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.exposicion = exposicion;
        this.proveedores = proveedores;
        this.reparaciones = reparaciones;
        this.tipoCarros = tipoCarros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getExposición() {
        return exposicion;
    }

    public void setExposición(String exposición) {
        this.exposicion = exposición;
    }

    public Proveedor[] getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedor[] proveedores) {
        this.proveedores = proveedores;
    }

    public Reparacion[] getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Reparacion[] reparaciones) {
        this.reparaciones = reparaciones;
    }

    public TipoCarro[] getTipoCarros() {
        return tipoCarros;
    }

    public void setTipoCarros(TipoCarro[] tipoCarros) {
        this.tipoCarros = tipoCarros;
    }
}
