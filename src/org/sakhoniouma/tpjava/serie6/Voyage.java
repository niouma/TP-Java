package org.sakhoniouma.tpjava.serie6;



public class Voyage {
	private String portDepart, portDest;
	private int jours;
	
	public Voyage(){
		
	}
	
	public Voyage(String portD, String portA, int njours){
		portDepart = portD;
		portDest = portA;
		jours = njours;
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
	

}
