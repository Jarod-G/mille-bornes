package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import cartes.Carte;


public class Sabot<E> implements Iterable<E> {
	private int nbCartes = 0;
	private Carte [] cartesSabot;
	private int nbOperations = 0;
	private boolean nextEffectue = false;
	
	
	public Sabot(int capacite) {
		this.cartesSabot = new Carte[capacite];
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) {
		cartesSabot[nbCartes] = carte;
		nbCartes = nbCartes + 1;
		nbOperations++;
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i = 0; i < carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte[] cartes) {
		for(int i = 0; i < cartes.length; i++) {
			ajouterFamilleCarte(cartes[i]);
		}
	}
	
	
	public E piocher() {
		Iterator<E> iter = iterator();
		if(iter.hasNext()) {
			E carte = iter.next();
			iter.remove();
			return carte;
		}
		return null;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new SabotIterator();
	}
	
	private class SabotIterator implements Iterator<E>{
		private int indiceIterator = 0;
		private int nbOperationsRef = nbOperations;

		@Override
		public boolean hasNext() {
			return indiceIterator < nbCartes;
		}
		
		@Override
        public void remove() {
            if (nbOperations != nbOperationsRef) {
                throw new ConcurrentModificationException();
            }

            if (nbCartes < 1 || !nextEffectue) {
                throw new IllegalStateException("Impossible de supprimer l'élément actuel.");
            }
            
            for (int i = indiceIterator - 1; i < nbCartes - 1; i++) {
                cartesSabot[i] = cartesSabot[i + 1];
            }
            
            nextEffectue = false;
            nbOperationsRef++;
            nbOperations++;
            nbCartes--;
            indiceIterator--;
        }

		@Override
		public E next() {
			verificationConcurrence();
			if(hasNext()) {
				@SuppressWarnings("unchecked")
				E element = (E) cartesSabot[indiceIterator];
				indiceIterator++;
				nextEffectue = true;
				return element;
				
			}else {
				throw new NoSuchElementException("Pas d'élément suivant !");
			}
		}
		
		private void verificationConcurrence(){
			 if (nbOperations != nbOperationsRef) {
				 throw new ConcurrentModificationException();
			 }
			 
		 }
		
		
	}
	
}
