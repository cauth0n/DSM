package driver;

import gui.Window;

/**
 * cauth0n
 */
public class Driver {

	private final static String fileIn = "rel1DeptList.txt";
	private final static String fileOut = "dsmOut.txt";
	private Simulator go;

	public static void main(String[] args) {
		Driver go = new Driver();
	}

	public Driver() {
		simulateFromString(fileIn);
	}

	public void simulateFromString(String fileIn) {
		go = new Simulator(fileIn);
		go.readValues();
		go.initMatrix();
		go.fillMatrix();
		Window vis = new Window(go.getMatrix());
	}

}
