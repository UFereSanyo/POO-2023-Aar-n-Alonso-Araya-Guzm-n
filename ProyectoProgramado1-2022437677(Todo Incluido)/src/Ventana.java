import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JFrame frame;

    public Ventana() {
        frame = new JFrame("Interfaz");

        frame.setSize(1440, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));

        button1 = new JButton("Inventario");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (Articulo arti : Main.getInventario()) {
                    sb.add(String.valueOf(arti) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button1.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button1);

        button2 = new JButton("Reparaciones");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (Item item : Main.getReparaciones()) {
                    sb.add(String.valueOf(item) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button2.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button2);

        button3 = new JButton("Factura Ventas");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(String.valueOf(Main.getDate())+"\n"+"NOTA: COLOCAR CURSOR SOBRE ESPACIO EN EL TEXTO IMPRESO Y PRESIONAR ENTER PARA REVELAR MAS INFORMACIÓN EN CASO DE AGREGAR MAS ARTICULOS" + "\n" + String.valueOf(Main.getBill1()));
            }
        });
        button3.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button3);

        button4 = new JButton("Factura Reparaciones");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(String.valueOf(Main.getDate())+"\n"+"NOTA: COLOCAR CURSOR SOBRE ESPACIO EN EL TEXTO IMPRESO Y PRESIONAR ENTER PARA REVELAR MAS INFORMACIÓN EN CASO DE AGREGAR MAS ITEMS" + "\n" +String.valueOf(Main.getBill2()));
            }
        });
        button4.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button4);

        button5 = new JButton("Historial Facturas");
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for ( String fact : Main.getHistFact()) {
                    sb.add(String.valueOf(fact) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+"Cantidad de Facturas: "+String.valueOf(Main.getCantFacturas())+"\n"+sb);
            }
        });
        button5.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button5);

        button6 = new JButton("Planilla");
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (String plan : Main.getPlanilla()) {
                    sb.add(String.valueOf(plan) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button6.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button6);

        button7 = new JButton("Vendedores");
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (String vend : Main.getVendedores()) {
                    sb.add(String.valueOf(vend) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button7.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button7);

        button8 = new JButton("Tecnicos");
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (String tech : Main.getTecnicos()) {
                    sb.add(String.valueOf(tech) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button8.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button8);

        button9 = new JButton("Gerentes");
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> sb = new ArrayList<String>();
                for (String gere : Main.getGerentes()) {
                    sb.add(String.valueOf(gere) + "\n");
                }
                textArea.setText(String.valueOf(Main.getDate())+"\n"+sb);
            }
        });
        button9.setPreferredSize(new Dimension(100, 100));
        buttonPanel.add(button9);

        frame.add(buttonPanel, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(300, 300));
        textArea.setText(String.valueOf(Main.getDate()));
        frame.add(textArea, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void showFrame() {
        frame.setVisible(true);
    }
}
