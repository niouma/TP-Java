package org.sakhoniouma.tpjava.serie0;
import java.math.BigInteger;

public class Factorielle {
	int nombre;
	
	public Factorielle()
	{
	}
	
	public int factorielle (int nombre) {
		int i,res = 1;
		for(i=0;i < nombre;i++)
			res = res * (nombre-i);
		return res;
	}
	
	public double factorielle (double nombre) {
		int i;
		double res = 1;
		for(i=0;i < nombre;i++)
			res = res * (nombre-i);
		return res;
	}
	
	public BigInteger factorielle (BigInteger nombre) {
		BigInteger i;
		BigInteger res = BigInteger.ONE;
		i = BigInteger.ONE;
		for( i = BigInteger.ONE  ;i.compareTo(nombre) == -1;i = i.add(BigInteger.ONE))
			res.multiply(nombre.add(i.negate()));
		return res;
	}



}
