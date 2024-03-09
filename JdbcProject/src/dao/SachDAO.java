package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JdbcUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach t) {
		int check = 0;
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "INSERT INTO sach(ID, TenSach, GiaBan, NamXuatBan)" + " VALUES('" + t.getId() + "', '"
					+ t.getTenSach() + "', " + t.getGiaBan() + ", " + t.getNamXuatBan() + ")";

			check = statement.executeUpdate(sql);

			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int update(Sach t) {
		int check = 0;
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "UPDATE sach " + "SET " + "TenSach= '" + t.getTenSach() + "', " + "NamXuatBan= "
					+ t.getNamXuatBan() + ", GiaBan= " + t.getGiaBan() + " WHERE ID='" + t.getId() + "'";

			check = statement.executeUpdate(sql);

			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(Sach t) {
		int check = 0;
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "DELETE FROM sach WHERE ID = '" + t.getId() + "'";

			check = statement.executeUpdate(sql);

			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "SELECT * FROM sach";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("ID");
				String tenSach = rs.getString("TenSach");
				Float giaBan = rs.getFloat("GiaBan");
				int namXuatBan = rs.getInt("NamXuatBan");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach ketQua = new Sach();
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "SELECT * FROM sach WHERE ID='" + t.getId() + "'";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("ID");
				String tenSach = rs.getString("TenSach");
				Float giaBan = rs.getFloat("GiaBan");
				int namXuatBan = rs.getInt("NamXuatBan");

				ketQua = new Sach(id, tenSach, giaBan, namXuatBan);
			}

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		try {
			// Tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// Tao doi tuong statement
			Statement statement = connection.createStatement();

			// Thuc thi cau lenh SQl
			String sql = "SELECT * FROM sach WHERE " + condition;

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString("ID");
				String tenSach = rs.getString("TenSach");
				Float giaBan = rs.getFloat("GiaBan");
				int namXuatBan = rs.getInt("NamXuatBan");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				ketQua.add(sach);
			}

			// Ngat ket noi
			JdbcUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
