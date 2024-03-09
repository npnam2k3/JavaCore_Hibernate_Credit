package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {

	public static void main(String[] args) {
//		Sach sach1 = new Sach("LTJV", "Lập trình Java", 800000, 2020);
//		SachDAO.getInstance().insert(sach1);
//		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//		for (Sach sach : list) {
//			System.out.println(sach.toString());
//			System.out.println("-------------");
//		}
//		Sach find = new Sach();
//		find.setId("LTC");
//		Sach sach = SachDAO.getInstance().selectById(find);
//		System.out.println(sach);
		// ArrayList<Sach> list = SachDAO.getInstance().selectByCondition("TenSach like
		// 'Lập trình Java'");
		ArrayList<Sach> list = SachDAO.getInstance().selectByCondition("GiaBan > 500000");
		for (Sach sach : list) {
			System.out.println(sach.toString());
			System.out.println("-------------");
		}
	}

}
