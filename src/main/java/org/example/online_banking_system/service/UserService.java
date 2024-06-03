package org.example.online_banking_system.service;

import org.example.online_banking_system.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  // save new user
  /**
   * @Description: save new user
   * @param username: String and unique user name
   * @param password: String value
   * return no specific value: void
   * */
   void saveUser(String username, String password);

  // find user by username
  User findByUsername(String username);



  }




