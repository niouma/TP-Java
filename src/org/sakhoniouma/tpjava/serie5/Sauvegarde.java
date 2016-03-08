package org.sakhoniouma.tpjava.serie5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import org.sakhoniouma.tpjava.serie1.Marin;

public class Sauvegarde {

	public Sauvegarde() {

	}

	public static void sauveFichierTexte(String nomFichier,Marin marin){

		File fichier = new File (nomFichier);
		Writer writer = null;

		try {
			writer = new FileWriter(fichier,true);
			writer.write(marin.getNom() + "|" + marin.getPrenom() + "|" + marin.getSalaire() + "\r\n");
		} catch (IOException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("Erreur " + e.getMessage());
					e.printStackTrace();
				}
			}

		}
	}

	public static ArrayList<Marin> lisFichierTexte(String nomFichier){

		Collection<Marin>marins = new ArrayList<Marin>();
		FileReader fr = null;
		try {
			fr = new FileReader(nomFichier);
			BufferedReader br = new BufferedReader(fr);
			String ligne;
			ligne = br.readLine();
			while(ligne != null){
				Marin m = new Marin();
				StringTokenizer st = new StringTokenizer(ligne,"|");
				m.setNom(st.nextToken());
				m.setPrenom(st.nextToken());
				m.setSalaire(Integer.parseInt(st.nextToken()));
				marins.add(m);
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

		return (ArrayList<Marin>) marins;

	}

	public static void sauveChampBinaire(String nomFichier, Marin marin){
		File fichier = new File (nomFichier);
		OutputStream os = null;

		try {
			os = new FileOutputStream(fichier,true);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(marin.getNom());
			dos.writeUTF(marin.getPrenom());
			dos.writeUTF((new Integer(marin.getSalaire())).toString());
			if (dos != null)
				dos.close();
		} catch (IOException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("Erreur " + e.getMessage());
					e.printStackTrace();
				}
			}

		}

	}

	public static ArrayList<Marin> lisChampBinaire(String nomFichier){
		Collection<Marin>marins = new ArrayList<Marin>();
		FileInputStream is = null;
		try {
			is = new FileInputStream(nomFichier);
			DataInputStream dis = new DataInputStream(is);
			try {
				
				while (dis.available()>0) {
					marins.add(new Marin(dis.readUTF(),dis.readUTF(),Integer.parseInt(dis.readUTF())));
				}
			} catch (EOFException e ) {
				System.out.println("Erreur " + e.getMessage());
				e.printStackTrace();
			}finally {
				if (dis != null)
					dis.close();
			}

		}catch (FileNotFoundException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (is != null){
				try {
					is.close();
				} catch (IOException e){
					System.out.println("Erreur " + e.getMessage());
					e.printStackTrace();
				}

			}
		}

		return (ArrayList<Marin>) marins;

	}
	
	public static void sauveObject(String nomFichier, ArrayList<Marin> marins){
		File fichier = new File (nomFichier);
		OutputStream os = null;
		try {
			os = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (Marin m : marins) {
				oos.writeObject(m);
			}
			if (oos != null)
				oos.close();
		} catch (IOException e) {
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();

		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("Erreur " + e.getMessage());
					e.printStackTrace();
				}
			}

		}
	}
	
	public static ArrayList<Marin> lisObject(String nomFichier){
		File fichier = new File (nomFichier);
		ArrayList<Marin> marins = new ArrayList<Marin>();
		FileInputStream is = null;

		try {
			is = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(is);
			System.out.println("I am in lisObject");
			try{
				while (ois.available()>0){
					System.out.println((Marin) ois.readObject());
					//marins.add((Marin) ois.readObject());
				}
				
			} 
			catch (EOFException e ) {
				System.out.println("Erreur1 " + e.getMessage());
				e.printStackTrace();
			}
			finally {
				if (ois != null)
					ois.close();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Erreur2 " + e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("Erreur3 " + e.getMessage());
			e.printStackTrace();

		} 
		catch (ClassNotFoundException e) {
			System.out.println("Erreur4 " + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			if (is != null) {
				try {
					is.close();
				} 
				catch (IOException e) {
					System.out.println("Erreur5 " + e.getMessage());
					e.printStackTrace();
				}
			}

		}
		return marins;
	}
}





