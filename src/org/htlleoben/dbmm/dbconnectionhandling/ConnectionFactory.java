package org.htlleoben.dbmm.dbconnectionhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:~/dbmm_2it_dao;AUTO_SERVER=TRUE";

  // Database credentials
  static final String USER = "sa";
  static final String PASS = "";

  public static Connection getConnection() {
    Connection theConnection = null;
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }

    // STEP 3: Open a connection
    System.out.println("Connecting to database...");
    try {
      theConnection = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

    return theConnection;
  }


  public static void closeConnection() {

  }
}
