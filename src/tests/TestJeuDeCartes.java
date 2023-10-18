package tests;

import java.util.ArrayList;
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
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		jeu2.afficherCartes();
		System.out.println("liste mélangée sans erreur ? " + Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		
		
		/*TODO
		listeCartes = Utils.rassember(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
		*/
	}

}
