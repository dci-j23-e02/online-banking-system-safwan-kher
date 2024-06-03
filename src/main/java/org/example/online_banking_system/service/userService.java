package org.example.online_banking_system.service;

import org.example.online_banking_system.model.User;
import org.springframework.stereotype.Service;

@Service
public interface userService {
  // save new user
  /**
   * @Description: save new user
   * @param usernames: String and unique user name
   * @param password: String value
   * return no specific value: void
   * */
   void saveUser(String usernames, String password);

  // find user by username
  User findByUsername(String username);



  }




