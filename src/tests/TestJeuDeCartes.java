package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		jeu.afficherCartes();
		System.out.println("Compte des cartes juste ? " + jeu.checkCount());
		
		// UTILS
		System.out.println(Utils.extraire(jeu.getListeCartes()).toString()); // Carte aléatoirement
		jeu.afficherCartes();
		
		//TEST
		JeuDeCartes jeu2 = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu2.getListeCartes();
		List<Carte> listeCartes = jeu2.getListeCartes();
		System.out.println("INIT LISTE : " + listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println("MELG LISTE : " +listeCartes);
		jeu2.afficherCartes();
		System.out.println("liste m�lang�e sans erreur ? " + Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		
		System.out.println(listeCartes);
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassembl�e sans erreur ? " + Utils.verifierRassemblement(listeCartes)); // Doit être true
		System.out.println("liste rassembl�e sans erreur ? " + Utils.verifierRassemblement(Arrays.asList(1,1,2,1,3))); // Doit être false
		
		jeu2.testerOccurrences(listeCartes);
	}

}
