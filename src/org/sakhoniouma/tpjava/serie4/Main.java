package org.sakhoniouma.tpjava.serie4;

import org.sakhoniouma.tpjava.serie1.Marin;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.sakhoniouma.tpjava.serie4.Equipage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipage equipage = new Equipage();
		Equipage equi = new Equipage();
		Marin m1,m2,m3,m4,m5,m6;
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		m4 = new Marin("Surcoff","Pierre",1700);
		m5 = new Marin("Dupont","Marc",1800);
		m6 = new Marin("Surcoff","Scott",1700);
		
		
		/*equipage.etendEquipage(7);
		System.out.println(equipage.getCapacite());*/
		System.out.println(equipage.addMarin(m1));
		System.out.println(equipage);
		System.out.println(equipage.addMarin(m2));
		System.out.println(equipage.isMarinPresent(m3));
		System.out.println(equipage.addMarin(m3));
		System.out.println(equipage.getNombreMarins());
		System.out.println(equipage.isMarinPresent(m3));
		//System.out.println(equipage.getEquipage());
		System.out.println(equipage);
		System.out.println(equipage);
		System.out.println(equipage.removeMarin(m3));
		System.out.println(equipage);
		equi.addMarin(m4);
		equi.addMarin(m5);
		System.out.println(equi);
		System.out.println(equipage.addAllEquipage(equi));
		System.out.println(equipage);
		equipage.removeMarin(m1);
		equipage.removeMarin(m2);
		System.out.println(equipage);
		System.out.println(equipage.equals(equi));
		System.out.println(equipage.hashCode());
		System.out.println(equi.hashCode());
		
		Set<Marin> set = new HashSet<Marin>();
		set.add(m1);
		System.out.println(set);
		set.add(m2);
		System.out.println(set);
		set.add(m3);
		System.out.println(set);
		
		MarinComparator mc = new MarinComparator();
		System.out.println(mc.compare(m1, m2));
		System.out.println(mc.compare(m3, m1));
		System.out.println(mc.compare(m1, m3));
		
		System.out.println(m1.compareTo(m2));
		System.out.println(m1.compareTo(m3));
		System.out.println(m1.compareTo(m4));
		
		SortedSet<Marin> tree = new TreeSet<Marin>();
		tree.add(m1);
		tree.add(m3);
		tree.add(m4);
		tree.add(m5);
		tree.add(m6);
		
		for (Marin m : tree)
			System.out.println(m);
		
		EquipageSet es = new EquipageSet();
		es.addMarin(m1);
		es.addMarin(m3);
		es.addMarin(m4);
		es.addMarin(m5);
		es.addMarin(m6);
		System.out.println(es);
		System.out.println(es.getMarinByName("Pierce"));

		
		


	}

}
