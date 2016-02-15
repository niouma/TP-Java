package org.sakhoniouma.tpjava.serie3;

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
	
	public void setSalaire(int Nsalaire){
		salaire = Nsalaire;
	}
	
	public int getSalaire(){
		return salaire;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public String toString() {
		String resultat;
		resultat = "Nom : " + nom + "\n";
		resultat += "Prenom : " + prenom + "\n";
		resultat += "Salaire : " + salaire + "\n";
		return resultat;
	}
	

}
