package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.JdbcUtil;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int check = 0;
		try {
			// tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// taoj doi tuong statement
			Statement statement = connection.createStatement();

			// thuc thi sql
			String sql = "INSERT INTO khachhang(HoTen, NgaySinh, DiaChi) VALUES('" + t.getHoTen() + "', '"
					+ t.getNgaySinh() + "', '" + t.getDiaChi() + "')";
			check = statement.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");
			// dong ket noi
			JdbcUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int update(KhachHang t) {
		int check = 0;
		try {
			// tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// taoj doi tuong statement
			Statement statement = connection.createStatement();

			// thuc thi sql
			String sql = "UPDATE khachhang SET HoTen = '" + t.getHoTen() + "', " + "NgaySinh= '" + t.getNgaySinh()
					+ "', " + "DiaChi= '" + t.getDiaChi() + "' WHERE ID=" + t.getId();
			check = statement.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");
			// dong ket noi
			JdbcUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(KhachHang t) {
		int check = 0;
		try {
			// tao ket noi
			Connection connection = JdbcUtil.getConnection();

			// taoj doi tuong statement
			Statement statement = connection.createStatement();

			// thuc thi sql
			String sql = "DELETE FROM khachhang WHERE ID=" + t.getId();
			check = statement.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("Co: " + check + " dong bi thay doi");
			// dong ket noi
			JdbcUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection connection = JdbcUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM khachhang";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hoTen = rs.getString("HoTen");
				String ngaySinh = rs.getString("NgaySinh");
				String diaChi = rs.getString("DiaChi");

				KhachHang khachHang = new KhachHang(id, hoTen, ngaySinh, diaChi);
				ketQua.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = new KhachHang();
		try {
			Connection connection = JdbcUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM khachhang WHERE ID = " + t.getId();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String hoTen = rs.getString("HoTen");
				String ngaySinh = rs.getString("NgaySinh");
				String diaChi = rs.getString("DiaChi");

				ketQua = new KhachHang(id, hoTen, ngaySinh, diaChi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
