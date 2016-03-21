package org.sakhoniouma.tpjava.serie7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;



public class Film {
	private String nomFilm;
	private int annee;
	ArrayList<Integer> acteurs = new ArrayList<Integer>();
	public static HashMap<String,Film> table = new HashMap<String,Film>();
	
	public Film (){
		
	}
	
	public Film(String film, int annee, ArrayList<Integer> liste){
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

	public ArrayList<Integer> getActeurs() {
		return acteurs;
	}

	public void setActeurs(ArrayList<Integer> acteurs) {
		this.acteurs = acteurs;
	}
	
	public String toString(){
		String resultat;
		Iterator<Integer> it = acteurs.iterator();
		resultat = "Film : " + nomFilm + '\n';
		resultat += "Année : " + annee + '\n';
		resultat += "Liste des acteurs :" + '\n';
		while (it.hasNext()){
			Integer element = it.next();
			resultat += Acteur.table.get(element).toString();	
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
		int i,j;
		try {
			fr = new FileReader("C:\\Niouma\\movies-mpaa.txt");
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			ligne = br.readLine();
			while(ligne != null){
			//for(j=0;j<5;j++){
				ArrayList<Integer> act = new ArrayList<Integer>();
				Film f = new Film();
				StringTokenizer st = new StringTokenizer(ligne);
				f.setNomFilm(st.nextToken("("));
				String annee = st.nextToken("/");
				f.setAnnee(Integer.parseInt(annee.substring(1, 5)));
				String [] tab1= ligne.split("/");
				//System.out.println("---->"+tab1[1]);
				for (i=1;i<tab1.length;i++) {
					Acteur a = new Acteur();
					String [] tab2 = tab1[i].split(",");
					//System.out.println("-+-->"+tab2[0]);
					a.setNom(tab2[0].trim());
					if (tab2.length < 2)
						a.setPrenom(" ");
					else
						a.setPrenom(tab2[1].trim());
					Acteur.table.put(a.hashCode(), a);
					act.add(a.hashCode());
				}
				f.setActeurs(act);
				
				table.put(f.getNomFilm().concat(String.valueOf(f.getAnnee())), f);
				//System.out.println(act);
				ligne = br.readLine();	
			} 
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
		}
		return table;
	}
	
	public static Film getFilmByNom(String nom){
		Set<String> keys = new TreeSet<String>();
		keys = table.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			String key = it.next();
			if (key.substring(0, key.length()-5).equals(nom))
				return table.get(key);
		}
		return null;
	}
	
	public static ArrayList<Film> getFilmsByAnnee(int annee){
		ArrayList<Film> resultat = new ArrayList<Film>();
		Set<String> keys = new TreeSet<String>();
		keys = table.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			String key = it.next();
			if (key.endsWith(String.valueOf(annee)))
					resultat.add(table.get(key));
		}
		return resultat;
	}
	
	public static ArrayList<Film> getFilmsBetweenAnnees(int debut,int fin){
		ArrayList<Film> resultat = new ArrayList<Film>();
		int i;
		for(i=debut;i<=fin;i++)
			resultat.addAll(Film.getFilmsByAnnee(i));
		return resultat;
		
	}
	
	public static ArrayList<Film> getFilmsApartirde(int annee){
		ArrayList<Film> resultat = new ArrayList<Film>();
		int i,max;
		Collection<Film> values = new ArrayList<Film>();
		values = table.values();
		Iterator<Film> it = values.iterator();
		max = it.next().getAnnee();
		while (it.hasNext()){
			Film f = it.next();
			if(f.getAnnee() > max)
				max = f.getAnnee();
		}
		for(i=annee;i<=max;i++)
			resultat.addAll(Film.getFilmsByAnnee(i));
		return resultat;
	}
	
	public static ArrayList<Film> getFilmsAvantAnnee(int annee){
		ArrayList<Film> resultat = new ArrayList<Film>();
		int i,min;
		Collection<Film> values = new ArrayList<Film>();
		values = table.values();
		Iterator<Film> it = values.iterator();
		min = it.next().getAnnee();
		while (it.hasNext()){
			Film f = it.next();
			if(f.getAnnee() < min)
				min = f.getAnnee();
		}
		for(i=min;i<=annee;i++)
			resultat.addAll(Film.getFilmsByAnnee(i));
		return resultat;
	}
	
	public static ArrayList<Film> getFilmsByActeur(Acteur a){
		ArrayList<Film> resultat = new ArrayList<Film>();
		Collection<Film> values = new ArrayList<Film>();
		values = table.values();
		Iterator<Film> it = values.iterator();
		while(it.hasNext()){
			Film f = it.next();
			Iterator<Integer> it2 = f.getActeurs().iterator();
			while(it2.hasNext()){
				Acteur acteur = Acteur.table.get(it2.next());
				if (acteur.equals(a))
					resultat.add(f);
			}
		}
		return resultat;
	}
	
	public static ArrayList<Film> getFilmsByActeurs(ArrayList<Integer> liste){
		ArrayList<Film> resultat = new ArrayList<Film>();
		Iterator<Integer> it = liste.iterator();
		while(it.hasNext()){
			Acteur a = Acteur.table.get(it.next());
			resultat.addAll(Film.getFilmsByActeur(a));
		}
		return resultat;
	}
	
	

}
