import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class GymRoutineModel {
    private List<GymRoutine> routines; // Lista de rutinas
    private List<GymRoutine> completedRoutines; // Lista de rutinas completadas
    private double weight; // Peso actual del usuario

    public GymRoutineModel() {
        this.routines = new ArrayList<>(); // Inicializa la lista de rutinas
        this.completedRoutines = new ArrayList<>(); // Inicializa la lista de rutinas completadas
        this.weight = 0.0; // Inicializa el peso en 0
    }

    public List<GymRoutine> getRoutines() {
        return routines; // Retorna la lista de rutinas
    }

    public List<GymRoutine> getCompletedRoutines() {
        return completedRoutines; // Retorna la lista de rutinas completadas
    }

    public double getWeight() {
        return weight; // Retorna el peso actual
    }

    public void setWeight(double weight) {
        this.weight = weight; // Establece el peso actual
    }

    public void addRoutine(GymRoutine routine) {
        routines.add(routine); // Agrega una rutina a la lista de rutinas
    }

    public void addCompletedRoutine(GymRoutine routine) {
        routine.setCompletionDate(getCurrentDate()); // Establece la fecha de finalización de la rutina como la fecha actual
        routine.setCompletionTime(getCurrentTime()); // Establece la hora de finalización de la rutina como la hora actual
        completedRoutines.add(routine); // Agrega la rutina completada a la lista de rutinas completadas
    }

    public void saveRoutinesToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (GymRoutine routine : routines) {
                writer.println("Routine: " + routine.getName());
                for (Exercise exercise : routine.getExercises()) {
                    writer.println("Exercise: " + exercise.getName());
                    writer.println("Description: " + exercise.getDescription());
                    writer.println("Duration: " + exercise.getDuration() + " seconds");
                    writer.println("Sets: " + exercise.getSets());
                    writer.println("Repetitions: " + exercise.getRepetitions());
                    writer.println();
                }
                writer.println();
            }
            writer.close();
            System.out.println("Routines saved successfully to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving routines to file: " + fileName);
        }
    }

    public void saveWeightToFile(String fileName, double weight, String label) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            writer.write(label + ": " + weight + " (Date and Time: " + formattedDateTime + ")\n");
            writer.close();
            System.out.println("Weight saved successfully to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving weight to file: " + fileName);
        }
    }

    public void saveCompletedRoutinesToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            for (GymRoutine routine : completedRoutines) {
                writer.println("Routine: " + routine.getName());
                writer.println("Completion Date: " + now.format(formatter));
                writer.println("Exercises:");
                for (Exercise exercise : routine.getExercises()) {
                    writer.println("   Exercise: " + exercise.getName());
                    writer.println("   Description: " + exercise.getDescription());
                    writer.println("   Duration: " + exercise.getDuration() + " seconds");
                    writer.println("   Sets: " + exercise.getSets());
                    writer.println("   Repetitions: " + exercise.getRepetitions());
                    writer.println();
                }
                writer.println();
            }
            writer.close();
            System.out.println("Completed routines log saved successfully to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving completed routines log to file: " + fileName);
        }
    }

    private String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter); // Retorna la fecha actual en formato "yyyy-MM-dd"
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter); // Retorna la hora actual en formato "HH:mm:ss"
    }
}
