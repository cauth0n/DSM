package driver;

/**
 * @author cauth0n
 */
public class DependentFile {
	private String path;

	public DependentFile(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean equals(DependentFile file) {
		boolean toRet = false;
		if (this.path.equals(file.path)) {
			toRet = true;
		}
		return toRet;
	}

}
