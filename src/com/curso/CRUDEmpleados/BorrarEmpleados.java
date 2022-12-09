package com.curso.CRUDEmpleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrarEmpleados {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/bdcurso";

		String user = "root";
		String pwd = "root";
		
		String query = "DELETE from empleados where idempleado=1";
		
		
		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				PreparedStatement preSentencia = conexion.prepareStatement(query);
				){
			PreparedStatement prest = conexion.prepareStatement(query);
			
			if(prest.executeUpdate() > 0) {
				System.out.println("Registro borrado con éxito");
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	}
	}
