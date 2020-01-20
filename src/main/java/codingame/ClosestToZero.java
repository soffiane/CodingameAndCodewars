package codingame;

class ClosestToZero {

	/** @return the number that is closest to zero */
	static int closestToZero(int[] ints) {
		//Utiliser Math.Abs()
		if (ints == null || ints.length == 0) {
			return 0;
		}
		int closestToZero = ints[0];
		for (int i =1;i<ints.length;i++) {
			int abs = Math.abs(ints[i]);
			if ( abs < Math.abs(closestToZero)) {
				closestToZero = ints[i];
			} else if (abs == Math.abs(closestToZero) && closestToZero < 0 && ints[i] > 0) {
				closestToZero = abs;
			}
		}
		return closestToZero;
	}
	
	public static void main (String [] args) {
		/*System.out.println(closestToZero(new int[]{7,5,9,1,4}));
		System.out.println(closestToZero(new int[]{-273}));
		System.out.println(closestToZero(new int[]{5526}));
		System.out.println(closestToZero(new int[]{-15, -7, -9, -14, -12}));*/
		System.out.println(closestToZero(new int[]{-10,-10}));
		/*System.out.println(closestToZero(new int[]{}));
		System.out.println(closestToZero(new int[]{15, -7, 9 ,14, 7 ,12}));*/
	}
}