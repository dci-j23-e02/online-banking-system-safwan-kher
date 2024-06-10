package org.example.online_banking_system.controller;


import org.example.online_banking_system.model.User;
import org.example.online_banking_system.service.BankingService;
import org.example.online_banking_system.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
  @Autowired
  private BankingService bankingService;

  @Autowired
  private UserServiceImpl userService;

  @GetMapping("/")
  public String showHomePage() {

    return "home";
  }

  @GetMapping("/openAccount")
  public String showOpenAccountForm() {

    return "openAccount";
  }

  @PostMapping("/openAccount")
  public String openNewAccount(
      @RequestParam String accountType,
      @RequestParam double initialDeposit,
      @AuthenticationPrincipal UserDetails userDetails,
      Model model) {
    User user = userService.findByUsername(userDetails.getUsername());
    bankingService.openNewAccount(accountType, initialDeposit, user.getId());
    model.addAttribute("message", "Account successfully created!");
    return "redirect:/accountSuccess";
  }

   @GetMapping("/transactions/deposit")
  public String showDepositForm() {
    return "deposit";
  }

  @PostMapping("/transactions/deposit")
  public String depositMoney(
      @RequestParam String accountNumber,
      @RequestParam double amount) {
    bankingService.depositMoney(accountNumber, amount);
    return "redirect:/";
  }

  @GetMapping("/transactions/withdraw")
  public String showWithdrawForm() {
    return "withdraw";
  }

  @PostMapping("/transactions/withdraw")
  public String withdrawMoney(@RequestParam String accountNumber, @RequestParam double amount) {
    bankingService.withdrawMoney(accountNumber, amount);
    return "redirect:/";
  }

  @GetMapping("/transactions/transfer")
  public String showTransferForm() {
    return "transfer";
  }

  @PostMapping("/transactions/transfer")
  public String transferMoney(@RequestParam String fromAccount, @RequestParam String toAccount, @RequestParam double amount) {
    bankingService.transferMoney(fromAccount, toAccount, amount);
    return "redirect:/";
  }
}
