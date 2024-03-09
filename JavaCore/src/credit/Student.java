package credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Human{
	private String class_;
	private List<Subject> subjectList = new ArrayList<Subject>();
	
	public Student() {
		
	}
	
	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
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
	public Student(String code, String fullname, String class_, String address) {
		super(code, fullname, address);
		this.class_ = class_;
	}
	public void addSubject(Subject sub) {
		subjectList.add(sub);
	}
	
	public float calTermAverageMark() {
		float ts = 0;
		float ms = 0;
		for (Subject subject : subjectList) {
			ts += subject.calConversionMark() * subject.getCredit();
			ms += subject.getCredit();
		}
		return ts/ms;
	}
	public void enterInfo(Scanner sc) {
		super.enterInfo(sc);
		System.out.print("Nhap lop: ");
		class_ = sc.nextLine();
		System.out.print("Nhap so mon hoc: ");
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			Subject sub = new Subject();
			sub.enterInfo(sc);
			addSubject(sub);
		}
	}
	@Override
	public String toString() {
		String s = super.toString()+"\nLop: "+class_+"\n";
		for (Subject subject : subjectList) {
			s+=subject.toString()+"\n";
		}
		if(!subjectList.isEmpty()) {
			s+="\nDiem trung binh: "+calTermAverageMark();
		}
		return s;
	}
}
