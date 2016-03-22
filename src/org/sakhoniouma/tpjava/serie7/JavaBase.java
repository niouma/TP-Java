package org.sakhoniouma.tpjava.serie7;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
								"Cle varchar(200) not null," +
								"Nom varchar(200) not null," +
								"Annee int not null," +
								"primary key(Cle)" + ")";
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
								"Cle int not null," +
								"NomActeur varchar(200) not null," +
								"Prenom varchar(200) null," + 
								"primary key(Cle)" + ")";
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
	
	private static void createfilmacteursTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		String createtableSQL = "create table filmacteurs (" +
								"CleNom int not null," +
								"CleFilm varchar(200) not null," +
								"foreign key (CleNom) references acteurs(Cle)," +
								"foreign key (CleFilm) references film(Cle)" + ")";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(createtableSQL);
			statement.execute(createtableSQL);
			System.out.println("Table \"filmacteurs\" is created");
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
		String inserttableSQL = " insert into film " + "(Cle,Nom,Annee) " + "VALUES"
								+ " (?,?,?)";
		try {
			dbConnection = getDBConnection();
			ps = dbConnection.prepareStatement(inserttableSQL);
			//System.out.println(createtableSQL);
			
			
			//System.out.println("toto" + "\n");
			Film.getTableFromFile();
			Set<String> keys = new TreeSet<String>();
			keys = Film.table.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()){
				//System.out.println("toto2" + "\n");
				String key = it.next();
				ps.setString(1, key);
				ps.setString(2, Film.table.get(key).getNomFilm());
				ps.setInt(3, Film.table.get(key).getAnnee());
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
	
	private static void insertRecordintoacteursTable() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		String inserttableSQL = " insert into acteurs " + "(Cle,NomActeur,Prenom) " + "VALUES"
								+ " (?,?,?)";
		try {
			dbConnection = getDBConnection();
			ps = dbConnection.prepareStatement(inserttableSQL);
			//System.out.println(createtableSQL);
			
			
			//System.out.println("toto" + "\n");
			Film.getTableFromFile();
			Set<Integer> keys = new TreeSet<Integer>();
			keys = Acteur.table.keySet();
			Iterator<Integer> it = keys.iterator();
			while (it.hasNext()){
				//System.out.println("toto2" + "\n");
				Integer key = it.next();
				ps.setInt(1, key);
				ps.setString(2, Acteur.table.get(key).getNom());
				ps.setString(3, Acteur.table.get(key).getPrenom());
				ps.executeUpdate();
				ps.clearParameters();
			}
			System.out.println("Table \"acteurs\" is filled");
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
	
	private static void insertRecordintofilmacteursTable() throws SQLException {
		int i;
		Connection dbConnection = null;
		PreparedStatement ps = null;
		String inserttableSQL = " insert into filmacteurs " + "(CleNom,CleFilm) " + "VALUES"
								+ " (?,?)";
		try {
			dbConnection = getDBConnection();
			ps = dbConnection.prepareStatement(inserttableSQL);
			//System.out.println(createtableSQL);
			
			
			//System.out.println("toto" + "\n");
			Film.getTableFromFile();
			Set<String> keys = new TreeSet<String>();
			keys = Film.table.keySet();
			Iterator<String> it = keys.iterator();
			for(i=0;i<15;i++){
				//System.out.println("toto2" + "\n");
				String key = it.next();
				Iterator<Integer> it2 = Film.table.get(key).getActeurs().iterator();
				while(it2.hasNext()){
					int acteur = it2.next();
					ps.setInt(1, acteur);
					ps.setString(2, key);
					ps.executeUpdate();
					ps.clearParameters();
				}
			}
			System.out.println("Table \"filmacteurs\" is filled");
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
	
	private static void selectRecordsfromfilmacteursTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		String createtableSQL = "select acteurs.NomActeur,acteurs.Prenom from filmacteurs inner join "
				+ "film on film.Cle = filmacteurs.CleFilm inner join acteurs on acteurs.Cle = "
				+ "filmacteurs.CleNom where film.Nom = \"King Frat\"" ;
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(createtableSQL);
			ResultSet rs = statement.executeQuery(createtableSQL);
			while (rs.next()){
				Acteur a = new Acteur();
				a.setNom(rs.getString("nomActeur"));
				a.setPrenom(rs.getString("Prenom"));
				System.out.println(a);
				//System.out.println(rs.getString("Nom"));
			}
			
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
	
	public static void main(String [] argv){
		try {
		//	createfilmTable();
			//createfilmacteursTable();
			//insertRecordintofilmacteursTable();
			selectRecordsfromfilmacteursTable();
		}catch (SQLException e){
			System.out.println("Erreur " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
