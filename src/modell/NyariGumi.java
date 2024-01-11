package modell;

// A NyariGumi osztály
public class NyariGumi extends Gumiabroncs {

    private GumiAllapot allapot;

    public NyariGumi(String gumiMarka, double profilmelyseg, GumiAllapot allapot) {
        super(gumiMarka, profilmelyseg);
        this.allapot = allapot;
    }

    public NyariGumi(String gumiMarka) {
        this(gumiMarka, 6.0, GumiAllapot.UJ);
    }

    public NyariGumi(String gumiMarka, double profilmelyseg) {
        super(gumiMarka, profilmelyseg);
        this.allapot = GumiAllapot.UJ;
    }

    public void elHasznalt() {
        if (allapot != GumiAllapot.ELHASZNALODOTT) {
            allapot = GumiAllapot.values()[allapot.ordinal() - 1];
        }
    }

    @Override
    public void javit() {
        if (profilmelyseg < 3.0) {
            kopott = true;
        } else {
            profilmelyseg *= 0.80;
        }
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os + "állapota " + allapot;
    }

    public GumiAllapot getAllapot() {
        return allapot;
    }
}
