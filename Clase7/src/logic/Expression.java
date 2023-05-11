package logic;

import java.util.LinkedList;

public class Expression {
    private LinkedList<Element> expression;

    public Expression() {
        this.expression = new LinkedList<Element>();
    }

    public void reconocer(String cadena){
        for (char c: cadena.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/')
                this.expression.add(new Operator(c));
            else if ((c>= '0') && (c<='9'))
                this.expression.add(new Number(Integer.parseInt(String.valueOf(c))));
            else
                throw new IllegalCharacterException("Caracter no renonocible", c);
        }
    }

    public float evaluar(){
        float result=0;
        while (this.expression.size() > 1) {
            Element v1 = this.expression.get(0);
            Element op = this.expression.get(1);
            Element v2 = this.expression.get(2);

            if(((Operator)op).getOperator() == '+')
                result = ((Number)v1).getNumber()+((Number)v2).getNumber();
            else if(((Operator)op).getOperator() == '-')
                result = ((Number)v1).getNumber()-((Number)v2).getNumber();
            else if(((Operator)op).getOperator() == '*')
                result = ((Number)v1).getNumber()*((Number)v2).getNumber();
            else if(((Operator)op).getOperator() == '/')
                result = ((Number)v1).getNumber()/((Number)v2).getNumber();

            //se eliminan los elementos de la lista antes de agregar el resultado de la operación
            this.expression.remove(0);
            this.expression.remove(0);
            this.expression.remove(0);

            //agregar el resultado de la operación
            this.expression.add(0,new Number(result));
        }

        return ((Number) this.expression.get(0)).getNumber();
    }
}
