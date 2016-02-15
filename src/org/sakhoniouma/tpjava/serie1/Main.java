package org.sakhoniouma.tpjava.serie1;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Marin m1,m2,m3;
		MarinUtil mu = new MarinUtil();
		Marin [] marins = new Marin[] { new Marin("Pierce","Sam",1500), new Marin("Pier","Bob",1600),
				new Marin("Surcoff","Pierre",1700),new Marin("Dupont","Marc",1800),
				new Marin("Pierce","Steeve",1900)};
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		System.out.println("ESt-ce que m1 et m2 sont égaux ?\n" + m1.equals(m2));
		System.out.println("ESt-ce que m1 et m3 sont égaux ?\n" + m1.equals(m3));
		System.out.println("ESt-ce que m2 et m3 sont égaux ?\n" + m2.equals(m3));
		System.out.println("Code hachage m1 : " + m1.hashCode());
		System.out.println("Code hachage m2 : " + m2.hashCode());
		System.out.println("Code hachage m3 : " + m3.hashCode());
		mu.augmenteSalaire(marins, 500);
		for(i=0;i<marins.length;i++)
			System.out.println(marins[i]);
		System.out.println(mu.getMaxSalaire(marins));
		System.out.println(mu.getMoyenneSalaire(marins));
		System.out.println(mu.getMedianeSalaire(marins));
		

	}

}
