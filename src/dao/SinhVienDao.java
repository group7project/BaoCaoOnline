package dao;
import java.sql.*;
import java.util.ArrayList;

import connect.DBConnect;
import models.SinhVien;
public class SinhVienDao {

	public ArrayList<SinhVien> getSVs()
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		String sql="Select * from dstaikhoansinhvien ";
		
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<SinhVien> list_sv =new ArrayList<>();
			while(rs.next()){
				SinhVien sv = new SinhVien();
				sv.setMasv(rs.getString("masv"));
				sv.setMatKhau(rs.getString("matkhau"));
				sv.setHoTen(rs.getString("hoten"));
				sv.setSdt(rs.getString("sdt"));
				sv.setTrangThai(rs.getString("trangthai"));
				list_sv.add(sv);
			}
			return list_sv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<SinhVien> getSVTH(String maDeTai)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		String sql="Select *  from sinhvien where madetai ='"+ maDeTai+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<SinhVien> list_sv =new ArrayList<>();
			while(rs.next()){
				SinhVien sv = new SinhVien();
				sv.setMasv(rs.getString("masv"));
				sv.setHoTen(rs.getString("hoten"));
				sv.setSdt(rs.getString("sdt"));
				list_sv.add(sv);
			}
			return list_sv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getMaDeTai(String masv)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		String sql="Select madetai  from sinhvien where masv ='"+ masv+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				return rs.getString("madetai");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getHoTenSVTH(String maDeTai)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		String sql="Select hoten  from sinhvien where madetai ='"+ maDeTai+"'";
		PreparedStatement ps;
		String svths = "";
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				svths+= rs.getString("hoten") +"   ";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svths;
	}
	
	public void insertSinhVien(String masv, String hoTen, String sdt)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into sinhvien"
					+ "(masv, hoten, sdt) values"
					+ "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, masv);
			preparedStatement.setString(2, hoTen);
			preparedStatement.setString(3, sdt);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateMaDeTai(String masv, String madt)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.execute("update sinhvien set madetai='"+madt+"' where masv ='"+masv+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateSinhVien(String masv, String hoTen, String sdt)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			st.execute("update sinhvien set hoten=N'"+hoTen+"', sdt ='"+sdt+"' where masv ='"+masv+"'");
			System.out.println("2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("3");
		}
	}
	
	public void deleteSinhVien(String masv)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql="DELETE FROM sinhvien "+ "WHERE magv = '"+masv+"'" ;
			st.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
