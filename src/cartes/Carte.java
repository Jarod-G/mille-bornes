package cartes;

public abstract class Carte {
	private int nombre;

	public Carte(int n) {
		this.nombre = n;
	}

	public int getNombre() {
		return nombre;
	}

}
