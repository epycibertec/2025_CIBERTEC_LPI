package com.cibertec.interfaces;

import java.util.List;

import com.cibertec.entidad.Cursos;

public interface CursoInterface {
	
//	int guardar(int codigo,String nombre,String nivel,String profesor);
	
	int guardar(Cursos objCursos);
	int eliminar(int codigo);
	int actualizar(Cursos objCursos);
	List<Cursos> consultar();
	Cursos consultarPorId(int codigo);
	
	
}
