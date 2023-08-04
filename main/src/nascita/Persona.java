package nascita;

import java.util.Random;

public class Persona {

    // valori byte (-128; 127)

    /**
     * sesso: valori possibili:
     *          1 -> uomo
     *          2 -> donna
     * Ho messo uno byte per gli ermafroditi o altre situazioni però non so come funziona quindi per ora lascio
     * uno byte con la possibilità di ampliare.
     * Non metto un boolean perchè se in futuro vogliamo ampliare poi dovremmo modificare tutto
     *
     */
    byte sesso;
    String nome;
    /**
     * Per il colore pelle ho inserito uno byte perchè le tonalità di pelle possono essere ampie.
     * Ho preferito mettere uno byte invece di un float perchè occupa meno spazio
     */
    byte colorePelle;
    /**
     * colore pelle m(madre) e p(padre) che incidono sul colore pelledel figlio
     */
    byte colorePelleM;
    byte colorePelleP;


    byte coloreOcchi;
    byte coloreOcchiM;
    byte coloreOcchiP;

    byte coloreCapelli;
    byte coloreCapelliM;
    byte coloreCapelliP;
    /**
     * Per le caratteristiche mi fermo qui al momento.
     * chiaramente dobbiamo creare un Adamo ed Eva iniziali.
     */

    public Persona(String nome, int colore_pelle_madre, int colore_pelle_padre, int colore_occhi_madre, int colore_occhi_padre, int colore_capelli_madre, int colore_capelli_padre) {
        this.nome = nome;
        this.colorePelleM = (byte) colore_pelle_madre;
        this.colorePelleP = (byte) colore_pelle_padre;
        this.coloreOcchiM = (byte) colore_occhi_madre;
        this.coloreOcchiP = (byte) colore_occhi_padre;
        this.coloreCapelliM = (byte) colore_capelli_madre;
        this.coloreCapelliP = (byte) colore_capelli_padre;
        generaCaratteristiche();

        Random random = new Random();

        //todo creare una classe con i valori possibili assegnabili; es. sessiPossibili = 2
        byte sessiPossibili = 2;

        // Generare un numero intero tra 0 e 1
        this.sesso = (byte) random.nextInt(sessiPossibili); // Genera un numero tra 0 (incluso) e 2 (escluso)

    }

    @Override
    public String toString() {
        return "Madre caratteristiche:\n" +
                "- tonalità colore occhi "      + coloreOcchiM + "\n" +
                "- tonalità colore capelli "    + coloreCapelliM + "\n" +
                "- tonalità colore pelle "  + colorePelleM + "\n" +
                "\nPadre caratteristiche:\n" +
                "- tonalità colore occhi "      + coloreOcchiP + "\n" +
                "- tonalità colore capelli "    + coloreCapelliP + "\n" +
                "- tonalità colore pelle "  + colorePelleP + "\n" +
                "\nPersona attuale caratteristiche:\n" +
                "- Nome: " + nome + "\n"+
                "- Sesso: " + sesso + "\n"+
                "- tonalità colore occhi "      + coloreOcchi + "\n" +
                "- tonalità colore capelli "    + coloreCapelli + "\n" +
                "- tonalità colore pelle "  + colorePelle + "\n" ;
    }

    private void generaCaratteristiche() {
        colorePelle = generaColore(colorePelleM, colorePelleP);
        coloreCapelli = generaColore(coloreCapelliM, coloreCapelliP);
        coloreOcchi = generaColore(coloreOcchiM, coloreOcchiP);
    }

    private byte generaColore(int valore_madre, int valore_padre) {

        byte colore;

        //creazione del colore misto tra colore padre e colore padre
        colore = (byte) ((valore_madre + valore_padre) / 2);

        //creazione numero random in cui può variare il colore
        Random random = new Random();
        int min = -10;
        int max = 10;
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;

        byte minColore = -126;
        byte maxColore = 126;


        int nuovoColore = colore + randomNumber;

// Verifica se il nuovoColore supera il massimo o va al di sotto del minimo
        if (nuovoColore > maxColore) {
            colore = maxColore;
        } else if (nuovoColore < minColore) {
            colore = minColore;
        } else colore = (byte) nuovoColore;

        colore = (byte) (colore + randomNumber);

        return colore;
    }
}
