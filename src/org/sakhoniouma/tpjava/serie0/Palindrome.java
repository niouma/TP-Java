package org.sakhoniouma.tpjava.serie0;

public class Palindrome {
	int nombre;
	
	public Palindrome(){
		
	}
	
	public String palindrome(int nombre){
		int i;
		String snombre="", res="";
		Double racine = Math.sqrt(nombre);
		for (i=2;i <= racine.intValue();i++){
			if (nombre % i == 0){
				res = nombre + " n'est pas premier";
				System.out.println(res);
				return res;
			}
		}
		snombre = Integer.toString(nombre);
		StringBuffer snombre2 = new StringBuffer(snombre);
		System.out.println(snombre2);
		StringBuffer sinvnombre = snombre2.reverse();
		System.out.println(sinvnombre);
		if (sinvnombre.equals(snombre2))
			res = nombre + " est un palindrome premier";
		else
			res = nombre + " n'est pas un palindrome premier";
		System.out.println(res);
		return res;
	}

}


