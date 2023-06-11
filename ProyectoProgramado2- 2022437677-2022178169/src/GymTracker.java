import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class GymTracker {
    public static void main(String[] args) {
        GymRoutineModel model = new GymRoutineModel(); // Crear instancia del modelo
        GymRoutineView view = new GymRoutineView(); // Crear instancia de la vista
        GymRoutineController controller = new GymRoutineController(model, view); // Crear instancia del controlador
// Generar datos de prueba para las rutinas
        generarRutinasDePrueba(model);
        controller.startApplication(); // Iniciar la aplicación
    }

    private static void generarRutinasDePrueba(GymRoutineModel model) {
        // Crear rutina de prueba para Bíceps
        List<Exercise> ejerciciosBiceps = new ArrayList<>();
        Exercise ejercicioBiceps1 = new Exercise("Ejercicio Bíceps 1", "Descripción del Ejercicio de Bíceps 1", 60, 3, 12);
        Exercise ejercicioBiceps2 = new Exercise("Ejercicio Bíceps 2", "Descripción del Ejercicio de Bíceps 2", 45, 4, 10);
        ejerciciosBiceps.add(ejercicioBiceps1);
        ejerciciosBiceps.add(ejercicioBiceps2);
        GymRoutine rutinaBiceps = new GymRoutine("Rutina de Bíceps", ejerciciosBiceps, model, null);
        model.addRoutine(rutinaBiceps);

        // Crear rutina de prueba para Tríceps
        List<Exercise> ejerciciosTriceps = new ArrayList<>();
        Exercise ejercicioTriceps1 = new Exercise("Ejercicio Tríceps 1", "Descripción del Ejercicio de Tríceps 1", 60, 3, 12);
        Exercise ejercicioTriceps2 = new Exercise("Ejercicio Tríceps 2", "Descripción del Ejercicio de Tríceps 2", 45, 4, 10);
        ejerciciosTriceps.add(ejercicioTriceps1);
        ejerciciosTriceps.add(ejercicioTriceps2);
        GymRoutine rutinaTriceps = new GymRoutine("Rutina de Tríceps", ejerciciosTriceps, model, null);
        model.addRoutine(rutinaTriceps);

        // Crear rutina de prueba para Abdominales
        List<Exercise> ejerciciosAbdominales = new ArrayList<>();
        Exercise ejercicioAbdominales1 = new Exercise("Abdominales", "Con las piernas flexionadas en una posición baja, con los pies fijados al suelo, recuesta tu espalda contra el suelo, coloca tus manos tras tu cabeza y levanta la espalda hasta que tus codos se recuesten sobre tus rodillas.", 60, 3, 12);
        Exercise ejercicioAbdominales2 = new Exercise("Burpees", "Coloca tu cuerpo acostado boca abajo con los brazos a los lados, en esa posición, fuerza tus piernas y pecho hacia arriba mientras tu abdomen mantiene el contacto con el suelo", 45, 4, 10);
        ejerciciosAbdominales.add(ejercicioAbdominales1);
        ejerciciosAbdominales.add(ejercicioAbdominales2);
        GymRoutine rutinaAbdominales = new GymRoutine("Rutina de Abdominales", ejerciciosAbdominales, model, null);
        model.addRoutine(rutinaAbdominales);
    }
}