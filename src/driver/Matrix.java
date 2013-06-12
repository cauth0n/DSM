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
	private Map<Integer, String> files;

	public Matrix(Map<Integer, String> files) {
		matrix = new Column[files.size()];
		this.files = files;
		initCols();
	}

	public void initCols() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new BooleanColumn(files.get(i), matrix.length);
			((BooleanColumn) matrix[i]).fill(false);
			this.addColumn(matrix[i]);
		}
	}

	public void markSpot(int col, int row) {
		((BooleanColumn) matrix[col]).set(row, true);
	}

}