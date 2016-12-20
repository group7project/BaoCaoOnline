package models;

public class Khoa {
	String maKhoa;
	String tenKhoa;
	String truongKhoa;
	public Khoa(String maKhoa, String tenKhoa, String truongKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.truongKhoa = truongKhoa;
	}
	public Khoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getTruongKhoa() {
		return truongKhoa;
	}
	public void setTruongKhoa(String truongKhoa) {
		this.truongKhoa = truongKhoa;
	}
	
	
}
