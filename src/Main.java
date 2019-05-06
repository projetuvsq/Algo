import java.util.Scanner;

public class Main {
	public static Scanner sr = new Scanner (System .in);
	
	public static void main(String[] args) {
		int id;
		String str;
		Noeud emmeteur, receveur;
		Reseau reseau = new Reseau ();
		System.out.println ("Création du réseau...");
		reseau .creationReseau();
		System.out.println ("Réseau créé");
		while (!(reseau .estConnexe())) {
			System.out.println ("Réseau non-connexe, redéfinition du réseau...");
			reseau .creationReseau();
		}
		System.out.println ("Réseau connexe");
		
		while (true) {
			System.out.println("Entrez votre message :");
			str = sr .nextLine();
			if (str == "fin") break;
			System.out.println("Choisissez le noeud émetteur :");
			id = sr .nextInt();
			emmeteur = reseau .tableauDesNoeuds [id];
			emmeteur .newMessage(str);
			System.out.println("Choisissez le noeud receveur :");
			id = sr .nextInt();
			receveur = reseau .tableauDesNoeuds [id];
			if (receveur == emmeteur) {
				System.out.println("Transmission impossible");
				continue;
			}
			System.out.println("Envoi en cours...");
			reseau .afficheChemin(emmeteur, receveur);
			System.out.println("Message envoyé");
		}
		sr .close();
	}

}
