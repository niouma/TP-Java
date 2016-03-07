package org.sakhoniouma.tpjava.serie4;

import java.util.Comparator;
import org.sakhoniouma.tpjava.serie1.Marin;

public class MarinComparator implements Comparator<Marin>{
	
	public int compare(Marin m1,Marin m2){
		
		if (m1.getNom().equals(m2.getNom()))
			return m1.getPrenom().compareTo(m2.getPrenom());
		else
			return m1.getNom().compareTo(m2.getNom());
		
	}

}
