import nascita.Persona;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Invio with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Maiusc+F10 or click the green arrow button in the gutter to run the code.

        Persona primoFiglio = new Persona("Caino",  -20,  30,-20,30,-20, 30);
        System.out.println(primoFiglio.toString());
    }
}