package cartes;

public class Botte extends Probleme {

	public Botte(int n, Type type) {
		super(n, type);
	}
	
	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU: {
			return "VéhiculePrioritaire";
		}
		case ESSENCE:{
			return "CiterneEssence";
		}
		case CREVAISON:{
			return "Increvable";
		}
		case ACCIDENT:{
			return "AsDuVolant";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte botte){
			Botte otherBotte = botte;
			return this.getType().equals(otherBotte.getType());
		}
		return false;
	}
}
