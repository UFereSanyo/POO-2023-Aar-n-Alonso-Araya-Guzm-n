class Item {
    private String descripcion;
    private String estado;
    private String motivo;
    private double precio;

    public Item(String descripcion, String estado,String motivo, double precio) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.motivo = motivo;
        this.precio = precio;
    }

    // getters y setters para los atributos

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", motivo='" + motivo + '\'' +
                ", precio=" + precio +
                '}';
    }
}