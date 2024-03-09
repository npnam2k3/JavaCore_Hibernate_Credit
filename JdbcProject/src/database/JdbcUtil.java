package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Dang ky MySQL Driver voi DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// cac thong so ket noi
			String url = "jdbc:mySQL://localhost:3306/nhasach";
			String username = "root";
			String password = "123456";

			// tao ket noi
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
