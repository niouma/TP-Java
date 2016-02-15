package org.sakhoniouma.tpjava.serie3;

import org.sakhoniouma.tpjava.serie1.Marin;

public class Capitaine extends Marin{
	private String grade;
	
	public Capitaine( Marin m, String grade){
		
		super(m.getNom(),m.getPrenom(),m.getSalaire());
		this.grade = grade;
		
	}
	
	


	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String toString() {
		String resultat = super.toString();
		resultat += "Grade : " + grade + "\n";
		return resultat;
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Capitaine))
			return false;
		
		Capitaine capitaine = (Capitaine)o;
		if ( grade.equals(capitaine.grade))
			return super.equals(capitaine);
		else
			return false;
	}
	
	public int hashCode(){
		int hashCode;
		hashCode = super.hashCode();
		hashCode = 31*hashCode + ((grade == null) ? 0 : grade.hashCode());
		return hashCode;
	}

}


