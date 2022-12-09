package com.curso.CRUDEmpleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ActualizarEmpleados {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/bdcurso";

		String user = "root";
		String pwd = "root";
		
		String query = "UPDATE empleados SET nombre=?, apellido1=?, apellido2=?, salario=? WHERE idempleado=?";
		
		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				PreparedStatement preSentencia = conexion.prepareStatement(query);
				){
			PreparedStatement prest = conexion.prepareStatement(query);
			
			prest.setString(1, "pepito");
			prest.setString(2, "suapellido1");
			prest.setString(3, "suapellido2");
			prest.setDouble(4, 98765.00);
			prest.setInt(5, 1); //ID
			
			if(prest.executeUpdate() > 0) {
				System.out.println("Registro actualizado");
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	

	}
	}
