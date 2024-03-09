package vn.edu.vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM {
	private List<Human> hrList;

	public HRM() {
		hrList = new ArrayList<Human>();
	}

	public void addHR(Human hm) {
		hrList.add(hm);
	}

	public void addHR(Scanner sc) {
		int i = 0;
		Human hm;
		do {
			System.out.print("Chon nhan su can nhap: 1-sinh vien, 2-giang vien, 3-thoat: ");
			i = sc.nextInt();
			sc.nextLine(); // Chống trôi lệnh
			if (i == 1) {
				hm = new Student();
				hm.enterInfo(sc); // đa hình
				addHR(hm);
			} else if (i == 2) {
				hm = new Lecturer();
				hm.enterInfo(sc);
				addHR(hm);
			}

		} while (i == 1 || i == 2);
	}

	public void printHRList() {
		System.out.println("\n--------------------");
		System.out.println("\nDanh sach nhan su: ");
		if (!hrList.isEmpty()) {
			for (Human hm : hrList) {
				System.out.println(hm.getCode() + ";" + hm.getFullname() + ";" + hm.getAddress());
			}
		}
	}

	public void printLecturerInfo() {
		System.out.println("\n------------------");
		System.out.println("\nDanh sach giang vien: ");
		for (Human hm : hrList) {
			if (hm instanceof Lecturer) {
				System.out.println(hm.toString());
				;
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("\n-------------------");
		System.out.println("\nDanh sach sinh vien: ");
		Student std = null;
		for (Human hm : hrList) {
			if (hm instanceof Student) {
				std = (Student) hm;
				System.out.println(hm.toString());
			}
		}
	}

	public String searchHuman(String code) {
		System.out.println("\n-----------------");
		System.out.println("\nKet qua tim kiem: ");
		for (Human hm : hrList) {
			if (code.equalsIgnoreCase(hm.code)) {
				return hm.toString();
			}
		}
		return "Khong tim thay";
	}

	public void initDemoData() {
		Student std1 = new Student("634593", "Nguyen Van Hai", "Khoa CNTT", "K63CNTTA");
		Subject sub11 = new Subject("TH03111", "Lap trinh Java", 3);
		TermCopy term = new TermCopy();
		sub11.setAttendanceMark(9f);
		sub11.setFinalExamMark(8.5f);
		sub11.setMidExamMark(6.5f);

		Subject sub12 = new Subject("TH03046", "Kiem thu phan mem", 2);
		sub12.setAttendanceMark(9f);
		sub12.setFinalExamMark(7.5f);
		sub12.setMidExamMark(8f);

//		std1.addSubject(sub11);
//		std1.addSubject(sub12);
//		term.addSubject(sub11);
//		term.addSubject(sub12);
//		std1.addTerm(term);

		Lecturer lec1 = new Lecturer("cnp02", "Nguyen Van Quan", "Khoa CNTT");
		Lecturer lec2 = new Lecturer("cnp09", "Dang Tuan Anh", "Khoa CNTT");

		addHR(std1);
		addHR(lec1);
		addHR(lec2);
	}

	public void initDemoData(Scanner sc) {
		String option = "n";
		do {
			addHR(sc);
		} while ("y".equalsIgnoreCase(option));
	}

	public static void main(String[] args) {
		HRM hrm = new HRM();
		Scanner sc = new Scanner(System.in);
		hrm.initDemoData(sc);
		hrm.printHRList();
		hrm.printStudentInfo();
		// hrm.printLecturerInfo();

//		String searchString= hrm.searchHuman("cnp02");
//		System.out.println(searchString);
	}

}
