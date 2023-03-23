public class Documento {

    private Hoja[] hojas;

    public Documento(Hoja[] hojas) {
        this.hojas = hojas;
    }

    public Hoja[] getHojas() {
        return hojas;
    }

    public void setHojas(Hoja[] hojas) {
        this.hojas = hojas;
    }
}
