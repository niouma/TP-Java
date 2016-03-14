package org.sakhoniouma.tpjava.serie7;



public class Acteur {
	private String nom,prenom;
	
	public Acteur(){
		
	}
	
	public Acteur(String nom,String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString(){
		String resultat;
		resultat = nom + " " + prenom + '\n';
		return resultat;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Acteur))
			return false;
		
		Acteur acteur = (Acteur)o;
		return nom.equals(acteur.getNom()) && prenom.equals(acteur.getPrenom());
	}
	
	public int hashCode(){
		int hashCode = 17;
		hashCode = 31*hashCode + ((nom == null) ? 0 : nom.hashCode());
		hashCode = 31*hashCode + ((prenom == null) ? 0 : prenom.hashCode());
		return hashCode;
	}

}
