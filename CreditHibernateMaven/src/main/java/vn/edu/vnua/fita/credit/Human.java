package vn.edu.vnua.fita.credit;

import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public class Human {
	@Id
	@Column(name = "MaSV")
	protected String code;
	@Column(name = "Ten")
	protected String fullname;
	@Transient
	protected String address;

	public Human() {

	}

	public Human(String code) {
		this.code = code;
	}

	public Human(String code, String fullname) {
		this.code = code;
		this.fullname = fullname;
	}

	public Human(String code, String fullname, String address) {
		this.code = code;
		this.fullname = fullname;
		this.address = address;
	}

	public void enterInfo(Scanner sc) {
		System.out.print("Nhap ma: ");
		code = sc.nextLine();
		System.out.print("Nhap ho ten: ");
		fullname = sc.nextLine();
		System.out.print("Nhap dia chi: ");
		address = sc.nextLine();
	}

	public String getAddress() {
		return address;
	}

	public String getCode() {
		return code;
	}

	public String getFullname() {
		return fullname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String toString() {
//		return code + "-" + fullname + "-" + address;
		return code + "-" + fullname;
	}
}
