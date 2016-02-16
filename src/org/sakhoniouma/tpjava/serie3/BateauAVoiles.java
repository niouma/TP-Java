package org.sakhoniouma.tpjava.serie3;

public class BateauAVoiles extends Bateau implements Propulsion{
	
	public BateauAVoiles(){
		
	}
	
	public BateauAVoiles(String nom, int tonnage, EquipageCommande equipage ){
		super(nom,tonnage,equipage);
	}
	
	public String getPropulsion(){
		return "voiles";
	}
	
	public String toString(){
		String resultat;
		resultat = super.toString();
		resultat += "Propulsion : " + this.getPropulsion();
		return resultat;
		
	}
	

}
