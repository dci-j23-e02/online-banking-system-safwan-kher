package org.example.online_banking_system.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;


  @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, orphanRemoval = true)
  private List<Account> accounts;

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public User(String username, String password,
      List<Account> accounts) {
    this.username = username;
    this.password = password;
    this.accounts = accounts;
  }
}
