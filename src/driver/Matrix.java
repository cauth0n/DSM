package driver;

import infovis.Column;
import infovis.column.BooleanColumn;
import infovis.table.DefaultTable;

import java.util.Map;

/**
 * @author cauth0n
 */
public class Matrix extends DefaultTable {
	private Column[] matrix;

	public Matrix(int dimensions, Map<Integer, String> correspondingFiles) {
		matrix = new BooleanColumn[dimensions];
	}

	public void initRows() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new Row();
		}
	}

	public int getDimensions() {
		return matrix.length;
	}

	public void markSpot(int col, int row) {

	}
}