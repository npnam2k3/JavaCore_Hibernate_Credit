package vn.edu.vnua.fita.credit;

import java.util.Scanner;

public class Lecturer extends Human{
	private String password;
	
	public Lecturer() {
		
	}
	public Lecturer(String code, String password) {
		this.code = code;
		this.password = password;
	}
	
	public Lecturer(String code, String fullname, String address) {
		super(code, fullname, address);
	}
	public void enterInfo(Scanner sc) {
		super.enterInfo(sc);
		System.out.print("Nhap mat khau: ");
		password = sc.nextLine();
	}
	public String toString() {
		return super.toString();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
