package org.sakhoniouma.tpjava.serie1;

import java.util.Arrays;

public class MarinUtil {
	
	public MarinUtil() {
	}
	
	public void augmenteSalaire( Marin[] marins, int pourcentage){
		int i;
		for(i=0;i<marins.length; i++)
			marins[i].augmenteSalaire(pourcentage);
			
	}
	
	public int getMaxSalaire( Marin[] marins){
		int res = marins[0].getSalaire();
		int i;
		for(i=1;i<marins.length;i++){
			if (marins[i].getSalaire() > res)
				res = marins[i].getSalaire();
		}
		return res;	
	}
	
	public int getMoyenneSalaire(Marin[] marins){
		int moy = 0,i;
		for(i=0;i<marins.length;i++)
			moy += marins[i].getSalaire();
		return moy/marins.length;
	}
	
	public int getMedianeSalaire(Marin[] marins){
		int [] tab = new int[marins.length];
		int i;
		for(i=0;i<marins.length;i++)
			tab[i] = marins[i].getSalaire();
		Arrays.sort(tab);
		if (marins.length % 2 == 1)
			return marins[marins.length/2].getSalaire();
		else
			return (marins[marins.length/2].getSalaire() + marins[marins.length/2 + 1].getSalaire())/2;
	}
	
	}

