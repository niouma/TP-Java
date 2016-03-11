package org.sakhoniouma.tpjava.serie5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.sakhoniouma.tpjava.serie1.Marin;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Marin m1,m2,m3,m4,m5,m6;
		Collection<Marin>marins = new ArrayList<Marin>();
		m1 = new Marin("Pierce","Sam",1500);
		m2 = new Marin("Pierce","Sam",1500);
		m3 = new Marin("Bo","Nicolas",1800);
		m4 = new Marin("Surcoff","Pierre",1700);
		m5 = new Marin("Dupont","Marc",1800);
		m6 = new Marin("Surcoff","Scott",1700);

	
		
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m1);
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m3);
		Sauvegarde.sauveFichierTexte("C:\\Niouma\\marins.txt", m4);
		//taile 55 octets
		
		marins = Sauvegarde.lisFichierTexte("C:\\Niouma\\marins.txt");
		System.out.println(marins);
		
		Sauvegarde.sauveChampBinaire("C:\\Niouma\\marins.bin", m1);
		Sauvegarde.sauveChampBinaire("C:\\Niouma\\marins.bin", m3);
		Sauvegarde.sauveChampBinaire("C:\\Niouma\\marins.bin", m4);
		//taille 61 octets
		
		marins = Sauvegarde.lisChampBinaire("C:\\Niouma\\marins.bin");
		System.out.println("read marins from binary file : \n " + marins);
		
		
		
		
		ArrayList<Marin> mm = new ArrayList<Marin>();
		mm.add(m1);
		//mm.add(m2);
		mm.add(m3);
		mm.add(m4);
		Sauvegarde.sauveObject("C:\\Niouma\\marin.bin", mm);
		// taille 180 octets
	
		
		marins = Sauvegarde.lisObject("C:\\Niouma\\marin.bin");
		System.out.println("read marins from object file : \n " + marins);


	}

}
