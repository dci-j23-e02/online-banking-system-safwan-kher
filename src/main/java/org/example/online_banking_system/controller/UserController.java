package org.example.online_banking_system.controller;



import jakarta.servlet.http.HttpServletRequest;
import org.example.online_banking_system.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

  @Autowired
  private UserServiceImpl userService;



  @GetMapping("/login")
  public String showLoginForm(Model model) {

    String errorMessage = "Invalid credentials";
    model.addAttribute("errorMessage", errorMessage);
    return "login";
  }



  @GetMapping("/signup")

  public String showRegistrationForm() {

    return "signup";

  }



  @PostMapping("/signup")

  public String signUp(@RequestParam String username, @RequestParam String password) {

    userService.saveUser(username, password);

    return "redirect:/login?success=true";

  }

  @GetMapping("/login?logout")
  public String logoutSuccess(Model model){
    String errorMessage = "You have been logged out successfully.";
    model.addAttribute("errorMessage", errorMessage);
    return "login";
  }

}