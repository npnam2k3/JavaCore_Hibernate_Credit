package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JdbcUtil;

public class TestJdbcUtil {
	public static void main(String[] args) {

		try {
			// buoc 1: Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Buoc 2: Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Buoc 3: tao cau lenh truy van SQl
			String sql = "INSERT INTO user(user_name, gender, age, salary) VALUES(\"Nguyễn Phương Nam\",\"Nam\",20,\"10000000\")";
			int check = statement.executeUpdate(sql);

			// Buoc 4: Xu ly ket qua
			System.out.println("Số dòng thay đổi: " + check);
			if (check > 0) {
				System.out.println("Thêm thành công!");
			} else {
				System.out.println("Thêm không thành công!");
			}
			// Buoc 5: Dong ket noi
			System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
