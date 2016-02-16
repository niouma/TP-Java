package org.sakhoniouma.tpjava.serie3;

import org.sakhoniouma.tpjava.serie1.Marin;
import org.sakhoniouma.tpjava.serie2.Equipage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marin m1,m2,m3,m4,m5,m6;
		Equipage equipage = new Equipage();;
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		m4 = new Marin("Surcoff","Pierre",1700);
		m5 = new Marin("Dupont","Marc",1800);
		m6 = new Marin();
		Capitaine c1,c2,c3;
		c1 = new Capitaine(m1,"BOSCO");
		c2 = new Capitaine(m2,"BOSCO");
		c3 = new Capitaine(m3,"CAPITAINE");
		EquipageCommande ec = new EquipageCommande(c3);
		
		System.out.println(m1);
		System.out.println(m1.equals(m3));
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		System.out.println(c1);
		System.out.println(c1.equals(c3));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		
		equipage.addMarin(m1);
		equipage.addMarin(c3);
		equipage.addMarin(m4);
		System.out.println(equipage);
		
		ec.addMarin(m5);
		System.out.println(ec);
		
		try {
			m6 = m1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m6);
		BateauAVoiles bar = new BateauAVoiles("Rames",1500,ec);
		System.out.println(bar.getPropulsion());
		System.out.println(bar);
		
		
		
		
		
		
		

	}

}
