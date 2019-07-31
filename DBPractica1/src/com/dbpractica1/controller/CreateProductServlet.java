package com.dbpractica1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
		
		response.setContentType("application/json");//mymetype
		Producto miProducto = new Producto();
		
		//miProducto.setId(request.getParameter("txtIdProducto"));
		miProducto.setId(Integer.parseInt("txtIdProducto"));		
		miProducto.setNombre(request.getParameter("txtNombreProducto"));
		miProducto.setPrecio(Double.parseDouble("txtPrecio"));
		miProducto.setExistencia(Integer.parseInt("txtExistencias"));
		
		
		
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
		String urlServidor ="jdbc:mysql://localhost:3306/ocarin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String sentenciaSQL;
		
		//paso 2 declarar los objetos conexion
		Connection conn;
		Statement stmnt;
		int nRegistros =0;
		
		
		response.getWriter().append("Mi texto");
		
		
		
		
		
		
		
		/*int id;
		String nombre;
		double precio;
		int existencia;
		
		//obtencion de los datos frontend
		id=Integer.parseInt(request.getParameter("txtIdProducto"));	
		nombre=request.getParameter("txtNombreProducto");
		precio=Double.parseDouble(request.getParameter("txtPrecio"));
		existencia=Integer.parseInt(request.getParameter("txtExistencias"));	
		
		
		response.setContentType("text/html");//mymetype
		
		PrintWriter salida = response.getWriter();
		
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<title>");
		salida.append("Practica 2");
		salida.append("</title>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h2>");
		salida.append("CRUD BD");
		salida.append("</h2>");
		salida.append("<p>");
		salida.append("Producto agregado: "+ id+ nombre+precio+existencia);
		salida.append("</p>");
		salida.append("</body>");
		salida.append("</html>");
		
		salida.close(); */
		
		
		//Producto producto = new Producto();
		
	//	producto.setId(Integer.parseInt(request.getParameter("txtIdProducto")));
	//	salida.append("txtIdProducto");
		
		//response.getWriter().append("");
	}

}
