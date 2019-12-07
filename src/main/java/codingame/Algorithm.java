package codingame;

public class Algorithm {
	
	static int getPositionAt(int n){
		int[] possiblePositions = {0, 1, -1, -4, -5, -3};
		System.out.println(possiblePositions[n % 6]);
		return possiblePositions[n % 6];
	}

	public static void main(String[] args) {
		Algorithm.getPositionAt(0);
		Algorithm.getPositionAt(1);
		Algorithm.getPositionAt(2);
		Algorithm.getPositionAt(3); 
		Algorithm.getPositionAt(100000); 
		Algorithm.getPositionAt(2147483647); 

	}

}
