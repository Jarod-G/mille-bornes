package jeu;

import java.util.Iterator;

import cartes.Carte;

public abstract class Sabot<E> implements Iterator<E> {
	private int nbCartes = 0;
	private Carte [] Cartes;
	
	public Sabot(int capacite) {
		this.Cartes = new Carte[capacite];
	}
	
	public boolean EstVide() {
		if(Cartes.length == 0) {
			return true;
		}
		return false;
	}
	
	private void ajouterCarte(Carte carte) {
		Cartes[nbCartes] = carte;
		nbCartes = nbCartes + 1;
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i = 0; i < carte.getNombre(); i++) {
			nbCartes++;
			Cartes[nbCartes] = carte;
		}
	}
	
	public void ajouterFamilleCarte(Carte[] cartes) {
		for(int i = 0; i < cartes.length; i++) {
			ajouterFamilleCarte(cartes[i]);
		}
	}
}
