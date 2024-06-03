package org.example.online_banking_system.controller;

import org.example.online_banking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
  private UserService userService;

    @GetMapping("/login")
  public String showLoginForm(){
      return "login";
    }

  @GetMapping("/signup")
  public String showRegistrationForm(){
    return "signup";
  }
}
