package org.sakhoniouma.tpjava.serie7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Acteur a1 = new Acteur("Armstrong", "Darrell");
		Acteur a2 = new Acteur("Armstrong", "Darrell");
		Acteur a3 = new Acteur("Moseley", "Mark");
		Acteur a4 = new Acteur("Brodie",  "Don");
		System.out.println(a1);
		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a3));
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a3.hashCode());
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1.add(a1.hashCode());
		list2.add(a1.hashCode());
		list2.add(a3.hashCode());
		Film f1 = new Film("Troie",2005,list1);
		Film f2 = new Film("Troie",2005,list1);
		Film f3 = new Film("Invictus",2010,list2);
		//System.out.println(f1);
		System.out.println(f1.equals(f2));
		System.out.println(f1.equals(f3));
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
		System.out.println(f3.hashCode());
		
		
		
		HashMap<String,Film> films = new HashMap<String,Film>();
		films = Film.getTableFromFile();
		//System.out.println(films.values());
		//System.out.println(Acteur.table.values());
		//System.out.println(Film.getFilmByNom("10"));
		//System.out.println(Film.getFilmsByAnnee(2003));
		//System.out.println(Film.getFilmsBetweenAnnees(2000,2003));
		//System.out.println(Film.getFilmsByActeur(a1));
		//System.out.println(Film.getFilmsByActeurs(list2));
		//System.out.println(Film.getFilmsApartirde(2002));
		//System.out.println(Film.getFilmsAvantAnnee(1930));
		System.out.println(Acteur.table.size());

	}

}
