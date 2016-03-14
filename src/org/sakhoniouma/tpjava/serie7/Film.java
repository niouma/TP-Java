package org.sakhoniouma.tpjava.serie7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;



public class Film {
	private String nomFilm;
	private int annee;
	ArrayList<Acteur> acteurs = new ArrayList<Acteur>();
	public static HashMap<String,Film> table = new HashMap<String,Film>();
	
	public Film (){
		
	}
	
	public Film(String film, int annee, ArrayList<Acteur> liste){
		nomFilm = film;
		this.annee = annee;
		this.acteurs = liste;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public ArrayList<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(ArrayList<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
	
	public String toString(){
		String resultat;
		Iterator<Acteur> it = acteurs.iterator();
		resultat = "Film : " + nomFilm + '\n';
		resultat += "Année : " + annee + '\n';
		resultat += "Liste des acteurs :" + '\n';
		while (it.hasNext()){
			Acteur element = it.next();
			resultat += element.toString();	
		}
		return resultat;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Film))
			return false;
		
		Film film = (Film)o;
		return nomFilm.equals(film.getNomFilm()) && annee == film.getAnnee();
	}
	
	public int hashCode(){
		int hashCode = 17;
		hashCode = 31*hashCode + ((nomFilm == null) ? 0 : nomFilm.hashCode());
		hashCode = 31*hashCode + annee;
		return hashCode;
	}
	
	public static HashMap<String,Film> getTableFromFile(){
		FileReader fr = null;
		int i;
		try {
			fr = new FileReader("C:\\Niouma\\movies-mpaa.txt");
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			ligne = br.readLine();
			while(ligne != null){
				ArrayList<Acteur> act = new ArrayList<Acteur>();
				Film f = new Film();
				StringTokenizer st = new StringTokenizer(ligne);
				f.setNomFilm(st.nextToken("("));
				String annee = st.nextToken("/");
				f.setAnnee(Integer.parseInt(annee.substring(1, 5)));
				String [] tab1= ligne.split("/");
				System.out.println("---->"+tab1[1]);
				for (i=1;i<tab1.length;i++) {
					String [] tab2 = tab1[i].split(",");
					act.add(new Acteur(tab2[0],tab2[1]));
				}
				f.setActeurs(act);
				
				table.put(f.getNomFilm().concat(String.valueOf(f.getAnnee())), f);
				//System.out.println(act);
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
		return table;
	}

}
