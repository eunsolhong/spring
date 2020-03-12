package board;

public class UpdateInfo {

	private String newName;

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public String toString() {
		return "[newName=" + newName + "]";
	}
	
}
