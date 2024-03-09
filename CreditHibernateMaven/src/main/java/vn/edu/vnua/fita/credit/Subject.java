package vn.edu.vnua.fita.credit;

import java.util.Scanner;


public class Subject {

	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;

	public Subject() {

	}

	public Subject(String subjectCode, String subjectName, int credit) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	public String getSubjectCode() {
		return subjectCode;
	}

	public float calSubjectMark() {
		return attendanceMark * 0.1f + midExamMark * 0.4f + finalExamMark * 0.5f;
	}

	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		if (subjectMark <= 3.9) {
			conversionMark = 0;
		} else if (subjectMark <= 4.9) {
			conversionMark = 1;
		} else if (subjectMark <= 5.4) {
			conversionMark = 1.5f;
		} else if (subjectMark <= 6.4) {
			conversionMark = 2;
		} else if (subjectMark <= 6.9) {
			conversionMark = 2.5f;
		} else if (subjectMark <= 7.4) {
			conversionMark = 3;
		} else if (subjectMark <= 8.4) {
			conversionMark = 3.5f;
		} else if (subjectMark <= 10) {
			conversionMark = 4;
		}
		return conversionMark;
	}

	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade = null;
		if (subjectMark < 0) {
			grade = "Error";
		} else if (subjectMark <= 3.9) {
			grade = "F";
		} else if (subjectMark <= 4.9) {
			grade = "D";
		} else if (subjectMark <= 5.4) {
			grade = "D+";
		} else if (subjectMark <= 6.4) {
			grade = "C";
		} else if (subjectMark <= 6.9) {
			grade = "C+";
		} else if (subjectMark <= 7.4) {
			grade = "B";
		} else if (subjectMark <= 8.4) {
			grade = "B+";
		} else if (subjectMark <= 10) {
			grade = "A";
		}
		return grade;
	}

	public float calConversionMark(String grade) {
		float conversionMark = -1;
		switch (grade) {
		case "F":
			conversionMark = 0;
			break;
		case "D":
			conversionMark = 1;
			break;
		case "D+":
			conversionMark = 1.5f;
			break;
		case "C":
			conversionMark = 2;
			break;
		case "C+":
			conversionMark = 2.5f;
			break;
		case "B":
			conversionMark = 3;
			break;
		case "B+":
			conversionMark = 3.5f;
			break;
		case "A":
			conversionMark = 4;
			break;
		}
		return conversionMark;
	}

	public int getCredit() {
		return this.credit;
	}
	
	public void setAttendanceMark(float attendanceMark) {
		if(attendanceMark>=0 && attendanceMark<=10) {
			this.attendanceMark = attendanceMark;
		}else {
			System.out.println("Lỗi điểm chuyên cần");
			System.exit(0);
		}
	}
	
	public void setFinalExamMark(float finalExamMark) {
		if(finalExamMark>=0 && finalExamMark<=10) {
			this.finalExamMark = finalExamMark;
		}else {
			System.out.println("Lỗi điểm cuối kỳ");
			System.exit(0);
		}
	}
	
	public void setMidExamMark(float midExamMark) {
		if(midExamMark>=0 && midExamMark<=10) {
			this.midExamMark = midExamMark;
		}else {
			System.out.println("Lỗi điểm giữa kỳ");
			System.exit(0);
		}
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName= subjectName;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode=subjectCode;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public float getAttendanceMark() {
		return attendanceMark;
	}

	public float getMidExamMark() {
		return midExamMark;
	}

	public float getFinalExamMark() {
		return finalExamMark;
	}

	public void setCredit(int credit) {
		this.credit=credit;
	}
	
	public String toString() {
		return subjectName + "-"+subjectCode+"-"+credit+"-"+calSubjectMark()+"-"+calConversionMark()+"-"+calGrade();
	}
	public void enterInfo(Scanner sc) {
		sc.nextLine();
		System.out.print("Nhập mã môn học: ");
		subjectCode = sc.nextLine(); 
		System.out.print("Nhập tên môn học: ");
		subjectName = sc.nextLine();
		System.out.print("Nhập số tín chỉ: ");
		credit = sc.nextInt();
		System.out.print("Nhap diem chuyen can: ");
		attendanceMark = sc.nextFloat();
		System.out.print("Nhap diem giua ky: ");
		midExamMark = sc.nextFloat();
		System.out.print("Nhap diem cuoi ky: ");
		finalExamMark = sc.nextFloat();
	}
	
	public static void main(String[] args) {
//		Subject sub = new Subject("TH03111", "Lập trình Java", 3);
//		sub.setAttendanceMark(9);
//		sub.setMidExamMark(8.5f);
//		sub.setFinalExamMark(9);
//		System.out.println(sub);
	}
}
