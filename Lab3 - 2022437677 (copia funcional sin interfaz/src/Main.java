import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Paso 1: Crear la interfaz para el comportamiento base de las preguntas
interface Pregunta {
    void mostrarPregunta();
    boolean verificarRespuesta(String respuestaUsuario);
    int obtenerPuntos();
}

// Paso 2: Crear las clases de preguntas que implementan la interfaz
class PreguntaSeleccionUnica implements Pregunta {
    private String enunciado;
    private List<String> opciones;
    private int respuestaCorrecta;
    private int puntos;

    public PreguntaSeleccionUnica(String enunciado, List<String> opciones, int respuestaCorrecta, int puntos) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.puntos = puntos;
    }

    public void mostrarPregunta() {
        System.out.println(enunciado);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ") " + opciones.get(i));
        }
    }

    public boolean verificarRespuesta(String respuestaUsuario) {
        int respuesta = Integer.parseInt(respuestaUsuario);
        return respuesta == respuestaCorrecta;
    }

    public int obtenerPuntos() {
        return puntos;
    }
}

class PreguntaRespuestaBreve implements Pregunta {
    private String enunciado;
    private List<String> frasesClave;
    private int puntos;

    public PreguntaRespuestaBreve(String enunciado, List<String> frasesClave, int puntos) {
        this.enunciado = enunciado;
        this.frasesClave = frasesClave;
        this.puntos = puntos;
    }

    public void mostrarPregunta() {
        System.out.println(enunciado);
    }

    public boolean verificarRespuesta(String respuestaUsuario) {
        for (String fraseClave : frasesClave) {
            if (respuestaUsuario.contains(fraseClave)) {
                return true;
            }
        }
        return false;
    }

    public int obtenerPuntos() {
        return puntos;
    }
}

public class SistemaEvaluaciones {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> reporteNotas = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1) Realizar prueba");
            System.out.println("2) Ver reporte de notas");
            System.out.println("3) Salir");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        realizarPrueba();
                        break;
                    case 2:
                        verReporteNotas();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingresa un número válido.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private static void realizarPrueba() {
        // Crear las preguntas
        Pregunta pregunta1 = new PreguntaSeleccionUnica("¿Cuál es la capital de Francia?",
                List.of("1. Londres", "2. París", "3. Berlín"), 2, 2);

        Pregunta pregunta2 = new PreguntaRespuestaBreve("¿Cuál es el color del cielo?", List.of("azul"), 3);

        Pregunta pregunta3 = new PreguntaSeleccionUnica("¿Cuántos planetas tiene el sistema solar?",
                List.of("1. 5", "2. 8", "3. 9"), 2, 2);

        Pregunta pregunta4 = new PreguntaRespuestaBreve("¿En qué año se descubrió América?", List.of("1492"), 3);

        Pregunta pregunta5 = new PreguntaSeleccionUnica("¿Cuál es el río más largo del mundo?",
                List.of("1. Amazonas", "2. Nilo", "3. Misisipi"), 1, 2);

        // Crear evaluación con las 5 preguntas
        List<Pregunta> evaluacion = List.of(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5);

        int aciertos = 0;
        int fallos = 0;
        int notaTotal = 0;

        // Recorrer las preguntas y obtener respuestas del usuario
        for (Pregunta pregunta : evaluacion) {
            pregunta.mostrarPregunta();
            String respuestaUsuario = scanner.nextLine();

            if (pregunta.verificarRespuesta(respuestaUsuario)) {
                System.out.println("Respuesta correcta.");
                aciertos++;
                notaTotal += pregunta.obtenerPuntos();
            } else {
                System.out.println("Respuesta incorrecta.");
                fallos++;
            }
        }

        int totalPreguntas = evaluacion.size();
        int porcentajeAciertos = (aciertos * 100) / totalPreguntas;

        String nombre = generarNombreAleatorio();
        String reporte = "Nombre: " + nombre + ", Aciertos: " + aciertos + ", Fallos: " + fallos + ", Nota: " + porcentajeAciertos + "%";
        reporteNotas.add(reporte);

        System.out.println("Prueba finalizada.");
    }

    private static String generarNombreAleatorio() {
        // Aquí puedes implementar la generación de un nombre aleatorio
        return "NombreAleatorio";
    }

    private static void verReporteNotas() {
        if (reporteNotas.isEmpty()) {
            System.out.println("No hay reportes de notas disponibles.");
        } else {
            System.out.println("Reporte de notas:");
            for (String reporte : reporteNotas) {
                System.out.println(reporte);
            }
        }
    }
}
