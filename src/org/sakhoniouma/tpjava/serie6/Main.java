package org.sakhoniouma.tpjava.serie6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Voyage v1 = new Voyage("Marseille","Havre",3);
	Voyage v2 = new Voyage("Marseille","Havre",6);
	Voyage v3 = new Voyage("Havre","Marseille",3);
	Voyage v4 = new Voyage("Amsterdam","Singapour",30);
		
		System.out.println(v1);
		System.out.println(v1.equals(v2));
		System.out.println(v1.equals(v3));
		System.out.println(v1.equals(v4));
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(v3.hashCode());
		System.out.println(v4.hashCode());
		System.out.println(Voyage.voyages);
		System.out.println(Voyage.getVoyage("Marseille", "Singapour"));
		System.out.println(Voyage.getVoyageAuDepartDe("Marseille"));
		System.out.println(Voyage.getPlusCourtAuDepartDe("Marseille"));
		System.out.println(Voyage.newInstance("Marseille","Havre",3));
		System.out.println(Voyage.newInstance("Marseille","Singapour",25));
		System.out.println(Voyage.voyages);
		
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\Niouma\\Voyages.txt");
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			ligne = br.readLine();
			while(ligne != null){
				StringTokenizer st = new StringTokenizer(ligne,",");
				System.out.println(st.nextToken() + '\n');
				System.out.println(st.nextToken() + '\n');
				System.out.println(st.nextToken() + '\n');
				ligne = br.readLine();	
			} 
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
		}
		
		System.out.println(Voyage.newInstanceFromFile());
		
	
		

	}

}
