package creazionedataset;

import java.util.ArrayList;

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

}
