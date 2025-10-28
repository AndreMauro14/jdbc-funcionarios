package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import db.DB;

public class Programa {
	public static void main (String[]args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Connection conn = null;
		PreparedStatement st = null;
		
		System.out.print("Digite seu nome : ");
		String nome = sc.nextLine();
		System.out.print("Digite seu email : ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento (dd/mm/yyyy) : ");
		Date data = sdf.parse(sc.next());
		System.out.print("Informe o seu salario : ");
		Double salario = sc.nextDouble();
		System.out.print("Informe o Id do seu departamento");
		int id = sc.nextInt();
		

		
		try {
			conn = DB.getConnection();
			st=conn.prepareStatement(
					"INSERT INTO  seller "+
					"(Name, Email,BirthDate, BaseSalary, DepartmentId) "+
					"VALUES "+
					"(?, ?, ?, ?, ?)");	
			
			st.setString(1, nome);
			st.setString(2, email);
			st.setDate(3, new java.sql.Date(data.getTime()));
			st.setDouble(4, salario);
			st.setInt(5, id);
			
			int linhas = st.executeUpdate();
			
			System.out.println("Done! Linhas Modificadas " + linhas);
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			sc.close();
		}
		
		
	}
}
