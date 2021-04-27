package codingame;

public class MileToKmConverter {
	public final double milesToKm(double miles){
		return getMilesToKmFactor() * miles;
	}

	private double getMilesToKmFactor() {
		return 1.6;
	}
}

class NauticalMilesToKmConverter extends MileToKmConverter{
	public double getMilesToKmFactor(){
		return 1.8;
	}
}

class Toto {
	public static void main(String[] args){
		System.out.println(new NauticalMilesToKmConverter().milesToKm(1));
	}
}
