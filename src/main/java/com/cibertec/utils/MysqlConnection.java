package com.cibertec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	public static void main(String [] args) {
		Connection con = conectar();
		if(con!=null) {
			System.out.println("Conectado");
		}else {
			System.out.println("No conectado");
		}
	}
	

	public static Connection conectar() {
		Connection con = null;
		String cadenaConexion = "jdbc:mysql://localhost:3306/bd_lp1";
		String usuario = "root";
		String password = "sistemas";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(cadenaConexion, usuario, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Mensaje de Error: " + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("Mensaje de Error: " + ex.getMessage());
			System.out.println("Codigo de Error: " + ex.getErrorCode());
			System.out.println("Codigo Estado: " + ex.getSQLState());
		}
		return con;
	}

}
