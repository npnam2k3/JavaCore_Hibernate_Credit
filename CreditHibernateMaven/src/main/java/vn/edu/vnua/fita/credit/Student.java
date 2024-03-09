package vn.edu.vnua.fita.credit;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "SinhVien")
public class Student extends Human {
	@Column(name = "MaLop")
	private String class_;
	// private List<Term> termList = new ArrayList<Term>();
	@Transient
	private Map<String, TermCopy> termMap = new HashMap<String, TermCopy>();

	public Student() {

	}

	public Student(String code) {
		super(code);
	}

	public Student(String code, String fullname) {
		super(code, fullname);
	}

	public Student(String code, String fullname, String class_) {
		super(code, fullname);
		this.class_ = class_;
	}

	public Student(String code, String fullname, String address, String class_) {
		super(code, fullname, address);
		this.class_ = class_;
	}

//	public void addSubject(Subject sub) {
//		subjectList.add(sub);
//	}
//	
//	public float calTermAverageMark() {
//		float ts=0;
//		int ms = 0;
//		for (Subject sub : subjectList) {
//			ts+=sub.getCredit()*sub.calConversionMark();
//			ms+=sub.getCredit();
//		}
//		return ts/ms;
//	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public void addTerm(TermCopy term) {
		// termList.add(term);
		termMap.put(term.getTermName(), term);
	}

//	public void enterInfo(Scanner sc) {
//		super.enterInfo(sc);
//		System.out.print("Nhap lop: ");
//		class_ = sc.nextLine();
//		System.out.print("Nhap so ky hoc: ");
//		int n = sc.nextInt();
//
//		for (int i = 0; i < n; i++) {
//			TermCopy term = new TermCopy();
//			term.enterInfo(sc);
//			// termList.add(term);
//			addTerm(term);
//		}
//	}

	public String toString() {
		String s = super.toString() + "-" + class_;
//		for(Term term : termList) {
//			s += term.toString()+"\n";
//		}
//		for (String key : termMap.keySet()) {
//			s += termMap.get(key).toString();
//		}
//		s += "\nSo tin chi tich luy: " + calAccumulationCredit() + "\nDiem trung binh tich luy: "
//				+ calAverageAccumulationMark();

		return s;
	}

	// tinh so tin chi tich luy
	public int calAccumulationCredit() {
		int sum = 0;
//		for (Term term : termList) {
//			sum+=term.calSumCreditInTerm();
//		}
		for (String key : termMap.keySet()) {
			sum += termMap.get(key).calSumCreditInTerm();
		}
		return sum;
	}

	// tinh diem trung binh tich luy
	public float calAverageAccumulationMark() {
		float ts = 0;
//		for(Term term: termList) {
//			ts+=term.calSumMark();
//		}
		for (String key : termMap.keySet()) {
			ts += termMap.get(key).calSumMark();
		}
		return ts / calAccumulationCredit();
	}

	public void addSubject(String term, ICreditSubject subject) {
		if (termMap.containsKey(term)) {
			termMap.get(term).addSubject(subject);
		} else {
			System.out.println("Học kỳ không tồn tại");
		}
	}

	public boolean editSubject(String term, String subjectCode) {
		if (termMap.containsKey(term)) {
			if (termMap.get(term).isEmpty(subjectCode)) {
				System.out.println("Khong ton tai mon hoc trong hoc ky " + term);
				return false;
			} else {
				termMap.get(term).editSubject(subjectCode);
				return true;
			}
		} else {
			System.out.println("Học kỳ không tồn tại");
			return false;
		}
	}

	public boolean removeSubject(String term, String subjectCode) {
		if (termMap.containsKey(term)) {
			if (termMap.get(term).isEmpty(subjectCode)) {
				System.out.println("Khong ton tai mon hoc trong hoc ky " + term);
				return false;
			} else {
				termMap.get(term).removeSubject(subjectCode);
				return true;
			}
		} else {
			System.out.println("Hoc ky khong ton tai");
			return false;
		}
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		Student std = new Student("6666414", "Nguyen Phuong Nam", "HN", "K66CNTTC");
////		std.enterInfo(sc);
//		ICreditSubject subject = new JavaSubject(9, 9, 9);
//		subject.setSubjectCode("TH001");
//		subject.setSubjectName("Lap trinh Java");
//		subject.setCredit(3);
//		TermCopy term = new TermCopy("1");
//		term.addSubject(subject);
//
//		ICreditSubject subject1 = new OOPSubject(9, 9, 9, 9);
//		subject1.setSubjectCode("TH002");
//		subject1.setSubjectName("Lap trinh OOP");
//		subject1.setCredit(3);
//		term.addSubject(subject1);
//
//		std.addTerm(term);
//		System.out.println("---------------\nDanh sach sinh vien: ");
//		System.out.println(std.toString());
////		System.out.print("Nhap vao hoc ky can xoa mon hoc: ");sc.nextLine();
////		String termName = sc.nextLine();
////		System.out.print("Nhap vao ma mon hoc can xoa: ");
////		String subjectCode = sc.nextLine();
////		
//////		subject.enterInfo(sc);
//////		std.addSubject(termName, subject);
////		if(std.removeSubject(termName, subjectCode)) {
////			System.out.println("---------------\nDanh sach sinh vien sau khi xoa: ");
////			System.out.println(std.toString());
////		}
//
////		System.out.print("Nhap vao hoc ky can sua mon hoc: ");sc.nextLine();
////		String termName = sc.nextLine(); 
////		System.out.print("Nhap vao ma mon hoc can sua: ");
////		String subjectCode = sc.nextLine();
////		if(std.editSubject(termName, subjectCode)) {
////			System.out.println("---------------\nDanh sach sinh vien sau khi sua: ");
////			System.out.println(std.toString());
////		}
//	}
}
