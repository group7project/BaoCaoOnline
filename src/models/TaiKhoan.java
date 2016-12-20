package models;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private String vaiTro;
	private String trangThai;
	private String matt;
	
	
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMatt() {
		return matt;
	}
	public void setMatt(String matt) {
		this.matt = matt;
	}
	public TaiKhoan(){};
	public TaiKhoan(String tenTaiKhoan,String matKhau,String vaiTro,String trangThai,String matt ){
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.trangThai = trangThai;
		this.matt = matt;
	}
}
