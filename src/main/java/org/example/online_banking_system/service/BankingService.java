package org.example.online_banking_system.service;

public interface BankingService {
  /**
   * A method to open new accounts
   * @param accountType : String value : Checking or Saving
   * @param initialDeposit : the initial balance
   * return no specific value : void
   * */
  void openNewAccount(String accountType, double initialDeposit);
  void depositMoney(String accountNumber, double amount);
  void withdrawMoney(String accountNumber, double amount);
  void transferMoney(String fromAccount, String toAccount, double amount);
}
