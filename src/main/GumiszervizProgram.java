package main;

import modell.GumiSzerviz;
import modell.GumiAllapot;
import modell.NyariGumi;
import modell.TeliGumi;
import modell.Gumiabroncs;

public class GumiszervizProgram {

    private final GumiSzerviz gumiszerviz;

    public static void main(String[] args) {

        new GumiszervizProgram();
    }

    public GumiszervizProgram() {
        gumiszerviz = new GumiSzerviz(8);

        gumiszerviz.befogad(new NyariGumi("Michelin"));
        gumiszerviz.befogad(new TeliGumi("Continental"));
        gumiszerviz.befogad(new NyariGumi("Pirelli"));
        gumiszerviz.befogad(new TeliGumi("Hankook", 4.0));
        gumiszerviz.befogad(new NyariGumi("Yokohama", 5.0));
        gumiszerviz.befogad(new TeliGumi("Kormor�n", 5.5));
        gumiszerviz.befogad(new NyariGumi("Goodyear", 4.5, GumiAllapot.KEVESET_FUTOTT));

        System.out.println("--- jav�t�s EL�TT:");
        gumikSzervizbenKiir();
        gumiszerviz.javit();
        System.out.println("--- 1. jav�t�s UT�N:");
        gumiszerviz.kiad("Pirelli");
        gumikSzervizbenKiir();
        gumiszerviz.javit();
        System.out.println("--- 2. jav�t�s UT�N:");
        gumikSzervizbenKiir();
        gumiszerviz.javit();
        System.out.println("--- 3. jav�t�s UT�N:");
        gumikSzervizbenKiir();
        gumiszerviz.leeg();
        gumikSzervizbenKiir();

    }

    private void gumikSzervizbenKiir() {
        System.out.println("Gumiszervizben l�v� gumiabroncsok:");
        for (Gumiabroncs gumiabroncs : gumiszerviz.getGumik()) {
            if (gumiabroncs != null) {
                System.out.println(gumiabroncs);
            }
        }
        
    }
}
