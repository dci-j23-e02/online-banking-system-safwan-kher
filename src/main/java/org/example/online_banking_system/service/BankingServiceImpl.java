package org.example.online_banking_system.service;

import org.example.online_banking_system.model.Account;
import org.example.online_banking_system.model.User;
import org.example.online_banking_system.repository.AccountRepository;
import org.example.online_banking_system.repository.UserRepository;
import org.example.online_banking_system.util.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingServiceImpl implements BankingService {
  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  @Modifying
  public void openNewAccount(String accountType, double initialDeposit, Long userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    Account account = new Account();
    account.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
    account.setAccountType(accountType);
    account.setBalance(initialDeposit);
    account.setUser(user);
    accountRepository.save(account);
  }

  @Override
  @Transactional
  @Modifying
  public void depositMoney(String accountNumber, double amount) {
    Account account = accountRepository.findByAccountNumber(accountNumber);
    if (account != null) {
      account.setBalance(account.getBalance() + amount);
      accountRepository.save(account);
    } else {
      throw new RuntimeException("Account not exist");
    }
  }

  @Override
  @Transactional
  @Modifying
  public void withdrawMoney(String accountNumber, double amount) {
    Account account = accountRepository.findByAccountNumber(accountNumber);
    if (account != null && account.getBalance() >= amount) {
      account.setBalance(account.getBalance() - amount);
      accountRepository.save(account);
    } else {
      throw new RuntimeException("Account not exist or insufficient funds for withdrawal");
    }
  }

  @Override
  @Transactional
  @Modifying
  public void transferMoney(String fromAccount, String toAccount, double amount) {
    withdrawMoney(fromAccount, amount);
    depositMoney(toAccount, amount);
  }
}