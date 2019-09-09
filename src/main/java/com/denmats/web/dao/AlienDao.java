package com.denmats.web.dao;

import com.denmats.web.model.Alien;
import java.sql.*;

public class AlienDao {

	public Alien getAlien(int aid) {
		Alien a = new Alien();
		
		String url = "jdbc:mysql://localhost/test?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String uname = "root";
		String pass = "1234";
		String sql = "select * from login where id="+aid;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				a.setAid(rs.getInt(1));
				a.setAname(rs.getString(2));
				a.setTech(rs.getString(3));
				
			}
			
			st.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
