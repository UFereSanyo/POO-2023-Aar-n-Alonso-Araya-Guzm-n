import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Respuesta extends JFrame {
    private JTextField preguntaTextField;
    private JTextField posibleRespuesta1TextField;
    private JTextField posibleRespuesta2TextField;
    private JTextField posibleRespuesta3TextField;

    public Respuesta() {
        setTitle("Respuesta Breve");
        setSize(400, 400);

        setLayout(new GridLayout(0, 1));

        preguntaTextField = new JTextField();
        preguntaTextField.setBorder(BorderFactory.createTitledBorder("Agregue la pregunta"));
        add(preguntaTextField);

        posibleRespuesta1TextField = new JTextField();
        posibleRespuesta1TextField.setBorder(BorderFactory.createTitledBorder("Respuesta Valida 1"));
        add(posibleRespuesta1TextField);

        posibleRespuesta2TextField = new JTextField();
        posibleRespuesta2TextField.setBorder(BorderFactory.createTitledBorder("Respuesta Valida 2"));
        add(posibleRespuesta3TextField);

        posibleRespuesta3TextField = new JTextField();
        posibleRespuesta3TextField.setBorder(BorderFactory.createTitledBorder("Respuesta Valida 3"));
        add(posibleRespuesta3TextField);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pregunta = preguntaTextField.getText();
                String opcion1 = posibleRespuesta1TextField.getText();
                String opcion2 = posibleRespuesta2TextField.getText();
                String opcion3 = posibleRespuesta3TextField.getText();
                System.out.println("Pregunta: " + pregunta);
                System.out.println("Respuesta Valida 1: " + opcion1);
                System.out.println("Respuesta Valida 2: " + opcion2);
                System.out.println("Respuesta Valida 3: " + opcion3);
                // Close the JFrame
                dispose();
            }
        });
        add(saveButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}