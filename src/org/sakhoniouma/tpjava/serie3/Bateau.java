package org.sakhoniouma.tpjava.serie3;

public class Bateau {
	
	private String nom;
	private int tonnage;
	private EquipageCommande equipage;
	
	public Bateau(){
		
	}
	
	public Bateau(String nom, int tonnage, EquipageCommande equipage ){
		this.nom = nom;
		this.tonnage = tonnage;
		this.equipage = equipage;
	}

	public void setEquipage(EquipageCommande equipage) {
		this.equipage = equipage;
	}

	public String getNom() {
		return nom;
	}

	public int getTonnage() {
		return tonnage;
	}

	public EquipageCommande getEquipage() {
		return equipage;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Bateau))
			return false;
		
		Bateau bateau = (Bateau)o;
		return nom.equals(bateau.nom);
	}
	
	public String toString(){
		String resultat;
		resultat = "Nom : " + nom + "\n";
		resultat += "Tonnage : " + tonnage + "\n";
		//resultat += "Propulsion : " + 
		resultat += "Equipage : " + equipage.toString();
		return resultat;
	}

}
