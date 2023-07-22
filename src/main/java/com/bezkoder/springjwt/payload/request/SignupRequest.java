package com.bezkoder.springjwt.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;


  @Size(min = 2, max = 9)
  @NotBlank
  private String usersId;

  @Size(min = 2, max = 20)
  @NotBlank
  private String nickname;

  @Size(min = 2, max = 20)
  @NotBlank
  private String zoneCode;

  @Size(min = 2, max = 20)
  @NotBlank
  private String address;

  @Size(min = 2, max = 20)
  @NotBlank
  private String detailaddress;

  @Size(min = 0, max = 20)
  private String legalDong;

  @Size(min = 3, max = 20)
  @NotBlank
  private String phonenumber;

  @Size(min = 13, max = 13)
  @NotBlank
  private String residentnumber;

  @Size(min = 1, max = 20)
  @NotBlank
  private String age;

  @Size(min = 1, max = 10)
  @NotBlank
  private String gender;

  public String getUsersId() {
    return usersId;
  }

  public void setUsersId(String usersId) {
    this.usersId = usersId;
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

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

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