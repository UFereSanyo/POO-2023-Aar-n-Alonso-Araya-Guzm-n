import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //crear e imprimir variables enteras
        int num1; int num2; int num3;
        num1 = 3; num2 = 2; num3 = 1;

        //crear el arreglo personas
        Persona[] personas;
        personas = new Persona[5];
        personas[0] = new Persona("Aarón Alonso","Araya Guzmán",21, true);
        personas[1] = new Persona("Amanda", "Guzmán Sibaja", 22, true);
        personas[2] = new Persona("María de los Ángeles", "Guzmán Sibaja", 49, true);
        personas[3] = new Persona("Luis Fernando Martín", "Velazco Zúñiga", 58, true);
        personas[4] = new Persona("Melany de los Ángeles", "Vindas Soto", 20, true);


        //imprimir el arreglo de personas
        //for (int i = 0; i < personas.length-1; i++) {
        //    System.out.println(personas);

        //}

        for (Persona per : personas) {
            System.out.println(per.toString());
        }

        System.out.println("Spider - Oingo Boingo");
        System.out.println("\n");
        System.out.println(num1); System.out.println(num2); System.out.println(num3);
        System.out.println("\n" +
                "Spider crawling\n" +
                "on the wall,\n" +
                "I see him and he\n" +
                "sees it all, and he\n" +
                "sees it all.\n" +
                "I fell down in that\n" +
                "lazy place where the\n" +
                "English language can't\n" +
                "penetrate and I\n" +
                "saw your mouth moving,\n" +
                "Just forget it and\n" +
                "lie here with me.\n" +
                "" +
                "Maybe we should just\n" +
                "climb under the sheets,\n" +
                "where the words they don't\n" +
                "get in the way\n" +
                "\n" +
                "We were wondering\n" +
                "if you recall:\n" +
                "Is this the end of it,\n" +
                "end of everything.\n" +
                "We were wondering,\n" +
                "Wonder.\n" +
                "Spider crawling\n" +
                "in my left ear,\n" +
                "has a message I\n" +
                "want you to hear:\n" +
                "\n" +
                "Hope you're happy,\n" +
                "Found what you're looking for?\n" +
                "Do you miss me?\n" +
                "Miss me at all?\n" +
                "\n" +
                "Spider tells me:\n" +
                "Saw you yesterday,\n" +
                "with somebody new.\n" +
                "What can I say?\n" +
                "What can I-\n" +
                "Spider crawling,\n" +
                "I crawl with him.\n" +
                "We go everywhere,\n" +
                "we see everything,\n" +
                "we are falling,\n" +
                "we are falling,\n" +
                "falling to nowhere.\n" +
                "\n" +
                "Hope you're happy,\n" +
                "Found what you're looking for?\n" +
                "Do you miss me?\n" +
                "Miss me at all?\n" +
                "\n" +
                "Spider crawling, spider crawling, spider crawling, spider crawling...");

    }

}