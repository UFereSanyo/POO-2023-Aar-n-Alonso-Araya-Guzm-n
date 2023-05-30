import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Examen {
    private String nombre;
    private List<Pregunta> preguntas;

    public Examen(String nombre, List<Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
}

public class Pregunta {
    private String enunciado;
    private boolean respuestaCorrecta;

    public Pregunta(String enunciado, boolean respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}

public class Reporte {
    private Examen examen;
    private double calificacion;

    public Reporte(Examen examen, double calificacion) {
        this.examen = examen;
        this.calificacion = calificacion;
    }

    public Examen getExamen() {
        return examen;
    }

    public double getCalificacion() {
        return calificacion;
    }
}

public class VentanaPrincipal extends JFrame {
    private List<Examen> examenes;
    private List<Reporte> reportes;

    public VentanaPrincipal() {
        examenes = new ArrayList<>();
        reportes = new ArrayList<>();

        JButton botonCrearExamen = new JButton("Crear Examen");
        botonCrearExamen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar tu lógica para crear un nuevo examen
                String nombreExamen = JOptionPane.showInputDialog(VentanaPrincipal.this, "Ingrese el nombre del examen");
                Examen examen = crearExamen(nombreExamen);
                if (examen != null) {
                    examenes.add(examen);
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Examen creado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "No se pudo crear el examen");
                }
            }
        });

        JButton botonRealizarPrueba = new JButton("Realizar Prueba");
        botonRealizarPrueba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (examenes.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "No hay exámenes disponibles");
                    return;
                }

                Examen examen = examenes.get(0); // Obtén el primer examen de la lista (puedes modificar esto según tus necesidades)
                List<Pregunta> preguntas = examen.getPreguntas();

                if (preguntas.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "No hay preguntas en el examen");
                    return;
                }

                double calificacion = 0;
                for (Pregunta pregunta : preguntas) {
                    String respuestaUsuario = JOptionPane.showInputDialog(VentanaPrincipal.this, pregunta.getEnunciado());
                    boolean respuestaCorrecta = pregunta.isRespuestaCorrecta();
                    if (respuestaUsuario != null && respuestaUsuario.equalsIgnoreCase("si") == respuestaCorrecta) {
                        calificacion++;
                    }
                }

                calificacion = (calificacion / preguntas.size()) * 100;
                Reporte reporte = new Reporte(examen, calificacion);
                reportes.add(reporte);
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Prueba realizada. Calificación: " + calificacion);
            }
        });

        JButton botonVerReportes = new JButton("Ver Reportes");
        botonVerReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (reportes.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "No hay reportes disponibles");
                    return;
                }

                StringBuilder reportesText = new StringBuilder();
                for (Reporte reporte : reportes) {
                    Examen examen = reporte.getExamen();
                    double calificacion = reporte.getCalificacion();
                    reportesText.append("Examen: ").append(examen.getNombre()).append(", Calificación: ").append(calificacion).append("\n");
                }

                JOptionPane.showMessageDialog(VentanaPrincipal.this, reportesText.toString());
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonCrearExamen);
        panelBotones.add(botonRealizarPrueba);
        panelBotones.add(botonVerReportes);

        getContentPane().add(panelBotones);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private Examen crearExamen(String nombreExamen) {
        // Aquí puedes agregar tu lógica para crear un nuevo examen según el nombre proporcionado
        // y devolverlo como resultado
        List<Pregunta> preguntas = new ArrayList<>();
        String pregunta = JOptionPane.showInputDialog(this, "Ingrese una pregunta");
        while (pregunta != null && !pregunta.isEmpty()) {
            boolean respuestaCorrecta = JOptionPane.showConfirmDialog(this, "¿Es la respuesta correcta?", "Respuesta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            preguntas.add(new Pregunta(pregunta, respuestaCorrecta));
            pregunta = JOptionPane.showInputDialog(this, "Ingrese otra pregunta (deje en blanco para terminar)");
        }

        if (!preguntas.isEmpty()) {
            return new Examen(nombreExamen, preguntas);
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
