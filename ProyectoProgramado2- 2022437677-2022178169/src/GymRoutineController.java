import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GymRoutineController {
    private GymRoutineModel model;
    private GymRoutineView view;

    public GymRoutineController(GymRoutineModel model, GymRoutineView view) {
        this.model = model;
        this.view = view;
    }

    public void startApplication() {
        view.displayWelcomeMessage(); // Muestra un mensaje de bienvenida
        boolean exit = false;
        while (!exit) {
            view.displayMenu(); // Muestra el menú de opciones
            int choice = view.readIntInput("Enter your choice: "); // Lee la elección del usuario
            switch (choice) {
                case 1:
                    view.displayRoutines(model.getRoutines()); // Muestra las rutinas disponibles
                    break;
                case 2:
                    createNewRoutine(); // Crea una nueva rutina
                    break;
                case 3:
                    selectRoutine(); // Selecciona una rutina para realizar
                    break;
                case 4:
                    view.displayCompletedRoutines(model.getCompletedRoutines()); // Muestra las rutinas completadas
                    break;
                case 5:
                    recordWeight(); // Registra el peso del usuario
                    break;
                case 6:
                    view.displayWeightHistory("weight.txt"); // Muestra el historial de pesos
                    break;
                case 7:
                    exit = true; // Sale de la aplicación
                    break;
                default:
                    view.displayErrorMessage("Invalid choice. Please try again."); // Muestra un mensaje de error para una elección inválida
                    break;
            }
        }
        view.displayExitMessage(); // Muestra un mensaje de despedida
    }

    private void createNewRoutine() {
        String name = view.readStringInput("Enter the name of the new routine: "); // Lee el nombre de la nueva rutina
        List<Exercise> exercises = new ArrayList<>();

        boolean addMoreExercises = true;
        while (addMoreExercises) {
            String exerciseName = view.readStringInput("Enter the name of an exercise: "); // Lee el nombre del ejercicio
            String description = view.readStringInput("Enter the description of the exercise: "); // Lee la descripción del ejercicio
            int duration = view.readIntInput("Enter the duration of the exercise in seconds: "); // Lee la duración del ejercicio en segundos
            int sets = view.readIntInput("Enter the number of sets: "); // Lee el número de series del ejercicio
            int repetitions = view.readIntInput("Enter the number of repetitions: "); // Lee el número de repeticiones del ejercicio

            Exercise exercise = new Exercise(exerciseName, description, duration, sets, repetitions); // Crea un nuevo ejercicio
            exercises.add(exercise); // Agrega el ejercicio a la lista de ejercicios de la rutina

            addMoreExercises = view.readStringInput("Do you want to add another exercise? (yes/no): ")
                    .equalsIgnoreCase("yes"); // Pregunta al usuario si desea agregar otro ejercicio
        }

        GymRoutine routine = new GymRoutine(name, exercises, model, view); // Crea una nueva rutina con el nombre y los ejercicios especificados
        model.addRoutine(routine); // Agrega la rutina al modelo
        model.saveRoutinesToFile("routines.txt"); // Guarda las rutinas en un archivo
        view.displayRoutines(model.getRoutines()); // Muestra las rutinas disponibles
    }

    private void selectRoutine() {
        List<GymRoutine> routines = model.getRoutines();
        if (routines.isEmpty()) {
            view.displayErrorMessage("No routines available. Please create a routine first."); // Muestra un mensaje de error si no hay rutinas disponibles
            return;
        }

        view.displayRoutines(routines); // Muestra las rutinas disponibles
        int routineIndex = view.readIntInput("Enter the index of the routine you want to select: "); // Lee el índice de la rutina seleccionada
        if (routineIndex < 1 || routineIndex > routines.size()) {
            view.displayErrorMessage("Invalid routine index. Please try again."); // Muestra un mensaje de error para un índice de rutina inválido
            return;
        }

        GymRoutine selectedRoutine = routines.get(routineIndex - 1); // Obtiene la rutina seleccionada
        model.addCompletedRoutine(selectedRoutine); // Agrega la rutina completada al modelo
        model.saveCompletedRoutinesToFile("completed_routines.txt"); // Guarda las rutinas completadas en un archivo
        view.displayCompletedRoutines(model.getCompletedRoutines()); // Muestra las rutinas completadas
    }

    private void recordWeight() {
        String weightFileName = "weight.txt";
        double initialWeight = 0.0;
        File file = new File(weightFileName);

        if (!file.exists() || file.length() == 0) {
            initialWeight = view.readDoubleInput("Enter your initial weight: "); // Lee el peso inicial del usuario
            view.displayWeightRecordedMessage(initialWeight, true); // Muestra un mensaje de éxito al registrar el peso inicial
            model.setWeight(initialWeight); // Establece el peso inicial en el modelo
            model.saveWeightToFile(weightFileName, initialWeight, "Peso Inicial"); // Guarda el peso inicial en un archivo
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Peso Inicial:")) {
                        String weightString = line.substring(line.indexOf(":") + 1, line.indexOf("(")).trim();
                        try {
                            initialWeight = Double.parseDouble(weightString);
                        } catch (NumberFormatException e) {
                            view.displayErrorMessage("Invalid weight in file. Weight not recorded."); // Muestra un mensaje de error si el peso en el archivo es inválido
                            return;
                        }
                        break;
                    }
                }
                reader.close();
            } catch (IOException e) {
                view.displayErrorMessage("Error reading weight file. Weight not recorded."); // Muestra un mensaje de error al leer el archivo de pesos
                return;
            }

            double currentWeight = view.readDoubleInput("Enter your current weight: "); // Lee el peso actual del usuario
            String message;
            if (currentWeight > initialWeight) {
                message = "You have gained weight.";
            } else if (currentWeight < initialWeight) {
                message = "You have lost weight.";
            } else {
                message = "Your weight has remained the same.";
            }

            model.setWeight(currentWeight); // Establece el peso actual en el modelo
            model.saveWeightToFile(weightFileName, currentWeight, "Peso Actual"); // Guarda el peso actual en el archivo
            view.displayWeightRecordedMessage(initialWeight, currentWeight, message); // Muestra un mensaje de éxito al registrar el peso actual
        }
    }
}
