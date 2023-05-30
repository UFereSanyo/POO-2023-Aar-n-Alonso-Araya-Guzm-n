// Step 1: Prototype
interface Calculator extends Cloneable {
    void performOperation(int num1, int num2);

    Calculator clone();
}
