package creazionedataset;

import java.util.ArrayList;
import java.util.Random;

public class Utente {
    private long id;
    private int sesso;
    private int eta;
    private ArrayList<Report> listaReport;

    public Utente(long id, int sesso, int eta, ArrayList<Report> listaReport) {
        this.id = id;
        this.sesso = sesso;
        this.eta = eta;
        this.listaReport = listaReport;
    }

    public Utente() {
        listaReport=new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSesso() {
        return sesso;
    }

    public void setSesso(int sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public ArrayList<Report> getListaReport() {
        return listaReport;
    }

    public void setListaReport(ArrayList<Report> listaReport) {
        this.listaReport = listaReport;
    }

    @Override
    public String toString() {
        return "Utente [eta=" + eta + ", id=" + id + ", listaReport=" + listaReport + ", sesso=" + sesso + "]";
    }

    public static Utente generaUtente(long id, int mesi) {
        Utente nuovoUtente = new Utente();
        Random r = new Random();
        nuovoUtente.setEta(r.nextInt(42) + 18);
        nuovoUtente.setSesso(r.nextInt(2));
        nuovoUtente.setId(id);
        nuovoUtente.AggiungiReport(Report.generaReport(nuovoUtente,1));
        for (int i = 1; i < mesi; i++) {
            nuovoUtente.AggiungiReport(Report.generaReport(nuovoUtente,i+1,
            (nuovoUtente.getListaReport().get(i-1).getPeso())-nuovoUtente.getListaReport().get(i-1).getVariazionePesoStimato()));
        }
        return nuovoUtente;

    }

    public void AggiungiReport(Report report) {
        this.listaReport.add(report);

    }

}
