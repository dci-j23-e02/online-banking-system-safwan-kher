package org.example.online_banking_system.controller;

import org.example.online_banking_system.model.User;
import org.example.online_banking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

  @PostMapping("/signup")
  public String signUp(
      @RequestParam String username,
      @RequestParam String password
  ){
      userService.saveUser(username, password);
      return "redirect:/login";
  }

  @PostMapping("/login")
  public ModelAndView login(
      @RequestParam String username,
      @RequestParam String password
  ){
    User user =   userService.findByUsername(username);
    boolean found = user != null;
    boolean correctPassword = false;
    if(found) correctPassword = userService.checkPassword(password, user.getPassword());

    System.out.println(found);
    System.out.println(correctPassword);
    if(found && correctPassword){
      return  new ModelAndView("redirect:/");
    }else{
      ModelAndView mAndV = new ModelAndView("login");
      mAndV.addObject("error", "Invalid credentials !!!");
      return mAndV;
    }


  }



}
