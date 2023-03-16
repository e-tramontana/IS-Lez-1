import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che legge da file, rappresenta una lista di importi, e fornisce metodi
 * granulari per il calcolo del totale e del valore massimo
 * 
 * @version 1.3
 */
public class Pagamenti {
    private List<String> importiLetti = new ArrayList<>();
    private List<Float> valori = new ArrayList<>();
    private float totale;
    private float massimo;

    /**
     * legge linea per linea il file, e riempie una lista
     * 
     * @param c nome cartella
     * @param n nome file
     */
    public void leggiFile(String c, String n) throws IOException {
        LineNumberReader f = new LineNumberReader(new FileReader(new File(c, n)));
        String riga;
        while (true) {
            riga = f.readLine();
            if (riga == null)
                break;
            inserisci(riga);
        }
        f.close();
    }

    /** inserisce in lista solo valori distinti */
    public void inserisci(String valore) {
        if (!importiLetti.contains(valore))
            importiLetti.add(valore);
    }

    /** converte i valori letti in numeri */
    public void converti() {
        for (String importo : importiLetti)
            valori.add(Float.parseFloat(importo));
    }

    /** calcola la somma dei valori in lista e aggiorna un attributo */
    public void calcolaSomma() {
        totale = 0;
        for (float v : valori)
            totale += v;
    }

    /** calcola il massimo fra i valori in lista e aggiorna un attributo */
    public void calcolaMassimo() {
        massimo = valori.get(0);
        for (float v : valori)
            if (massimo < v)
                massimo = v;
    }

    /** aggiorna tutti gli attributi ai valori iniziali */
    public void svuota() {
        importiLetti = new ArrayList<>();
        valori = new ArrayList<>();
        totale = 0;
        massimo = 0;
    }

    public float getMassimo() {
        return massimo;
    }

    public float getSomma() {
        return totale;
    }

    /** ritorna il numero di valori presenti */
    public int getDimens() {
        return importiLetti.size();
    }

    public String getElem(int indice) {
        return importiLetti.get(indice);
    }
}
