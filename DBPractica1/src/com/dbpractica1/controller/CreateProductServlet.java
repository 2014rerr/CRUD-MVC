package com.dbpractica1.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dbpractica1.model.Producto;

@WebServlet("/CreateProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");//mymetype
		Producto miProducto = new Producto();
		
		miProducto.setId(Integer.parseInt("txtIdProducto"));		
		
		miProducto.setNombre(request.getParameter("txtNombreProducto"));
		
		miProducto.setPrecio(Double.parseDouble("txtPrecio"));
		
		miProducto.setExistencia(Integer.parseInt("txtExistencias"));
		
		response.getWriter().append("estamos");
		
		//pasos para conectar con la base de datos
		//paso 1 declarar las variables de acceso
		//paso 2 declarar los objetos conexion
		//paso 3 inicializar el driver
		//paso 4 abrir la conexion
		//paso 5 preparar el comando SQL a ejecutar
		//paso 6 ejecutar el comando sql en la bd
		//paso 7 cerrar las conecciones.
		
		
		//paso 1 declarar las variables de acceso
		String user = "root";
		String pass ="Rodriguez31";
		String urlServidor ="jdbc:mysql://localhost:3306/generation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String sentenciaSQL="";
		
		//paso 2 declarar los objetos conexion
		Connection conn =null;
		Statement stmnt = null;
		int nRegistros =0;

		
		//paso 3 inicializar el driver
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			//paso 4 abrir la conexion
			conn=DriverManager.getConnection(urlServidor,user, pass);
			
			//Paso 5. Preparar el comando SQL a ejecutar
			stmnt=conn.createStatement();
			String sentenciasSQL="INSERT INTO Producto (id, nombre, precio, existencias) values ('"+miProducto.getId()+"','"+miProducto.getNombre()+"','"+miProducto.getPrecio()+"','"+miProducto.getExistencia()+"')";
			
			//Paso 6. Ejecutar el comando SQL en la BD
			nRegistros=stmnt.executeUpdate (sentenciasSQL);
			if (nRegistros>=0)response.getWriter().append("si se agrego el registro");
		}catch (Exception e)
		{
			response.getWriter().append("Mi texto 1");
			e.printStackTrace();
		}finally
		{
			try {
				
				//Paso 7. Cerrar las conexiones
				stmnt.close();
				conn.close();
			}catch(SQLException e) {
				response.getWriter().append("Mi texto 2");
				e.printStackTrace();
			}
		}
		
		
		
		response.getWriter().append("Mi texto");
		
	}

}
