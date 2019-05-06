public class Lien {
	public int valeur;
	
	/**
	 * Constructeur
	 * @param valeur valeur du lien 
	 */
	public Lien (int valeur) {
		this .valeur = valeur;
	}
	
	/**
	 * Permet de changer la valeur d'un lien
	 * @param valeur	nouvelle valeure du lien
	 */
	
	public void chgValeur (int valeur) {
		this .valeur = valeur;
	}
	
	/**
	 * Retourne la valeur d'un lien
	 * @return	la valeur du lien
	 */
	public int getValeur () {
		return this .valeur;
	}
}
