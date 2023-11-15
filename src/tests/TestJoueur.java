package tests;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;
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
		Joueur joueur1 = new Joueur("Michel",limites,batailles,bornes,bottes,mainJoueur);
		
		
		bornes.add(new Borne(1,50));
		bornes.add(new Borne(1,100));
		System.out.println("KM du joueur : " + joueur1.getKM() + "km !");	// Resultat attendu : 150 KM
		
		
		limites.add(new DebutLimite(1));
		System.out.println("Limite du joueur : " + joueur1.getLimite() + " !"); // Debut de limite = 50
		limites.add(new FinLimite(1));
		System.out.println("Limite du joueur : " + joueur1.getLimite() + " !"); // Fin de limite apres debut de limite = 200
		limites.add(new DebutLimite(1));
		System.out.println("Limite du joueur : " + joueur1.getLimite() + " !"); // Debut de limite apres une fin de limite = 50
		bottes.add(new Botte(1,Type.FEU));
		limites.add(new DebutLimite(1));
		System.out.println("Limite du joueur : " + joueur1.getLimite() + " !"); // Botte Feu toujours = 200
		
		
		
		
		bottes.clear();
		batailles.add(new Attaque(1, Type.FEU));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		bottes.add(new Botte(1, Type.FEU));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		batailles.add(new Attaque(1, Type.ACCIDENT));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		bottes.add(new Botte(1,Type.ACCIDENT));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		batailles.add(new Attaque(1, Type.ESSENCE));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		batailles.add(new Parade(1,Type.ESSENCE));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		bottes.clear();
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		batailles.add(new Parade(1, Type.FEU));
		System.out.println("Est joueur bloqué : " +  joueur1.estBloque());
		
		// true, false, true, false, true, false, true, false
	}
}
