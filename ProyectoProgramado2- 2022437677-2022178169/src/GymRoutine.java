import java.util.ArrayList;
import java.util.List;

class GymRoutine {
    private String name;
    private List<Exercise> exercises;
    private String completionDate;
    private String completionTime;
    private GymRoutineModel model;
    private GymRoutineView view;

    public GymRoutine(String name, List<Exercise> exercises, GymRoutineModel model, GymRoutineView view) {
        this.name = name;
        this.exercises = exercises;
        this.completionDate = "";
        this.completionTime = "";
        this.model = model;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    private Exercise createExercise() {
        String exerciseName = view.readStringInput("Enter the name of an exercise: "); // Lee el nombre del ejercicio
        String description = view.readStringInput("Enter the description of the exercise: "); // Lee la descripción del ejercicio
        int duration = view.readIntInput("Enter the duration of the exercise in seconds: "); // Lee la duración del ejercicio en segundos
        int sets = view.readIntInput("Enter the number of sets: "); // Lee el número de series del ejercicio
        int repetitions = view.readIntInput("Enter the number of repetitions: "); // Lee el número de repeticiones del ejercicio

        return new Exercise(exerciseName, description, duration, sets, repetitions); // Crea un nuevo ejercicio con los datos especificados
    }

    private void createNewRoutine() {
        String name = view.readStringInput("Enter the name of the new routine: "); // Lee el nombre de la nueva rutina
        List<Exercise> exercises = new ArrayList<>();

        boolean addMoreExercises = true;
        while (addMoreExercises) {
            Exercise exercise = createExercise(); // Crea un nuevo ejercicio
            exercises.add(exercise); // Agrega el ejercicio a la lista de ejercicios de la rutina

            addMoreExercises = view.readStringInput("Do you want to add another exercise? (yes/no): ")
                    .equalsIgnoreCase("yes"); // Pregunta al usuario si desea agregar otro ejercicio
        }

        GymRoutine routine = new GymRoutine(name, exercises, model, view); // Crea una nueva rutina con el nombre y los ejercicios especificados
        model.addRoutine(routine); // Agrega la rutina al modelo
        model.saveRoutinesToFile("routines.txt"); // Guarda las rutinas en un archivo
        view.displayRoutines(model.getRoutines()); // Muestra las rutinas disponibles
    }
}
