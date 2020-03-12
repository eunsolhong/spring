package chap04;

import java.sql.Connection;

public class JdbcConnectionProvider implements ConnectionProvider {

	private String driver;
	private String user;
	private String password;
	private String url;

	public void setDriver(String diver) {
		this.driver = diver;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void init() {
		System.out.printf("초기화 함  [%s, %s, %s, %s]\n", driver, url, user, password);
	}

	public Connection getConnection() {
		System.out.println("JdbcConnectionProvider : " + url + " connection 생성");
		return null;
	}

}
