package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email"),
      @UniqueConstraint(columnNames = "usersId"),
      @UniqueConstraint(columnNames = "residentnumber"),
      @UniqueConstraint(columnNames = "nickname")
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  @Size(max = 50)
  private String usersId;

  @Size(max = 50)
  @NotBlank
  private String nickname;

  @Size(max = 50)
  @NotBlank
  private String zoneCode;

  @Size(max = 50)
  @NotBlank
  private String address;

  @Size(max = 50)
  @NotBlank
  private String detailaddress;

  @Size(max = 50)
  private String legalDong;

  @Size(max = 50)
  @NotBlank
  private String phonenumber;

  @Size(max = 50)
  @NotBlank
  private String residentnumber;

  @Size(max = 50)
  @NotBlank
  private String age;

  @Size(max = 50)
  @NotBlank
  private String gender;


  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String usersId,
  String nickname, String zoneCode, String address, String detailaddress, String legalDong, String phonenumber, String residentnumber, String age, String gender) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.usersId = usersId;
    this.nickname = nickname;
    this.zoneCode = zoneCode;
    this.address = address;
    this.detailaddress = detailaddress;
    this.legalDong = legalDong;
    this.phonenumber = phonenumber;
    this.residentnumber = residentnumber;
    this.age = age;
    this.gender = gender;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public void setUsersId(String usersId) { this.usersId = usersId;}

  public String getUsersId(){ return usersId;}

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDetailaddress() {
    return detailaddress;
  }

  public void setDetailaddress(String detailaddress) {
    this.detailaddress = detailaddress;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getResidentnumber() {
    return residentnumber;
  }

  public void setResidentnumber(String residentnumber) {
    this.residentnumber = residentnumber;
  }

  public String getZoneCode() {
    return zoneCode;
  }

  public void setZoneCode(String zoneCode) {
    this.zoneCode = zoneCode;
  }

  public String getLegalDong() {
    return legalDong;
  }

  public void setLegalDong(String legalDong) {
    this.legalDong = legalDong;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}