import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Si vuole leggere da un file e calcolare il totale dei valori letti
 * 
 * @version 0.1
 */
public class CalcolaImporti01 { // classe
    private final List<String> importi = new ArrayList<>();
    // List e ArrayList sono tipi della libreria Java
    private float totale;

    /**
     * legge linea per linea il file, aggiunge in lista e calcola totale
     * 
     * @param c cartella
     * @param n nomeFile
     */
    public float calcola(final String c, final String n) throws IOException { // metodo
        final LineNumberReader f = new LineNumberReader(new FileReader(new File(c, n)));
        // lettura file tramite le API Java: File, FileReader, LineNumberReader

        totale = 0;
        while (true) {
            final String riga = f.readLine(); // legge una riga dal file
            if (null == riga)
                break; // esce dal ciclo
            importi.add(riga); // aggiunge in lista
            totale += Float.parseFloat(riga); // converte da String a float
        }
        f.close(); // chiude file
        return totale; // restituisce il totale al chiamante
    }
}