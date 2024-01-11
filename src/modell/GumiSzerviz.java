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
            System.out.println("A gumiszerviz nem üzemel, nem tudunk gumiabroncsot befogadni.");
            return;
        }

        for (int i = 0; i < gumiabroncsok.length; i++) {
            if (gumiabroncsok[i] == null) {
                gumiabroncsok[i] = gumiabroncs;
                return;
            }
        }
        System.out.println("A gumiszerviz megtelt, nem tudunk több gumiabroncsot befogadni.");
    }

    public void kiad(String gumiMarka) {
        if (!uzemel) {
            System.out.println("A gumiszerviz nem üzemel, nem tudunk gumiabroncsot kiadni.");
            return;
        }
        for (int i = 0; i < gumiabroncsok.length; i++) {
            if (gumiabroncsok[i] != null && gumiabroncsok[i].getGumiMarka().equals(gumiMarka)) {
                System.out.println(gumiabroncsok[i].getGumiMarka() + " kiadva a gumiszervizbõl.");
                gumiabroncsok[i] = null;
                return;
            }
        }
        System.out.println("Nincs ilyen nevø gumiabroncs a gumiszervizben.");
    }

    public void javit() {
        if (!uzemel) {
            System.out.println("A gumiszerviz nem üzemel, nem tudunk javítani.");
            return;
        }
        for (Gumiabroncs gumiabroncs : gumiabroncsok) {
            if (gumiabroncs != null) {
                if (gumiabroncs.isKopas()) {
                    System.out.println(gumiabroncs.getGumiMarka() + " gumiabroncs kopott, nem lehet javítani.");
                } else {
                    gumiabroncs.javit();
                    if (gumiabroncs instanceof NyariGumi) {
                        ((NyariGumi) gumiabroncs).elHasznalt();
                    }
                    System.out.println(gumiabroncs.getGumiMarka() + " gumiabroncs javítva.");
                }
            }
        }
        System.out.println("A gumiszerviz elvégezte a javítást.");
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
            System.out.println("A gumiszerviz leégett, nem tudunk tovább üzemelni.");
        }
    }
}
