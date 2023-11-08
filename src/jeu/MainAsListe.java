package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartes.Carte;

public class MainAsListe implements Main {
    private List<Carte> cartesEnMain;

    public MainAsListe() {
        cartesEnMain = new ArrayList<>();
    }

    @Override
    public void prendre(Carte carte) {
        cartesEnMain.add(carte);
    }

    @Override
    public void jouer(Carte carte) {
        assert cartesEnMain.contains(carte) : "La carte à jouer n'est pas présente dans la main.";
        cartesEnMain.remove(carte);
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartesEnMain.iterator();
    }
}

