
public class Routage {
	Noeud voisin;
	
	public Routage () {
		this .voisin = null;
	}
		
	public void chgVoisin (Noeud voisin) {
		this .voisin = voisin;
	}
	
	public Noeud getVoisin () {
		return this .voisin;
	}
}
