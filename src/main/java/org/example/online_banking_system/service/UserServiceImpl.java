package org.example.online_banking_system.service;



import org.example.online_banking_system.model.User;

import org.example.online_banking_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;



@Service

public class UserServiceImpl implements UserDetailsService {



  @Autowired

  private UserRepository userRepository;



  @Autowired

  private BCryptPasswordEncoder passwordEncoder;



  public void saveUser(String username, String password) {

    User user = new User(username, passwordEncoder.encode(password));

    userRepository.save(user);

  }



  public User findByUsername(String username) {

    return userRepository.findUserByUsername(username);

  }



  public boolean checkPassword(String rawPassword, String encodedPassword) {

    return passwordEncoder.matches(rawPassword, encodedPassword);

  }



  @Override

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = findByUsername(username);

    if (user == null) {

      System.out.println("Null user");

      throw new UsernameNotFoundException("User not found");

    }

    return org.springframework.security.core.userdetails.User

        .withUsername(user.getUsername())

        .password(user.getPassword())

        .authorities("USER") // You can set roles/authorities here

        .build();

  }

}