package com.dbpractica1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PruebaServlet")
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PruebaServlet() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("prueba servelt");
	}

}
