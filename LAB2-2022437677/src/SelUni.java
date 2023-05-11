import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelUni extends JFrame {
    public SelUni() {
        setTitle("Seleccion Unica");

        setSize(600, 600);
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel crearPruebaTab = new JPanel();
        crearPruebaTab.setLayout(new GridLayout(0, 1));


        for (int i = 1; i <= 5; i++) {
            JTextField textField = new JTextField();
            textField.setText("Agregue la pregunta ");
            crearPruebaTab.add(textField);

        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);


        Seleccion seleccion = new Seleccion();
        seleccion.setVisible(true);

    }
}


