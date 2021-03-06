public class Reseau {
	public Lien  [][] tableauDesLiens;
	public Noeud [] tableauDesNoeuds;
	public Routage [][] tableDeRoutage;
	
	/**
	 * Constructeur de la classe Reseau
	 */
	public Reseau () {
		this .tableauDesLiens = new Lien [100][100];
		this .tableauDesNoeuds = new Noeud [100];
		this .tableDeRoutage = new Routage [100][100];
	}
	
	public void initTableDeRoutage () {
		int i, j;
		for (i=0; i<100; i++) {
			for (j=0; j<100; j++) {
				this .tableDeRoutage [i][j] = new Routage();
			}
		}
	}
	
	/**
	 * Créé les différents noeuds du réseau
	 */
	public void initTableauDesNoeuds () {
		int i;
		for (i=0; i<8; ++i) {
			this .tableauDesNoeuds [i] = new Noeud (i, 1);
		}
		for (; i<28; ++i) {
			this .tableauDesNoeuds [i] = new Noeud (i, 2);
		}
		for (; i<100; ++i) {
			this .tableauDesNoeuds [i] = new Noeud (i, 3);
		}
	}
	
	/**
	 * Créé les différents liens potentiels du réseaux
	 */
	public void initTableauDesLiens () {
		int i, j;
		for (i = 0; i<100; ++i) {
			for (j = 0; j<100; ++j) {
				this .tableauDesLiens [i][j] = new Lien (0);
			}
		}
	}
	
	/**
	 * Initialise le réseaux :
	 * Wrapper des fonctions initTableauDesNoeuds() et initTableauDesLiens()
	 */
	public void initReseau () {
		this .initTableauDesNoeuds ();
		this .initTableauDesLiens ();
		this .initTableDeRoutage();
	}
	
	public void initLien () {
		lienNiveau1 ();
		lienNiveau2 ();
		lienNiveau3 ();
	}
	
	public void creationReseau () {
		initReseau ();
		initLien ();
		testTableDeRoutage();
	}
	/**
	 * Initialise les liens pour les noeuds de niveau 1 (blackbone)
	 */
	public void lienNiveau1 () {
		int i, j;
		int valeur;
		for (i=0; i<8; ++i) {
			for (j=i+1; j<8; ++j) {
				if (Math .random() <= 0.75) {
						valeur = 5 + ((int) (Math .random() * 6));
						this .tableauDesNoeuds [i] .addLien ();
						this .tableauDesLiens [i][j] .chgValeur (valeur);
						this .tableauDesNoeuds [j] .addLien ();
						this .tableauDesLiens [j][i] .chgValeur (valeur);
				}
			}
		}
	}
	
	/**
	 * Initialise les liens pour les noeuds de niveau 2
	 */
	public void lienNiveau2 () {
		int i, j;
		int alea;
		int nbLien;
		int noeud;
		int valeur;
		for (i = 8; i<28; ++i) {
			
			alea = (int) (Math .random() * 2);
			if (alea == 0)	nbLien = 1;
			else 			nbLien = 2;
			
			for (j=0; j<nbLien; ++j) {
				valeur = (int) (Math .random() * 11) + 10;
				noeud = (int) (Math .random() * 8);
				if (this .tableauDesLiens [i][noeud] .getValeur() == 0) {
					this .tableauDesNoeuds [i] .addLien ();
					this .tableauDesNoeuds [noeud] .addLien ();
				}
				this .tableauDesLiens [i][noeud] .chgValeur(valeur);
				this .tableauDesLiens [noeud][i] .chgValeur(valeur);
			}
			
			alea = (int) (Math .random() * 2);
			if (alea == 0)	nbLien = 2;
			else 			nbLien = 3;
			
			for (j=0; j<nbLien; ++j) {
				
				do {
					noeud = 8 + (int) (Math .random() * 20);
				}while(noeud == i);
				
				if (this .tableauDesLiens [i][noeud] .getValeur() == 0 && this .tableauDesLiens [noeud][i] .getValeur() == 0) {
					this .tableauDesNoeuds [i] .addLien ();
					this .tableauDesNoeuds [noeud] .addLien ();
				}
				else {
					--j;
					continue;
				}
				valeur = (int) (Math .random() * 11) + 10;
				this .tableauDesLiens [i][noeud] .chgValeur(valeur);
				this .tableauDesLiens [noeud][i] .chgValeur(valeur);
			}
		}
	}
	
	/**
	 * Initialise les liens pour les noeuds de niveau 3
	 */
	public void lienNiveau3 () {
		int i, j;
		int noeud;
		int valeur;
		for (i=28; i<100; ++i) {
			for (j=0; j<2; ++j) {
				noeud = (int) (8 + Math .random() * 20);
				if (this .tableauDesLiens [i][noeud] .getValeur() == 0) {
					valeur =(int) (15 + Math .random() * 36);
					this .tableauDesNoeuds [i] .addLien();
					this .tableauDesNoeuds [noeud] .addLien();
					this .tableauDesLiens [i][noeud] .chgValeur(valeur);
					this .tableauDesLiens [noeud][i] .chgValeur(valeur);
				}
				else {
					--j;
					continue;
				}
			}
			
			do {
				noeud =(int) (28 + Math .random() * 72);
			}while (noeud == i || 
					this .tableauDesLiens [i][noeud] .getValeur() != 0 || this .tableauDesLiens [noeud][i] .getValeur() != 0);
			valeur =(int) (15 + Math .random() * 36);
			this .tableauDesNoeuds [i] .addLien();
			this .tableauDesNoeuds [noeud] .addLien();
			this .tableauDesLiens [i][noeud] .chgValeur(valeur);
			this .tableauDesLiens [noeud][i] .chgValeur(valeur);
		}
	}
	
	public boolean estConnexe () {
		int [] graphe = new int [100];
		int i;
		for (i = 0; i<100; ++i) {
			graphe [i] = 0;
		}
		parcourProfondeur (0, graphe);
		for (i=0; i<100; i++) {
			if (graphe [i] == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void parcourProfondeur (int idNoeud, int [] graphe) {
		graphe [idNoeud] = 1;
		for (int i = 0; i<100; i++) {
			if (i == idNoeud) continue;
			else if (this .tableauDesLiens [idNoeud][i]. getValeur() != 0 && graphe [i] == 0) {
				parcourProfondeur (i, graphe);
			}
		}
	}
	
	public Noeud voisinPetit(Noeud depart) {
		int i;
		int valeur;
		int init = 0;
		for (i= 0 ; i<100 ; ++i) {
			if (i == depart .getId()) continue;
			valeur = this .tableauDesLiens [depart .getId()][i] .getValeur();
			if ( valeur != 0) {
				init = valeur;
				break;
			}
		}
		Noeud voisin = this .tableauDesNoeuds [init];
		int test; 
		valeur = init;
		for (i= 0 ; i<100 ; ++i) {
			if (i == depart .getId()) continue;
			test = this .tableauDesLiens [depart .getId()][i] .getValeur();
			if (test != 0 && test < valeur) {
				valeur = test;
				voisin = this .tableauDesNoeuds[i];
			}
		}
		return voisin;
	}
	
	public void testTableDeRoutage () {
		int i, j;
		Noeud voisin;
		for (i= 0; i<100; i++) {
			for (j = 0; j<100; ++j) {
				if (i == j) continue;
				this .tableDeRoutage [i][j] .chgVoisin(voisinPetit (this .tableauDesNoeuds[i]));
			}
		}
	}
	
	/*public void tableDeRoutage  () {
		int i, j;
		Noeud voisin;
		for (i=0; i<100; i++) {
			for (j = i+1; j<100; j++) {
				voisin = premierVoisin(this .tableauDesNoeuds [i], this .tableauDesNoeuds [j]);
				this .tableDeRoutage [i][j] .chgVoisin(voisin);
			}
		}
	}
	
	/**
	 * Retourne le premier voisin du plus court chemin entre un sommet de depart et un sommet d'arrivee
	 * @param depart sommet de depart
	 * @param arrive sommet d'arrivee
	 * @return	premier voisin du sommet de depart
	 */
	/*public Noeud premierVoisin (Noeud depart, Noeud arrive) {
		
	}*/
	
	public String chemin(Noeud depart, Noeud arrive) {
		if (depart == arrive) {
			return "-> " + arrive .getId() + " fin";
		}
		else {
			this .transfereMessage (depart .getId(), this .tableDeRoutage [depart .getId()][arrive .getId()] .getVoisin() .getId());
			return "->" + depart .getId() + chemin (this .tableDeRoutage[depart .getId()][arrive .getId()] .getVoisin(), arrive);
		}
	}
	
	public void afficheChemin (Noeud depart, Noeud arrive) {
		System.out.println(chemin(depart, arrive));
	}
	
	/**
	 * Transfere un message d'un noeud de départ à un noeud d'arrivé (uniquement entre deux noeuds connectés)
	 * @param idNoeudDepart		id du noeud de depart
	 * @param idNoeudArrive		id du noeud d'arrivé
	 */
	public void transfereMessage (int idNoeudDepart, int idNoeudArrive) {
		this .tableauDesNoeuds [idNoeudArrive] .newMessage (this .tableauDesNoeuds [idNoeudDepart] .getMessage());
		this .tableauDesNoeuds [idNoeudDepart] .newMessage (null);
	}
	
}
