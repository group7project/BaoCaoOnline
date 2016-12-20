package connect;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnect {

	static String dbname="baocao_db";
	static String dbuser="root";
	static String dbpass="RAAmqd46708";
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/baocao_db","root","Kyneymar116");
			//conn = DriverManager.getConnection("jdbc:mysql://mysql56900-baocaonline.whelastic.net/"+dbname+"?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", dbuser, dbpass);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
