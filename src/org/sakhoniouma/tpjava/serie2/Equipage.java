package org.sakhoniouma.tpjava.serie2;

import org.sakhoniouma.tpjava.serie1.Marin;

public class Equipage {
	
	public Marin [] marins = new Marin[5];
	
	public Equipage(){
	}
	
	public int getCapacite(){
		return marins.length;
	}
	
	public int getNombreMarins(){
		int res=0,i;
		for (i=0;i<marins.length;i++){
			if (marins[i] != null)
				res++;	
		}
		return res;
	}
	
	public boolean addMarin(Marin m){
		int i,ind=0;
		if (this.isMarinPresent(m))
			return false;
		else
		{
		for(i=0;i<marins.length;i++){
			if(marins[i] != null)
				ind++;
		}
		if(ind == marins.length-1)
			return false;
		else
		{
			marins[ind] = m;
			return true;
		}
		}
	}
	
	public String toString() {
		String resultat="";
		int i;
		for(i=0;i<marins.length;i++)
		{
			if (marins[i] != null){
				resultat += "Marin " + i + " : \n";
				resultat += "Nom : " + marins[i].getNom() + "\n";
				resultat += "Prenom : " + marins[i].getPrenom() + "\n";
				resultat += "Salaire : " + marins[i].getSalaire() + "\n";
			}
		}
		return resultat;
	}
	
	public boolean isMarinPresent(Marin m) {
		int i;
		for(i=0;i<marins.length;i++){
			if (marins[i] != null){
				if(marins[i].equals(m))
					return true;
			}
		}
		return false;
	}
	
	public boolean removeMarin(Marin m){
		int i;
		for(i=0;i<marins.length;i++){
			if(marins[i] != null){
				if(marins[i].equals(m))
				{
					marins[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public Marin[] getEquipage(){
		int i,j=0,ind=0;
		for(i=0;i<marins.length;i++){
			if(marins[i] != null)
				ind++;
		}
		Marin [] equipage = new Marin[ind];
		for(i=0;i<marins.length;i++){
			if(marins[i] != null){
				equipage[j] = marins[i];
				j++;
			}
		}
		return equipage;
	}
	
	public void clear() {
		int i;
		for(i=0;i<marins.length;i++){
			if(marins[i] != null)
				removeMarin(marins[i]);
		}
	}
	
	public boolean addAllEquipage(Equipage e){
		int i,j;
		boolean bool;
		for (i=0;i<e.getEquipage().length;i++){
			bool = this.addMarin(e.getEquipage()[i]);
			if (bool == false){
				for(j=0;j<e.getEquipage().length;j++)
					this.removeMarin(e.getEquipage()[j]);
				return false;
				
			}
		}
		return true;
	}
	
	public void etendEquipage(int place){
		marins = new Marin[marins.length + place];
		
	}
	
	public boolean equals(Object o){
		int i;
		boolean bool;
		if (!(o instanceof Equipage))
			return false;
		
		Equipage equipage = (Equipage)o;
		for (i=0;i<equipage.getEquipage().length;i++){
			bool = this.isMarinPresent(equipage.getEquipage()[i]);
			if (bool == false)
				return false;
		}
		return true && this.getNombreMarins() == equipage.getNombreMarins();
		
	}
	
	public int hashCode(){
		int hashCode = 17;
		int i;
		for (i=0;i<this.getCapacite();i++){
			if (marins[i] != null)
				hashCode = 31 * hashCode + marins[i].hashCode();
		}
		return hashCode;
	}
}
