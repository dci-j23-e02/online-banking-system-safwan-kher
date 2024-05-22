package org.example.online_banking_system.controller;

import org.example.online_banking_system.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankingController {

  @Autowired
  private BankingService service;

  @GetMapping("/")
  public String showHomePage() {
    return "home";
  }

}
