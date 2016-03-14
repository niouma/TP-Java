package org.sakhoniouma.tpjava.serie6;

import java.util.ArrayList;
import java.util.Iterator;

public class Voyage {
	private String portDepart, portDest;
	private int jours;
	public static ArrayList<Voyage> voyages = new ArrayList<Voyage>();
	
	public Voyage(){
		
	}
	
	private Voyage(String portD, String portA, int njours){
		portDepart = portD;
		portDest = portA;
		jours = njours;
		voyages.add(this);
	}

	public String getPortDepart() {
		return portDepart;
	}

	public void setPortDepart(String portDepart) {
		this.portDepart = portDepart;
	}

	public String getPortDest() {
		return portDest;
	}

	public void setPortDest(String portDest) {
		this.portDest = portDest;
	}

	public int getJours() {
		return jours;
	}

	public void setJours(int jours) {
		this.jours = jours;
	}
	
	public String toString(){
		String resultat;
		resultat = "Voyage :" + "\n";
		resultat += "Départ : " + portDepart + "\n";
		resultat += "Arrivée : " + portDest + "\n";
		resultat += "Durée : " + jours + " jours" + "\n";
		return resultat;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Voyage))
			return false;
		
		Voyage voyage = (Voyage)o;
		if (this.getPortDepart().equals(voyage.getPortDepart()) && this.getPortDest().equals(voyage.getPortDest()))
			return true;
		else
			return this.getPortDepart().equals(voyage.getPortDest()) && this.getPortDest().equals(voyage.getPortDepart());
		
	}
	
	public int hashCode(){
		int hashCode = 17;
		String Port;
		if (portDepart.compareTo(portDest) <0)
			Port = portDepart.concat(portDest);
		else
			Port = portDest.concat(portDepart);
		hashCode = 31*hashCode + ((Port == null) ? 0 : Port.hashCode());
		hashCode = 31*hashCode + jours;
		return hashCode;
	}
	
	public static Voyage getVoyage(String depart,String destination){
		Iterator<Voyage> it = voyages.iterator();
		while (it.hasNext()){
			Voyage element = it.next();
			if (element.getPortDepart().equals(depart) && element.getPortDest().equals(destination))
				return element;
		}
		return null;
		
	}
	
	public static ArrayList<Voyage> getVoyageAuDepartDe(String depart){
		ArrayList<Voyage> resultat = new ArrayList<Voyage>();
		Iterator<Voyage> it = voyages.iterator();
		while (it.hasNext()){
			Voyage element = it.next();
			if (element.getPortDepart().equals(depart))
				resultat.add(element);
		}
		return resultat;
		
	}
	
	public static Voyage getPlusCourtAuDepartDe(String depart){
		ArrayList<Voyage> resultat = new ArrayList<Voyage>();
		resultat = Voyage.getVoyageAuDepartDe(depart);
		Voyage voyage = new Voyage();
		Iterator<Voyage> it = resultat.iterator();
		while (it.hasNext()){
			Voyage element = it.next();
			if (element.getJours() < it.next().getJours())
				voyage = element;
		}
		return voyage;
	}
	
	public static Voyage newInstance(String depart, String arrivee, int nombreJours){
		if (Voyage.getVoyage(depart, arrivee) != null)
			return Voyage.getVoyage(depart, arrivee);
		else
		{
			Voyage voyage = new Voyage(depart,arrivee,nombreJours);
			return voyage;
		}
		
	}
	

}
