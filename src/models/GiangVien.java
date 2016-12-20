package models;

import java.util.ArrayList;

public class GiangVien {
	String magv;
	String matKhau;
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	String hoTen;
	String sdt;
	String truongKhoa;
	String trangThai;
	
	ArrayList<DeTai> dsdts;
	
	
	public ArrayList<DeTai> getDsdts() {
		return dsdts;
	}
	public void setDsdts(ArrayList<DeTai> dsdts) {
		this.dsdts = dsdts;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMagv() {
		return magv;
	}
	public void setMagv(String magv) {
		this.magv = magv;
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
	public String getTruongKhoa() {
		return truongKhoa;
	}
	public void setTruongKhoa(String truongKhoa) {
		this.truongKhoa = truongKhoa;
	}
	public GiangVien(){};
	public GiangVien(String magv,String matKhau, String hoTen, String sdt, String truongKhoa, String trangThai)
	{
		this.magv = magv;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.truongKhoa = truongKhoa;
		this.trangThai = trangThai;
		this.matKhau = matKhau;
	}
}
