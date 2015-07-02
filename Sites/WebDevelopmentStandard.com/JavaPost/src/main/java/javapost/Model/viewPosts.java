package javapost.Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.fabric.xmlrpc.base.Array;
 
public class viewPosts { 
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/cs313";
	private static final String DB_USER = "cs313user";
	private static final String DB_PASSWORD = "p@55w0rd";
 
//	public static void main(String[] argv) { 
//		try { 
//			String name = "henry";
//			selectRecordsFromTable(name); 
//		} catch (SQLException e) { 
//			System.out.println(e.getMessage()); 
//		} 
//	}
 
	public static ArrayList selectRecordsFromTable(String name) throws SQLException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String query = "SELECT * FROM Post WHERE username = ? ORDER BY postID DESC";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, name);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
			ArrayList myList = new ArrayList();

			while (rs.next()) { 
				myList.add("<tr><td>"+rs.getInt("postID")+"</td>");
				myList.add("<td>"+rs.getString("post")+"</td>");
				myList.add("<td>"+rs.getDate("fecha")+"</td></tr>");				 
			}
			 
			//System.out.println(myList); 
			return myList;

		} catch (SQLException e) { 
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			} 
			if (dbConnection != null) {
				dbConnection.close();
			} 
		}
		return null; 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try { 
			Class.forName(DB_DRIVER); 
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()); 
		} 
		try { 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage()); 
		} 
		return dbConnection; 
	} 
}
