import javax.swing.*;

// Usage
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calculatorApp = new CalculatorApp();
            calculatorApp.setVisible(true);
        });
    }
}
