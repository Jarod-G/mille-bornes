package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;


public class JeuDeCartes {
	Carte[] typesDeCartes = {new Borne(10,25), new Borne(10,50), new Borne(12,100), new Borne(4,200), new DebutLimite(4), new FinLimite(6),new Probleme(20,Type.FEU),new Probleme(10,Type.ESSENCE), new Probleme(10,Type.CREVAISON), new Probleme(10,Type.ACCIDENT)};
	
	
	public JeuDeCartes() {
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, new Attaque(5, Type.FEU),new Attaque(3, Type.ESSENCE),new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ACCIDENT));
		Collections.addAll(listeCartes, new Parade(14, Type.FEU),new Parade(6, Type.ESSENCE),new Parade(6, Type.CREVAISON), new Parade(6, Type.ACCIDENT));
		Collections.addAll(listeCartes, new Botte(1, Type.FEU),new Botte(1, Type.ESSENCE),new Botte(1, Type.CREVAISON), new Botte(1, Type.ACCIDENT));
		Collections.addAll(listeCartes, new Borne(10,25), new Borne(10,50), new Borne(12,100), new Borne(4,200), new DebutLimite(4), new FinLimite(6));
		int i = 0;
		for (Iterator iterator = listeCartes.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.println("La carte : " + carte.toString() +" " +carte.getNombre());
			i += carte.getNombre();
		}
		System.out.println("TOTAL DE CARTES : " + i);
	}

}
