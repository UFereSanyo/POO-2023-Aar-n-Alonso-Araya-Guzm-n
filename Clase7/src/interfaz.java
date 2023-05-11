import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.*;
import java.awt.event.*;
import logic.Expression;
import logic.IllegalCharacterException;

class interfaz extends JFrame {

    interfaz() {

        //JPanel panelPrincipal = new JPanel();
        JLabel labelE = new JLabel("Expresión:");
        labelE.setBounds(10, 10, 280, 25);
        JTextField expresionE = new JTextField();
        expresionE.setBounds(10, 45, 280, 25);
        JButton button = new JButton("Calcular");
        button.setBounds(10, 80, 280, 25);
        JLabel labelR = new JLabel("Resultado:");
        labelR.setBounds(10, 115, 280, 25);
        JTextField resultadoR = new JTextField();
        resultadoR.setBounds(10, 150, 280, 25);

        try {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Expression inst = new Expression();
                    inst.reconocer(expresionE.getText());
                    //float f = inst.evaluar();
                    //String s = Float.toString(f);
                    //resultadoR.setText(s);
                    resultadoR.setText(Float.toString(inst.evaluar()));
                }
            });

        }catch(IllegalCharacterException r){
            JOptionPane.showMessageDialog(this,r.toString(),"Caracter No Válido",JOptionPane.ERROR_MESSAGE);

        }

        setLayout(null);
        add(labelE);
        add(expresionE);
        add(button);
        add(labelR);
        add(resultadoR);
        setSize(315, 220);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

}