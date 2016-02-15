package org.sakhoniouma.tpjava.serie3;

public class Capitaine extends Marin{
	private String grade;
	
	public Capitaine(){
		
	}


	public String toString() {
		String resultat;
		resultat = "Nom : " + super.getNom() + "\n";
		resultat += "Prenom : " + super.getPrenom() + "\n";
		resultat += "Salaire : " + super.getSalaire() + "\n";
		resultat += "Grade : " + grade + "\n";
		return resultat;
	}

}
