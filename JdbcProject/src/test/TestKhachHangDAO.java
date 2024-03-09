package test;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
//		KhachHang khachHang1 = new KhachHang(2, "Nguyễn Phương Nam", "09-11-2003", "Gia Lâm - Hà Nội");
//		KhachHang khachHang2 = new KhachHang(5, "Đặng Văn Lâm", "12-12-2002", "Bắc Ninh");
//		KhachHangDAO.getInstance().delete(khachHang2);

//		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
//		for (KhachHang khachHang : list) {
//			System.out.println(khachHang);
//		}
		KhachHang find = new KhachHang();
		find.setId(3);
		KhachHang khachHang = KhachHangDAO.getInstance().selectById(find);
		System.out.println(khachHang);
	}
}
