package models;

public class SinhVien {

	String masv;
	String matKhau;
	String hoTen;
	String sdt;
	String trangThai;
	public SinhVien(String masv, String matKhau, String hoTen, String sdt,
			String trangThai) {
		super();
		this.masv = masv;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.trangThai = trangThai;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
