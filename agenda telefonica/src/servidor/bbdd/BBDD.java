package servidor.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class BBDD {
	 
	  private static BBDD instance = null;
	  private Connection con = null;
	 
	  public BBDD() {

	  }
	  
	  //Thread safe instantiate method
	  public static synchronized BBDD getInstance() {
	    if (instance == null) {
	      instance = new BBDD();
	    }
	    return instance;
	  }
	 
	  public Connection getConnection() {
	    return con;
	  }
	 
	  /**
	   * Connection to SQLServer Database
	   */
	  private static Connection getSQLServerConnection() {
	    Connection con = null;
	 
	    try {
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 
	      String URL = "jdbc:sqlserver://localhost;databaseName=NID;user=sa;password=123;";
	      con = DriverManager.getConnection(URL);
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    return con;
	  }
	 
	  /**
	   * Connection to MySQL Database
	   */
	  private static Connection getMySQLConnection() {
	    Connection con = null;
	 
	    try {
	 
	      String strCon = "jdbc:mysql://127.0.0.1/test?user=rtuser&password=123";
	      con = DriverManager.getConnection(strCon);
	    } catch (SQLException se) {
	      System.out.println(se);
	    }
	    return con;
	  }
	 
	}