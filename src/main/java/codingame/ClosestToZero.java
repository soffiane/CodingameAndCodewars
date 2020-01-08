package codingame;

class ClosestToZero {

	/** @return the number that is closest to zero */
	static int closestToZero(int[] ints) {
		//Utiliser Math.Abs()
		int closestToZero = Integer.MAX_VALUE;

		if (ints == null || ints.length == 0) {
			return 0;
		}
		for (int i = 0; i < ints.length - 1; i++) {
			if (Math.abs(closestToZero) > Math.abs(ints[i])) {
				closestToZero = ints[i];
			}
		}
		return closestToZero > 0 ? closestToZero : Math.abs(closestToZero);
	}
	
	public static void main (String [] args) {
		System.out.print(closestToZero(new int[]{-2,2}));
	}

	//Le résultat est correct avec un jeu de données simple: {7 5 9 1 4} -> 1
	//Résolution de problèmes+70pts
	//La solution fonctionne avec -273 seul
	//Résolution de problèmes+20pts
	//La solution fonctionne avec 5526 seul
	//Résolution de problèmes+20pts
	//La solution fonctionne quand les données ne contiennent que des nombres négatifs : {-15 -7 -9 -14 -12} -> -7
	//Résolution de problèmes+35pts
	//La solution fonctionne avec 2 températures négatives égales : {-10 -10} -> -10
	//Résolution de problèmes+35pts
	//La solution affiche 0 s'il n'y a pas de température
	//Résolution de problèmes+35pts
	//Quand 2 températures sont aussi proches de 0, alors la positive l'emporte : {15 -7 9 14 7 12} -> 7
	//Résolution de problèmes+85pts
}