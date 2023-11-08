package jeu;

import java.util.List;
import java.util.Set;
import cartes.Carte;
import cartes.Borne;

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
	
	public int getLimite() {
		int km = 0;
		for(Carte carte : this.getBornes()) {
			Borne carteBorne = (Borne)carte;
			km += carteBorne.getKm();
		}
		return km;
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
