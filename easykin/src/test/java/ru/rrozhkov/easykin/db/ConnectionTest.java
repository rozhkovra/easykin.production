package ru.rrozhkov.easykin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
   public static void main(String[] args) { 
      Connection con = null; 
      Statement stmt = null; 
      ResultSet result = null; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/easykin", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeQuery("SELECT * FROM category");
         while(result.next()){
            System.out.println(result.getInt("id")+" | "+
            result.getString("name"));
		 }		          
      } catch (Exception e) { 
    	  e.printStackTrace(System.out); 
      } finally {
    	  try {
    		  if(result!=null)
    			  result.close();
    		  if(stmt!=null)
    			  stmt.close();
    		  if(con!=null)
    			  con.close();
    	  } catch (SQLException e) {
    		  e.printStackTrace();
    	  }
      }  
   } 
}