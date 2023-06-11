class Exercise {
    private String name; // Nombre del ejercicio
    private String description; // Descripción del ejercicio
    private int duration; // Duración del ejercicio en segundos
    private int sets; // Número de series del ejercicio
    private int repetitions; // Número de repeticiones por serie del ejercicio

    public Exercise(String name, String description, int duration, int sets, int repetitions) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public int getSets() {
        return sets;
    }

    public int getRepetitions() {
        return repetitions;
    }
}
