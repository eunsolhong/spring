package acl;

public class AccessPerm {

	private String id;
	private boolean canRead;
	private boolean canCreate;
	private boolean canModify;
	private boolean canDelete;
	private boolean removed;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}
	public void setCanCreate(boolean canCreate) {
		this.canCreate = canCreate;
	}
	public void setCanModify(boolean canModify) {
		this.canModify = canModify;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	
	public boolean isCanRead() {
		return canRead;
	}
	public boolean isCanCreate() {
		return canCreate;
	}
	public boolean isCanModify() {
		return canModify;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public boolean isRemoved() {
		return removed;
	}
	public void copyFrom(AccessPerm other){
		this.canCreate = other.canCreate;
		this.canRead = other.canRead;
		this.canDelete = other.canDelete;
		this.canModify = other.canModify;
		this.removed = other.removed;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "AccessPerm [id=" + id + ", canRead=" + canRead + ", canCreate=" + canCreate + ", canModify=" + canModify
				+ ", canDelete=" + canDelete + ", removed=" + removed + "]";
	}

}
