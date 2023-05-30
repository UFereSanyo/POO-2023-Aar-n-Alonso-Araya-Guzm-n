class DivisionCalculator implements Calculator {
    @Override
    public void performOperation(int num1, int num2) {
        if (num2 != 0) {
            double result = (double) num1 / num2;
            System.out.println("Division Result: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    @Override
    public Calculator clone() {
        try {
            return (Calculator) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
