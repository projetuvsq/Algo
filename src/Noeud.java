
public class Noeud {
	public int nbLien;
	public int identifiant;
	public int type;
	public String message;
	
	/**
	 * Constructeur
	 * @param identifiant	id du noeud
	 * @param type			type de noeud (1, 2 ou 3 pour chaque niveau)
	 */
	public Noeud (int identifiant, int type){
		this .identifiant = identifiant;
		this .type = type;
		this .nbLien = 0;
		this .message = null;
	}
	
	/**
	 * Change le message que contient le noeud
	 * @param	message		nouveu message du noeud
	 */
	public void newMessage (String message) {
		this .message = message;
	}
	
	/**
	 * retourne le nombre de lien d'un noeud
	 * @return	le nombre de lien du noeud
	 */
	public int getNbLien () {
		return this .nbLien;
	}
	
	/**
	 * Retourne l'identifiant du Noeud
	 * @return identifiant du noeud
	 */
	public int getId() {
		return this .identifiant;
	}
	
	public void addLien () {
		this .nbLien++;
	}
	/**
	 * Retourne le message contenu par le noeud
	 * @return	le message que contient le noeud
	 */
	public String getMessage () {
		return this .message;
	}
}

