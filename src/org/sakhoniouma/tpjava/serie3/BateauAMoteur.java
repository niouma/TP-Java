package org.sakhoniouma.tpjava.serie3;

public class BateauAMoteur extends Bateau implements Propulsion{
	
	public BateauAMoteur(){
		
	}
	
	public BateauAMoteur(String nom, int tonnage, EquipageCommande equipage ){
		super(nom,tonnage,equipage);
	}
	
	public String getPropulsion(){
		return "moteur";
	}
	
	public String toString(){
		String resultat;
		resultat = super.toString();
		resultat += "Propulsion : " + this.getPropulsion();
		return resultat;
		
	}

}
