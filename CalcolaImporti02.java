import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Si vuole leggere da un file, calcolare il totale dei valori letti, e
 * trovare il massimo fra i valori letti
 * 
 * @version 0.2
 */
public class CalcolaImporti02 {
    private List<String> importi = new ArrayList<String>();
    private float totale, massimo;

    /**
     * legge da file i valori, trova il massimo e li somma
     * 
     * @param c nome cartella
     * @param n nome file
     * @return totale valori
     */
    public float calcola(String c, String n) throws IOException {
        // preparazione variabile per la lettura del file
        LineNumberReader f = new LineNumberReader(new FileReader(new File(c, n)));
        String riga;
        // ciclo di lettura da file e inserimento in lista
        while (true) {
            riga = f.readLine();
            if (riga == null)
                break;
            if (!importi.contains(riga))
                importi.add(riga);
        }
        f.close();
        // calcolo del totale
        totale = 0;
        for (int i = 0; i < importi.size(); i++) {
            totale += Float.parseFloat(importi.get(i));
        }
        // estrazione del massimo
        massimo = Float.parseFloat(importi.get(0));
        for (int i = 1; i < importi.size(); i++)
            if (massimo < Float.parseFloat(importi.get(i)))
                massimo = Float.parseFloat(importi.get(i));
        return totale;
    }
}