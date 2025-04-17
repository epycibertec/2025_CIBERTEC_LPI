package com.cibertec.mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Cursos;
import com.cibertec.interfaces.CursoInterface;
import com.cibertec.utils.MysqlConnection;

public class MantenimientoCursos implements CursoInterface {

	@Override
	public int guardar(Cursos objCursos) {
		int procesar = -1;
		String query = "insert into cursos(codigo,nombre,nivel, profesor) values (?,?,?,?)";
		try (Connection conexion = MysqlConnection.conectar();
				PreparedStatement pst = conexion.prepareStatement(query);) {
			pst.setInt(1, objCursos.getCodigo());
			pst.setString(2, objCursos.getNombre());
			pst.setString(3, objCursos.getNivel());
			pst.setString(4, objCursos.getProfesor());
			procesar = pst.executeUpdate();
		} catch (Exception ex) {
			System.out.println("guardar-Error: " + ex.getMessage());
		}
		return procesar;
	}

	@Override
	public int eliminar(int codigo) {
		int procesar=-1;
		String query= "delete from cursos where codigo=?";
		try(
				Connection con= MysqlConnection.conectar();
				PreparedStatement pst= con.prepareStatement(query);
				) {
			pst.setInt(1, codigo);
			procesar= pst.executeUpdate();
		}catch(Exception ex) {
			System.out.println("eliminar-Error: "+ ex.getMessage());
		}
		return procesar;
	}

	@Override
	public int actualizar(Cursos objCursos) {
		int procesar=-1;
		String query="update cursos set nombre=?, nivel=?, profesor=? where codigo=?";
		try (
				Connection conexion= MysqlConnection.conectar();
				PreparedStatement pst= conexion.prepareStatement(query);
				)
		{
			pst.setString(1, objCursos.getNombre());
			pst.setString(2, objCursos.getNivel());
			pst.setString(3, objCursos.getProfesor());
			pst.setInt(4, objCursos.getCodigo());
			procesar= pst.executeUpdate();
		}catch(Exception ex) {
			System.out.println("actualizar-Error: "+ ex.getMessage());
		}
		return procesar;
	}

	@Override
	public List<Cursos> consultar() {
		String query= "select codigo, nombre, nivel, profesor from cursos";
		List<Cursos> lista = new ArrayList<Cursos>();
		try (
				Connection con= MysqlConnection.conectar();
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs= pst.executeQuery();
				){
			Cursos objCursos;
			while(rs.next()) {
				objCursos= new Cursos();
				objCursos.setCodigo(rs.getInt("codigo"));
				objCursos.setNombre(rs.getString("nombre"));
				objCursos.setNivel(rs.getString("nivel"));
				objCursos.setProfesor(rs.getString("profesor"));
				lista.add(objCursos);	
			}	
		}catch(Exception ex) {
			System.out.println("consultar-Error:"+ex.getMessage());
		}
		return lista;
	}

	@Override
	public Cursos consultarPorId(int codigo) {
		Cursos objCursos = null;
		String query= "select codigo, nombre, nivel, profesor from cursos where codigo=?";
		try(
				Connection con= MysqlConnection.conectar();
				PreparedStatement pst= con.prepareStatement(query);
				) {
			pst.setInt(1, codigo);
			try(ResultSet rs= pst.executeQuery()){
				while(rs.next()) {
					objCursos = new Cursos();
					objCursos.setCodigo(rs.getInt("codigo"));
					objCursos.setNombre(rs.getString("nombre"));
					objCursos.setNivel(rs.getString("nivel"));
					objCursos.setProfesor(rs.getString("profesor"));
				}
			}
		}catch(Exception ex) {
			System.out.println("consultarPorId-Error:"+ ex.getMessage());
		}
		return objCursos;
	}

}
