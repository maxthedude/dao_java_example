package org.htlleoben.dbmm.daoimplementations;

import org.htlleoben.dbmm.Interfaces.UserDao;
import org.htlleoben.dbmm.dbconnectionhandling.ConnectionFactory;
import org.htlleoben.dbmm.transferobjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoRelational implements UserDao {
  private Connection dbConnection;

  public UserDaoRelational() {
    dbConnection = ConnectionFactory.getConnection();
  }

  @Override
  public boolean save(User user) {
    PreparedStatement st = null;
    String query = "INSERT INTO Users ("
          + " username,"
          + " email,"
          + " password,"
          + "  ) VALUES ("
          + "?,?,?)";

    try {
      // set all the preparedstatement parameters
      st = dbConnection.prepareStatement(query);
      st.setString(1, user.getUserName());
      st.setString(2, user.getEmail());
      st.setString(3, user.getPassword());

      // execute the preparedstatement insert
      System.out.println("Executing the following Query: " + st.toString());
      st.executeUpdate();
      st.close();
    } catch (SQLException se) {
      // log exception
      System.out.println("Exception occured during Save for User: " + user.getUserName());
    } finally {
      //finally block used to close resources
      try {
        if (st != null) st.close();
      } catch (SQLException se2) {
      } // nothing we can do
      try {
        if (dbConnection != null) dbConnection.close();
      } catch (SQLException se) {
        se.printStackTrace();
      } //end finally try
    } //end try
    return true;
  }

  @Override
  public User getUser(String username) {
    // TODO implementieren Sie die Methode
    return null;
  }

  @Override
  public List<User> getAllUsers() {
    PreparedStatement st = null;
    List<User> usersInDB = new ArrayList<User>();
    if (dbConnection == null)
      dbConnection = ConnectionFactory.getConnection();
    String sqlStatement = "Select * from users";

    try {
      st = dbConnection.prepareStatement(sqlStatement);
      // execute the preparedstatement insert
      System.out.println("Executing the following Query: " + st.toString());

      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        User dbUser = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"));
        usersInDB.add(dbUser);
      }

      st.close();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //finally block used to close resources
      try {
        if (st != null)
          st.close();
      } catch (SQLException se2) {
      } // nothing we can do
      try {
        if (dbConnection != null) dbConnection.close();
      } catch (SQLException se) {
        se.printStackTrace();
      } //end finally try
    } //end try

    return usersInDB;
  }

  @Override
  public boolean saveUsers(List<User> users) {
    // TODO implementieren Sie die Methode
    return false;
  }

}
