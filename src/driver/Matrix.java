package driver;

import infovis.graph.DefaultGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cauth0n
 */
public class Matrix {
	private Map<Integer, String> files;
	private DefaultGraph graph;

	public Matrix(Map<Integer, String> files) {
		super();
		graph = new DefaultGraph();
		this.files = files;
	}

	public void initCols() {
		for (int i = 0; i < files.size(); i++) {
			graph.addVertex();
		}
	}

	public void markSpot(int col, int row) {
		graph.addEdge(col, row);
	}

	public DefaultGraph getGraph() {
		return graph;
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
}