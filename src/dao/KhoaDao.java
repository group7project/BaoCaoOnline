package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Khoa;
import connect.DBConnect;

public class KhoaDao {
	
	public String getMaKhoa(String tenKhoa) // lay makhoa theo ten khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="SELECT makhoa FROM khoa where tenkhoa =N'"+tenKhoa+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				return rs.getString("makhoa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Khoa getKhoa(String makdt) // lay makhoa theo ten khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="SELECT * FROM khoa where makhoa = '"+makdt+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			Khoa k = new Khoa();
			while(rs.next()){
				System.out.println("---------------------------");
				k.setMaKhoa(rs.getString("makhoa"));
				k.setTenKhoa(rs.getString("tenkhoa"));
				k.setTruongKhoa(rs.getString("truongkhoa"));
				System.out.println(rs.getString("tenkhoa"));
				return k;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
