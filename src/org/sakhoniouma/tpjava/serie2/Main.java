package org.sakhoniouma.tpjava.serie2;

import org.sakhoniouma.tpjava.serie1.Marin;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Equipage equipage = new Equipage();
		Equipage equi = new Equipage();
		Marin m1,m2,m3,m4,m5;
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		m4 = new Marin("Surcoff","Pierre",1700);
		m5 = new Marin("Dupont","Marc",1800);
		
		System.out.println(equipage.getCapacite());
		equipage.etendEquipage(7);
		System.out.println(equipage.getCapacite());
		System.out.println(equipage.addMarin(m1));
		System.out.println(equipage);
		System.out.println(equipage.addMarin(m2));
		System.out.println(equipage.isMarinPresent(m3));
		System.out.println(equipage.addMarin(m3));
		System.out.println(equipage.getNombreMarins());
		System.out.println(equipage.isMarinPresent(m3));
		//System.out.println(equipage.getEquipage());
		System.out.println(equipage);
		System.out.println(equipage.removeMarin(m3));
		System.out.println(equipage);
		equi.addMarin(m4);
		equi.addMarin(m5);
		System.out.println(equi);
		System.out.println(equipage.addAllEquipage(equi));
		System.out.println(equipage);
		equipage.removeMarin(m1);
		System.out.println(equipage);
		System.out.println(equipage.equals(equi));
		System.out.println(equipage.hashCode());
		System.out.println(equi.hashCode());

	}

}
