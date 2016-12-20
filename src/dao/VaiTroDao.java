package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.DeTai;
import models.GiangVien;
import models.VaiTro;
import connect.DBConnect;

public class VaiTroDao {
	//ghi diem
	
	public void InsertScore(String magv, String madt, String score, String comment)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			
			int d = Integer.parseInt(score);
			st = con.createStatement();
			st.execute("update  vaitro set diem="+d+", nhanxet = '"+comment+"' where madetai ='"+madt+"' and magv ='"+magv+"'");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int daChamDiem (String magv, String madt)
	{
		
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql = "Select * from vaitro where magv='"+magv+"' and madetai ='"+madt+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()){
				VaiTro vt = new VaiTro();
				vt.setDiem(rs.getDouble("diem"));
				double temp = rs.getDouble("diem");
				if (temp !=0)
				return 1;
			}
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int LaChuTich (String magv, String madt)
	{
		
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql = "Select * from vaitro where magv='"+magv+"' and vaitro='Chủ tịch' and madetai ='"+madt+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()){
				VaiTro vt = new VaiTro();
				vt.setMadt(rs.getNString("madetai"));
				vt.setMagv(rs.getNString("magv"));
				GiangVien gv = new GiangVien();
				GiangVienDao gvd = new GiangVienDao();
				gv = gvd.get_GV(magv);
				vt.setGv(gv);
				return 1;
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	// xoa vai tro theo ma de tai
	public void DeleteVaiTro(String madt)
	{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st;
			try {
				
				st = con.createStatement();
				st.execute("delete from vaitro where madetai ='"+madt+"'");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// insert chutich
	public void InsertChuTich(String madt, String maChuTich)
	{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st;
			try {
				
				st = con.createStatement();
				st.execute("insert into vaitro (magv, madetai, vaitro) values"+"('"+maChuTich+"', '"+madt+"',N'Chủ tịch')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void InsertUyVien(String madt, String maUyVien)
	{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st;
			try {
				
				st = con.createStatement();
				st.execute("insert into vaitro(magv, madetai, vaitro) values" +"('"+maUyVien+"', '"+madt+"',N'Ủy viên')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void InsertPhanBien(String madt,String maPhanBien)
	{
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st;
			try {
				
				st = con.createStatement();
				st.execute("insert into vaitro(magv, madetai, vaitro) values" +"('"+maPhanBien+"', '"+madt+"',N'Phản biện')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ArrayList<VaiTro> get_VaiTros(String madetai)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select * from vaitro where madetai='"+madetai+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<VaiTro> list_vt =new ArrayList<>();
			while(rs.next()){
				VaiTro vt = new VaiTro();
				String magv = rs.getString("magv");
				double k = rs.getDouble("diem");
				vt.setMadt(rs.getNString("madetai"));
				vt.setMagv(rs.getNString("magv"));
				vt.setNhanXet(rs.getNString("nhanxet"));
				vt.setDiem(k);
				GiangVien gv = new GiangVien();
				GiangVienDao gvd = new GiangVienDao();
			
				gv = gvd.get_GV(magv);
				System.out.print(gv.getHoTen());
				vt.setGv(gv);
				
				list_vt.add(vt);
			}
			return list_vt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<DeTai> getVaiTros(String maKhoa) // lay ds de tai theo khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from detai where makhoa = '"+maKhoa+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<DeTai> list_dt =new ArrayList<>();
			while(rs.next()){
				DeTai dt = new DeTai();
				String madt = rs.getString("madetai");
				
				dt.setMaDeTai(madt);
				dt.setTenDeTai(rs.getString("tendetai"));
				dt.setNgayBaoCao(rs.getString("ngaybaocao"));
				dt.setGioBaoCao(rs.getString("giobaocao"));
				dt.setTgbctd(rs.getString("thoigianbctd"));
				
				String maGVHD = rs.getString("magvhd");
				
				GiangVienDao gvd = new GiangVienDao();
				dt.setGvhd(gvd.getGVHD(maGVHD));
				SinhVienDao svd = new SinhVienDao();
				//dt.setSvths(svd.getHoTenSVTH(madt));
				dt.setSvths(svd.getSVTH(madt));
				dt.setMoTa(rs.getString("mota"));
				dt.setDiem(rs.getInt("diem"));
				dt.setTrangThai(rs.getString("trangthai"));
				list_dt.add(dt);
				
			}
			return list_dt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
