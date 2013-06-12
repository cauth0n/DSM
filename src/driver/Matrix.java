package driver;

import java.util.Map;

/**
 * @author cauth0n
 */
public class Matrix {
	private Tile[][] matrix;

	public Matrix(int dimensions) {
		matrix = new Tile[dimensions][dimensions];

	}

	public void initTiles() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Tile(false);
			}
		}
	}

	public void markSpot(int col, int row) {
		matrix[col][row].setDependent(true);
	}

	public String toString(Map<Integer, DependentFile> correspondingFiles) {

		StringBuilder returnVal = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			returnVal.append(String.format("%-60s", correspondingFiles.get(i).getPath()));
			for (int j = 0; j < matrix[i].length; j++) {
				returnVal.append('|');
				returnVal.append(matrix[i][j].toString());
			}
			returnVal.append('\n');
		}
		return returnVal.toString();
	}

	public class Tile {
		private boolean isDependent;

		public Tile(boolean isDependent) {
			this.isDependent = isDependent;
		}

		public boolean isDependent() {
			return isDependent;
		}

		public void setDependent(boolean value) {
			isDependent = value;
		}

		public String toString() {
			String returnVal;
			if (isDependent) {
				returnVal = "x";
			} else {
				returnVal = " ";
			}
			return returnVal;
		}

	}
}
