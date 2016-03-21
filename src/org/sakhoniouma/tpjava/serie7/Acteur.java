package org.sakhoniouma.tpjava.serie7;

import java.util.HashMap;

public class Acteur {
	private String nom,prenom;
	public static HashMap<Integer,Acteur> table = new HashMap<Integer,Acteur>();
	
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
		String name;
		name = nom.concat(prenom);
		hashCode = 31*hashCode + ((name == null) ? 0 : name.hashCode());
		return hashCode;
	}

}
