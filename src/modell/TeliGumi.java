package modell;

public class TeliGumi extends Gumiabroncs {

    public TeliGumi(String gumiMarka, double profilmelyseg) {
        super(gumiMarka, profilmelyseg);
    }

    public TeliGumi(String gumiMarka) {
        this(gumiMarka, 6.0);

    }

    @Override
    public void javit() {
        if (profilmelyseg < 4.0) {
            kopott = true;
        } else {
            profilmelyseg *= 0.85;
        }
    }
}
