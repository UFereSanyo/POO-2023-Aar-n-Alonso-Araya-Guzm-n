import javax.swing.*;
import java.awt.*;

public class PruebaFrame extends JFrame {
    public PruebaFrame() {
        setTitle("Prueba Frame");
        setSize(600, 600);
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel crearPruebaTab = new JPanel();
        crearPruebaTab.setLayout(new GridLayout(0, 1));

        for (int i = 1; i <= 5; i++) {
            JLabel label = new JLabel();
            label.setText("Tipo de la pregunta " + i);

            crearPruebaTab.add(label);
            JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JRadioButton seleccionRadioButton = new JRadioButton("Seleccion");
            JRadioButton respuestaBreveRadioButton = new JRadioButton("Respuesta breve");
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(seleccionRadioButton);
            buttonGroup.add(respuestaBreveRadioButton);
            radioPanel.add(seleccionRadioButton);
            radioPanel.add(respuestaBreveRadioButton);
            crearPruebaTab.add(radioPanel);


        }

        JButton siguiente = new JButton();
        siguiente.setText("Siguiente");
        crearPruebaTab.add(siguiente);

        tabbedPane.addTab("Crear prueba", crearPruebaTab);

        JPanel realizarPruebaTab = new JPanel();
        realizarPruebaTab.setLayout(new FlowLayout());

        JButton botonRelizarPrueba = new JButton("Realizar prueba");
        realizarPruebaTab.add(botonRelizarPrueba);

        tabbedPane.addTab("Realizar prueba", realizarPruebaTab);

        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public PruebaFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public PruebaFrame(String title) throws HeadlessException {
        super(title);
    }

    public PruebaFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

}
