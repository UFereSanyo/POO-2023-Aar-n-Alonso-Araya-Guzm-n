package logic;

public class Operator extends Element{
    private char operator;

    public Operator(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
