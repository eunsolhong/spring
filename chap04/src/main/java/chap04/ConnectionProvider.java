package chap04;

import java.sql.Connection;

public interface ConnectionProvider {

	public Connection getConnection();
}
