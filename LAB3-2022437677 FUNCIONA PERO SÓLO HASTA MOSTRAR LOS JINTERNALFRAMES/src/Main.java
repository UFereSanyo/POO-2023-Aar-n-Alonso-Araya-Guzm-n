import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

enum TipoPregunta {
    RESPUESTA_BREVE, SELECCION
}

class Pregunta {
    private String enunciado;
    private TipoPregunta tipo;
    private List<String> opciones;
    private int respuestaCorrecta;

    public Pregunta(String enunciado, TipoPregunta tipo) {
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.opciones = new ArrayList<>();
        this.respuestaCorrecta = -1;
    }

    public void agregarOpcion(String opcion) {
        opciones.add(opcion);
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public TipoPregunta getTipo() {
        return tipo;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}

class Examen {
    private String nombre;
    private List<Pregunta> preguntas;

    public Examen(String nombre) {
        this.nombre = nombre;
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
}

class VentanaBase extends JFrame {
    private JDesktopPane desktopPane;

    public VentanaBase() {
        super("Ventana Base");
        setLayout(new BorderLayout());

        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        JButton botonCrearExamen = new JButton("Crear Examen");
        botonCrearExamen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaCrearExamen ventanaCrearExamen = new VentanaCrearExamen();
                ventanaCrearExamen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                ventanaCrearExamen.setSize(400, 300);
                ventanaCrearExamen.setVisible(true);
                desktopPane.add(ventanaCrearExamen);
            }
        });

        JButton botonRealizarPrueba = new JButton("Realizar Prueba");
        botonRealizarPrueba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaRealizarPrueba ventanaRealizarPrueba = new VentanaRealizarPrueba();
                ventanaRealizarPrueba.setExamenes(getExamenes());
                ventanaRealizarPrueba.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                ventanaRealizarPrueba.setSize(400, 300);
                ventanaRealizarPrueba.setVisible(true);
                desktopPane.add(ventanaRealizarPrueba);
            }
        });

        JButton botonVerReporte = new JButton("Ver Reporte");
        botonVerReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaVerReporte ventanaVerReporte = new VentanaVerReporte();
                ventanaVerReporte.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                ventanaVerReporte.setSize(400, 300);
                ventanaVerReporte.setVisible(true);
                desktopPane.add(ventanaVerReporte);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonCrearExamen);
        panelBotones.add(botonRealizarPrueba);
        panelBotones.add(botonVerReporte);

        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private List<Examen> getExamenes() {
        List<Examen> examenes = new ArrayList<>();

        // Código para obtener los exámenes de alguna fuente de datos

        return examenes;
    }
}

class VentanaCrearExamen extends JInternalFrame {
    private List<Pregunta> preguntas;

    public VentanaCrearExamen() {
        super("Crear Examen");
        setLayout(new FlowLayout());

        preguntas = new ArrayList<>();

        JLabel labelEnunciado = new JLabel("Enunciado:");
        JTextField campoEnunciado = new JTextField(20);
        JLabel labelTipo = new JLabel("Tipo:");
        JComboBox<TipoPregunta> comboTipo = new JComboBox<>(TipoPregunta.values());
        JLabel labelOpciones = new JLabel("Opciones:");
        JTextField campoOpciones = new JTextField(20);
        JButton botonAgregarOpcion = new JButton("Agregar Opción");
        JLabel labelRespuestaCorrecta = new JLabel("Respuesta Correcta:");
        JTextField campoRespuestaCorrecta = new JTextField(20);
        JButton botonAgregarPregunta = new JButton("Agregar Pregunta");

        botonAgregarOpcion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion = campoOpciones.getText();
                if (!opcion.isEmpty()) {
                    campoOpciones.setText("");
                    campoOpciones.requestFocus();

                    JCheckBox checkbox = new JCheckBox(opcion);
                    add(checkbox);
                    revalidate();
                    repaint();
                }
            }
        });

        botonAgregarPregunta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enunciado = campoEnunciado.getText();
                TipoPregunta tipo = (TipoPregunta) comboTipo.getSelectedItem();

                Pregunta pregunta = new Pregunta(enunciado, tipo);

                Component[] componentes = getContentPane().getComponents();
                for (Component componente : componentes) {
                    if (componente instanceof JCheckBox) {
                        JCheckBox checkbox = (JCheckBox) componente;
                        pregunta.agregarOpcion(checkbox.getText());
                        if (checkbox.isSelected()) {
                            pregunta.setRespuestaCorrecta(pregunta.getOpciones().size() - 1);
                        }
                    }
                }

                preguntas.add(pregunta);

                campoEnunciado.setText("");
                comboTipo.setSelectedIndex(0);
                campoOpciones.setText("");
                getContentPane().removeAll();
                revalidate();
                repaint();
            }
        });

        add(labelEnunciado);
        add(campoEnunciado);
        add(labelTipo);
        add(comboTipo);
        add(labelOpciones);
        add(campoOpciones);
        add(botonAgregarOpcion);
        add(labelRespuestaCorrecta);
        add(campoRespuestaCorrecta);
        add(botonAgregarPregunta);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}

