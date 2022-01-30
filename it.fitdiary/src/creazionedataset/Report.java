package creazionedataset;

import java.util.Random;

public class Report {
    private int mese;
    private int kcal;
    private float peso;
    private float variazionePesoStimato;

    public Report(int mese, int kcal, float peso, float variazionePesoStimato) {
        this.mese = mese;
        this.kcal = kcal;
        this.peso = peso;
        this.variazionePesoStimato = variazionePesoStimato;
    }

    public Report() {
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getVariazionePesoStimato() {
        return variazionePesoStimato;
    }

    public void setVariazionePesoStimato(float variazionePesoStimato) {
        this.variazionePesoStimato = variazionePesoStimato;
    }

    @Override
    public String toString() {
        return "Report [kcal=" + kcal + ", mese=" + mese + ", peso=" + peso + ", variazionePesoStimato="
                + variazionePesoStimato + "]";
    }

    public static Report generaReport(Utente nuovoUtente, int mese) {
        Report report = new Report();
        Random r = new Random();
        report.setMese(mese);
        report.setPeso(r.nextInt(50) + 60);
        int kcalDaAssumere = calcoloKcalDaAssumere(nuovoUtente, report.getPeso());
        int kcalAssunte = Integer
                .parseInt("" + (r.nextInt(4) > 2 ? kcalDaAssumere + (kcalDaAssumere * (r.nextInt(40) / 100))
                        : kcalDaAssumere - (kcalDaAssumere * (r.nextInt(40) / 100))));
        report.setKcal(kcalAssunte);
        report.setVariazionePesoStimato(calcolaPesoPerso(nuovoUtente, report.getKcal(), kcalDaAssumere));
        return report;
    }

    public static int calcoloKcalDaAssumere(Utente utente, float peso) {

        double metabolismoBasale = 0;
        double livelloAttivitaFisica = 0;
        Random r = new Random();
        double kcalDaAssumere = 0;
        if (utente.getSesso() == 0) {
            if (utente.getEta() >= 18 && utente.getEta() <= 29) {
                metabolismoBasale = 14.7 * peso + 496;
            } else if (utente.getEta() >= 30 && utente.getEta() <= 59) {
                metabolismoBasale = 8.7 * peso + 829;
            } else if (utente.getEta() >= 60 && utente.getEta() <= 74) {
                metabolismoBasale = 9.2 * peso + 688;
            } else if (utente.getEta() >= 75) {
                metabolismoBasale = 9.8 * peso + 624;
            }
            livelloAttivitaFisica = 1.78;
        } else if (utente.getSesso() == 1) {
            if (utente.getEta() >= 18 && utente.getEta() <= 29) {
                metabolismoBasale = 15.3 * peso + 679;
            } else if (utente.getEta() >= 30 && utente.getEta() <= 59) {
                metabolismoBasale = 11.6 * peso + 879;
            } else if (utente.getEta() >= 60 && utente.getEta() <= 74) {
                metabolismoBasale = 11.9 * peso + 700;
            } else if (utente.getEta() >= 75) {
                metabolismoBasale = 8.4 * peso + 819;
            }
            livelloAttivitaFisica = 1.64;
        }
        kcalDaAssumere = metabolismoBasale * livelloAttivitaFisica;

        return (int) kcalDaAssumere;
    }

    public static float calcolaPesoPerso(Utente utente, int kcal, int kcalDaAssumere) {
        Random peso = new Random();
        return (peso.nextInt(4) + 2) * (1 - kcalDaAssumere / kcal);

    }
}
