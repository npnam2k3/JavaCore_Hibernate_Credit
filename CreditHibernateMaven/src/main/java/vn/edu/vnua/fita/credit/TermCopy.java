package vn.edu.vnua.fita.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TermCopy {
	// dung hashMap de luu
	private List<ICreditSubject> subjectList;
	private String termName;

	public TermCopy(String termName) {
		this.termName = termName;
		subjectList = new ArrayList<ICreditSubject>();
	}

	public TermCopy() {
		subjectList = new ArrayList<ICreditSubject>();
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public void addSubject(ICreditSubject sub) {
		subjectList.add(sub);
	}

	public float calTermAverageMark() {
		float ts = 0;
		int ms = 0;
		for (ICreditSubject sub : subjectList) {
			ts += sub.getCredit() * sub.calConversionMark();
			ms += sub.getCredit();
		}
		return ts / ms;
	}

	public String toString() {
		String s = "\nKy hoc: " + termName + "\nMon hoc: \n";
		for (ICreditSubject sub : subjectList) {
			s += sub.toString() + "\n";
		}
		if (!subjectList.isEmpty()) {
			s += "\nDiem trung binh hoc ky: " + calTermAverageMark();
		}
		return s;
	}

//	public void enterInfo(Scanner sc) {
//		sc.nextLine();
//		System.out.print("Nhap ten ky hoc: ");
//		termName = sc.nextLine();
//		System.out.print("Nhap so mon hoc: ");
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			Subject subject = new Subject();
//			subject.enterInfo(sc);
//			addSubject(subject);
//		}
//	}

	// tong so tin chi trong 1 ky
	public int calSumCreditInTerm() {
		int sum = 0;
		for (ICreditSubject subject : subjectList) {
			sum += subject.getCredit();
		}
		return sum;
	}

	// tong diem*so tin chi trong hoc ky
	public float calSumMark() {
		float sum = 0;
		for (ICreditSubject subject : subjectList) {
			sum += subject.calSubjectMark() * subject.getCredit();
		}
		return sum;
	}

	// xoa mon hoc
	public void removeSubject(String subjectCode) {
		// List<Subject> subjectToRemove = new ArrayList<Subject>();
		for (ICreditSubject subject : subjectList) {
			if (subject.getSubjectCode().equalsIgnoreCase(subjectCode)) {
//				subjectList.remove(subject);
				// subjectToRemove.add(subject);
				subjectList.remove(subject);
			}
		}
		// subjectList.removeAll(subjectToRemove);
	}

	// Sua mon hoc
	public void editSubject(String subjectCode) {
		Scanner sc = new Scanner(System.in);
		for (ICreditSubject subject : subjectList) {
			if (subjectCode.equals(subject.getSubjectCode())) {
				System.out.print("Nhap ten mon hoc: ");
				String subjectName = sc.nextLine();
				subject.setSubjectName(subjectName);

				System.out.print("\nNhap vao so tin chi: ");
				int credit = sc.nextInt();
				subject.setCredit(credit);
			}
		}
	}

	public boolean isEmpty(String subjectCode) {
		for (ICreditSubject subject : subjectList) {
			if (subject.getSubjectCode().equalsIgnoreCase(subjectCode)) {
				return false;
			}
		}
		return true;
	}
}
