package gui;

import infovis.graph.visualization.MatrixVisualization;
import driver.Matrix;

public class Window {

	public Window(Matrix table) {
		MatrixVisualization vis = new MatrixVisualization(table);
		System.out.println(vis.getColumnCount());
	}

}
