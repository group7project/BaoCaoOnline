package models;

import java.util.ArrayList;


public class DeTai {

	String maDeTai;
	String tenDeTai;
	String ngayBaoCao;
	String gioBaoCao;
	String tgbctd;
	String filebaocao;
	public String getFilebaocao() {
		return filebaocao;
	}
	public void setFilebaocao(String filebaocao) {
		this.filebaocao = filebaocao;
	}
	GiangVien gvhd;
	
	ArrayList<VaiTro> dshd;
	ArrayList<SinhVien> svths;
	String moTa;
	double diem;
	String trangThai;
	String maKhoa;
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public DeTai(String maDeTai, String maKhoa, String tenDeTai, String ngayBaoCao,
			String gioBaoCao, String tgbctd, GiangVien gvhd,
			ArrayList<SinhVien> svths, String moTa, double diem, String trangThai, String fileBaoCao) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.ngayBaoCao = ngayBaoCao;
		this.gioBaoCao = gioBaoCao;
		this.tgbctd = tgbctd;
		this.gvhd = gvhd;
		this.svths = svths;
		this.moTa = moTa;
		this.diem = diem;
		this.trangThai = trangThai;
		this.filebaocao = fileBaoCao;
	}
	public ArrayList<VaiTro> getDshd() {
		return dshd;
	}
	public void setDshd(ArrayList<VaiTro> dshd) {
		this.dshd = dshd;
	}
	public ArrayList<SinhVien> getSvths() {
		return svths;
	}
	public void setSvths(ArrayList<SinhVien> svths) {
		this.svths = svths;
	}

	public String getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public DeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public String getNgayBaoCao() {
		return ngayBaoCao;
	}
	public void setNgayBaoCao(String ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}
	public String getGioBaoCao() {
		return gioBaoCao;
	}
	public void setGioBaoCao(String gioBaoCao) {
		this.gioBaoCao = gioBaoCao;
	}
	public String getTgbctd() {
		return tgbctd;
	}
	public void setTgbctd(String tgbctd) {
		this.tgbctd = tgbctd;
	}
	public GiangVien getGvhd() {
		return gvhd;
	}
	public void setGvhd(GiangVien gvhd) {
		this.gvhd = gvhd;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
