package agendagui.GUI;

import agendagui.Data.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaMain extends JFrame{
    private JPanel panel1;
    private JButton agregarContactoButton;
    private JButton agregarEventoButton;
    private JButton mostrarAgendaButton;
    private JComboBox comboBoxContacto;
    private Agenda laAgenda;
    public AgendaMain() {
        this.laAgenda = new Agenda();

        setContentPane(this.panel1);
        agregarContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxContacto.getSelectedIndex() == 0){
                    (new AgregarContactoFamiliar(laAgenda)).setVisible(true);
                } else if (comboBoxContacto.getSelectedIndex() == 1) {


                }

            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //pack();
        setSize(300,300);
        mostrarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new ImprimirAgenda(laAgenda)).setVisible(true);
            }
        });
        agregarContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarEventoReunion(laAgenda).setVisible(true);
            }
        });
    }
}
