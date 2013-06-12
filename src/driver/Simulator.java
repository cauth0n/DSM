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
	private Map<Integer, DependentFile> correspondingFiles;

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

				DependentFile from = new DependentFile(files[0].replace("/home/lxiao/jhotdraw/JHotDraw5.4/src/CH/ifa/", ""));
				DependentFile to = new DependentFile(files[1].replace("/home/lxiao/jhotdraw/JHotDraw5.4/src/CH/ifa/", ""));

				if (!isFileAlreadyPresent(from)) {
					addFile(from);
				}
				if (!isFileAlreadyPresent(to)) {
					addFile(to);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find dependency file");
		}
	}

	public boolean isFileAlreadyPresent(DependentFile in) {
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

	public void addFile(DependentFile in) {
		int size = correspondingFiles.size();
		correspondingFiles.put(size, in);
	}

	public void initMatrix() {
		matrix = new Matrix(correspondingFiles.size());
		matrix.initTiles();
	}

	public void fillMatrix() {
		try {
			Scanner in = new Scanner(new File(fileName));
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] files = line.split(" ");

				int fromSpot = matchFileToMap(files[0].replace("/home/lxiao/jhotdraw/JHotDraw5.4/src/CH/ifa/", ""));
				int toSpot = matchFileToMap(files[1].replace("/home/lxiao/jhotdraw/JHotDraw5.4/src/CH/ifa/", ""));
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
			if (s.equalsIgnoreCase(correspondingFiles.get(i).getPath())) {
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
		PrintWriter out;
		try {
			out = new PrintWriter(new File(outFile));
			out.println(matrix.toString(correspondingFiles));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to create output file");
		}
	}
}
