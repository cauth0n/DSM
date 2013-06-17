package driver;

import infovis.column.BooleanColumn;
import infovis.table.DefaultTable;

import java.util.Map;

/**
 * @author cauth0n
 */
public class Matrix extends DefaultTable {
	private BooleanColumn[] matrix;
	private Map<Integer, String> files;

	public Matrix(Map<Integer, String> files) {
		matrix = new BooleanColumn[files.size()];
		this.files = files;
	}

	public void initCols() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new BooleanColumn(files.get(i), matrix.length);
			matrix[i].fill(false);
			this.addColumn(matrix[i]);
		}
	}

	public void markSpot(int col, int row) {
		matrix[col].set(row, true);
	}

}