package org.sakhoniouma.tpjava.serie7;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JavaBase {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/base_java";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	private static Connection getDBConnection(){
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		}catch (ClassNotFoundException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		return dbConnection;
		
	}
	
	private static void createfilmTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		String createtableSQL = "create table film (" +
								"Nom varchar(200) not null," +
								"Annee int not null," +
								"primary key(Nom)" + ")";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(createtableSQL);
			statement.execute(createtableSQL);
			System.out.println("Table \"film\" is created");
		} catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (statement != null)
				statement.close();
			if (dbConnection != null)
				dbConnection.close();
		}
		
		
	}
	
	private static void createacteursTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		String createtableSQL = "create table acteurs (" +
								"NomFilm varchar(200) not null," +
								"NomActeur int not null," +
								"Prenom varchar(100) null," + 
								"foreign key(NomFilm) references film(Nom)" + ")";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(createtableSQL);
			statement.execute(createtableSQL);
			System.out.println("Table \"acteurs\" is created");
		} catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (statement != null)
				statement.close();
			if (dbConnection != null)
				dbConnection.close();
		}
		
		
	}
	
	private static void insertRecordintofilmTable() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		String inserttableSQL = " insert into film " + "(Nom,Annee) " + "VALUES"
								+ " (?,?)";
		try {
			dbConnection = getDBConnection();
			ps = dbConnection.prepareStatement(inserttableSQL);
			//System.out.println(createtableSQL);
			
			
			//System.out.println("toto" + "\n");
			Film.getTableFromFile();
			for(Film film : Film.table.values()){
				//System.out.println("toto2" + "\n");
				ps.setString(1, film.getNomFilm());
				ps.setInt(2, film.getAnnee());
				ps.executeUpdate();
				ps.clearParameters();
			}
			System.out.println("Table \"film\" is filled");
		} catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (ps != null)
				ps.close();
			if (dbConnection != null)
				dbConnection.close();
		}
		
		
	}
	
	public static void main(String [] argv){
		try {
			//createfilmTable();
			//createacteursTable();
			insertRecordintofilmTable();
		}catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
