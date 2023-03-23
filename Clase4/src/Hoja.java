import java.util.ArrayList;

public class Hoja {

    private ArrayList<ObjRep> objetos;

    public Hoja(ArrayList<ObjRep> objetos) {
        this.objetos = objetos;
    }

    public Hoja() {
        this.objetos = new ArrayList<ObjRep>();
    }

    public ArrayList<ObjRep> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjRep> objetos) {
        this.objetos = objetos;
    }
}
