package vn.edu.vnua.fita.credit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseCrudOperation {
	private static String jdbcURL = "jdbc:ucanaccess://lib/db_student.accdb";
	private static String jdbcUsername = "";
	private static String jdbcPassword = "";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Phuong thuc them moi sinh vien
	public static void insertStudent(String MaSV, String HoDem, String ten, Date NgaySinh, String GioiTinh,
			String MaLop) {
		String INSERT_STUDENT_SQL = "INSERT INTO SinhVien(MaSV, Hodem, Ten, Ngaysinh, Gioitinh, MaLop) VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, MaSV);
			preparedStatement.setString(2, HoDem);
			preparedStatement.setString(3, ten);
			preparedStatement.setDate(4, NgaySinh);
			preparedStatement.setString(5, GioiTinh);
			preparedStatement.setString(6, MaLop);
			System.out.println(preparedStatement);
			int rowsInserted = preparedStatement.executeUpdate();

			if (rowsInserted > 0) {
				System.out.println("Thêm mới thành công!");
			} else {
				System.out.println("Thêm mới không thành công!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phuong thuc lay tat ca Sinh vien trong bang
	public static void selectAllStudent() {
		String SELECT_ALL_STUDENT_SQL = "SELECT * FROM SinhVien";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_STUDENT_SQL);
			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoDem = rs.getString("Hodem");
				String ten = rs.getString("Ten");
				Date ngaySinh = rs.getDate("Ngaysinh");
				String gioiTinh = rs.getString("Gioitinh");
				String maLop = rs.getString("MaLop");
				System.out.println(maSV + "-" + hoDem + "-" + ten + "-" + ngaySinh + "-" + gioiTinh + "-" + maLop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudent(String MaSV) {
		String DELETE_STUDENT_SQL = "DELETE FROM SinhVien WHERE MaSV = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
			preparedStatement.setString(1, MaSV);
			System.out.println(preparedStatement);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Xoa thanh cong!");
			} else {
				System.out.println("Xoa khong thanh cong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void selectStudent_Subject() {
		String SELECT_ALL_STUDENT_SQL = "SELECT * FROM (SinhVien INNER JOIN KetQua on SinhVien.MaSV = KetQua.MaSV) INNER JOIN MonHoc on KetQua.MaMH = MonHoc.MaMH";
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_STUDENT_SQL);
			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoDem = rs.getString("Hodem");
				String ten = rs.getString("Ten");
				Date ngaySinh = rs.getDate("Ngaysinh");
				String gioiTinh = rs.getString("Gioitinh");
				String maLop = rs.getString("MaLop");
				String maMH = rs.getString("MaMH");
				float diem = rs.getFloat("Diem");
				String tenMH = rs.getString("TenMH");
				System.out.println(maSV + "-" + hoDem + "-" + ten + "-" + ngaySinh + "-" + gioiTinh + "-" + maLop + "-"
						+ maMH + "-" + diem + "-" + tenMH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// bài 1 cho phép SV nhập mã sinh viên, mã môn học, để đăng ký vào CSDL
	public static void register(Scanner sc) {
		System.out.print("Nhap ma sinh vien: ");
		String studentCode = sc.nextLine();
		System.out.print("Nhap ma mon hoc: ");
		String subjectCode = sc.nextLine();
		String INSERT_KETQUA_SQL = "INSERT INTO KetQua(MaSV, MaMH) VALUES(?, ?)";
		try (Connection connect = getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(INSERT_KETQUA_SQL)) {
			preparedStatement.setString(1, studentCode);
			preparedStatement.setString(2, subjectCode);
			int rowInserted = preparedStatement.executeUpdate();
			if (rowInserted > 0) {
				System.out.println("Thêm mới thành công");
			} else {
				System.out.println("Thêm mới không thành công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// bài 2 cho phép SV nhập mã sinh viên, mã môn học, điểm để cập nhật vào CSDL,
	// nếu chưa tồn tại thì báo lỗi
	public static void updateResult(Scanner sc) {
		System.out.print("Nhap ma sinh vien: ");
		String studentCode = sc.nextLine();
		System.out.print("Nhap ma mon hoc: ");
		String subjectCode = sc.nextLine();
		System.out.print("Nhap diem: ");
		float mark = sc.nextFloat();
		String SELECT_STUDENT = "SELECT * FROM KetQua WHERE MaSV = ? and MaMH = ?";
		try (Connection connect = getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_STUDENT)) {
			preparedStatement.setString(1, studentCode);
			preparedStatement.setString(2, subjectCode);
			ResultSet rs = preparedStatement.executeQuery();

			boolean status = rs.next();
			if (status) {
				String UPDATE_SQL = "UPDATE KetQua SET Diem = ? WHERE MaSV = ? and MaMH = ?";
				try (Connection connection = getConnection();
						PreparedStatement preStm = connect.prepareStatement(UPDATE_SQL)) {
					preStm.setFloat(1, mark);
					preStm.setString(2, studentCode);
					preStm.setString(3, subjectCode);
					int rowUpdate = preStm.executeUpdate();
					if (rowUpdate > 0) {
						System.out.println("Cap nhat thanh cong");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Khong ton tai sinh vien va mon hoc nay");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// bài 3 cho phép nhập MSV, hiện ra thông tin chi tiết, các môn học (gồm điểm)
	// ra màn hình
	public static void showInfoStudent(Scanner sc) {
		System.out.print("Nhập mã sinh viên: ");
		String studentCode = sc.nextLine();
		String SELECT_STUDENT = "SELECT * FROM (SinhVien INNER JOIN KetQua ON SinhVien.MaSV = KetQua.MaSV) INNER JOIN MonHoc ON MonHoc.MaMH = KetQua.MaMH WHERE SinhVien.MaSV = ?";

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT)) {
			statement.setString(1, studentCode);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoDem = rs.getString("Hodem");
				String ten = rs.getString("Ten");
				Date ngaySinh = rs.getDate("Ngaysinh");
				String gioiTinh = rs.getString("Gioitinh");
				String maLop = rs.getString("MaLop");
				String maMH = rs.getString("MaMH");
				String tenMH = rs.getString("TenMH");
				float diem = rs.getFloat("Diem");
				System.out.println("\nHọ tên: " + hoDem + " " + ten + "\nNgày sinh: " + ngaySinh + "\nGiới tính: "
						+ gioiTinh + "\nMã lớp: " + maLop + "\nMa mon hoc: " + maMH + "\nTen mon hoc: " + tenMH
						+ "\nDiem: " + diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Bài 4: Viết phương thức với tham số là MSV, trả về đối tượng SV gồm các thông
	 * tin của sinh viên và danh sách tất cả các môn học mà sinh viên này đã học qua
	 * (dạng HashMap chia theo từng kỳ) (Lấy từ các bảng SinhVien, KetQua,
	 * MonHoc_KyHoc)
	 * 
	 * public Student getStudent(String studentCode) { Câu này em chưa làm được }
	 */

	/*
	 * Bài 5: Viết phương thức trả về danh sách tất cả các đối tượng sinh viên chứa
	 * thông tin sinh viên, các môn học qua các kỳ của SV đó public List<Student>
	 * getAllStudent(){ Câu này em chưa làm được }
	 * 
	 */

	public static void main(String[] args) throws ClassNotFoundException {
//		insertStudent("689999", "Đặng Văn", "Lâm", null, "Nam", "K67CNTTC");
//		selectAllStudent();
//		deleteStudent("689999");
//		selectAllStudent();
//		selectStudent_Subject();
		Scanner sc = new Scanner(System.in);
		showInfoStudent(sc);
		// register(sc);
		// updateResult(sc);
	}
}
