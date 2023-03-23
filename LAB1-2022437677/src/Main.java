import java.util.ArrayList;
import java.util.Collections;
public class Main {

    public static void main(String[] args) {

        Persona[] personas;
        personas = new Persona[10];
        personas[0] = new Persona("Aaron", 21, "2022437677", "Male", "at at gc ta cg at gc ta cg ta");
        personas[1] = new Persona("Melany", 20, "2021468522", "Female", "gc ta at cg ta gc cg ta at gc");
        personas[2] = new Persona("Allan", 23, "2022454777", "Male", "at at at gc ta gc cg gc cg ta");
        personas[3] = new Persona("May", 21, "2020566482", "Female", "cg gc at cg cg ta ta cg cg ta");
        personas[4] = new Persona("Andrey", 21, "2021468595", "Male", "cg gc at cg cg ta cg ta cg ta");
        personas[5] = new Persona("Maria", 19, "2023648852", "Female", "at cg ta ta cg ta at cg at cg");
        personas[6] = new Persona("Abelardo", 25, "2017644852", "Male", "at gc cg cg ta cg at cg ta cg");
        personas[7] = new Persona("Margarita", 24, "2019485516", "Female", "at ta ta gc gc cg at ta cg gc");
        personas[8] = new Persona("Alfredo", 18, "2023446855", "Male", "at at at gc gc at cg gc ta");
        personas[9] = new Persona("Mariela", 21, "2022466859", "Female", "gc cg at ta cg at cg ta cg ta");

        int x = 0;
        int valid = 0;
        while (x <= 9) {
            for (char c : personas[x].getDna().toCharArray()) {
                if (c != 'a' && c != 't' && c != 'c' && c != 'g' && c != ' ') {
                    valid = 1;
                    System.out.println("El DNA de la siguiente persona Es invalido:");
                    System.out.println(personas[x].getName());
                    System.out.println(personas[x].getDna());
                }
            }
            for (int i = 0; i < personas[x].getDna().length() - 1; i++) {
                char currentChar = personas[x].getDna().charAt(i);
                char nextChar = personas[x].getDna().charAt(i + 1);
                if ((currentChar == 'a' && nextChar == 'c') || (currentChar == 'c' && nextChar == 'a') || (currentChar == 't' && nextChar == 'g') || (currentChar == 'g' && nextChar == 't')) {
                    valid = 1;
                    System.out.println("El DNA de la siguiente persona Es invalido:");
                    System.out.println(personas[x].getName());
                    System.out.println(personas[x].getDna());
                }
            }

            if (valid == 1) {
                System.out.println("Uno de los valores de ADN no es valido, por favor verifique que sólo contenga los caracteres A, T, C, G, y que las As y Ts estén juntas así como las Cs y Gs y los pares separados por espacios");
                break;
            } else {
                x += 1;
            }

        }
        for (Persona per : personas) {
            System.out.println(per.toString());
        }

        PromptADN[] promptADNS;
        promptADNS = new PromptADN[1];

        //este es el string a modificar para comparar con el array de adn
        promptADNS[0] = new PromptADN("at ta gc cg gc cg ta at ta gc");


        for (char c : promptADNS[0].getPrompt().toCharArray()) {
            if (c != 'a' && c != 't' && c != 'c' && c != 'g' && c != ' ') {
                System.out.println("ADN Ingresado Para Comparar Invalido");
                System.out.println(promptADNS[0].getPrompt());
            }
        }
        for (int i = 0; i < promptADNS[0].getPrompt().length() - 1; i++) {
            char currentChar = promptADNS[0].getPrompt().charAt(i);
            char nextChar = promptADNS[0].getPrompt().charAt(i + 1);
            if ((currentChar == 'a' && nextChar == 'c') || (currentChar == 'c' && nextChar == 'a') || (currentChar == 't' && nextChar == 'g') || (currentChar == 'g' && nextChar == 't')) {
                System.out.println("ADN Ingresado Para Comparar Invalido");
                System.out.println(promptADNS[0].getPrompt());

            }
        }
    }
}