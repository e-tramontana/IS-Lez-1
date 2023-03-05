import java.time.LocalDate;
// import indica dove trovare la classe LocalDate

/**
 * Classe che stampa sullo schermo un messaggio e la data corrente
 */
public class HelloWorld { // definizione classe HelloWorld
    // dichiarazione e assegnazione campi
    private static final String MSG = "Lezione di Ingegneria del Software";
    private LocalDate d;

    /**
     * Metodo da cui inizia l’esecuzione del programma
     * 
     * @param args parametri passati al metodo all’avvio della classe
     * 
     * @version 0.1
     */
    public static void main(String[] args) {
        final String NAME = "Marco";
        System.out.print("Hello "); // scrive su schermo
        System.out.println(NAME);
        System.out.println(MSG);
        
        HelloWorld world = new HelloWorld(); // crea oggetto
        world.printDate(); // chiama metodo
    }

    /** questo metodo serve a stampare la data */
    private void printDate() { // metodo
        d = LocalDate.now(); // chiama metodo static
        System.out.println("data: "+d);   
    }
}
