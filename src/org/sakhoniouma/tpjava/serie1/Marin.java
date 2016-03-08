package org.sakhoniouma.tpjava.serie1;
import java.io.Serializable;

public class Marin implements Serializable, Cloneable , Comparable<Marin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4446861375991332752L;
	private String nom,prenom;
	private int salaire;
	
	public Marin(String Nnom, String Nprenom, int Nsalaire){
		nom = Nnom;
		prenom = Nprenom;
		salaire = Nsalaire;
		
	}
	
	public Marin(){
		
	}
	
	public Marin(String Nnom, int Nsalaire){
		this(Nnom,"",Nsalaire);
	}
	
	public void setNom(String Nnom){
		nom = Nnom;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setPrenom(String Nprenom){
		prenom = Nprenom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public void setSalaire(int Nsalaire){
		salaire = Nsalaire;
	}
	
	public int getSalaire(){
		return salaire;
	}
	
	public void augmenteSalaire(int augmentation){
		salaire = salaire + augmentation;
	}
	
	public String toString() {
		String resultat;
		resultat = "Nom : " + nom + "\n";
		resultat += "Prenom : " + prenom + "\n";
		resultat += "Salaire : " + salaire + "\n";
		return resultat;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Marin))
			return false;
		
		Marin marin = (Marin)o;
		return nom.equals(marin.nom) && prenom.equals(marin.prenom) 
				&& salaire == marin.salaire;
		
	}
	
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31*hashCode + ((nom == null) ? 0 : nom.hashCode());
		hashCode = 31*hashCode + ((prenom == null) ? 0 : prenom.hashCode());
		hashCode = 31*hashCode + salaire;
		return hashCode;
		
	}
	
	public Marin clone() throws CloneNotSupportedException {
		return (Marin)super.clone();
	}
	
	public int compareTo(Marin m){
		
		if (this.getNom().equals(m.getNom()))
			return this.getPrenom().compareTo(m.getPrenom());
		else
			return this.getNom().compareTo(m.getNom());
		
	}


}
