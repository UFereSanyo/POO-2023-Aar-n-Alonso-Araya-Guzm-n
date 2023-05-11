import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seleccion extends JFrame {
    private JTextField preguntaTextField;
    private JTextField opcion1TextField;
    private JTextField opcion2TextField;
    private JTextField opcion3TextField;

    public Seleccion() {
        // Set JFrame title
        setTitle("Seleccion");

        // Set JFrame size
        setSize(400, 400);

        // Set layout as grid layout with one column
        setLayout(new GridLayout(0, 1));

        preguntaTextField = new JTextField();
        preguntaTextField.setBorder(BorderFactory.createTitledBorder("Agregue la pregunta"));
        add(preguntaTextField);

        opcion1TextField = new JTextField();
        opcion1TextField.setBorder(BorderFactory.createTitledBorder("Opcion 1"));
        add(opcion1TextField);

        opcion2TextField = new JTextField();
        opcion2TextField.setBorder(BorderFactory.createTitledBorder("Opcion 2"));
        add(opcion2TextField);

        opcion3TextField = new JTextField();
        opcion3TextField.setBorder(BorderFactory.createTitledBorder("Opcion 3"));
        add(opcion3TextField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pregunta = preguntaTextField.getText();
                String opcion1 = opcion1TextField.getText();
                String opcion2 = opcion2TextField.getText();
                String opcion3 = opcion3TextField.getText();
                System.out.println("Pregunta: " + pregunta);
                System.out.println("Opcion 1: " + opcion1);
                System.out.println("Opcion 2: " + opcion2);
                System.out.println("Opcion 3: " + opcion3);
                // Close the JFrame
                dispose();
            }
        });
        add(saveButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}