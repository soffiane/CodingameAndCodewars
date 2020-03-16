package codeKata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Note: There is a harder version (Sports League Table Ranking (with Head-to-head) : https://www.codewars.com/kata/5e0e17220d5bc9002dc4e9c4) of this.
 * <p>
 * Description
 * You organize a sports league in a round-robin-system. Each team meets all other teams. In your league a win gives a team 2 points, a draw gives both teams 1 point.
 * After some games you have to compute the order of the teams in your league. You use the following criteria to arrange the teams:
 * <p>
 * Points
 * Scoring differential (the difference between goals scored and those conceded)
 * Goals scored
 * First you sort the teams by their points. If two or more teams reached the same number of points, the second criteria comes into play and so on.
 * Finally, if all criteria are the same, the teams share a place.
 * <p>
 * Input
 * number: Number of teams in your league.
 * games: An array of arrays. Each item represents a played game with an array of four elements [TeamA,TeamB,GoalA,GoalB]
 * (TeamA played against TeamB and scored GoalA goals and conceded GoalB goals ).
 * <p>
 * Output
 * positions: An array of positions. The i-th item should be the position of the i-th team in your league.
 * <p>
 * Example
 * number = 6
 * games = [[0, 5, 2, 2],   // Team 0 - Team 5 => 2:2
 * [1, 4, 0, 2],   // Team 1 - Team 4 => 0:2
 * [2, 3, 1, 2],   // Team 2 - Team 3 => 1:2
 * [1, 5, 2, 2],   // Team 1 - Team 5 => 2:2
 * [2, 0, 1, 1],   // Team 2 - Team 0 => 1:1
 * [3, 4, 1, 1],   // Team 3 - Team 4 => 1:1
 * [2, 5, 0, 2],   // Team 2 - Team 5 => 0:2
 * [3, 1, 1, 1],   // Team 3 - Team 1 => 1:1
 * [4, 0, 2, 0]]   // Team 4 - Team 0 => 2:0
 * You may compute the following table:
 * <p>
 * Rank	Team	For : Against	GD	Points
 * 1.	Team 4	5 : 1	+4	5
 * 2.	Team 5	6 : 4	+2	4
 * 3.	Team 3	4 : 3	+1	4
 * 4.	Team 0	3 : 5	-2	2
 * 4.	Team 1	3 : 5	-2	2
 * 6.	Team 2	2 : 5	-3	1
 * Team 5 and Team 3 reached the same number of points. But since Team 5 got a better scoring differential, it ranks better than Team 3. All values of Team 0 and Team 1 are the same, so these teams share the fourth place.
 * <p>
 * In this example you have to return the array [4, 4, 6, 3, 1, 2].
 */
public class SportsLeagueTableRanking {
	static class Team {
		int numTeam;
		int numGoalsScored;
		int numGoalsConcedeed;
		int score;
		int rank;

		public Team(int numTeam, int numGoalsScored, int numGoalsConcedeed, int score, int rank) {
			this.numTeam = numTeam;
			this.numGoalsScored = numGoalsScored;
			this.numGoalsConcedeed = numGoalsConcedeed;
			this.score = score;
			this.rank = rank;
		}

		public int getNumGoalsScored() {
			return numGoalsScored;
		}

		public int getNumTeam() {
			return this.numTeam;
		}

		public int getScore() {
			return score;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public void addGoalsScored(int goals) {
			this.numGoalsScored += goals;
		}

		public void addGoalsConceeded(int goals) {
			this.numGoalsConcedeed += goals;
		}

		public int getScoringDifferential() {
			return this.numGoalsScored - this.numGoalsConcedeed;
		}

		public void addScore(int score) {
			this.score += score;
		}
	}

	public static int[] computeRanks(int number, int[][] games) {
		List<Team> teams = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			teams.add(new Team(i, 0, 0, 0, 0));
		}
		for (int j = 0; j < games.length; j++) {
			//match[0] : idTeamA - match[1] : idTeamB - match[2] : goalsScoredTeamA - match[3] : goalsScoredTeamB
			int[] match = games[j];
			Team teamA = teams.get(match[0]);
			teamA.addGoalsScored(match[2]);
			Team teamB = teams.get(match[1]);
			teamB.addGoalsScored(match[3]);
			teamB.addGoalsConceeded(match[2]);
			teamA.addGoalsConceeded(match[3]);
			if (match[2] > match[3]) {
				teamA.addScore(2);
			} else if (match[2] < match[3]) {
				teamB.addScore(2);
			} else {
				teamA.addScore(1);
				teamB.addScore(1);
			}
		}
		Optional<Comparator<Team>> comparingPoints = Optional.ofNullable(Comparator.comparing(Team::getScore, Integer::compareTo).reversed());
		Optional<Comparator<Team>> scoreDifferential = Optional.ofNullable(Comparator.comparing(Team::getScoringDifferential, Integer::compareTo).reversed());
		Optional<Comparator<Team>> goalsScored = Optional.ofNullable(Comparator.comparing(Team::getNumGoalsScored, Integer::compareTo).reversed());

		Comparator<Team> sort = Stream.of(comparingPoints, scoreDifferential, goalsScored)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.reduce((c1, c2) -> 0, Comparator::thenComparing);

		List<Team> sortedTeams = teams
				.stream()
				.sorted(sort)
				.collect(Collectors.toList());

		ListIterator<Team> iter = sortedTeams.listIterator();
		int rank = 1;
		int rankSkipped = 0;
		while (iter.hasNext()) {
			Team topOfRank = iter.next();
			topOfRank.setRank(rank);
			while (iter.hasNext()) {
				final Team team = iter.next();
				if (!isSameRank(topOfRank, team)) {
					rank += rankSkipped+1;
					team.setRank(rank);
					rankSkipped = 0;
				} else {
					team.setRank(rank);
					rankSkipped++;
				}
				topOfRank = team;
			}
		}

		return sortedTeams.stream()
				.sorted(Comparator.comparing(Team::getNumTeam))
				.map(Team::getRank)
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static boolean isSameRank(Team topOfRank, Team team) {
		return topOfRank.getScore() == team.getScore() && topOfRank.getScoringDifferential() == team.getScoringDifferential() && topOfRank.getNumGoalsScored() == team.getNumGoalsScored();
	}

	public static void main(String[] args) {
		//expected : new int[]{4,4,6,3,1,2}
		System.out.println(Arrays.toString(computeRanks(6, new int[][]
				{{0, 5, 2, 2},
						{1, 4, 0, 2},
						{2, 3, 1, 2},
						{1, 5, 2, 2},
						{2, 0, 1, 1},
						{3, 4, 1, 1},
						{2, 5, 0, 2},
						{3, 1, 1, 1},
						{4, 0, 2, 0}})));

		//expected new int[]{2,3,4,1,5,6},
		System.out.println(Arrays.toString(computeRanks(6, new int[][]
				{{0, 5, 2, 0},
						{1, 4, 2, 2},
						{2, 3, 1, 3},
						{1, 5, 0, 0},
						{2, 0, 2, 1},
						{3, 4, 3, 1}})));

		//expected new int[]{3,1,1,3},
		System.out.println(Arrays.toString(computeRanks(4, new int[][]
				{{0, 3, 1, 1},
						{1, 2, 2, 2},
						{1, 3, 2, 0},
						{2, 0, 2, 0}})));

		//expected new int[]{1,1,1,1,1,1,1,1,1,1},
		System.out.println(Arrays.toString(computeRanks(10, new int[0][])));

		//expected new int[]{1,2,2,2,2,2,2,8},
		System.out.println(Arrays.toString(computeRanks(8, new int[][]{{0, 7, 2, 0}})));
	}
}

/**
 * Meilleure solution sur kodecata
 *
 * public static int[] computeRanks(int nTeams, int[][] games) {
 *
 *         int[][] cnts = IntStream.range(0,nTeams).mapToObj( i->new int[] {0,0,0,i}).toArray(int[][]::new);
 *         for(int[] g: games){
 *             int tA=g[0], tB=g[1], sA=g[2], sB=g[3];
 *             updateCnt(cnts[tA], sA, sB);
 *             updateCnt(cnts[tB], sB, sA);
 *         }
 *         Arrays.sort(cnts, LeagueOrder::cmpTeams);
 *
 *         int[] out = new int[nTeams];
 *         int rnk = 0;
 *         for (int i=0 ; i<nTeams ; i++) {
 *             if (i==0 || cmpTeams(cnts[i],cnts[i-1])!=0) rnk=i+1;
 *             out[cnts[i][3]] = rnk;
 *         }
 *         return out;
 *     }
 *
 *     private static void updateCnt(int[] cnt, int sc, int sco) {
 *             cnt[0] += sc==sco ? 1 : sc>sco ? 2 : 0;
 *             cnt[1] += sc-sco;
 *             cnt[2] += sc;
 *     }
 *
 *     private static int cmpTeams(int[] a, int[] b) {
 *         return a[0]!=b[0] ? b[0]-a[0] : a[1]!=b[1] ? b[1]-a[1] : b[2]-a[2];
 *     }
 */
