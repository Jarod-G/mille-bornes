package cartes;

public class Attaque extends Bataille {

	public Attaque(int n, Type type) {
		super(n, type);
	}
	
	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FeuRouge";
		}
		case ESSENCE:{
			return "PanneEssence";
		}
		case CREVAISON:{
			return "Crevaison";
		}
		case ACCIDENT:{
			return "Accident";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Attaque attaque){
			Attaque otherAttaque = attaque;
			return this.getType().equals(otherAttaque.getType());
		}
		return false;
	}
}
