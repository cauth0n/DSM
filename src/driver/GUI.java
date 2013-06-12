package driver;

/**
 filechooser taken from http://processinghacks.com/hacks:filechooser
 @author Tom Carden
 */

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class GUI extends Component {

	public GUI() {
		
	}

	// set system look and feel
	public File setUp() {
		File file = null;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			// create a file chooser
			final JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Select a dependency file to be read");
			// in response to a button click:
			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();

			} else {
				System.out.println("Open command cancelled by user.");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return file;
	}
}
