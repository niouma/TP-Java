package org.sakhoniouma.tpjava.serie4;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.sakhoniouma.tpjava.serie1.Marin;

public class EquipageSet {
	
	SortedSet<Marin> marins = new TreeSet<Marin>();
	
	public EquipageSet(){
		
	}
	
	public int getNombreMarins(){
		return marins.size();
		
	}
	
	public boolean addMarin(Marin m){
		return marins.add(m);
	}
	
	public String toString(){
		String resultat="";
		Iterator<Marin> it = marins.iterator();
		while(it.hasNext())
		{
			Marin element = it.next();
			resultat += element.toString();
		}
		return resultat;
	}
	
	public boolean isMarinPresent(Marin m){
		return marins.contains(m);
	}
	
	public boolean removeMarin(Marin m){
		return marins.remove(m);
	}
	
	public Marin[] getEquipage(){
		Marin [] equipage = new Marin[marins.size()];
		equipage = (Marin[])marins.toArray();
		return equipage;
	}
	
	public void clear(){
		marins.clear();
	}
	
	public boolean addAllEquipage(Equipage e){
		return marins.addAll(e.marins);
	}
	
	public boolean equals(Object o){
		boolean bool;
		if (!(o instanceof Equipage))
			return false;
		
		Equipage equipage = (Equipage)o;
		Iterator<Marin> it = equipage.marins.iterator();
		while(it.hasNext()){
			Marin element = it.next();
			bool = this.isMarinPresent(element);
			if (bool == false)
				return false;
		}
		return true && this.getNombreMarins() == equipage.getNombreMarins();
		
	}
	
	public int hashCode(){
		int hashCode = 17;
		Iterator<Marin> it = marins.iterator();
		while(it.hasNext()){
			Marin element = it.next();
			hashCode = 31 * hashCode + element.hashCode();
		}
		return hashCode;
	}
	
	public Marin getMarinByName(String nom){
		Iterator<Marin> it = marins.iterator();
		while(it.hasNext()){
			Marin m = it.next();
			if( m.getNom().equals(nom))
				return m;
		}
		return null;
		
	}

}
