package org.example.online_banking_system.controller;

import org.example.online_banking_system.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankingController {

  @Autowired
  private BankingService service;

  @GetMapping("/")
  public String showHomePage() {

    return "home";
  }

  @GetMapping("/accounts/new")
  public String showNewAccountForm(){

    return "new-account";
  }


  @PostMapping("/accounts/new")
  public String openNewAccountForm(
      @RequestParam String accountType,
      @RequestParam double initialDeposit
  ){

    service.openNewAccount(accountType, initialDeposit);
    return "redirect:/";

  }


  @GetMapping("/transactions/deposit")
  public  String showDepositForm(){
    return "deposit";
  }


  @PostMapping("/transactions/deposit")
  public String depositMoney(
      @RequestParam String accountNumber,
      @RequestParam double amount
  ){
    service.depositMoney(accountNumber, amount);
    return "redirect:/";

  }

  @GetMapping("/transactions/withdraw")
  public String showWithdrawFormat(){
    return "withdraw";
  }

  @PostMapping("/transactions/withdraw")
  public String withdrawMoney(
      @RequestParam String accountNumber,
      @RequestParam double amount
  ){
    service.withdrawMoney(accountNumber, amount);
    return "redirect:/";

  }

  @GetMapping("/transactions/transfer")
  public String showTransferFormat(){
    return "transfer";
  }

  @PostMapping("/transactions/transfer")
  public String transferMoney(
      @RequestParam String fromAccount,
      @RequestParam String toAccount,
      @RequestParam double amount
  ){
    service.transferMoney(fromAccount,toAccount,  amount);
    return "redirect:/";

  }


}
