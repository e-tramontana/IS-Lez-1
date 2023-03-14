import java.io.IOException;

/**
 * La classe TestPagamenti è sottoclasse di MyTestSupport che implementa i 
 * metodi assert (assertEquals e assertTrue).
 */
public class TestPagamenti extends MyTestSupport {
    private final Pagamenti pagam = new Pagamenti();
    private final String nomeFile = "Importi.csv";
    private final String percorso = "./";

    public static void main(String[] args) {
        TestPagamenti t = new TestPagamenti();
        t.testLeggiFile();
        t.testLeggiValoreDaFile();
        t.testSommaValori();
        t.testMaxValore();
    }

    private void initLista() {
        pagam.svuota();
        pagam.inserisci("321.01");
        pagam.inserisci("531.7");
        pagam.inserisci("1234.5");
        pagam.converti();
    }

    public void testSommaValori() {
        initLista();
        // chiama il metodo da testare
        pagam.calcolaSomma();
        // legge il risultato calcolato e lo confronta con il risultato atteso
        assertEquals(pagam.getSomma(), 2087.21f, "somma");
    }

    public void testLeggiFile() {
        pagam.svuota();
        try {
            pagam.leggiFile(percorso, nomeFile);
            assertTrue(true, "apri e leggi file");
        } catch (IOException e) {
            assertTrue(false, "apri e leggi file");
        }
    }

    public void testLeggiValoreDaFile() {
        pagam.svuota();
        try {
            pagam.leggiFile(percorso, nomeFile);
        } catch (IOException e) {
            assertTrue(false, "leggi valore da file");
        }
        if (pagam.getDimens() > 1) {
            assertTrue(true, "valore letto da file");
            String elem = pagam.getElem(0);
            assertEquals(Float.parseFloat(elem), 1946.28f, "valore da file");
        }
    }

    public void testMaxValore() {
        initLista();
        pagam.calcolaMassimo();
        assertEquals(pagam.getMassimo(), 1234.5f, "massimo valore");
    }
}
