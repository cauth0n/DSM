package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author cauth0n
 */
public class Simulator {
	private String fileName;
	private Matrix matrix;
	private Map<Integer, String> correspondingFiles;

	public Simulator(String fileName) {
		this.fileName = fileName;
		correspondingFiles = new HashMap<>();
	}

	public void readValues() {
		try {
			Scanner in = new Scanner(new File(fileName));
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] files = line.split(" ");

				if (!isFileAlreadyPresent(files[0])) {
					addFile(files[0]);
				}
				if (!isFileAlreadyPresent(files[1])) {
					addFile(files[1]);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find dependency file");
		}
	}

	public boolean isFileAlreadyPresent(String in) {
		boolean toRet = false;
		int i = 0;
		int size = correspondingFiles.size();
		while (i < size && !toRet) {
			if (in.equals(correspondingFiles.get(i))) {
				toRet = true;
			}
			i++;
		}
		return toRet;
	}

	public void addFile(String in) {
		int size = correspondingFiles.size();
		correspondingFiles.put(size, in);
	}

	public void initMatrix() {
		matrix = new Matrix(correspondingFiles);
		matrix.initCols();
	}

	public void fillMatrix() {
		try {
			Scanner in = new Scanner(new File(fileName));
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] files = line.split(" ");

				int fromSpot = matchFileToMap(files[0]);
				int toSpot = matchFileToMap(files[1]);
				matrix.markSpot(fromSpot, toSpot);

			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find dependency file");
		}
	}

	public int matchFileToMap(String s) {
		int size = correspondingFiles.size();
		boolean hasFound = false;
		int toRet = 0;
		int i = 0;
		while (!hasFound) {
			if (s.equalsIgnoreCase(correspondingFiles.get(i))) {
				hasFound = true;
				toRet = i;
			}

			if (i > size) {
				System.out.println("Some horrible error has occured");
			}
			i++;
		}
		return toRet;
	}

	public void matrixToFile(String outFile) {

	}

	public Matrix getMatrix() {
		return matrix;
	}
}
