package codingame;

import java.math.BigInteger;

public class TestsOnStringAndIntegers {

	public static void main(String[] args) {
		String s = "abc";
		//upperCase renvoie un String, il faut donc mettre le resultat dans s sinon pas de modif
		//il faudrait ecrire s = s.toUpperCase pour modifier s
		s.toUpperCase();

		System.out.println(s);
		
		BigInteger b = new BigInteger("1000");
		//ici pareil, il faut ecrire b = b.add(new BigInteger("2)
		b.add(new BigInteger("2"));

		System.out.println(b);
		//Toutes les methodes d'un objet immuable ne permettent pas de modifier l'objet en lui meme : String et BigInteger sont immuables
		
		//equals vs ==
		String s1 = "text";
		String s2 = "text";
		String s3 = "t" + "ext";

		System.out.println(s1 == s2); // true
		System.out.println(s2 == s3); // true
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1.equals(s3)); //true
		
		Integer a = 127;
		Integer e = 127;
		Integer c = 128;
		Integer d = 128;

		System.out.println(a == e); // true
		System.out.println(c == d); // false!!!!!  Why? Because integer values between -128 and 127 are cached, but 128 is not.
		System.out.println(a.equals(e)); // true
		System.out.println(c.equals(d)); // true
		
		String t = new String("pouet");
		String q = "ouept";
	
	}

}
