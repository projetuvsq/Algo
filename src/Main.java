
public class Main {

	public static void main(String[] args) {
		Reseau TableDeRoutage = new Reseau ();
		System.out.println ("Création du réseau...");
		
		TableDeRoutage .creationReseau();
		
		while (!(TableDeRoutage .estConnexe())) {
			System.out.println ("Réseau créé non-connexe, redéfinition du réseau...");
			TableDeRoutage .creationReseau();
		}
		System.out.println ("Réseau créé connexe");
	}

}
