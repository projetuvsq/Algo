import java.util.ArrayList;
public class Dijkstra {
	public static final int INFINI = 10000;
	private Noeud depart;
	private ArrayList<Noeud> ensemble;
	private int taille;
	
	public Dijkstra (Noeud depart) {
		this .depart = depart;
		this .ensemble = new ArrayList<Noeud>();
		this .ensemble .add(depart);
		this .taille = 1;		
	}
	
	public void Djikstra (Reseau reseau) {
		int i, j;
		for (i = 0 ; i< 100; ++i) {
			
		}
	}
}
