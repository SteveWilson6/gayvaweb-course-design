package com.task2;

import java.sql.*;

public class DBUtil {
	public static final String USERNAME = "wilson";
	public static final String PWD="wangshixin";
	public static final String URL="jdbc:mariadb://localhost:3306/javaweb_employee";
	//public static final String DRIVER="org.mariadb.jdbc.Driver";
	public static final String DRIVER="org.mariadb.jdbc.Driver";

	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javaweb_employee", USERNAME, PWD)) {
			try (PreparedStatement ps = conn.prepareStatement("select * from tb_resume_basicinfo")) {
				try (ResultSet rs = ps.executeQuery()) {
					rs.first();
					System.out.println(rs.getString(1) + ", " + rs.getString(2));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
	
	public static  void closeJDBC(Connection con,Statement st, ResultSet rs)
	{
		
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(st!=null)
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
