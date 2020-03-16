package member;

public class MemberInfo {
	private String id;
	private String name;
	private String email;
	private String password;
	private boolean allowNoti;
	private Address address;
	
	public MemberInfo(String id, String name, String email, String password, boolean allowNoti, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.allowNoti = allowNoti;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public boolean isAllowNoti() {
		return allowNoti;
	}
	public Address getAddress() {
		return address;
	}
	
	
	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", allowNoti=" + allowNoti + ", address=" + address + "]";
	}
	
}
