/**
 * Gary et Dave veulent faire une partie de Dungeons & Dragons.
 *
 * Ils jouent avec:
 *
 *     Un nombre D de dés
 *     Chaque dé ayant F faces, sachant que F >= 6
 *
 * Quelle est la probabilité qu'au moins un des dés fasse un 6 ? Cette probabilité sera approximée à la 5ème décimale la plus proche.
 */
package codingame;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculProbaDice {

    public static BigDecimal throwDices(int D, int F) {

        BigDecimal dices = new BigDecimal(D);
        BigDecimal faces = new BigDecimal(F);
        //probabilité d'avoir un 6 sur un dés a 6 faces
        //BigDecimal proba = new BigDecimal(1/6);
        //probabilité d'avoir un 6 sur un dés a F faces
        BigDecimal probaBis = BigDecimal.ONE.divide(faces,5, RoundingMode.HALF_UP);
        //un 6 sur N dés à F faces
        BigDecimal probaTer = BigDecimal.ONE.divide(faces,5, RoundingMode.HALF_UP).pow(D);
        return probaTer;
    }

    public static void main(String[] args){
        System.out.println("resultat "+throwDices(2,6));
    }
}
