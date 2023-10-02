package tests;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme;
import jeu.Sabot;

public class TestEquals {
	
	public static void main(String[] args) {
        
        Carte accident = new Attaque(1, Probleme.Type.ACCIDENT);
        Carte accident2 = new Attaque(1, Probleme.Type.ACCIDENT);

        Carte asDuVolant = new Botte(1, Probleme.Type.ACCIDENT);
        
        
        System.out.println("Test equals due to adress comparaison : " + (accident == accident));
        System.out.println("Test not equals due to adress comparaison : " + (accident == accident2));
        
        // Method equals
        System.out.println("Test equals due to type comparaison : " + accident.equals(accident2));
        System.out.println("Test equals due to type comparaison : " + accident.equals(asDuVolant));
        
    }
	
	
}
