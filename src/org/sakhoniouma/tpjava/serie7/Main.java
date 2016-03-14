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
		
		Acteur a1 = new Acteur("Darrell","Beatty");
		Acteur a2 = new Acteur("Darrell","Beatty");
		Acteur a3 = new Acteur("Billy","Cady");
		System.out.println(a1);
		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a3));
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a3.hashCode());
		
		ArrayList<Acteur> list1 = new ArrayList<Acteur>();
		ArrayList<Acteur> list2 = new ArrayList<Acteur>();
		list1.add(a1);
		list2.add(a1);
		list2.add(a3);
		Film f1 = new Film("Troie",2005,list1);
		Film f2 = new Film("Troie",2005,list1);
		Film f3 = new Film("Invictus",2010,list2);
		System.out.println(f1);
		System.out.println(f1.equals(f2));
		System.out.println(f1.equals(f3));
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
		System.out.println(f3.hashCode());
		
		/*FileReader fr = null;
		try {
			fr = new FileReader("C:\\Niouma\\movies-mpaa.txt");
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			ligne = br.readLine();
			//while(ligne != null){
				System.out.println(ligne);
				StringTokenizer st = new StringTokenizer(ligne);
				System.out.println(st.nextToken("(") + '\n');
				System.out.println(st.nextToken("()") + '\n');
				System.out.println(st.nextToken("/,") + '\n');
				System.out.println(st.nextToken(", /") + '\n');
				System.out.println(st.nextToken("/,") + '\n');
				System.out.println(st.nextToken(", /") + '\n');
				ligne = br.readLine();	
			//} 
			br.close();
		}catch (FileNotFoundException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (fr != null){
				try {
					fr.close();
				} catch (IOException e){
					System.out.println("Erreur " + e.getMessage());
					e.printStackTrace();
				}

			}
		}*/
		
		
		HashMap<String,Film> films = new HashMap<String,Film>();
		films = Film.getTableFromFile();
		System.out.println(films.get("Piranha, Piranha! 1972"));
		//System.out.println(films.values());
		
		

	}

}
