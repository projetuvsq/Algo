
public class Main {

	public static void main(String[] args) {
		Reseau reseau = new Reseau ();
		System.out.println ("Création du réseau...");
		reseau .creationReseau();
		System.out.println ("Réseau créé");
		while (!(reseau .estConnexe())) {
			System.out.println ("Réseau non-connexe, redéfinition du réseau...");
			reseau .creationReseau();
		}
		System.out.println ("Réseau connexe");
	}

}
