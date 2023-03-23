public class Grp extends ObjRep {

    private ObjRep objeto1;
    private ObjRep objeto2;

    public Grp(ObjRep objeto1, ObjRep objeto2) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
    }

    public Grp() {

        super();

    }

    public ObjRep getObjeto1() {
        return objeto1;
    }

    public void setObjeto1(ObjRep objeto1) {
        this.objeto1 = objeto1;
    }

    public ObjRep getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(ObjRep objeto2) {
        this.objeto2 = objeto2;
    }
}
