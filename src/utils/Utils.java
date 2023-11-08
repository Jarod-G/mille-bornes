package utils;

import java.util.*;

public class Utils {
    

	public static <T> T extraire(List<T> liste) {
	    if (liste.isEmpty()) {
	        throw new IllegalArgumentException("Liste vide.");
	    }

	    Random rand = new Random();
	    int randomIndex = rand.nextInt(liste.size());

	    T element = liste.get(randomIndex);
	    liste.remove(randomIndex);
	    return element;
	}

	public static <T> T extraireListeIte (List<T> liste) {
        Random rand = new Random();
        ListIterator<T> iterator = liste.listIterator();
        int randomIndex = rand.nextInt(liste.size());

        while (iterator.nextIndex() < randomIndex) {
            iterator.next();
        }

        T element = iterator.next();
        iterator.remove();
        return element;
        
    }
	
	
	public static <T> List<T> melanger (List<T> liste) {
		List<T> listeMelange = new ArrayList<>();
		while(!liste.isEmpty()) {		
			listeMelange.add(extraire(liste));
		}
		return listeMelange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
        if (liste1.size() != liste2.size()) {
            return false; // Les listes n'ont pas la m�me taille
        }

        for (T element : liste1) {
            int occurencesListe1 = Collections.frequency(liste1, element);
            int occurencesListe2 = Collections.frequency(liste2, element);

            if (occurencesListe1 != occurencesListe2) {
                return false; // Pas le m�me nombre d'occurrences.
            }
        }

        return true;
    }
    
    
    public static <T> List<T> rassembler(List<T> liste) {
        List<T> listeRassemblee = new ArrayList<>();
        for (T current : liste) {
        	if(!listeRassemblee.contains(current)) {
                int occ = Collections.frequency(liste, current);

                // Ajouter les copies de l'élément actuel
                for (int k = 0; k < occ; k++) {
                    listeRassemblee.add(current);
                }
        	}
        }
        return listeRassemblee;
    }
    
    public static <T> boolean verifierRassemblement(List<T> liste) {
        ListIterator<T> it1 = liste.listIterator();
        int size = liste.size();
        ListIterator<T> it2 = liste.listIterator(size);
        if (!it1.hasNext()) {
            return true;
        }
        while (it1.hasNext()) {
            T element1 = it1.next();
            while(it2.hasPrevious() && it2 != it1) {
                T element2 = it2.previous();
                if (element2.equals(element1) && it2.hasPrevious() && !it2.previous().equals(element1)) {
                    return false;
                }
           }
        }
        return true;
    }
    
    
}
