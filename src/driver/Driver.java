package driver;

import java.io.File;

/**
 * cauth0n
 */
public class Driver {

	private final static String fileIn = "C:/Users/derek.reimanis/workspace/DSM/rel1DeptList.txt";
	private final static String fileOut = "C:/Users/derek.reimanis/workspace/DSM/dsmOut.txt";

	public static void main(String[] args) {
		Driver go = new Driver();
	}

	public Driver() {
		// gui();
		simulateFromString(fileIn);
	}

	public void gui() {
		GUI gui = new GUI();
		simulateFromFile(gui.setUp());
	}

	public void simulateFromString(String fileIn) {
		Simulator go = new Simulator(fileIn);
		go.readValues();
		go.initMatrix();
		go.fillMatrix();
		go.matrixToFile(fileOut);
	}

	public void simulateFromFile(File fileIn) {
		Simulator go = new Simulator(fileIn.toString());
		go.readValues();
		go.initMatrix();
		go.fillMatrix();
		go.matrixToFile(fileOut);
	}

}
