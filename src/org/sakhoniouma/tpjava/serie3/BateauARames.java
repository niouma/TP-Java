package org.sakhoniouma.tpjava.serie3;

public class BateauARames extends Bateau implements Propulsion {
	
	public BateauARames(){
		
	}
	
	public BateauARames(String nom, int tonnage, EquipageCommande equipage ){
		super(nom,tonnage,equipage);
	}

	
	public String getPropulsion(){
		return "rames";
	}
	
	public String toString(){
		String resultat;
		resultat = super.toString();
		resultat += "Propulsion : " + this.getPropulsion();
		return resultat;
		
	}
	

}
