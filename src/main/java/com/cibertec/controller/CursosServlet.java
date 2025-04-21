package com.cibertec.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Cursos;
import com.cibertec.entidad.RespuestaServidor;
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
	
		String indicador = request.getParameter("indicador");
		switch(indicador) {
			case "listar": listar(request,response); break;
			case "consultarxid": consultarxid(request,response); break;
		}
	}

	private void consultarxid(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String rpta_servidor;
		Gson gson= new Gson();
		CursoInterface cursoInterface = new MantenimientoCursos();
		List<Cursos> lista = cursoInterface.consultar();
		rpta_servidor = gson.toJson(lista);
		response.setContentType("application/json");
		response.getWriter().print(rpta_servidor);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String indicador= request.getParameter("indicador");
		switch(indicador) {
			case "eliminar": eliminar(request,response); break;
			case "insertar": insertar(request,response); break;
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String rpta_servidor;
		RespuestaServidor objRpta;
		
		String codigo, nombre, nivel , profesor, indicador;
		codigo= request.getParameter("codigo");
		nombre= request.getParameter("nombre");
		nivel = request.getParameter("nivel");
		profesor= request.getParameter("profesor");
		indicador= request.getParameter("funcion");
		
		System.out.println("Codigo : "+ codigo);
		System.out.println("nombre : "+ nombre);
		System.out.println("nivel : "+ nivel);
		System.out.println("profesor : "+ profesor);
		System.out.println("indicador : "+ indicador);
		
		Cursos objCursos= new Cursos();
		objCursos.setCodigo(Integer.parseInt(codigo));
		objCursos.setNombre(nombre);
		objCursos.setNivel(nivel);
		objCursos.setProfesor(profesor);
		int procesar;
		CursoInterface cursoInterface= new MantenimientoCursos();
		if (indicador.equals("0")) {
			procesar = cursoInterface.guardar(objCursos);
		}else {
			procesar = cursoInterface.actualizar(objCursos);
		}
		if (procesar>=0) {
			objRpta= new RespuestaServidor(1, "Exito");
		}else {
			objRpta= new RespuestaServidor(0, "Error");
		}
		rpta_servidor= gson.toJson(objRpta);
		response.setContentType("application/json");
		response.getWriter().print(rpta_servidor);
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		RespuestaServidor objRptaServidor;
		String rpta_servidor;
		Gson gson= new Gson();
		String codigo;
		codigo=request.getParameter("codigo");
		CursoInterface cursoInterface = new MantenimientoCursos();
		int procesar= cursoInterface.eliminar(Integer.parseInt(codigo));
		if (procesar>=0) {
			objRptaServidor= new RespuestaServidor(1, "Exito");
		}else {
			objRptaServidor= new RespuestaServidor(0, "Hubo un error");
		}
		rpta_servidor= gson.toJson(objRptaServidor);
		response.getWriter().print(rpta_servidor);
	}
	
	
	/*
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
	*/

}
















