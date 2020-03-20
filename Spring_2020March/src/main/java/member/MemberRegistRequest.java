package member;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberRegistRequest {

	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	private boolean allowNoti;
	private Address address;
	private Date birthday;
	
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public boolean isAllowNoti() {
		return allowNoti;
	}
	
	public Address getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//@DateTimeFormat(pattern = "yyyyMMdd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSamePasswordConfirmPassword() {
		if(password == null || confirmPassword == null) {
			return false;
		}
		return password.equals(confirmPassword);
	}
	
	public boolean hashPassword() {
		return password != null && password.trim().length()>0;
	}
	

	@Override
	public String toString() {
		return "MemberRegistValidator [email=" + email + ", name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", allowNoti=" + allowNoti + ", address=" + address
				+ ", birthday=" + birthday + "]";
	}
}
