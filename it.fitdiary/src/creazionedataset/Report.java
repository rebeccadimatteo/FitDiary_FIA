package creazionedataset;

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

    
}
