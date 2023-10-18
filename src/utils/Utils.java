package utils;

import java.util.*;

public class Utils {
    


	// rassembler pour chaque elem compter le nb d'occ et ajouter autant de copie dans la lst rassembler.
	
	// tant que e = precedent quand != precedent je parcours fin de liste puis je reprends (i lfaut 2 boucles)
    
    
	public static <T> T extraire (List<T> liste) {
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
            return false; // Les listes n'ont pas la même taille
        }

        for (T element : liste1) {
            int occurencesListe1 = Collections.frequency(liste1, element);
            int occurencesListe2 = Collections.frequency(liste2, element);

            if (occurencesListe1 != occurencesListe2) {
                return false; // Pas le même nombre d'occurrences.
            }
        }

        return true;
    }

}
