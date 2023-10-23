package com.dietai.backend.model.entities;

import com.dietai.backend.model.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  private List<String> diets;

  public User() {}

  public User(String username, String password) {

    this.username = username;
    this.password = password;
    this.diets = new ArrayList<>();

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<String> getDiets() {
    return diets;
  }

  public void setDiets(List<String> diets) {
    this.diets = diets;
  }

  public UserDto toDto() {
    return new UserDto(this.id, this.username);
  }
}
