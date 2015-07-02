package javapost.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addPost {
	public static boolean insert(String name, String post, String fecha) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url      = "jdbc:mysql://";
        String host     = "localhost";
        String port     = "3306";
        String dbName   = "cs313";  
        String driver   = "com.mysql.jdbc.Driver";  
        String userName = "cs313user";  
        String passWord = "p@55w0rd";  
        
        
        if(System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null){
            host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            passWord = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        }
        
        try {  
            Class.forName(driver).newInstance();  
            //conn = DriverManager.getConnection(url + dbName, userName, passWord);  
            conn = DriverManager.getConnection(url + host +":" + port + "/" +dbName, userName, passWord);  
  
            pst = conn.prepareStatement("INSERT INTO cs313.Post(username, post, fecha) VALUES (?,?,?)");  
            pst.setString(1, name);  
            pst.setString(2, post);
            pst.setString(3, fecha);
            pst.executeUpdate();
  
            //rs = pst.executeQuery();  
            status = rs.next();  
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return status;  
    }
}

