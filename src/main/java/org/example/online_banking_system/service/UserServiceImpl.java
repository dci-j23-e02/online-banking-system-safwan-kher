package org.example.online_banking_system.service;

import org.example.online_banking_system.model.User;
import org.example.online_banking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /**
   * @param username : String and unique user name
   * @param password  : String value return no specific value: void
   * @Description: save new user
   */
  @Override
  public void saveUser(String username, String password) {
      User user;
      user = findByUsername(username);
      if(user != null) throw new RuntimeException("A User with this username already exist !");

      user = new User(username, passwordEncoder.encode(password));

      userRepository.save(user);
  }

  @Override
  public User findByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }
}
