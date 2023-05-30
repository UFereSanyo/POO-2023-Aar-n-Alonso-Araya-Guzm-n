class MultiplicationCalculator implements Calculator {
    @Override
    public void performOperation(int num1, int num2) {
        int result = num1 * num2;
        System.out.println("Multiplication Result: " + result);
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
