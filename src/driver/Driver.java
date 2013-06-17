package driver;

import gui.Window;

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
		simulateFromString(fileIn);
	}

	public void simulateFromString(String fileIn) {
		Simulator go = new Simulator(fileIn);
		go.readValues();
		go.initMatrix();
		go.fillMatrix();
		System.out.println(go.getMatrix());
		Window vis = new Window(go.getMatrix());
	}

}
