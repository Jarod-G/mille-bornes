package cartes;

public abstract class Probleme extends Carte {
	enum Type{FEU, ESSENCE, CREVAISON, ACCIDENT};
	private Type type;
	
	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}
}
