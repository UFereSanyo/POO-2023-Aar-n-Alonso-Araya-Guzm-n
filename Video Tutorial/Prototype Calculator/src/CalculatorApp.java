import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

// Step 3: Interface
class CalculatorApp extends JFrame implements ActionListener {
    private JComboBox<String> operatorComboBox;
    private JTextField number1Field;
    private JTextField number2Field;
    private JButton calculateButton;

    private static final Map<String, Calculator> calculatorCache = new HashMap<>();

    static {
        calculatorCache.put("+", new AdditionCalculator());
        calculatorCache.put("-", new SubtractionCalculator());
        calculatorCache.put("*", new MultiplicationCalculator());
        calculatorCache.put("/", new DivisionCalculator());
    }

    public CalculatorApp() {
        setTitle("2-Digit Number Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        operatorComboBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        number1Field = new JTextField(10);
        number2Field = new JTextField(10);
        calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(this);

        add(new JLabel("Number 1: "));
        add(number1Field);
        add(new JLabel("Number 2: "));
        add(number2Field);
        add(new JLabel("Operator: "));
        add(operatorComboBox);
        add(calculateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operator = operatorComboBox.getSelectedItem().toString();
        int number1 = Integer.parseInt(number1Field.getText());
        int number2 = Integer.parseInt(number2Field.getText());

        Calculator calculator = calculatorCache.get(operator);
        if (calculator != null) {
            Calculator clonedCalculator = calculator.clone();
            clonedCalculator.performOperation(number1, number2);
        } else {
            System.out.println("Invalid operator.");
        }
    }
}
