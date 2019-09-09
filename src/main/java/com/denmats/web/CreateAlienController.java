package com.denmats.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.denmats.web.dao.CreateDao;
import com.denmats.web.model.Alien;
import java.sql.*;

/**
 * Servlet implementation class CreateAlien
 */
public class CreateAlienController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aname = request.getParameter("aname");
		String tech = request.getParameter("tech");
		
		CreateDao newAlien = new CreateDao();
		Alien a1 = newAlien.createAlien(aname, tech);
				
		
		request.setAttribute("newAlien", a1);
		RequestDispatcher rd = request.getRequestDispatcher("showNewAlien.jsp");
		rd.forward(request, response);
	}
}
