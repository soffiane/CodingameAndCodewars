package codingame;

public class LetsDance {
	
	static int getPositionAt(int n){
		int[] possiblePositions = {0, 1, -1, -4, -5, -3};
		return possiblePositions[n % 6];
	}

	public static void main(String[] args) {
		System.out.println(LetsDance.getPositionAt(0));
		System.out.println(LetsDance.getPositionAt(1));
		System.out.println(LetsDance.getPositionAt(2));
		System.out.println(LetsDance.getPositionAt(3));
		System.out.println(LetsDance.getPositionAt(4));
		System.out.println(LetsDance.getPositionAt(5));
		System.out.println(LetsDance.getPositionAt(6));
		System.out.println(LetsDance.getPositionAt(7));
		System.out.println(LetsDance.getPositionAt(8));
		System.out.println(LetsDance.getPositionAt(9));
		System.out.println(LetsDance.getPositionAt(10));
		System.out.println(LetsDance.getPositionAt(11));
		System.out.println(LetsDance.getPositionAt(12));
		System.out.println(LetsDance.getPositionAt(100000));
		System.out.println(LetsDance.getPositionAt(2147483647));

	}

}
