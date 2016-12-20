package dao;

import java.sql.*;

import connect.DBConnect;
import models.TaiKhoan;

public class TaiKhoanDao {
	
	public TaiKhoan login(String tentaikhoan, String matkhau, String vaitro)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		ResultSet rs;
		try {
			st = con.createStatement();
			
			rs = st.executeQuery("select * from taikhoan where tentaikhoan='"+ 
					tentaikhoan + "' and matkhau = '" + matkhau +"' and vaitro = '" + vaitro +"'");
				if(rs.next())
				{
					TaiKhoan tk =new TaiKhoan();
					tk.setTenTaiKhoan(rs.getString("tentaikhoan"));
					tk.setMatKhau(rs.getString("matkhau"));
					tk.setVaiTro(rs.getString("vaitro"));
					tk.setTrangThai(rs.getString("trangthai"));
					tk.setMatt(rs.getString("matt"));
					return tk;
				}
				con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	public void insertTaiKhoan(String tentk, String matKhau, String vaitro)
	{
		try {
			System.out.println("Vao TaiKhoanDao");
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into taikhoan"
					+ "(tentaikhoan, matkhau, vaitro,trangthai,matt) values"
					+ "(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, tentk);
			preparedStatement.setString(2, matKhau);
			preparedStatement.setString(3, vaitro);
			preparedStatement.setString(4, "Hoạt động");
			preparedStatement.setString(5, "1");
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			
			System.out.println("Thuc thi xong cau insert");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Lỗi");
		}
	}
	
	
	public void updateTaiKhoan(String magv, String matKhau)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			
			st.execute("update taikhoan set matkhau= '"+ matKhau +"' where tentaikhoan ='"+magv+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteTaiKhoan(String tentaikhoan)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql="DELETE FROM taikhoan "+ "WHERE tentaikhoan = '"+tentaikhoan+"'" ;
			st.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void blockAccount(String tentaikhoan)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st = null;
		
		try {
			System.out.println("1");
			System.out.println(tentaikhoan);
			st = con.createStatement();
			String sql="update taikhoan set trangthai= N'Khóa' , matt = '0' where tentaikhoan ='"+tentaikhoan+"'" ;
			st.execute(sql);
			System.out.println("2");
			
		} catch (SQLException e) {
			System.out.println("3");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void OpenAccount(String tentaikhoan)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st = null;
		
		try {
			st = con.createStatement();
			String sql="update taikhoan set trangthai= N'Hoạt động' , matt = '1' where tentaikhoan ='"+tentaikhoan+"'" ;
			st.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkpass(String taikhoan, String pass)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			ResultSet rs;
			Statement st = (Statement) con.createStatement();
			rs = st.executeQuery("select * from taikhoan where tentaikhoan = '"+taikhoan+"' and matkhau='"+pass+"'");
				if(rs.next())
				{
					return true;
				}
				con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	public void updatePass(String tentk, String new_pass)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "update taikhoan set matkhau=? "
					+ "where tentaikhoan = ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, new_pass);
			preparedStatement.setString(2, tentk);

			preparedStatement .executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
