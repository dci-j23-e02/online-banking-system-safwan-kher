package org.example.online_banking_system.service;

import org.example.online_banking_system.model.User;
import org.example.online_banking_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

  @Autowired
  private UserRepository userRepository;


  // register user : save new user
  public void registerUser(String usernames, String password) {
    User user = new User(usernames, password);
    userRepository.save(user);

  }
  // log in user : find user by username
  public String logInUser(String usernames, String password) {


    User  user = userRepository.findUserByUsername(usernames);

    if(user == null){
      throw new IllegalArgumentException("Bad Credentials !!");
    }

    if(!password.equals(user.getPassword())){
      throw new IllegalArgumentException("Bad Credentials !!");
    }

    return user.getUsername();
    }

  // edit user credentials : username or password
  }




