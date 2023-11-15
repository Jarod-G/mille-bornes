package cartes;

public class Parade extends Bataille {

	public Parade(int n, Type type) {
		super(n, type);
	}
	
	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "FeuVert";
		}
		case ESSENCE:{
			return "Essence";
		}
		case CREVAISON:{
			return "RoueDeSecours";
		}
		case ACCIDENT:{
			return "R�parations";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade parade){
			Parade otherParade = parade;
			return this.getType().equals(otherParade.getType());
		}
		return false;
	}
}
