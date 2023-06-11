import logic.Expression;

public class Main {
    public static void main(String[] args) {
        Expression inst = new Expression();
        inst.reconocer("1+2*3/2");
        System.out.println(inst.evaluar());
    }
}