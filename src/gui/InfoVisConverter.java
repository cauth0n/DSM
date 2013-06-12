package gui;

import infovis.table.DefaultTable;
import driver.Matrix;

public class InfoVisConverter {
	private DefaultTable table;

	public InfoVisConverter(Matrix matrix) {
		table = new DefaultTable();
	}

	public DefaultTable getTable() {
		return table;
	}
}
