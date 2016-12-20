package dao;
import java.sql.*;
import java.util.ArrayList;

import connect.DBConnect;
import models.GiangVien;

public class GiangVienDao {
	
	public ArrayList<GiangVien> getGVs()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from dstaikhoangiangvien ";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<GiangVien> list_gv =new ArrayList<>();
			while(rs.next()){
				GiangVien gv = new GiangVien();
				gv.setMagv(rs.getString("magv"));
				gv.setMatKhau(rs.getString("matkhau"));
				gv.setHoTen(rs.getString("hoten"));
				gv.setSdt(rs.getString("sdt"));
				gv.setTrangThai(rs.getString("trangthai"));
				list_gv.add(gv);
				
			}	
			return list_gv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<GiangVien> getGV_Khoa(String maKhoa) // lay danh sach gv theo khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from giangvien where magv like '"+maKhoa+"%'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<GiangVien> list_gv =new ArrayList<>();
			while(rs.next()){
				GiangVien gv = new GiangVien();
				gv.setMagv(rs.getString("magv"));
				gv.setHoTen(rs.getString("hoten"));
				gv.setSdt(rs.getString("sdt"));
				list_gv.add(gv);
			}	
			return list_gv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<GiangVien> getGV_DTTrung(String maKhoa) // lay danh sach gv theo khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="select distinct dt.magv, hoten, sdt from detai,giangvien, (select dt1.magv as magv , dt1.madetai, dt1.tendt, dt1.gbc, dt1.nbc from detaivaitro as dt1, detaivaitro as dt2 where dt1.magv = dt2.magv and dt1.madetai!= dt2.madetai) as dt where dt.magv = giangvien.magv and detai.madetai = dt.madetai and detai.makhoa='"+maKhoa+"'";
		
		PreparedStatement ps;
		try {
			
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<GiangVien> list_gv =new ArrayList<>();
			while(rs.next()){
				GiangVien gv = new GiangVien();
				gv.setMagv(rs.getString("magv"));
				gv.setHoTen(rs.getString("hoten"));
				gv.setSdt(rs.getString("sdt"));
				String mgv = gv.getMagv();
				
				DeTaiDao dtd = new DeTaiDao();
				System.out.println("okkkkkkkkkk");
				gv.setDsdts(dtd.getDeTaiTrungNhaus(mgv));				

				list_gv.add(gv);
			}	
			return list_gv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getMaGV(String hoTen)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
			
			String sql="Select magv from giangvien where hoten =N'"+ hoTen+"'";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					return rs.getString("magv");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	public GiangVien getGVHD(String magvhd)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
			
			String sql="Select * from giangvien where magv ='"+ magvhd+"'";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					GiangVien gv = new GiangVien();
					gv.setMagv(rs.getString("magv"));
					gv.setHoTen(rs.getString("hoten"));
					gv.setSdt(rs.getString("sdt"));
					return gv;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	public GiangVien get_GV(String magv)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
			
			String sql="Select * from giangvien where magv ='"+ magv+"'";
			PreparedStatement ps;
			try {
				ps = con.prepareCall(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					GiangVien gv = new GiangVien();
					gv.setMagv(rs.getString("magv"));
					gv.setHoTen(rs.getString("hoten"));
					gv.setSdt(rs.getString("sdt"));
					return gv;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	@SuppressWarnings("finally")
	public GiangVien getGV(String madt, String vaitro)  // lay giang vien theo ma de tai va vai tro
	{
		GiangVien gv = new GiangVien();
		try {

			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			String sql="Select gv.magv, gv.hoten from giangvien gv,vaitro vt where gv.magv = vt.magv "+
					" and madetai= '"+madt+"' "+" and vaitro =N'"+vaitro+"' ";	
	
			PreparedStatement ps;
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();		
			while(rs.next()){

				gv.setMagv(rs.getString("magv"));
//				System.out.println(rs.getString("magv"));
//				System.out.println(rs.getString("hoten"));
				gv.setHoTen(rs.getString("hoten"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			return gv;
		}
}
	
	public void insertGiangVien(String magv, String hoTen, String sdt)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into giangvien"
					+ "(magv, hoten, sdt) values"
					+ "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, magv);
			preparedStatement.setString(2, hoTen);
			preparedStatement.setString(3, sdt);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateGiangVien(String magv, String hoTen, String sdt)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			
			st = con.createStatement();
			st.execute("update giangvien set hoten=N'"+hoTen+"', sdt ='"+sdt+"' where magv ='"+magv+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteGiangVien(String magv)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			Statement st = null;
			st = con.createStatement();
			String sql="DELETE FROM giangvien "+ "WHERE magv = '"+magv+"'" ;
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
