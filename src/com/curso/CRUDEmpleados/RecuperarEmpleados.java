package com.curso.CRUDEmpleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class RecuperarEmpleados {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/bdcurso";

		String user = "root";
		String pwd = "root";
		
		String query = "select * from empleados";
		
		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				PreparedStatement preSentencia = conexion.prepareStatement(query);	
				ResultSet rs = preSentencia.executeQuery(query);
					) {
			while(rs.next()) {
				System.out.println("#################");
				String nombre = rs.getString("nombre");
				System.out.println("Nombre: " + nombre);
				String apellido1 = rs.getString("apellido1");
				System.out.println("Primer apellido: " + apellido1);
				String apellido2 = rs.getString("apellido2");
				System.out.println("Segundo apellido: " + apellido2);
				Date fechaDeNacimiento = rs.getDate("fechaDeNacimiento");
				System.out.println("La fecha de nacimiento es: " + fechaDeNacimiento);
				double salario = rs.getDouble("salario");
				System.out.println("El salario es: " + salario);
				System.out.println("#################");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
