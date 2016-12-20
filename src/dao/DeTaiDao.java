package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;

import models.DeTai;
import models.VaiTro;
import connect.DBConnect;

public class DeTaiDao {
	
	public void set_Diem(String madt)
	{
		
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from vaitro where madetai = '"+madt+"'";
		
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			double tong =0;
			int t=0;
			while(rs.next()){
				double diem = rs.getDouble("diem");
				tong+= diem;
				if (diem !=0)
					t++;
			}
			double trungbinh= tong/t;
			Statement st;
			st = con.createStatement();
			st.execute("update detai set diem="+trungbinh+" where madetai ='"+madt+"'");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean ktBaoCao(String madt) throws ParseException
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		System.out.println(madt);
		System.out.println("----------------");
		
		String sql="Select * from detai where madetai = '"+madt+"'";
		PreparedStatement ps;
		
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				System.out.println("-++++++++++++++++");
				String ngaybc = rs.getString("ngaybaocao");
				String tgbctd = rs.getString("thoigianbctd");
				Date giobc = rs.getTime("giobaocao");
				System.out.println(giobc);
				DateFormat dateFormat =  new SimpleDateFormat("HH:mm:ss");
				//String giohientai = dateFormat.format(Calendar.getInstance().getTime());
				Calendar cal = Calendar.getInstance();
				
				Date  gioht =cal.getTime();
				System.out.println(gioht);
				
				SimpleDateFormat parser = new SimpleDateFormat("HH:mm"); 
				Date t1 = (Date)parser.parse("giobc");
				Date t2	= (Date)parser.parse("giohientai");
				System.out.println(t2);
				System.out.println("-++++++++++++++++");
				
				Date date = new Date();
				String ngaydang = dateFormat.format(date);
				
				if (ngaybc.equals(ngaydang))
				{
					if (t1.before(t2))
					{
						long timeDiff = t2.getTime() - t1.getTime();
						
						System.out.println(timeDiff);
						System.out.println("----------------");
						long temp = Integer.parseInt(tgbctd)*60*1000;
						System.out.println(temp);
						System.out.println("----------------");

						if (timeDiff<temp)
							return true;
						else return false;
					}
					return false;
				}
				return false;
				
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<DeTai> getDeTais(String maKhoa)
	{// lay ds de tai theo khoa
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
				dt.setFilebaocao(rs.getString("filebaocao"));
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
	
	public ArrayList<DeTai> getDeTaiTrungNhaus(String maGV) // lay ds de tai theo khoa
	{
		
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		System.out.println(maGV);
		System.out.println("--------------------");
		String sql = "select distinct detai.madetai, magvhd, giobaocao,ngaybaocao,thoigianbctd,mota, diem, trangthai,tendetai from detaivaitro, detai where magv='"+maGV+"' and detaivaitro.madetai = detai.madetai";
		PreparedStatement ps;
		try {
			System.out.println("vo---------");
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<DeTai> list_dt =new ArrayList<>();
			while(rs.next()){
				System.out.println("list---------");
				DeTai dt = new DeTai();
				String madt = rs.getString("madetai");
				System.out.println(madt);
				dt.setMaDeTai(madt);
				dt.setTenDeTai(rs.getString("tendetai"));
				dt.setNgayBaoCao(rs.getString("ngaybaocao"));
				dt.setGioBaoCao(rs.getString("giobaocao"));
				dt.setTgbctd(rs.getString("thoigianbctd"));
				
				System.out.println(dt.getTenDeTai());
				String maGVHD = rs.getString("magvhd");
				
				GiangVienDao gvd = new GiangVienDao();
				dt.setGvhd(gvd.getGVHD(maGVHD));
				SinhVienDao svd = new SinhVienDao();

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
	
	public ArrayList<DeTai> getDeTais_GV(String maGV, String flag) // lay ds de tai theo khoa
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		if (flag== null)
			flag ="3";
		System.out.println(flag);
		String sql="select * from detai, vaitro where vaitro.magv = '"+maGV+"' and vaitro.madetai = detai.madetai";
		String sql1="select * from detai, vaitro where vaitro.magv = '"+maGV+"' and vaitro.madetai = detai.madetai and vaitro =  N'Phản biện'";
		String sql2="select * from detai, vaitro where vaitro.magv = '"+maGV+"' and vaitro.madetai = detai.madetai and vaitro =  N'Ủy viên'";
		String sql4= "select * from detai, vaitro where vaitro.magv = '"+maGV+"' and vaitro.madetai = detai.madetai and curdate() = ngaybaocao and curtime() > giobaocao";
		
		PreparedStatement ps;
		try {
			if (flag.equals("3"))
			ps = con.prepareCall(sql);
			else if (flag.equals("2"))
				ps = con.prepareCall(sql2);
			else if(flag.equals("1")) ps = con.prepareCall(sql1);
			else 
				ps = con.prepareCall(sql4);
				
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
				dt.setFilebaocao(rs.getString("filebaocao"));
				String maGVHD = rs.getString("magvhd");
				
				GiangVienDao gvd = new GiangVienDao();
				dt.setGvhd(gvd.getGVHD(maGVHD));
				SinhVienDao svd = new SinhVienDao();
				//dt.setSvths(svd.getHoTenSVTH(madt));
				
				ArrayList<VaiTro> vts = new ArrayList<>();
				VaiTroDao vtd = new VaiTroDao();
				
				vts = vtd.get_VaiTros(madt);
				dt.setDshd(vts);
				
				
				dt.setSvths(svd.getSVTH(madt));
				dt.setMoTa(rs.getString("mota"));
				dt.setDiem(rs.getDouble("diem"));
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
	
	public DeTai getDeTai(String madt) // lay de tai theo ma dt
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="Select * from detai where madetai = '"+madt+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareCall(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				DeTai dt = new DeTai();
				dt.setMaDeTai(madt);
				dt.setTenDeTai(rs.getString("tendetai"));
				dt.setNgayBaoCao(rs.getString("ngaybaocao"));
				dt.setGioBaoCao(rs.getString("giobaocao"));
				dt.setTgbctd(rs.getString("thoigianbctd"));
				String maGVHD = rs.getString("magvhd");
				dt.setMaKhoa(rs.getString("makhoa"));
				dt.setFilebaocao(rs.getString("filebaocao"));
				GiangVienDao gvd = new GiangVienDao();
				dt.setGvhd(gvd.getGVHD(maGVHD));
				SinhVienDao svd = new SinhVienDao();
				//dt.setSvths(svd.getHoTenSVTH(madt));
				dt.setSvths(svd.getSVTH(madt));
				dt.setMoTa(rs.getString("mota"));
				dt.setDiem(rs.getInt("diem"));
				dt.setTrangThai(rs.getString("trangthai"));
				
				return dt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLastMaDeTai() // lay de tai theo ma dt
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		
		String sql="SELECT madetai FROM detai ORDER BY  madetai DESC LIMIT  1";
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
	
	public void insertDeTai(String madt, String tendt, String magvhd, String mota, String khoa)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "insert into detai"
					+ "(madetai, tendetai, magvhd,mota,makhoa) values"
					+ "(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, madt);
			preparedStatement.setString(2, tendt);
			preparedStatement.setString(3, magvhd);
			preparedStatement.setString(4, mota);
			preparedStatement.setString(5, khoa);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean updateDeTai(String madt, String magvhd, String mota,String filebaocao)
	{
		try {
			DBConnect connect = new DBConnect();
			java.sql.Connection con = connect.getConnection();
			
			String insertTableSQL = "update detai "
					+ " set magvhd = ?,mota = ?, filebaocao=? "+
					" where madetai = ?";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(4, madt);
			preparedStatement.setString(1, magvhd);
			preparedStatement.setString(2, mota);
			preparedStatement.setString(3, filebaocao);
			// execute insert SQL statement
			preparedStatement .executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void updateThoiGian(String madt, String ngaybc, String giobc, String tgbctd)
	{
		DBConnect connect = new DBConnect();
		java.sql.Connection con = connect.getConnection();
		Statement st;
		try {
			
			st = con.createStatement();
			st.execute("update detai set ngaybaocao='"+ngaybc+"', giobaocao ='"+giobc
					+"', thoigianbctd ='"+tgbctd+"' where madetai ='"+madt+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
