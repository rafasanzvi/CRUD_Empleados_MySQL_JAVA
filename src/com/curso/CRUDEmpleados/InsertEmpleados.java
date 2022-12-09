package com.curso.CRUDEmpleados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmpleados {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/bdcurso";

		String user = "root";
		String pwd = "root";
		
		String query = "insert into empleados ( nombre, apellido1, apellido2, fechaDeNacimiento, salario) values (?,?,?,?,?)"; //Con autoincrement, para que añada el id de forma automática al crear un nuevo registro
		// String query = "insert into empleados ( nombre, apellido1, apellido2, fechaDeNacimiento, salario) values (?,?,?,?,?)"; //Sin autoincrement
		
		try (Connection conexion = DriverManager.getConnection(url, user, pwd);
				PreparedStatement preSentencia = conexion.prepareStatement(query);	
					) {
			// preSentencia.setInt(1, 4321); //Esto es para añadir el id manualmente sin autoincrement
			preSentencia.setString(1, "Rafael David");
			preSentencia.setString(2, "Melquiades");
			preSentencia.setString(3, "Sánchez");
			preSentencia.setDate(4, Date.valueOf("2022-10-07"));
			preSentencia.setDouble(5, 100.00);
			
			
			
			if(preSentencia.executeUpdate() > 0) {
				
				System.out.println("Registro insertado en la BD");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	}

}
