package model;

public class KhachHang {
	private int id;
	private String hoTen;
	private String ngaySinh;
	private String diaChi;

	public KhachHang() {
		super();
	}

	public KhachHang(int id, String hoTen, String ngaySinh, String diaChi) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		String s = "Id: " + id + "\nHo ten: " + hoTen + "\nNgay sinh: " + ngaySinh + "\nDia chi: " + diaChi;
		return s;
	}

}
