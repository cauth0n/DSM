package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cauth0n
 */
public class Matrix {
	private Map<Integer, String> files;
	private Tile[][] tileArray;
	private int size;

	public Matrix(Map<Integer, String> files) {
		size = files.size();
		this.files = files;
		tileArray = new Tile[size][size];
	}

	public void initCols() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tileArray[i][j] = new Tile();
				if (i == j) {
					tileArray[i][j].setFound('-');
				}
			}
		}
	}

	public void markSpot(int col, int row) {
		tileArray[col][row].setFound('x');
	}

	public Map<Integer, String> getFile() {
		return files;
	}

	public List<String> getValueSet() {
		List<String> retVal = new ArrayList<>();

		for (int i : files.keySet()) {
			retVal.add(files.get(i));
		}
		return retVal;
	}

	public Tile[][] getTiles() {
		return tileArray;
	}

	private class Tile {
		private char isFound;

		private Tile() {
			isFound = ' ';
		}

		private void setFound(char found) {
			this.isFound = found;
		}

		private char getFound() {
			return isFound;
		}

		public String toString() {
			String retVal = isFound + "";
			return retVal;
		}

	}
}