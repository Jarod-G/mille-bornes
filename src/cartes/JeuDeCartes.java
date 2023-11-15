package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;
import utils.Utils;


public class JeuDeCartes {
	private List<Carte> listeCartes;
	private Carte[] typesDeCartes;
	
	public JeuDeCartes() {
		typesDeCartes = new Carte[] {
            new Borne(10,25), new Borne(10,50), new Borne(10,75),
            new Borne(12,100), new Borne(4,200), new DebutLimite(4),
            new FinLimite(6),new Attaque(5, Type.FEU),new Attaque(3, Type.ESSENCE),
            new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ACCIDENT),
            new Parade(14, Type.FEU),new Parade(6, Type.ESSENCE),new Parade(6, Type.CREVAISON),
            new Parade(6, Type.ACCIDENT), new Botte(1, Type.FEU),new Botte(1, Type.ESSENCE),
            new Botte(1, Type.CREVAISON), new Botte(1, Type.ACCIDENT)
		};
		
		listeCartes = new ArrayList<>();
		for(Carte carte : typesDeCartes) {
			for(int i = 0; i < carte.getNombre(); i++) {
				listeCartes.add(carte);
			}
		}
		
		listeCartes = Utils.melanger(listeCartes);
	
	}
	
	
	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	
	public void afficherCartes() {
		int i = 0;
		System.out.println("Voici les cartes comprises dans le jeu : \n");
		for (Iterator<Carte> iterator = listeCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.println(carte.toString());
			i += 1;
		}
		System.out.println("\nTOTAL DE CARTES : " + i);
	}
	
	
	public boolean checkCount() {
        int[] counts = new int[typesDeCartes.length];

        for (Carte carte : listeCartes) {
            int index = -1;

            if (carte instanceof Borne) {
                Borne borne = (Borne) carte;
                switch (borne.getKm()) {
                case 25: index = 0; break;
                case 50: index = 1; break;
                case 75: index = 2; break;
                case 100: index = 3; break;
                case 200: index = 4; break;
            }
            } else if (carte instanceof DebutLimite) {
                index = 5; // DebutLimite
            } else if (carte instanceof FinLimite) {
                index = 6; // FinLimite
            } else if (carte instanceof Attaque) {
                Attaque attaque = (Attaque) carte;
                index = 7 + attaque.getType().ordinal(); // Attaque
            } else if (carte instanceof Parade) {
                Parade parade = (Parade) carte;
                index = 11 + parade.getType().ordinal(); // Parade
            } else if (carte instanceof Botte) {
                Botte botte = (Botte) carte;
                index = 15 + botte.getType().ordinal(); // Botte
            }

            if (index >= 0) {
                counts[index]++;
            }
        }

        for (int i = 0; i < typesDeCartes.length; i++) {
            if (counts[i] != typesDeCartes[i].getNombre()) {
                System.out.println("Erreur : Le nombre d'exemplaires de type " + i + " est incorrect.");
                return false;
            }
        }
        return true;
    }
	
	
	public void testerOccurrences(List<Carte> listeCartes) {
        for (Carte carte : listeCartes) {
            int occurrencesInitiales = Collections.frequency(listeCartes, carte);
            int occurrencesMelangees = Collections.frequency(listeCartes, carte);
            if (occurrencesInitiales != occurrencesMelangees) {
                System.out.println("Erreur pour la carte : " + carte);
                System.out.println("Occurrences initiales : " + occurrencesInitiales);
                System.out.println("Occurrences mélangées : " + occurrencesMelangees);
            }
        }
        System.out.println("Vérification des occurrences terminée. Nombre d'occurences respectés !");
    }

    
}
