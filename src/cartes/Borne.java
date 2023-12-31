package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int n, int km) {
		super(n);
		this.setKm(km);
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return "Carte " + this.getKm() + "km";
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Borne borne){
			 Borne carte = borne;
			 return super.equals(carte) && km == borne.getKm();
		 }
		 return false;
	}
}
