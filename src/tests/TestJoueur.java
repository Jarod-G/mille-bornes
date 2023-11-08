package tests;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Borne;
import cartes.Carte;
import jeu.Joueur;
import jeu.Main;
import jeu.MainAsListe;

public class TestJoueur {
	
	public static void main(String[] args) {
		List<Carte> limites = new ArrayList<>(); // Pile de debut de limite/ fin de limite
		List<Carte> batailles = new ArrayList<>(); // Pile attaques/parades
		List<Carte> bornes = new ArrayList<>(); // Cartes Bornes
		Set<Carte> bottes = new HashSet<>(); // Cartes Bottes
		Main mainJoueur = new MainAsListe();
		
		bornes.add(new Borne(1,50));
		bornes.add(new Borne(1,100));
		
		Joueur joueur1 = new Joueur("Michel",limites,batailles,bornes,bottes,mainJoueur);
		
		System.out.println("KM du joueur : " + joueur1.getKM() + " !");	
		
	}
}
