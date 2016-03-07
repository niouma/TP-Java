package org.sakhoniouma.tpjava.serie5;

import java.util.ArrayList;
import java.util.Collection;

import org.sakhoniouma.tpjava.serie1.Marin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marin m1,m2,m3,m4,m5,m6;
		Collection<Marin>marins = new ArrayList<Marin>();
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		m4 = new Marin("Surcoff","Pierre",1700);
		m5 = new Marin("Dupont","Marc",1800);
		m6 = new Marin("Surcoff","Scott",1700);

	
		
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m1);
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m3);
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m4);
		
		marins = Sauvegarde.lisFichierTexte("C:\\Niouma\\marins.txt");
		System.out.println(marins);
		Sauvegarde.sauveChampBinaire("C:\\Niouma\\marins.bin", m5);
		Sauvegarde.sauveChampBinaire("C:\\Niouma\\marins.bin", m6);


	}

}
