package codingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VoteCounting {

    public static void process(String fileName) {
        Map<String, Votant> votants;
        try (Scanner in = new Scanner(new File(fileName))) {
            int N = in.nextInt();
            int M = in.nextInt();
            votants = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String personName = in.next();
                int nbVote = in.nextInt();
                votants.put(personName, new Votant(nbVote, 0, 0, 0));
            }
            for (int i = 0; i < M; i++) {
                String voterName = in.next();
                String voteValue = in.next();
                Votant votant = votants.get(voterName);
                if (votant != null) {
                    votant.addVote(voteValue);
                }
            }

            int nbVotesYes = 0;
            int nbVotesNo = 0;
            for (Map.Entry<String, Votant> entry : votants.entrySet()) {
                Votant votant = entry.getValue();
                if (votant.getTotalVotes() <= votant.getNbMaxVotes()) {
                    nbVotesYes += votant.getNbVotesYes();
                    nbVotesNo += votant.getNbVotesNo();
                }
            }
            System.out.println(nbVotesYes+" "+nbVotesNo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) throws FileNotFoundException {
        process("src/main/ressources/codingameFile/VoteCounting/exemple.txt");
    }

    static class Votant {
        private int nbMaxVotes;
        private int nbVotesYes;
        private int nbVotesNo;
        private int nbVotesInvalid;

        public Votant(int nbMaxVotes, int nbVotesYes, int nbVotesNo, int nbVotesInvalid) {
            this.nbMaxVotes = nbMaxVotes;
            this.nbVotesYes = nbVotesYes;
            this.nbVotesNo = nbVotesNo;
            this.nbVotesInvalid = nbVotesInvalid;
        }

        public int getNbMaxVotes() {
            return nbMaxVotes;
        }

        public int getNbVotesYes() {
            return nbVotesYes;
        }

        public int getNbVotesNo() {
            return nbVotesNo;
        }

        public void addVote(String voteValue) {
            switch (voteValue) {
                case "Yes":
                    this.nbVotesYes++;
                    break;
                case "No":
                    this.nbVotesNo++;
                    break;
                default:
                    this.nbVotesInvalid++;
                    break;
            }
        }

        public int getTotalVotes() {
            return nbVotesYes + nbVotesNo + nbVotesInvalid;
        }
    }

    /**
     * Meilleure solution sur Codingame
     *
     *     public static void main(String args[]) {
     *         Map<String, List<Integer>> voteMap = new HashMap<>();
     *         Scanner in = new Scanner(System.in);
     *         int N = in.nextInt();
     *         int M = in.nextInt();
     *
     *         for (int i = 0; i < N; i++) {
     *             String personName = in.next();
     *             int nbVote = in.nextInt();
     *
     *             voteMap.put(personName,  new ArrayList<>(Arrays.asList(nbVote)));
     *         }
     *
     *         for (int i = 0; i < M; i++) {
     *             String voterName = in.next();
     *             String voteValue = in.next();
     *             List<Integer> voteList = voteMap.get(voterName);
     *
     *             if (voteMap.containsKey(voterName) && voteList.get(0) > 0) {
     *                 if (voteValue.equals("Yes")) {
     *                     voteList.add(-1);
     *                 } else if (voteValue.equals("No")) {
     *                     voteList.add(-2);
     *                 }
     *                 voteList.set(0, voteList.get(0) - 1);
     *             } else {
     *                 voteMap.remove(voterName);
     *             }
     *         }
     *
     *         List<Integer> voteList = new ArrayList<>();
     *         voteMap.values().forEach(voteList::addAll);
     *         System.out.format("%d %d", Collections.frequency(voteList, -1), Collections.frequency(voteList, -2));
     *     }
     */
}
