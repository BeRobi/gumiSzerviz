package modell;

public abstract class Gumiabroncs {

    private String gumiMarka;
    public boolean kopott;
    public double profilmelyseg;

    public Gumiabroncs(String gumiMarka, double profilmelyseg) {
        this.gumiMarka = gumiMarka;
        this.kopott = false;
        this.profilmelyseg = profilmelyseg;
    }

    public String getGumiMarka() {
        return gumiMarka;
    }

    public boolean isKopas() {
        return kopott;
    }

    public double getProfilmelyseg() {
        return profilmelyseg;
    }

    public void setGumiMarka(String gumiMarka) {
        this.gumiMarka = gumiMarka;
    }

    public String kopottE() {
        if (isKopas()) {
            return "elkopott";
        }
        return "javítható";
    }

    public abstract void javit();

    @Override
    public String toString() {
        return "Gumiabroncs: " + gumiMarka + " " + kopottE() + String.format(", profilmélység: %.1f mm, ", profilmelyseg);
    }
}
