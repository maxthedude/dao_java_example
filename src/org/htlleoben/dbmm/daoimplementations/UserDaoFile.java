package org.htlleoben.dbmm.daoimplementations;

import org.htlleoben.dbmm.Interfaces.UserDao;
import org.htlleoben.dbmm.transferobjects.User;

import java.util.List;


public class UserDaoFile implements UserDao {

  @Override
  public boolean save(User user) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public User getUser(String username) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<User> getAllUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean saveUsers(List<User> users) {
    // TODO Auto-generated method stub
    return false;
  }

}
