package org.sakhoniouma.tpjava.serie3;

import org.sakhoniouma.tpjava.serie2.Equipage;

public class EquipageCommande extends Equipage{
	
	private Capitaine commandant;
	
	public EquipageCommande(Capitaine c){
		super();
		commandant = c;
		super.addMarin(c);
	}
	public String toString() {
		String resultat = super.toString();
		resultat += "Commandant : \n" + commandant.toString();
		return resultat;
	}
	
	public Capitaine getCommandant() {
		return commandant;
	}
	
	public void setCommandant(Capitaine commandant) {
		this.commandant = commandant;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof EquipageCommande))
			return false;
		
		EquipageCommande ec = (EquipageCommande)o;
		if ( commandant.equals(ec.commandant))
			return super.equals(ec);
		else
			return false;
	}
	
	public int hashCode(){
		int hashCode;
		hashCode = super.hashCode();
		hashCode = 31*hashCode + commandant.hashCode();
		return hashCode;
	}


}
