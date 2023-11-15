package jeu;

import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;
import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;

public class Joueur {
	private String nomJoueur;
	private List<Carte> limites; // Pile de debut de limite/ fin de limite
	private List<Carte> batailles; // Pile attaques/parades
	private List<Carte> bornes; // Cartes Bornes
	private Set<Carte> bottes; // Cartes Bottes
	private Main mainJoueur;
	
	
	public Joueur(String nomJoueur, List<Carte> limites, List<Carte> batailles, List<Carte> bornes, Set<Carte> bottes, Main mainJoueur) {
		this.nomJoueur = nomJoueur;
		this.limites = limites;
		this.batailles = batailles;
		this.bornes = bornes;
		this.bottes = bottes;
		this.mainJoueur = mainJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}
	
	public List<Carte> getLimites() {
		return limites;
	}
	
	public List<Carte> getBatailles() {
		return batailles;
	}
	
	public List<Carte> getBornes() {
		return bornes;
	}
	
	public Set<Carte> getBottes() {
		return bottes;
	}
	
	public Main getMainJoueur() {
		return mainJoueur;
	}
	
	public void donner(Carte carte) {
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) {
			return null;
		}
		Carte carteD = sabot.get(0);
		this.donner(carteD);
		return carteD;
	}
	
	public int getKM() {
		int km = 0;
		for(Carte carte : this.getBornes()) {
			Borne carteBorne = (Borne)carte;
			km += carteBorne.getKm();
		}
		return km;
	}
	
	private boolean isVhPrioritaire() {
	    // Vérifier si le joueur a une botte de type FEU
	    for (Carte botte : this.getBottes()) {
	    	Botte botte_c = (Botte)botte;
	        if (botte_c.getType().equals(Type.FEU)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public int getLimite() {
		List<Carte> limites_l = this.getLimites();
		if(limites_l.isEmpty()) {
			return 200;
		}
		else {
			Carte sommetPile = limites_l.get(limites_l.size() - 1);
			if((sommetPile instanceof FinLimite) || isVhPrioritaire()) {
				return 200;
			}else {
				return 50;
			}
		}
	}
	
	private boolean aBotteDeTypeAutreQueFeu(Type type) {
        // Vérifier si le joueur a une botte pour le type spécifié
        for (Carte botte : this.getBottes()) {
            Botte botte_c = (Botte) botte;
            if (botte_c.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
	
	public boolean estBloque() {
		List<Carte> batailles_l = this.getBatailles();
        if (batailles_l.isEmpty() && isVhPrioritaire()) {
            // La pile de bataille est vide et le joueur est prioritaire
            return false;
        }if(!batailles_l.isEmpty()) {
        	Carte sommetPile = batailles_l.get(batailles_l.size() - 1);
        	if(sommetPile instanceof Parade parade && parade.getType() == Type.FEU) {
        		return false;
        	}
        	
        	if(sommetPile instanceof Parade && isVhPrioritaire()) {
        		return false;
        	}
        	
        	if((sommetPile instanceof Attaque attaque && attaque.getType() == Type.FEU) && isVhPrioritaire()) {
        		return false;
        	}
        	
        	if (sommetPile instanceof Attaque attaque && !attaque.getType().equals(Type.FEU) && aBotteDeTypeAutreQueFeu(attaque.getType()) && isVhPrioritaire()) {
                // Le sommet est une attaque d'un autre type, le joueur a une botte pour ce type, et il est prioritaire
                return false;
            }
        }
        return true;
	}
	
	
	@Override
	public String toString() {
		return this.getNomJoueur();
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Joueur joueur){
			 return this.toString().equals(joueur.toString());
		 }
		 return false;
	}
	



	
	
	
}
