package com.dbpractica1.controller;

import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.io.PrintWriter;
import java.sql.Connection;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadGeneralServlet
 */
@WebServlet("/ReadGeneralServlet")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadGeneralServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="root";
		String pass="Rodriguez31";
		String urlServidorBD = "jdbc:mysql://localhost:3306/generation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs=null;
		String sentenciaSQL="SELECT * FROM producto";
		
		PrintWriter salida = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			conn=DriverManager.getConnection(urlServidorBD,user, pass);
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sentenciaSQL);
			while(rs.next())
			{
				salida.append(rs.getString("idProducto"));
				salida.append("<br/>");
				salida.append(rs.getString(2));
				salida.append("<br/>");
				salida.append(" "+rs.getDouble(3));
				salida.append("<br/>");
				salida.append(" "+rs.getInt(4));
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
