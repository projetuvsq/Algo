 
public class Routage {
	private Noeud voisin;
	
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
