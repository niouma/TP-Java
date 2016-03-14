package org.sakhoniouma.tpjava.serie6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//Voyage v1 = new Voyage("Marseille","Havre",3);
	//	Voyage v2 = new Voyage("Marseille","Havre",6);
	//	Voyage v3 = new Voyage("Havre","Marseille",3);
	//	Voyage v4 = new Voyage("Amsterdam","Singapour",30);
		
	//	System.out.println(v1);
	//	System.out.println(v1.equals(v2));
	//	System.out.println(v1.equals(v3));
	//	System.out.println(v1.equals(v4));
	//	System.out.println(v1.hashCode());
	//	System.out.println(v2.hashCode());
	//	System.out.println(v3.hashCode());
	//	System.out.println(v4.hashCode());
		System.out.println(Voyage.voyages);
		System.out.println(Voyage.getVoyage("Marseille", "Singapour"));
		System.out.println(Voyage.getVoyageAuDepartDe("Marseille"));
		System.out.println(Voyage.getPlusCourtAuDepartDe("Marseille"));
		System.out.println(Voyage.newInstance("Marseille","Havre",3));
		System.out.println(Voyage.newInstance("Marseille","Singapour",25));
		System.out.println(Voyage.voyages);
		
	
		

	}

}