class VentanaRealizarPrueba extends JInternalFrame {
    private List<Examen> examenes;
    private List<Pregunta> preguntas;
    private int indicePreguntaActual;
    private JLabel labelEnunciado; // Declaración de la variable labelEnunciado

    public VentanaRealizarPrueba() {
        super("Realizar Prueba");
        setLayout(new BorderLayout());

        preguntas = new ArrayList<>();
        indicePreguntaActual = 0;

        labelEnunciado = new JLabel(); // Inicialización de la variable labelEnunciado

        JTextField campoRespuesta = new JTextField(20);
        JButton botonSiguiente = new JButton("Siguiente");

        botonSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String respuesta = campoRespuesta.getText();

                if (indicePreguntaActual >= preguntas.size()) {
                    // Ya se respondieron todas las preguntas
                    JOptionPane.showMessageDialog(VentanaRealizarPrueba.this,
                            "Se han respondido todas las preguntas.");
                    return;
                }

                Pregunta preguntaActual = preguntas.get(indicePreguntaActual);
                String enunciado = preguntaActual.getEnunciado();
                int respuestaCorrecta = preguntaActual.getRespuestaCorrecta();

                if (preguntaActual.getTipo() == TipoPregunta.RESPUESTA_BREVE) {
                    if (respuesta.equals(preguntaActual.getOpciones().get(0))) {
                        JOptionPane.showMessageDialog(VentanaRealizarPrueba.this,
                                "¡Respuesta correcta!");
                    } else {
                        JOptionPane.showMessageDialog(VentanaRealizarPrueba.this,
                                "Respuesta incorrecta.");
                    }
                } else if (preguntaActual.getTipo() == TipoPregunta.SELECCION) {
                    int respuestaSeleccionada = Integer.parseInt(respuesta);
                    if (respuestaSeleccionada == respuestaCorrecta) {
                        JOptionPane.showMessageDialog(VentanaRealizarPrueba.this,
                                "¡Respuesta correcta!");
                    } else {
                        JOptionPane.showMessageDialog(VentanaRealizarPrueba.this,
                                "Respuesta incorrecta.");
                    }
                }

                campoRespuesta.setText("");
                indicePreguntaActual++;

                if (indicePreguntaActual >= preguntas.size()) {
                    labelEnunciado.setText("Se han respondido todas las preguntas.");
                    campoRespuesta.setEditable(false);
                    botonSiguiente.setEnabled(false);
                } else {
                    labelEnunciado.setText(preguntas.get(indicePreguntaActual).getEnunciado());
                }
            }
        });

        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new GridLayout(3, 1));
        panelContenido.add(labelEnunciado);
        panelContenido.add(campoRespuesta);
        panelContenido.add(botonSiguiente);

        add(panelContenido, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
        preguntas.clear();

        if (!examenes.isEmpty()) {
            Examen ultimoExamen = examenes.get(examenes.size() - 1);
            preguntas.addAll(ultimoExamen.getPreguntas());
        }

        if (!preguntas.isEmpty()) {
            labelEnunciado.setText(preguntas.get(0).getEnunciado());
        }
    }
}

class VentanaVerReporte extends JInternalFrame {
    public VentanaVerReporte() {
        super("Ver Reporte");

        // Lógica para mostrar el reporte
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaBase ventanaBase = new VentanaBase();
                ventanaBase.setSize(800, 600);
                ventanaBase.setVisible(true);
            }
        });
    }
}
