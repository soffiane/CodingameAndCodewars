/**
 * ob le minion veut faire des salades de fruits pour son maître très méchant.
 *
 * Il dispose de 5 types de fruits: des bananes, des abricots, des oranges, des pommes et des poires.
 *
 * Pour chaque salade de fruits, il doit mixer exactement 3 fruits différents.
 *
 * En fonction du nombre de chacun des fruits disponibles, combien de salades de fruit peut-il faire?
 *
 * Par exemple, s'il a:
 *
 *     1 banane
 *     1 abricot
 *     5 oranges
 *     2 pommes
 *     0 poire
 *
 * Il ne peut, au mieux, réaliser que 2 salades de fruits: banane-orange-pomme et abricot-orange-pomme, après il n'aura plus que des oranges...
 *
 * Note : vous pouvez accéder au code source de l'énumération Fruit par l'onglet "Code fourni" au-dessus de l'éditeur de texte. Ce code n'est pas modifiable.
 */
package codingame;

import java.util.*;

public class SaladeDeFruits {

    public static enum Fruit {
        BANANA, APRICOT, ORANGE, APPLE, PEAR
    };

    public static int fruitSalad(EnumMap<Fruit, Integer> fruits) {
        int max = 0;
        Set<Fruit> fruits1 = fruits.keySet();
        Collection<Integer> values = fruits.values();
        //trouver le ou les fruits en plus grande quantité
        for(Fruit fruit : fruits.keySet()){
            System.out.println(fruit + " -- " +fruits.get(fruit));
        }
        for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        /*for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
        System.out.println(fruits1+" "+values);
        return -1;
    }

    public static void main(String[] args){
        EnumMap<Fruit, Integer> fruits = new EnumMap<Fruit, Integer>(Fruit.class);
        fruits.put(Fruit.BANANA,1);
        fruits.put(Fruit.APRICOT,1);
        fruits.put(Fruit.ORANGE,5);
        fruits.put(Fruit.APPLE,2);
        fruits.put(Fruit.PEAR,0);
        fruitSalad(fruits);
    }

    public static int fact (int n) {
        if (n==0) return(1);
        else return(n*fact(n-1));
    }


}
