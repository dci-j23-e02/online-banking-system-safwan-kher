package org.example.online_banking_system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String accountNumber; // provided by the bank system and not ID, should be unique and NOT NULL

  private String accountType;
  private double balance;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getAccountType() {
    return accountType;
  }

  public double getBalance() {
    return balance;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public Account() {
  }

  public Account(String accountNumber, String accountType, double balance,
      User user) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.user = user;
  }

  public Account(Long id, String accountNumber, String accountType, double balance,
      User user) {
    this.id = id;
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.user = user;
  }
}
