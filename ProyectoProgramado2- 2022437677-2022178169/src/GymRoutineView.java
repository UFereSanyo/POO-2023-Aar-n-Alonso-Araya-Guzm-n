import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class GymRoutineView {
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Gym Routine Application!"); // Muestra un mensaje de bienvenida
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. View Routines"); // Opción para ver las rutinas
        System.out.println("2. Create New Routine"); // Opción para crear una nueva rutina
        System.out.println("3. Realizar rutina"); // Opción para realizar una rutina
        System.out.println("4. View Completed Routines"); // Opción para ver las rutinas completadas
        System.out.println("5. Record Weight"); // Opción para registrar el peso
        System.out.println("6. View Weight History"); // Opción para ver el historial de pesos
        System.out.println("7. Exit"); // Opción para salir
        System.out.print("Enter your choice: ");
    }

    public void displayRoutines(List<GymRoutine> routines) {
        System.out.println("Routines:");
        for (int i = 0; i < routines.size(); i++) {
            GymRoutine routine = routines.get(i);
            System.out.println((i + 1) + ". " + routine.getName());
            for (Exercise exercise : routine.getExercises()) {
                System.out.println("   Exercise: " + exercise.getName());
                System.out.println("   Description: " + exercise.getDescription());
                System.out.println("   Duration: " + exercise.getDuration() + " seconds");
                System.out.println("   Sets: " + exercise.getSets());
                System.out.println("   Repetitions: " + exercise.getRepetitions());
                System.out.println();
            }
        }
        System.out.println();
    }

    public void displayCompletedRoutines(List<GymRoutine> completedRoutines) {
        System.out.println("Completed Routines:");
        for (int i = 0; i < completedRoutines.size(); i++) {
            GymRoutine routine = completedRoutines.get(i);
            System.out.println((i + 1) + ". " + routine.getName());
            System.out.println("   Completion Date: " + routine.getCompletionDate());
            System.out.println("   Completion Time: " + routine.getCompletionTime());
            System.out.println("   Exercises:");
            for (Exercise exercise : routine.getExercises()) {
                System.out.println("      Exercise: " + exercise.getName());
                System.out.println("      Description: " + exercise.getDescription());
                System.out.println("      Duration: " + exercise.getDuration() + " seconds");
                System.out.println("      Sets: " + exercise.getSets());
                System.out.println("      Repetitions: " + exercise.getRepetitions());
                System.out.println();
            }
        }
    }

    public void displayExitMessage() {
        System.out.println("Thank you for using the Gym Routine Application. Goodbye!"); // Muestra un mensaje de despedida
    }

    public void displayErrorMessage(String errorMessage) {
        System.out.println("Error: " + errorMessage); // Muestra un mensaje de error con el mensaje proporcionado
    }

    public void displayWeightRecordedMessage(double initialWeight, boolean firstTime) {
        String message = "Weight recorded successfully: " + initialWeight;
        if (firstTime) {
            message += " (Initial weight)";
        }
        System.out.println(message); // Muestra un mensaje de éxito al registrar el peso, incluyendo el peso inicial si es la primera vez
    }

    public void displayWeightRecordedMessage(double initialWeight, double currentWeight, String message) {
        System.out.println("Weight recorded successfully:");
        System.out.println("Initial weight: " + initialWeight);
        System.out.println("Current weight: " + currentWeight);
        System.out.println(message); // Muestra un mensaje de éxito al registrar el peso, incluyendo el peso inicial y el peso actual, junto con un mensaje adicional
    }

    public void displayWeightHistory(String weightFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(weightFileName));
            String line;
            System.out.println("Weight History:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Muestra el historial de pesos leyendo el archivo línea por línea
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading weight file: " + weightFileName); // Muestra un mensaje de error al leer el archivo de pesos
        }
    }

    public double readDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble(); // Lee un número decimal ingresado por el usuario
    }

    public String readStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine(); // Lee una cadena ingresada por el usuario
    }

    public int readIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt(); // Lee un número entero ingresado por el usuario
    }
}
