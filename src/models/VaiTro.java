package models;

public class VaiTro {
	String magv;
	String madt;
	String vaiTro;
	DeTai dt;
	GiangVien gv;
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public String getNhanXet() {
		return nhanXet;
	}
	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}
	double diem;
	String nhanXet;
	public DeTai getDt() {
		return dt;
	}
	public void setDt(DeTai dt) {
		this.dt = dt;
	}
	public GiangVien getGv() {
		return gv;
	}
	public void setGv(GiangVien gv) {
		this.gv = gv;
	}
	public VaiTro(String magv, String madt, String vaiTro, DeTai dt, GiangVien gv, double diem, String nhanXet) {
		super();
		this.magv = magv;
		this.madt = madt;
		this.vaiTro = vaiTro;
		this.dt = dt;
		this.gv = gv;
		this.diem= diem;
		this.vaiTro= vaiTro;
	}
	public VaiTro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMagv() {
		return magv;
	}
	public void setMagv(String magv) {
		this.magv = magv;
	}
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	
}
