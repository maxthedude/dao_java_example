package org.htlleoben.dbmm.Interfaces;

import org.htlleoben.dbmm.transferobjects.User;

import java.util.List;


public interface UserDao {
  public boolean save(User user);

  public User getUser(String username);

  public List<User> getAllUsers();

  public boolean saveUsers(List<User> users);
}
