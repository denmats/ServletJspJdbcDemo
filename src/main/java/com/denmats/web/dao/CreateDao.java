package com.denmats.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.denmats.web.model.Alien;

public class CreateDao {
	public Alien createAlien(String aname, String tech) {
		Alien a = new Alien();
		
		String url = "jdbc:mysql://localhost/test?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String uname = "root";
		String pass = "1234";
		String sql = null;
		PreparedStatement ps = null;
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			
			sql = "insert into login values(null,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, aname);
			ps.setString(2, tech);
			ps.executeUpdate();
								
			ps = null;
			sql= null;
			sql = "select * from login where uname=? and pass=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, aname);
			ps.setString(2, tech);
			ResultSet rs1 = ps.executeQuery();
			
			if(rs1.next()) {
				a.setAid(rs1.getInt(1));
				a.setAname(rs1.getString(2));
				a.setTech(rs1.getString(3));
			}
			
			ps.close();
			con.close();	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
		return a;
	}

}
