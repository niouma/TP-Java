package org.sakhoniouma.tpjava.serie5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
				dos.writeBytes(marin.getNom());
				dos.writeBytes(marin.getPrenom());
				dos.writeInt(marin.getSalaire());
				dos.writeChar('\n');
				
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
			int i = 0;
			
			
			
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
	}
	
	
	
	

