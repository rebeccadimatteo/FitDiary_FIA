package creazionedataset;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataSet{
    public static void main(String[] args) {
        ArrayList<Utente> listaUtenti=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listaUtenti.add(Utente.generaUtente(i+1, 36));
        }
        String csv="id,sesso,eta,mese,peso,kcal,pesoStimato\n";
        for (Utente utente : listaUtenti) {
            var listaReport=utente.getListaReport();
            for (Report report : listaReport) {
                csv+=utente.getId()+","+utente.getSesso()+","
                +utente.getEta()+","+report.getMese()+","
                +report.getPeso()+","+report.getKcal()+","
                +report.getVariazionePesoStimato()+"\n";
            }
        }
        File csvOutputFile = new File("dataset.csv");
        try (PrintWriter pw=new PrintWriter(csvOutputFile)){
            pw.print(csv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}