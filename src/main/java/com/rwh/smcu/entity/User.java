package com.rwh.smcu.entity;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity(name = "User")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  private Long age;
  private String password;
  private String username;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public static void main(String[] args) {
    User user = new User();
    Field[] fields = user.getClass().getDeclaredFields();
    System.out.println("user");
    for (int i = 0; i < fields.length; i++) {

      System.out.println(fields[i]);
    }

  }
}
