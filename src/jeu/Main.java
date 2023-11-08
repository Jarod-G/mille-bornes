package jeu;

import java.util.Iterator;

import cartes.Carte;

public interface Main {
    // Méthode pour ajouter une carte à la main
    void prendre(Carte carte);

    // Méthode pour jouer une carte de la main
    void jouer(Carte carte);

    // Méthode pour obtenir un itérateur sur les cartes de la main
    Iterator<Carte> iterator();
}

