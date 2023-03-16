import java.io.IOException;

/** Classe che contiene il main e che avvia le operazioni di calcolo */
public class ClientPagam {

    public static void main(final String[] args) {
        Pagamenti p = new Pagamenti();
        p.svuota();
        try {
            p.leggiFile("./", "Importi.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.converti();
        p.calcolaSomma();
        p.calcolaMassimo();
        System.out.println("Dimens: " + p.getDimens());
        System.out.println("Massimo: " + p.getMassimo());
        System.out.println("Totale: " + p.getSomma());
    }

}
