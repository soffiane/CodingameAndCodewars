package codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simulation d'une bataille navale sur une carte de N a deux dimensions
 * en entree on a la taille de la carte, les coordonées des coins superieurs gauches et inferieur droit des bateaux
 * et les coordonnées des coup joués
 * le but est d'avoir en sortie le nombre de bateaux coulés et le nombre de bateaux touchés
 */
public class BattleShip {
	public static void main(String[] args) {
		System.out.println(new BattleShip().solution(4, "1B 2C,2D 4D", "2B 2D 3D4D 4A"));
	}

	public String solution(int N, String S, String T) {
		// write your code in Java SE 11
		int sunkedShips = 0;
		int touchedShips = 0;
		List<Ship> shipList = Arrays.stream(S.split(","))
				.map(ships -> ships.split(" "))
				.map(shipCells -> new Ship(new Cell(shipCells[0]), new Cell(shipCells[1])))
				.collect(Collectors.toList());

		List<Cell> hittedCells = Arrays.stream(T.split(" "))
				.map(Cell::new)
				.collect(Collectors.toList());

		for (Ship current : shipList) {
			long hitsOnCurrentShip = current.getHitsOnShip(hittedCells);
			if (hitsOnCurrentShip > 0) {
				if (hitsOnCurrentShip == current.getShipSizeInCells()) {
					sunkedShips++;
				} else {
					touchedShips++;
				}
			}
		}

		return sunkedShips + "," + touchedShips;
	}

	public class Ship {
		Cell topleft;
		Cell bottomRight;

		public Ship(Cell topleft, Cell bottomRight) {
			this.topleft = topleft;
			this.bottomRight = bottomRight;
		}

		public Cell getTopleft() {
			return topleft;
		}

		public void setTopleft(Cell topleft) {
			this.topleft = topleft;
		}

		public Cell getBottomRight() {
			return bottomRight;
		}

		public void setBottomRight(Cell bottomRight) {
			this.bottomRight = bottomRight;
		}

		public long getHitsOnShip(List<Cell> hittedCells) {
			return hittedCells.stream().
					filter(cell -> cell.greaterOrEqual(topleft) && bottomRight.greaterOrEqual(cell))
					.count();
		}

		public int getShipSizeInCells() {
			return (Math.abs(topleft.getRow() - bottomRight.getRow()) + 1)
					* (Math.abs(topleft.getColumn() - bottomRight.getColumn()) + 1);
		}
	}

	public class Cell {
		int row;
		int column;

		public Cell(String cell) {
			this.row = Character.getNumericValue(cell.charAt(0));
			this.column = cell.charAt(1) - 'A' + 1;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		public boolean greaterOrEqual(Cell comparedCell) {
			return row >= comparedCell.row && column >= comparedCell.column;
		}
	}
}
