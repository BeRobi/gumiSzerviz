package modell;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GumiSzerviz {

    private Gumiabroncs[] gumiabroncsok;
    private boolean uzemel;

    public GumiSzerviz() {
        this(5);
    }

    public GumiSzerviz(int db) {
        this.uzemel = true;
        gumiabroncsok = new Gumiabroncs[db];
    }

    public void befogad(Gumiabroncs gumiabroncs) {
        if (!uzemel) {
            System.out.println("A gumiszerviz nem �zemel, nem tudunk gumiabroncsot befogadni.");
            return;
        }

        for (int i = 0; i < gumiabroncsok.length; i++) {
            if (gumiabroncsok[i] == null) {
                gumiabroncsok[i] = gumiabroncs;
                return;
            }
        }
        System.out.println("A gumiszerviz megtelt, nem tudunk t�bb gumiabroncsot befogadni.");
    }

    public void kiad(String gumiMarka) {
        if (!uzemel) {
            System.out.println("A gumiszerviz nem �zemel, nem tudunk gumiabroncsot kiadni.");
            return;
        }
        for (int i = 0; i < gumiabroncsok.length; i++) {
            if (gumiabroncsok[i] != null && gumiabroncsok[i].getGumiMarka().equals(gumiMarka)) {
                System.out.println(gumiabroncsok[i].getGumiMarka() + " kiadva a gumiszervizb�l.");
                gumiabroncsok[i] = null;
                return;
            }
        }
        System.out.println("Nincs ilyen nev� gumiabroncs a gumiszervizben.");
    }

    public void javit() {
        if (!uzemel) {
            System.out.println("A gumiszerviz nem �zemel, nem tudunk jav�tani.");
            return;
        }
        for (Gumiabroncs gumiabroncs : gumiabroncsok) {
            if (gumiabroncs != null) {
                if (gumiabroncs.isKopas()) {
                    System.out.println(gumiabroncs.getGumiMarka() + " gumiabroncs kopott, nem lehet jav�tani.");
                } else {
                    gumiabroncs.javit();
                    if (gumiabroncs instanceof NyariGumi) {
                        ((NyariGumi) gumiabroncs).elHasznalt();
                    }
                    System.out.println(gumiabroncs.getGumiMarka() + " gumiabroncs jav�tva.");
                }
            }
        }
        System.out.println("A gumiszerviz elv�gezte a jav�t�st.");
    }

    public Gumiabroncs[] getGumiabroncsok() {
        return gumiabroncsok;
    }

    public List<Gumiabroncs> getGumik() {
        List<Gumiabroncs> gumikListaja = Arrays.asList(gumiabroncsok);
        return Collections.unmodifiableList(gumikListaja);
    }

    public void leeg() {
        uzemel = false;
        for (int i = 0; i < gumiabroncsok.length; i++) {
            if (gumiabroncsok[i] != null) {
                gumiabroncsok[i] = null;
            }
            System.out.println("A gumiszerviz le�gett, nem tudunk tov�bb �zemelni.");
        }
    }
}
