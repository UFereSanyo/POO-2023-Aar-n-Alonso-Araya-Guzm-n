public class Persona {

    private String name;

    private int age;

    private String id;

    private String gender;

    private String dna;

    public Persona(String name, int age, String id, String gender, String dna) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.gender = gender;
        this.dna = dna;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", dna='" + dna + '\'' +
                '}';
    }
}
