package credit;

import java.util.Scanner;

public class Human {
	protected String address;
	protected String code;
	protected String fullname;
	
	public Human() {
		
	}
	
	public Human(String code) {
		this.code = code;
	}
	public Human(String code, String fullname) {
		this(code);
		this.fullname = fullname;
	}
	public Human(String code, String fullname, String address) {
		this(code, fullname);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void enterInfo(Scanner sc) {
		System.out.print("Nhap ma: ");
		code = sc.nextLine();
		System.out.print("Nhap ho ten: ");
		fullname = sc.nextLine();
		System.out.print("Nhap dia chi: ");
		address = sc.nextLine();
	}
	@Override
	public String toString() {
		String s = "Ma: "+ code +"\nHo ten: "+fullname+"\nDia chi: "+address;
		return s;
	}
}
