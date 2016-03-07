package org.sakhoniouma.tpjava.serie4;

public class Marin {
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
}
