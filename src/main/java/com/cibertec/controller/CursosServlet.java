package com.cibertec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Cursos;
import com.cibertec.interfaces.CursoInterface;
import com.cibertec.mantenimientos.MantenimientoCursos;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CursosServlet
 */
@WebServlet("/CursosServlet")
public class CursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CursosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Solicitud de cliente.....");
		
		List<Cursos> lista= new ArrayList<Cursos>();
		lista.add(new Cursos(100, "juana", "basico", "prof. domingo"));
		lista.add(new Cursos(101, "juan", "intermedio", "prof. ricardo"));
		
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		System.out.println("Json: "+ json);
		
		response.setContentType("application/json");
		response.getWriter().append(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensajeRpta;
		String codigo, nombre, nivel, profesor;
		codigo = request.getParameter("cod");
		nombre = request.getParameter("nom");
		nivel = request.getParameter("niv");
		profesor = request.getParameter("pro");

		CursoInterface interfazCurso = new MantenimientoCursos();
		Cursos objCurso = new Cursos(Integer.parseInt(codigo), nombre, nivel, profesor);

		int operacion = interfazCurso.guardar(objCurso);

		if (operacion >= 0) {
			mensajeRpta= "Exito";
			System.out.println("Se inserto en la base de datos");
		} else {
			mensajeRpta= "Error";
			System.out.println("Hubo un error");
		}
		
		response.getWriter().print(mensajeRpta);
		
	}

}
















