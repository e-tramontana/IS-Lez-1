import java.io.IOException;

/** Classe che contiene il main e che avvia le operazioni di calcolo */
public class ClientCalcola {
    private final CalcolaImporti01 ci = new CalcolaImporti01();
    private float r = 0;

    public static void main(final String[] args) {
        final ClientCalcola c = new ClientCalcola();
        c.eseguiCalcoli();
    }

    public void eseguiCalcoli() {
        // bisogna catturare eventuali eccezioni lanciate
        try {
            r = ci.calcola("./", "Importi.csv");
        } catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("Totale: " + r);
    }
}