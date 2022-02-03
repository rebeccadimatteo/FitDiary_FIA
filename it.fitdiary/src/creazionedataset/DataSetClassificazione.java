package creazionedataset;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataSetClassificazione {
    public static void main(String[] args) throws Exception {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listaUtenti.add(Utente.generaUtente(i + 1, 36));
        }
        String csvClassificazione = "id,sesso,eta,mese,peso,kcal,pesoStimato\n";
        for (Utente utente : listaUtenti) {
            var listaReport = utente.getListaReport();
            for (Report report : listaReport) {
                csvClassificazione += utente.getId() + "," + utente.getSesso() + ","
                        + utente.getEta() + "," + report.getMese() + ","
                        + report.getPeso() + "," + report.getKcal() + ","
                        + range(report.getVariazionePesoStimato(), 25) + "\n";
            }
        }
        File csvOutputFileClassificazione = new File("datasetClassificazione.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFileClassificazione)) {
            pw.print(csvClassificazione);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int range(float number,int range){
        int newNumber=0;
        newNumber=(int)(13+(Math.floor((number/range)*100)));
        return newNumber;
    }
}
