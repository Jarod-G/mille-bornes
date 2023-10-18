package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;


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
		Collections.addAll(listeCartes, typesDeCartes);
	
	}
	
	
	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	
	public void afficherCartes() {
		int i = 0;
		System.out.println("Voici les cartes comprises dans le jeu : \n");
		for (Iterator<Carte> iterator = listeCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.println("x"+carte.getNombre() + " " + carte.toString());
			i += carte.getNombre();
		}
		System.out.println("\nTOTAL DE CARTES : " + i);
	}
	
	
	public boolean checkCount() {
	    for (Carte carte : listeCartes) {
	        int expectedCount = 0;

	        if (carte instanceof Borne) {
	            Borne borne = (Borne) carte;
	            switch (borne.getKm()) {
	                case 25,50,75:
	                    expectedCount = 10; break;
	                case 100:
	                    expectedCount = 12; break;
	                case 200:
	                    expectedCount = 4; break;
	            }
	        } 
	        else if (carte instanceof Attaque) {
	            Attaque attaque = (Attaque) carte;
	            switch (attaque.getType()) {
	                case FEU:
	                    expectedCount = 5; break;
	                case ESSENCE,CREVAISON,ACCIDENT:
	                    expectedCount = 3; break;
	            }
	        } 
	        else if (carte instanceof Parade) {
	            Parade parade = (Parade) carte;
	            switch (parade.getType()) {
	                case FEU:
	                    expectedCount = 14; break;
	                case ESSENCE,CREVAISON,ACCIDENT:
	                    expectedCount = 6; break;	        
	            }
	        } else if (carte instanceof Botte) {
	            expectedCount = 1;
	        } else if (carte instanceof DebutLimite) {
	            expectedCount = 4;
	        } else if (carte instanceof FinLimite) {
	            expectedCount = 6;
	        }

	        if (carte.getNombre() != expectedCount) {
	            return false;
	        }
	    }

	    return true;
	}


    
}
