package codinNightFevrier2019;

public class IsoContext {

    // nombre de sommets dans le graphe
    /*int n=5;

    // matrice d'adjacence du graphe
    int[][] adjacencymatrix = new int[][] {
            new int[] {1,1,1,0,0}, //    1
            new int[] {1,1,1,1,0}, //  / | \
            new int[] {1,1,1,1,0}, // 0  |  3 - 4
            new int[] {0,1,1,1,1}, //  \ | /
            new int[] {0,0,0,1,1}, //    2
    };

    // stockage du chemin pendant l'exploration recursive
    int[] path = new int[n];

    // verrou pour la recherche taboo (tous initialisés à "false" par défaut)
    char[] taboo = new boolean[n];

    // sommets de départ/arrivé souhaités
    int source=0;
    int target=4;

    void explore(int position, int depth) {
        path[depth]=position;

        // on est sur le sommet d'arrivé -> fini
        if (position==target) {
            // affiche la solution
            for(int i=0;i<=depth;i++) System.out.print(path+" ");
            System.out.print("\n");
            return;
        }

        // sinon...

        taboo[position]=true; // on pose un caillou

        // on explore les chemins restants
        for(int i=0;i<n;i++) {
            if (path[position]==0 || taboo) continue;
            explore(i,depth+1);
        }

        taboo[position]=false; // on retire le caillou
    }
*/
}
